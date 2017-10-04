package interviewbit.heapmaps;

import java.util.*;


public class PeopleHeights {

    public static void main(String[] args) {
        PeopleHeights s = new PeopleHeights();
        ArrayList<Integer> result = s.solve(Arrays.asList(3, 1, 3, 1), Arrays.asList(1, 4, 1, 4));
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
