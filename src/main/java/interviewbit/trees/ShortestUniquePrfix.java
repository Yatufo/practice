package interviewbit.trees;


import java.util.*;
import java.util.stream.Collectors;

public class ShortestUniquePrfix {
    public static void main(String[] args) {

        new ShortestUniquePrfix().prefix(Arrays.asList("abc", "efg", "abd"));

    }
    public List<String> prefix(List<String> words) {
        Map<String, String> prefixes = new HashMap<>();
        Map<String, String> inverse = new HashMap<>();
        Set<String> current, todo = new HashSet<>(words);

        int legnth = 1;
        while(!todo.isEmpty()) {
            current = todo;
            todo = new HashSet<>();

            for (String word : current) {
                if (legnth <= word.length()){
                    String prefix = word.substring(0, legnth);
                    if(prefixes.containsKey(prefix)){
                        todo.add(word);
                        todo.add(prefixes.get(prefix));
                    } else{
                        prefixes.put(prefix, word);
                        inverse.put(word, prefix);
                    }
                }
            }


            legnth ++;
        }

        ArrayList<String> result = new ArrayList<>();
        words.forEach(w -> result.add(inverse.get(w)));
        return result;
    }
}