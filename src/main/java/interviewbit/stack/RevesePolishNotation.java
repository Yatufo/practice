package interviewbit.stack;

import java.util.*;

public class RevesePolishNotation {


    public static void main(String[] args) {
        System.out.println(new RevesePolishNotation().solve(Arrays.asList("5", "1", "2", "+", "4", "*", "+", "3", "-")));
    }


    public int solve(List<String> elements) {
        Stack<Integer> operands = new Stack<>();
        List<String> operators = Arrays.asList("+", "-", "*", "/");

        for (String element : elements) {
            if (operators.contains(element)) {
                Integer right = operands.pop();
                Integer left = operands.pop();

                switch (element) {
                    case "+":
                        operands.add(left + right);
                        break;
                    case "-":
                        operands.add(left - right);
                        break;
                    case "*":
                        operands.add(left * right);
                        break;
                    case "/":
                        operands.add(left / right);
                        break;
                    default:
                        break;
                }
            } else {
                operands.add(Integer.valueOf(element));
            }
        }
        return operands.pop();
    }

}
