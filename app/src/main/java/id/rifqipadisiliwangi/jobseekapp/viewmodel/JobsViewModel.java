package id.rifqipadisiliwangi.jobseekapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import java.util.List;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.data.repository.JobsRepository;
import id.rifqipadisiliwangi.jobseekapp.util.JobPagingSource;
import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

public class JobsViewModel extends ViewModel {
    // Define Flowable for movies
    public Flowable<PagingData<JobsItem>> jobPagingDataFlowable;
    public JobsViewModel() {
        init();
    }
    // Init ViewModel Data
    private void init() {
        // Define Paging Source
        JobPagingSource jobPagingSource = new JobPagingSource();

        // Create new Pager
        Pager<Integer, JobsItem> pager = new Pager(
                // Create new paging config
                new PagingConfig(10, //  Count of items in one page
                        10, //  Number of items to prefetch
                        false, // Enable placeholders for data which is not yet loaded
                        10, // initialLoadSize - Count of items to be loaded initially
                        10 * 499),// maxSize - Count of total items to be shown in recyclerview
                () -> jobPagingSource); // set paging source

        // inti Flowable
        jobPagingDataFlowable = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(jobPagingDataFlowable, coroutineScope);

    }
}