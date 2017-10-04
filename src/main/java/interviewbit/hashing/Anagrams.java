package interviewbit.hashing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Anagrams {

    public static void main(String[] args) {
        Anagrams s = new Anagrams();
        s.anagrams(Arrays.asList("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"));
   }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> words) {
        HashMap<BigDecimal, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < words.size(); i++ ){
            String word = words.get(i);
            BigDecimal hash = getHash(word);
            ArrayList<Integer> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(i+1);
            map.put(hash, list);
        }

        return new ArrayList<>(map.values());
    }

    private BigDecimal getHash(String word) {
        byte[] characters = word.getBytes();
        BigDecimal product = new BigDecimal(1);

        for(int i = 0; i< characters.length; i++){
            product = product.multiply(new BigDecimal(characters[i]));
        }

        return product;
    }
}
