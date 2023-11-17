package id.rifqipadisiliwangi.jobseekapp.view.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import id.rifqipadisiliwangi.jobseekapp.R;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityDashboardBinding;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityDetailBinding;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.retrofit.ApiClient;
import id.rifqipadisiliwangi.jobseekapp.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        String postId = getIntent().getStringExtra("");
        if (postId != "") {
            getPostDetail(postId);
        }

        binding.tvWebsite.setPaintFlags(binding.tvWebsite.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.icBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
    private void getPostDetail(String postId) {
        ApiService apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<JobsItem> call = apiService.getJobsDetailService(postId);

        call.enqueue(new Callback<JobsItem>() {
            @Override
            public void onResponse(Call<JobsItem> call, Response<JobsItem> response) {
                if (response.isSuccessful()) {
                    JobsItem jobsItem = response.body();
                    if (jobsItem != null) {

                    }
                } else {
                    // Tangani respons tidak berhasil di sini
                }
            }

            @Override
            public void onFailure(Call<JobsItem> call, Throwable t) {
                // Tangani kegagalan di sini
            }
        });
    }
}