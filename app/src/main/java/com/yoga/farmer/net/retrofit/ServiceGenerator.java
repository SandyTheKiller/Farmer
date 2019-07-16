package com.yoga.farmer.net.retrofit;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.yoga.farmer.constants.C.url.API_BASE_URL;
import static com.yoga.farmer.constants.C.url.BASE_URL_DSIJ;

public class ServiceGenerator {

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(new BasicAuthInterceptor("admin", "1234"))
            .addNetworkInterceptor(new StethoInterceptor());

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
    /*sandip*/
    private static Retrofit.Builder builderLocal =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL_DSIJ)
                    .addConverterFactory(GsonConverterFactory.create());


/*gayatri PC*/
    public static <S> S createServiceLocal(Class<S> serviceClass) {
        Retrofit retrofit = builderLocal.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }


}