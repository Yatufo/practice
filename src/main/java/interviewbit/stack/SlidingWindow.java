package interviewbit.stack;

import java.util.*;


class SlidingWindow {

    public static void main(String[] args) {
        SlidingWindow s = new SlidingWindow();
        s.slidingMaximum(Arrays.asList(1,3,-1,-3,5,3,6,7), 2);
    }


    public List<Integer> slidingMaximum(final List<Integer> a, int b) {
        LinkedList<Integer> maxIndex = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();


        if (b >= a.size()) {
            Integer max = Integer.MIN_VALUE;
            for (int i = 0; i < b && i < a.size(); i++) {
                max = Math.max(max, a.get(i));
            }
            result.add(max);
            return result;
        }

        for (int i = 0; i < a.size(); i++) {
            while (!maxIndex.isEmpty() && a.get(i) >= a.get(maxIndex.peekLast())) {
                maxIndex.removeLast();
            }
            maxIndex.add(i);
            int outIndex = i - b;
            if (outIndex >=  -1) {
                if (outIndex == maxIndex.peekFirst()) {
                    maxIndex.removeFirst();
                }
                Integer maximum = a.get(maxIndex.peekFirst());
                result.add(maximum);
            }
        }

        return result;
    }


}
