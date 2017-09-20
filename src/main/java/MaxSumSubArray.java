import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumSubArray {

    public static void main(String[] args){
        Integer[] integers = {1967513926, 1540383426, -1303455736, -521595368};
        new MaxSumSubArray().maxset(Arrays.asList(integers));
    }

    public ArrayList<Integer> maxset(List<Integer> elements) {
        Long max = 0L;
        Long currentSum = 0L;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0; i <= elements.size(); i++){

            Integer element = (i < elements.size() ? elements.get(i) : -1);
            if(element >= 0){
                currentSum += element;
                temp.add(element);
            } else {
                if(currentSum > max || (currentSum == max && temp.size() > result.size())){
                    max = currentSum;
                    result.clear();
                    result.addAll(temp);
                }
                currentSum = 0L;
                temp.clear();
            }

        }
        return result;
    }

    ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }

}
