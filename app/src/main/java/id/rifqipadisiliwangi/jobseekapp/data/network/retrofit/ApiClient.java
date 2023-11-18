package id.rifqipadisiliwangi.jobseekapp.data.network.retrofit;

import static id.rifqipadisiliwangi.jobseekapp.constans.AppConstant.BASE_URL;
import static id.rifqipadisiliwangi.jobseekapp.constans.AppConstant.CONTENT_URL;

import id.rifqipadisiliwangi.jobseekapp.model.JobsPageItem;
import io.reactivex.rxjava3.core.Single;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiClient {
    // Define APIInterface
    static APIInterface apiInterface;
    // create retrofit instance
    public static APIInterface getAPIInterface() {
        if (apiInterface == null) {
            // Create OkHttp Client
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            // Add interceptor to add API key as query string parameter to each request
            client.addInterceptor(chain -> {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .build();
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            });
            // Create retrofit instance
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client.build())
                    // Add Gson converter
                    .addConverterFactory(GsonConverterFactory.create())
                    // Add RxJava spport for Retrofit
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
            // Init APIInterface
            apiInterface = retrofit.create(APIInterface.class);
        }
        return apiInterface;
    }
    //API service interface
    public interface APIInterface {
        // Define Get request with query string parameter as page number
        @GET(CONTENT_URL)
        Single<JobsPageItem> getJobsByPage(@Query("page") int page);
    }
}
