
import array.*;
import stack.DecimalBinarySolution;
import stack.DeleteWithPairSolution;
import stack.StockPriceSolution;
import stack.ValidParenthesisLeftRotateSolution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StockPriceSolution s = new StockPriceSolution();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 2, 3})));
    }
}
