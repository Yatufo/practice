package interviewbit.recursion;

import interviewbit.linkedlist.ListNode;

import java.util.*;


public class LetterPhone {

    public static void main(String[] args) {
        LetterPhone s = new LetterPhone();
        s.letterCombinations("23");
    }

    static HashMap<String, List<String>> map = new HashMap<>();
    static {
        map.put("0", Collections.singletonList("0"));
        map.put("1", Collections.emptyList());
        map.put("2", Arrays.asList("a","b","c"));
        map.put("3", Arrays.asList("d","e","f"));
        map.put("4", Arrays.asList("g","h","i"));
        map.put("5", Arrays.asList("j","k","l"));
        map.put("6", Arrays.asList("m","n","o"));
        map.put("7", Arrays.asList("p","q","r","s"));
        map.put("8", Arrays.asList("t","u","v"));
        map.put("9", Arrays.asList("w","x","y","z"));
    }

    public ArrayList<String> letterCombinations(String number) {
        if (number.length() == 1){
           return new ArrayList<>(map.get(number));
        }

        ArrayList<String> result = new ArrayList<>();
        String[] split = number.split("", 2);
        String first = split[0], rest = split[1];
        List<String> combinations = letterCombinations(rest);
        for(String firstLetter: map.get(first)){
            for(String otherLetters: combinations){
                String combination = firstLetter + otherLetters;
                result.add(combination);
            }
        }

        return result;
    }

}
