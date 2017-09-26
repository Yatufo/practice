package interviewbit.arrays;

import java.util.*;

public class NumRange {

    public static void main(String[] args){
        Integer[] integers = {10, 5, 1, 0, 2};
        new NumRange().solve(Arrays.asList(integers), 6, 8);
    }

    public int solve(List<Integer> elements, int left, int right) {

        Integer count = 0;
        for(int i = 0; i < elements.size(); i++){
            Integer sum = 0;
            for(int j = i; j< elements.size(); j++){
                sum += elements.get(j);
                if(sum <= right){
                    if (left <= sum){
                        count ++;
                    }
                } else {
                    break;
                }
            }
        }

        return count;
    }


}
