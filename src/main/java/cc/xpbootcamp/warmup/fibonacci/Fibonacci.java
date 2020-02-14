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
        if (cache.containsKey(in))
            return cache.get(in);

        if (in == 1 || in == 2)
            return 1;

        long v1 = calculate(in - 1);
        cache.putIfAbsent(in - 1, v1);
        long v2 = calculate(in - 2);
        cache.putIfAbsent(in - 2, v2);

        return v1 + v2;
    }

    private void initCache() {
        cache.put(1L, 1L);
        cache.put(2L, 1L);
    }
}
