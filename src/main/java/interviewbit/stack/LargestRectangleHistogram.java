package interviewbit.stack;

import java.util.*;

public class LargestRectangleHistogram {


    public static void main(String[] args) {
//        System.out.println(new LargestRectangleHistogram().solve(Arrays.asList(1,2,3)));
        System.out.println(new LargestRectangleHistogram().solve(Arrays.asList(1,4,8,5,3)));

//        System.out.println(new LargestRectangleHistogram().solve(Arrays.asList(6, 2, 5, 4, 5, 1, 6)));
//        System.out.println(new LargestRectangleHistogram().solve(Arrays.asList(1, 1, 4, 1, 1)));
//        System.out.println(new LargestRectangleHistogram().solve(Arrays.asList(1, 1, 4, 4, 1, 1)));
//        System.out.println(new LargestRectangleHistogram().solve(Arrays.asList(2, 1, 5, 6, 2, 3)));
    }


    public Integer solve(List<Integer> elements) {
        Integer maxArea = 0, previousBlock = 0;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> blockStart = new HashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            int currentBlock = elements.get(i);

            if (currentBlock <= previousBlock) {
                int removedBlockStart = i;
                while (!stack.isEmpty() && currentBlock <= stack.peek()) {
                    Integer removedBlock = stack.pop();
                    removedBlockStart = blockStart.remove(removedBlock);

                    int removedArea = removedBlock * (i - removedBlockStart);
                    maxArea = removedArea > maxArea ? removedArea : maxArea;
                }

                blockStart.put(currentBlock, removedBlockStart);
            } else {
                blockStart.put(currentBlock, i);
            }
            stack.add(currentBlock);


            previousBlock = currentBlock;
        }

        for (int firstBlock: blockStart.keySet()) {
            int area = firstBlock * (elements.size() - blockStart.get(firstBlock));
            maxArea = area > maxArea ? area : maxArea;
        }


        return maxArea;
    }

}
