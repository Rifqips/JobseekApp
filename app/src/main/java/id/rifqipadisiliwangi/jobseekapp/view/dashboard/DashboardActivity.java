package id.rifqipadisiliwangi.jobseekapp.view.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import id.rifqipadisiliwangi.jobseekapp.adapter.JobsArticleAdapter;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityDashboardBinding;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.viewmodel.JobsViewModel;

public class DashboardActivity extends AppCompatActivity {
    ActivityDashboardBinding binding;
    private static final String TAG = "DashboardActivity";
    private JobsArticleAdapter adapter;
    private ArrayList<JobsItem> articleArrayList = new ArrayList<>();
    JobsViewModel jobsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initialization();
        getJobsArticles();
    }


    private void initialization() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(DashboardActivity.this);
        binding.rvJobs.setLayoutManager(layoutManager);
        binding.rvJobs.setHasFixedSize(true);
        adapter = new JobsArticleAdapter(DashboardActivity.this, articleArrayList);
        binding.rvJobs.setAdapter(adapter);
        jobsViewModel = new ViewModelProvider(this).get(JobsViewModel.class);

    }

    @SuppressLint("NotifyDataSetChanged")
    private void getJobsArticles() {
        jobsViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {
                binding.pbDashboard.setVisibility(View.GONE);
                List<JobsItem> articles = articleResponse;
                articleArrayList.addAll(articles);
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "No Values", Toast.LENGTH_SHORT).show();
            }
        });
    }

}