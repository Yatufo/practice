package interviewbit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestSmallestElement {


    public static void main(String[] args) {
        new NearestSmallestElement().solve(Arrays.asList(4, 5, 2, 10, 8));
        new NearestSmallestElement().solve(Arrays.asList(3,4,2));
    }


    public List<Integer> solve(List<Integer> elements) {
        List<Integer> results = new ArrayList<>();
        Stack<Integer> smaller = new Stack<>();
        for (Integer current : elements) {


            boolean looking = true;
            while (looking && !smaller.empty()) {
                Integer minor = smaller.pop();
                if (minor < current) {
                    results.add(minor);
                    smaller.add(minor); //add back
                    looking = false;
                }
            }

            if (smaller.empty()) {
                results.add(-1);
            }


            smaller.add(current);
        }


        return results;
    }

}
