package zerobase.us.lunchbox.base.api;

import android.app.Application;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.retrofit.RetrofitObjectPersisterFactory;
import com.octo.android.robospice.request.CachedSpiceRequest;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;
import zerobase.us.lunchbox.utils.UrlHolder;

/**
 * This is the base for the spice request.
 * Created by Sripad on 1/11/2016.
 */
public class BaseSpiceService<T> extends SpiceService {

    // This is the map that holds the managers and their services.
    private Map<Class<?>, T> retrofitManagerToServiceMap = new HashMap<>();

    // This is the converter that is used make JSON into java object
    protected Converter converter = null;

    // This is the builder that is used to create the rest adapter.
    protected RestAdapter.Builder builder = null;

    // This is the rest adapter that is used to create the service that is used to make the call.
    protected RestAdapter restAdapter = null;

    // This is the object that is used to intercept the request.
    protected Interceptor requestInterceptor = null;

    // This is used to handle the response errors.
    protected ErrorHandler networkErrorHandler = new ErrorHandler() {
        @Override
        public Throwable handleError(RetrofitError cause) {
            return cause;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        builder = (builder != null) ? builder : createRestAdapterBuilder();
        restAdapter = builder.build();
    }

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        CacheManager cacheManager = new CacheManager();
        cacheManager.addPersister(new RetrofitObjectPersisterFactory(application, converter));
        return cacheManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addRequest(CachedSpiceRequest<?> request, Set<RequestListener<?>> listRequestListener) {
        if (request.getSpiceRequest() instanceof RetrofitSpiceRequest) {
            RetrofitSpiceRequest retrofitSpiceRequest =
                    (RetrofitSpiceRequest) request.getSpiceRequest();

            retrofitSpiceRequest.setService(getRetrofitService(
                    retrofitSpiceRequest.getRetrofitedInterfaceClass()));
        }
        super.addRequest(request, listRequestListener);
    }

    /**
     * This is the function that is used to get the server endpoint.
     *
     * @return A string that holds the base URL or endpoint.
     */
    private String getServerURL() {
        return UrlHolder.BASE_URL();
    }

    /**
     * This is the function that is used to create a builder that in turn is used to customize and
     * create the the rest adapter.
     *
     * @return An object of the RestAdapter.Builder class.
     */
    private RestAdapter.Builder createRestAdapterBuilder() {
        builder = new RestAdapter.Builder();

        // Setting the endpoint that we make the call to.
        builder.setEndpoint(getServerURL());

        // This is the where the converter is set.
        if (converter != null) {
            builder.setConverter(converter);
        } else {
            // This is the custom GSON converter.
            Gson customGSONExclusionStrategy =
                    new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
                        @Override
                        public boolean shouldSkipField(FieldAttributes f) {
                            return false;
                        }

                        @Override
                        public boolean shouldSkipClass(Class<?> clazz) {
                            return false;
                        }
                    }).create();

            converter = new GsonConverter(customGSONExclusionStrategy);
            builder.setConverter(converter);

        }

        // Setting the request interceptor if it is present.
        if (requestInterceptor != null) {
            builder.setRequestInterceptor(requestInterceptor);
        }

        // Setting the error handler.
        builder.setErrorHandler(networkErrorHandler);

        // Setting the log level. Has to be removed when adding the debug build config.
        builder.setLogLevel(RestAdapter.LogLevel.FULL);

        // Creating the client and setting it to the builder.
        Client client = new OkClient();
        builder.setClient(client);

        return builder;
    }

    /**
     * This is the function that is used to get the service which corresponds to the request
     * manager.
     *
     * @param requestManager A request manager who's service is needed.
     * @return A generic object which is the service used to make the call.
     */
    public T getRetrofitService(Class<T> requestManager) {
        T service = retrofitManagerToServiceMap.get(requestManager);

        if (service == null) {
            service = restAdapter.create(requestManager);
            retrofitManagerToServiceMap.put(requestManager, service);
        }

        return service;
    }

}
