package interviewbit.heapmaps;

import java.util.*;


public class MaxPairCombo {

    public static void main(String[] args) {
        MaxPairCombo s = new MaxPairCombo();
        ArrayList<Integer> result = s.solve(Arrays.asList(3, 1, 3, 1), Arrays.asList(1, 4, 1, 4));
//        ArrayList<Integer> result = s.solve(
//                Arrays.asList(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28),
//                Arrays.asList(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43)
//        );
    }


    public ArrayList<Integer> solve(List<Integer> left, List<Integer> right) {
        left.sort(Collections.reverseOrder());
        right.sort(Collections.reverseOrder());
        Stack<Integer> rightHeap = new Stack<>(), leftHeap = new Stack<>();
        rightHeap.addAll(right);
        leftHeap.addAll(left);

        PriorityQueue<Integer> maximums = new PriorityQueue<>();
        int n = left.size();
        Stack<Integer> current, other;

        while (leftHeap.size() > 0 && rightHeap.size() > 0) {
            boolean leftIsHigh = leftHeap.peek() >= rightHeap.peek();
            current = leftIsHigh ? leftHeap : rightHeap;
            other = leftIsHigh ? rightHeap : leftHeap;
            int currentValue = current.pop();

            for (Integer otherValue : other) {
                int sum = otherValue + currentValue;
                if ((maximums.size() > 0 && sum > maximums.peek()) || maximums.size() < n) {
                    maximums.add(sum);
                } else {
                    break;
                }
            }


            while (maximums.size() > n) {
                maximums.poll();
            }
        }

        ArrayList<Integer> result = new ArrayList<>(maximums);
        result.sort(Collections.reverseOrder());
        return result;
    }
}
