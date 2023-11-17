package id.rifqipadisiliwangi.jobseekapp.retrofit;

import static id.rifqipadisiliwangi.jobseekapp.constans.AppConstant.CONTENT_URL;
import java.util.List;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface  ApiService {
    @GET(CONTENT_URL)
    Call<List<JobsItem>> getJobsService();
    @GET("recruitment/positions/{id}")
    Call<JobsItem> getJobsDetailService(@Path("id") String postId);
}
