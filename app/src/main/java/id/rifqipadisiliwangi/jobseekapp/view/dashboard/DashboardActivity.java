package id.rifqipadisiliwangi.jobseekapp.view.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import id.rifqipadisiliwangi.jobseekapp.data.network.retrofit.ApiClient;
import id.rifqipadisiliwangi.jobseekapp.data.network.retrofit.ApiService;
import id.rifqipadisiliwangi.jobseekapp.util.GridSpace;
import id.rifqipadisiliwangi.jobseekapp.util.JobsComparator;
import id.rifqipadisiliwangi.jobseekapp.view.adapter.JobLoadStateAdapter;
import id.rifqipadisiliwangi.jobseekapp.view.adapter.JobsArticleAdapter;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityDashboardBinding;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.viewmodel.JobsViewModel;

@AndroidEntryPoint
public class DashboardActivity extends AppCompatActivity {
    ActivityDashboardBinding binding;
    JobsViewModel jobsViewModel;
    JobsArticleAdapter jobsAdapter;
    @Inject
    RequestManager requestManager;


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initRecyclerviewAndAdapter();

        jobsAdapter = new JobsArticleAdapter(new JobsComparator(),requestManager,this);
        // Create ViewModel
        jobsViewModel = new ViewModelProvider(this).get(JobsViewModel.class);
        jobsViewModel.jobPagingDataFlowable.subscribe(jobsPagingData -> {
            // submit new data to recyclerview adapter
            jobsAdapter.submitData(getLifecycle(), jobsPagingData);
        });

    }

    private void initRecyclerviewAndAdapter() {
        // Create GridlayoutManger with span of count of 2
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        // Finally set LayoutManger to recyclerview
        binding.rvJobs.setLayoutManager(gridLayoutManager);

        // Add ItemDecoration to add space between recyclerview items
        binding.rvJobs.addItemDecoration(new GridSpace(2, 20, true));

        // set adapter
        binding.rvJobs.setAdapter(
                // This will show end user a progress bar while pages are being requested from server
                jobsAdapter.withLoadStateFooter(
                        // When we will scroll down and next page request will be sent
                        // while we get response form server Progress bar will show to end user
                        new JobLoadStateAdapter(v -> {
                            jobsAdapter.retry();
                        })));
        // set Grid span to set progress at center
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                // If progress will be shown then span size will be 1 otherwise it will be 2
                return jobsAdapter.getItemViewType(position) == JobsArticleAdapter.LOADING_ITEM ? 1 : 2;
            }
        });

    }


}