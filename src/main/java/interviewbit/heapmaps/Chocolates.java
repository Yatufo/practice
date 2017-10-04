package interviewbit.heapmaps;

import java.util.*;


public class Chocolates {

    public static void main(String[] args) {
        Chocolates s = new Chocolates();
        int result = s.nchoc(10, Arrays.asList(2147483647, 2000000014, 2147483647));
    }


    public int nchoc(int time, List<Integer> bags) {
        Long totalEaten = 0L;
        PriorityQueue<Integer> bagsHeap = new PriorityQueue<>(Collections.reverseOrder());
        bagsHeap.addAll(bags);
        for (int i = 1; i <= time; i++){
            Integer chocolates = bagsHeap.poll();
            totalEaten += chocolates;
            bagsHeap.add((int) Math.floor(chocolates / 2));
        }
        return (int) (totalEaten % ((Math.pow(10, 9))+7));
    }
}
