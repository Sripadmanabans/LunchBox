package zerobase.us.lunchbox.interfaces;

/**
 * This is used for the cache.
 * Created by Sripad on 1/11/2016.
 */
public interface CacheableSpiceRequest {

    /**
     * This is the function that is overridden to get the cache key.
     *
     * @return An object that acts as the caches key.
     */
    Object getCacheKey();
}
