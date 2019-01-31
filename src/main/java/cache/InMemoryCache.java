package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InMemoryCache<K, V> {

    private final int cacheTtlMinutes;

    private final Map<K, V> cache = new HashMap<>();

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public InMemoryCache(int cacheTtlMinutes) {
        this.cacheTtlMinutes = cacheTtlMinutes;
    }

    public void set(final K k, final V v) {
        cache.put(k, v);
        scheduler.schedule(() -> cache.remove(k), cacheTtlMinutes, TimeUnit.MINUTES);
    }

    public V get(final K k) {
        return cache.get(k);
    }
}
