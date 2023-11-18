package id.rifqipadisiliwangi.jobseekapp.data.repository;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.data.network.retrofit.ApiClient;
import id.rifqipadisiliwangi.jobseekapp.data.network.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobsDetailRepository {
//    private static final String TAG = "JobsRepository";
//    private ApiService apiService;
//
//    public JobsDetailRepository() {
//        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
//    }
//    public LiveData<JobsItem> getDetailsService(String jobsId) {
//        final MutableLiveData<JobsItem> data = new MutableLiveData<>();
//        apiService.getJobsDetailService(jobsId)
//                .enqueue(new Callback<JobsItem>() {
//
//                    @Override
//                    public void onResponse(Call<JobsItem> call, Response<JobsItem> response) {
//
//                        if (response.body() != null) {
//                            data.setValue(response.body());
//
//                            Log.d(TAG, "onResponse response Detail:: " + response.body());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<JobsItem> call, Throwable t) {
//                        Log.d(TAG, "onResponse failure Detail:: " + t);
//                        data.setValue(null);
//                    }
//                });
//        return data;
//    }
}
