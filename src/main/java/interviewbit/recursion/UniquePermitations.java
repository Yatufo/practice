package interviewbit.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class UniquePermitations {

    public static void main(String[] args) {
        UniquePermitations s = new UniquePermitations();
        ArrayList<ArrayList<Integer>> permute = s.permute(new ArrayList<>(Arrays.asList(1, 1, 2)));
        System.out.println(permute);
    }


    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> digits) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<String> uniques = new HashSet<>();

        if (digits.size() == 1){
            result.add(digits);
        }

        for (Integer first: digits){
            ArrayList<Integer> rest = new ArrayList<>(digits);
            rest.remove(first);
            ArrayList<ArrayList<Integer>> combinations = permute(rest);
            for(ArrayList<Integer> combination: combinations){
                combination.add(first);
                String hash = getHash(combination);
                if(!uniques.contains(hash)){
                    uniques.add(hash);
                    result.add(combination);
                }
            }
        }

        return result;
    }

    private String getHash(ArrayList<Integer> combination) {
        StringBuilder builder =  new StringBuilder();
        combination.forEach(builder::append);
        return builder.toString();
    }

}
