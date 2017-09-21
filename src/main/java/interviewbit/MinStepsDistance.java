package interviewbit;

import java.util.Arrays;
import java.util.List;

public class MinStepsDistance {
    public static void main(String[] args){
        Integer[] X = { -7, -13};
        Integer[] Y = { 1, -5};
        new MinStepsDistance().coverPoints(Arrays.asList(X), Arrays.asList(Y));
    }
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(List<Integer> X, List<Integer> Y) {
        if(X.size() <= 1 || Y.size() <= 1 || X.size() != Y.size()){
            return 0;
        }

        int steps = 0;
        for(int i = 1; i < Y.size(); i++){
            int distanceX = Math.abs(X.get(i - 1) - X.get(i));
            int distanceY = Math.abs(Y.get(i - 1) - Y.get(i));

            steps += (distanceX > distanceY ? distanceX : distanceY);
        }

        return steps;
    }
}
