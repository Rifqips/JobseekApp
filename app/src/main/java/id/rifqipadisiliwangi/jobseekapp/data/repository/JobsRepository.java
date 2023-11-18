package id.rifqipadisiliwangi.jobseekapp.data.repository;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.data.network.retrofit.ApiClient;
import id.rifqipadisiliwangi.jobseekapp.data.network.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobsRepository {
//    private static final String TAG = "JobsRepository";
//
//    private ApiService apiService;
//
//    public JobsRepository() {
//        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
//    }
//
//    public LiveData<List<JobsItem>> getJobsService() {
//        final MutableLiveData<List<JobsItem>> data = new MutableLiveData<>();
//        apiService.getJobsService("")
//                .enqueue(new Callback<List<JobsItem>>() {
//
//                    @Override
//                    public void onResponse(Call<List<JobsItem>> call, Response<List<JobsItem>> response) {
//
//                        if (response.body() != null) {
//                            data.setValue(response.body());
//
//                            Log.d(TAG, "onResponse response:: " + response.body().get(0));
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<JobsItem>> call, Throwable t) {
//                        Log.d(TAG, "onResponse failure:: " + t);
//                        data.setValue(null);
//                    }
//                });
//        return data;
//    }
}
