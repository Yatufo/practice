package interviewbit.arrays;

public class PrintMatrix {

    public static void main(String[] args){
        new PrintMatrix().prettyPrint(1);
    }

    public int[][] prettyPrint(int size) {
        int n = (size * 2) - 1;
        int[][] result = new int[n][n];
        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                int bottom= (n - j - 1);
                int top = j;
                int left = i;
                int right = n - i - 1;
                int x = (left < right ? left : right);
                int y = (top < bottom ? top : bottom);
                int distance = (x < y ? x : y);
                result[i][j] = size - distance;
            }
        }
        return result;
    }

}
