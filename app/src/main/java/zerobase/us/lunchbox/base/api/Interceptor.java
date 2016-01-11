package zerobase.us.lunchbox.base.api;

import retrofit.RequestInterceptor;

/**
 * This is the interceptor that used for the adding headers to the request.
 * Created by Sripad on 1/11/2016.
 */
public class Interceptor implements RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        // Use if we need to add headers.
    }
}
