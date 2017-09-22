package interviewbit;

import org.scalactic.Bool;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {


    public static void main(String[] args) {
        System.out.println(new RainWaterTrapped().solve(Arrays.asList(1, 0, 2)));
        System.out.println(new RainWaterTrapped().solve(Arrays.asList(3, 0, 1)));
        System.out.println(new RainWaterTrapped().solve(Arrays.asList(2, 0, 2)));
        System.out.println(new RainWaterTrapped().solve(Arrays.asList(2, 0, 1, 0, 2)));
        System.out.println(new RainWaterTrapped().solve(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
        System.out.println(new RainWaterTrapped().solve(Arrays.asList(15, 0, 5, 10)));
        System.out.println(new RainWaterTrapped().solve(Arrays.asList(10, 10, 0, 15)));
        System.out.println(new RainWaterTrapped().solve(Arrays.asList(57, 57, 45, 58, 5, 38, 8, 81, 22, 35, 98, 56, 63, 53, 67, 16, 25, 38, 22, 65, 28, 75, 29, 100, 45, 58, 64, 62, 56, 49, 41, 11, 43, 72, 5, 24, 98, 8, 51, 66, 9, 35, 36, 83, 15, 55, 37, 12, 62, 78, 55, 20, 86, 85, 82, 57, 16, 84, 68, 12, 98, 40, 25, 32, 88, 54, 21, 53, 55, 86, 79, 79, 65, 100, 34, 91, 69, 21, 55, 79, 70, 35, 39, 38, 49, 93, 46, 73, 29, 25, 78, 55, 24, 51, 5, 78, 92, 35, 93, 87, 88, 87, 42, 5, 55, 56, 88, 37, 16, 66, 60, 48, 52, 94, 32, 18, 39, 84, 91, 92, 50, 22, 18, 87, 50, 77, 41, 4, 19, 80, 23, 73, 59, 31, 52, 14, 57, 63, 18, 86, 98, 13, 40, 82, 51, 26, 69, 58, 30, 46, 37, 47, 89, 1, 3, 38, 94, 2, 87, 37, 38, 86, 82, 35, 41, 98, 72, 92, 24, 46, 19, 32, 87, 99, 73, 97, 6, 34, 5, 21, 13, 73, 95, 20, 75, 54, 9, 21, 0, 11, 16, 6, 15, 26, 10, 2, 54, 14, 15, 57, 88, 37, 24, 58, 14, 75, 69, 45, 23, 2, 58, 80, 72, 78, 24, 51, 55, 76, 25, 25, 78, 4, 44, 64, 1, 2, 43, 45, 93, 4, 51, 60, 74, 30, 54, 1, 93, 45, 58, 91, 68, 51, 42, 100, 78, 92, 21, 95, 74, 88, 29, 6, 76, 83, 10, 12, 27, 94, 61, 61, 22, 56, 42, 3, 10, 34, 87, 90, 89, 31, 72, 75, 74, 21, 37, 13, 12, 32, 24, 48, 86, 58, 39, 18, 80, 78, 15, 12, 84, 37, 37, 50, 86, 11, 95, 44, 59, 48, 68, 11, 92, 16, 100, 88, 93, 80, 18, 72, 71, 12, 42, 27, 17, 2, 30, 16, 45, 61, 24, 21, 50, 4, 12, 73, 74, 81, 51, 40, 44, 100, 56, 22, 49, 59, 52, 93, 78, 38, 44, 47, 2, 36, 94, 53, 97, 56, 62, 47, 59, 55, 65, 18, 85, 61, 35, 51, 15, 59, 93, 48, 41, 89, 35, 89, 93, 28, 16, 85, 89, 29, 33, 84, 94, 11, 28, 94, 74, 97, 85, 83, 40, 46, 20, 72, 36, 21, 79, 42, 56, 1, 100, 78, 46, 19, 41, 26, 10, 36, 36, 39, 73, 32, 43, 34, 19, 83, 47, 92, 59, 65, 24, 59, 3, 49, 93, 3, 15, 95, 50, 92, 51, 39, 78, 7, 27, 42, 85, 90, 18, 43, 13, 23, 12, 84, 52, 52, 20, 96, 28, 85, 66, 13, 9, 8, 61, 2, 29, 51, 10, 66, 64, 35, 54, 98, 7, 62, 47, 56, 90, 9, 36, 13, 78, 93, 84, 59, 16, 22, 59, 51, 83, 21, 17, 42, 85, 16, 38, 63, 36, 16, 57, 66, 67, 61, 34, 58, 10, 72, 3, 99, 30, 19, 64, 33, 69, 53, 43, 56, 97, 92, 63, 55, 7, 75, 71, 97, 0, 33, 58, 0, 93, 22, 78, 1, 38, 41, 70, 77, 82, 26, 37, 60, 47, 30, 21, 32, 31, 20, 56, 68, 14, 43, 23, 74, 34, 12, 57, 14, 99, 33, 72, 91, 78, 87, 18, 76, 42, 61, 17, 4, 60, 63, 43, 11, 15, 48, 14, 55, 71, 51, 11, 74, 64, 61, 73, 19, 71, 75, 63, 61, 53, 73, 12, 97, 89, 21, 60, 3, 64, 77, 71, 100, 5, 74, 30, 91, 80, 39, 24, 35, 87, 12, 90, 38, 1, 18, 25, 60, 98, 16, 48, 11, 18, 92, 91, 8, 61, 28, 48, 10, 19, 19, 78, 63, 54, 63, 43, 57, 86, 47, 99, 8, 7, 19, 87, 10, 36, 13, 93, 25, 33, 27, 63, 26, 65, 62, 43, 39, 27, 48, 91, 85, 27, 34, 17, 42, 56, 19, 97, 63, 29, 69, 41, 49, 90, 82, 15, 74, 36, 79, 82, 39, 20, 71, 50, 13, 24, 15, 35, 65, 18, 42, 98, 68, 85, 2, 1, 47, 29, 53, 32, 81, 4, 25, 5, 62, 29, 43, 4, 55, 41, 66, 59, 6, 80, 99, 26, 27, 73, 53, 63, 73, 71, 69, 86, 29, 90, 22, 28, 45, 29, 78, 71, 14, 57, 74, 54, 87, 56, 94, 2, 36, 88, 36, 16, 53, 25, 67, 78, 91, 97, 75, 85, 70, 51, 86, 32, 57, 84, 31, 37, 1, 66, 93, 23, 91, 57, 83, 49, 29, 51, 66)));
    }


    public int solve(List<Integer> levels) {
        Integer leftBarrier = 0, water = 0, previousLevel = 0;
        Stack<Integer> waterStack = new Stack<>();

        for (Integer rightLevel : levels) {
            if (rightLevel >= previousLevel) {
                Integer levelled = 0;
                Integer waterLevel = rightLevel > leftBarrier ? leftBarrier : rightLevel;
                Boolean notFilled = !waterStack.empty();

                while (notFilled) {
                    Integer fillingLevel = waterStack.pop();
                    if (waterLevel > fillingLevel || waterLevel == leftBarrier) {
                        water += waterLevel - fillingLevel;
                        levelled += 1;
                        notFilled = !waterStack.empty();
                    } else {
                        //fill the water back
                        waterStack.add(fillingLevel);
                        for (int i = 0; i <= levelled; i++) {
                            waterStack.add(waterLevel);
                        }
                        notFilled = false;
                    }
                }

                if (waterStack.isEmpty()) {
                    leftBarrier = rightLevel;
                    waterStack.add(leftBarrier);
                }

            } else {
                waterStack.add(rightLevel);
            }


            previousLevel = rightLevel;
        }


        return water;
    }

}
