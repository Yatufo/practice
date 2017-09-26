package interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class WaveArray {

    public static void main(String[] args){
        Integer[] integers = {2, 3, 4, 5, 5, 5, 5};
        new WaveArray().solve(Arrays.asList(integers));
    }

    public List<Integer> solve(List<Integer> elements) {
        Integer[] sorted = new Integer[elements.size()];
        elements.toArray(sorted);
        Arrays.sort(sorted);
        for(int i = 0; i < sorted.length; i += 2){
            if(i < sorted.length) {
                int temp = sorted[i + 1];
                sorted[i + 1] = sorted[i];
                sorted[i] = temp;
            }
        }
        return Arrays.asList(sorted);
    }


}
