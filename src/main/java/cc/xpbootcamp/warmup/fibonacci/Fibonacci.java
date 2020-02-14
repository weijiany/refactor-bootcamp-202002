package cc.xpbootcamp.warmup.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Long, Long> cache;

    public Fibonacci() {
        this.cache = new HashMap<>();
        initCache();
    }

    public long calculate(long in) {
        checkInputIsValid(in);

        if (cache.containsKey(in))
            return cache.get(in);

        long v1 = getValue(in, 1);
        long v2 = getValue(in, 2);

        return v1 + v2;
    }

    private long getValue(long in, int offset) {
        long value = calculate(in - offset);
        cache.putIfAbsent(in - offset, value);
        return value;
    }

    private void checkInputIsValid(long in) {
        if (in < 1)
            throw new RuntimeException();
    }

    private void initCache() {
        cache.put(1L, 1L);
        cache.put(2L, 1L);
    }
}
