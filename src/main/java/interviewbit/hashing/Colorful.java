package interviewbit.hashing;

import java.util.*;


public class Colorful {

    public static void main(String[] args) {
        Colorful s = new Colorful();
        s.colorful(1234);
    }

    public int colorful(int number) {
        char[] digits = String.valueOf(number).toCharArray();
        HashSet<Long> elements = new HashSet<>();
        for (int start = 0; start < digits.length; start++) {
            for (int length = 1; length <= digits.length - start; length++) {
                Long product = 1L;
                for(int i = start; i < start + length; i++){
                    product = product * Character.getNumericValue(digits[i]);
                }
                if (!elements.contains(product)){
                    elements.add(product);
                } else {
                    return 0;
                }
            }
        }

        return 1;
    }
}
