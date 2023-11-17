package id.rifqipadisiliwangi.jobseekapp.data.network.retrofit;

import static id.rifqipadisiliwangi.jobseekapp.constans.AppConstant.CONTENT_URL;
import java.util.List;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface  ApiService {
    @GET(CONTENT_URL)
    Call<List<JobsItem>> getJobsService(@Query("query") String query);
    @GET("recruitment/positions/{id}")
    Call<JobsItem> getJobsDetailService(@Path("id") String postId);
}
