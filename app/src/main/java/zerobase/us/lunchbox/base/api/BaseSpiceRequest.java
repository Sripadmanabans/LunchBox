package zerobase.us.lunchbox.base.api;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import zerobase.us.lunchbox.interfaces.CacheableSpiceRequest;

/**
 * This is the base for the spice request.
 * Created by Sripad on 1/11/2016.
 */
public abstract class BaseSpiceRequest<T, V> extends RetrofitSpiceRequest<T, V>
        implements CacheableSpiceRequest {

    public BaseSpiceRequest(Class<T> clazz, Class<V> retrofitedInterfaceClass) {
        super(clazz, retrofitedInterfaceClass);
    }
}
