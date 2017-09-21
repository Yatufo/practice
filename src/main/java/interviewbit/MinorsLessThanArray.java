package interviewbit;

import java.util.Arrays;
import java.util.List;

public class MinorsLessThanArray {

    public static void main(String[] args){
        Integer[] integers = {2, 3, 4, 5, 5, 5, 5};
        new MinorsLessThanArray().solve(Arrays.asList(integers));
    }

    public int solve(List<Integer> elements) {
        Object[] sorted = elements.toArray();
        Arrays.sort(sorted);
        for(int i = 0; i < sorted.length; i++){
            int p = (int) sorted[i];
            int greaterThanP = sorted.length - i - 1;
            for(int j = i + 1; j < sorted.length; j ++){
                if((int) sorted[j] == p){
                    greaterThanP --;
                } else {
                    i = j - 1;
                    break;
                }
            }
            if (greaterThanP == p){
                return 1;
            }
        }
        return -1;
    }


}
