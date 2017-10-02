package interviewbit.recursion;

import java.util.*;


public class Permitations {

    public static void main(String[] args) {
        Permitations s = new Permitations();
        s.permute(new ArrayList<>(Arrays.asList(1,2,3)));
    }


    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> digits) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (digits.size() == 1){
            result.add(digits);
        }

        for (Integer first: digits){
            ArrayList<Integer> rest = new ArrayList<>(digits);
            rest.remove(first);
            ArrayList<ArrayList<Integer>> combinations = permute(rest);
            for(ArrayList<Integer> combination: combinations){
                combination.add(first);
                result.add(combination);
            }
        }

        return result;
    }

}
