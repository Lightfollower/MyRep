package calculator;

public class Calculator {
    public int calculate(int n1, Operations op, int n2) {
        int res = 0;
        switch (op) {
            case Division:
                res = n1 / n2;
                break;
            case Addition:
                res = n1 + n2;
                break;
            case Subtraction:
                res = n1 - n2;
                break;
            case Multiplication:
                res = n1 * n2;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }
}

