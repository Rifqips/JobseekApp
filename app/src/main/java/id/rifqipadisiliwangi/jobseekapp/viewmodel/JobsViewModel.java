package id.rifqipadisiliwangi.jobseekapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.repository.JobsRepository;

public class JobsViewModel extends AndroidViewModel {

    private final LiveData<List<JobsItem>> jobsResponseLiveData;

    public JobsViewModel(@NonNull Application application) {
        super(application);

        JobsRepository jobsRepository = new JobsRepository();
        this.jobsResponseLiveData = jobsRepository.getJobsService();

    }

    public LiveData<List<JobsItem>> getArticleResponseLiveData() {
        return jobsResponseLiveData;
    }
}