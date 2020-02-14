package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    public int calculate(int in) {
        if (in == 1 || in == 2)
            return 1;

        return calculate(in - 1) + calculate(in - 2);
    }
}
