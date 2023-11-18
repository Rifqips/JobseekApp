package id.rifqipadisiliwangi.jobseekapp.util;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import id.rifqipadisiliwangi.jobseekapp.data.network.retrofit.ApiClient;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.model.JobsPageItem;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class JobPagingSource extends RxPagingSource<Integer, JobsItem> {

    @NotNull
    @Override
    public Single<PagingSource.LoadResult<Integer, JobsItem>> loadSingle(@NotNull PagingSource.LoadParams<Integer> loadParams) {
        try {
            // If page number is already there then init page variable with it otherwise we are loading fist page
            int page = loadParams.getKey() != null ? loadParams.getKey() : 1;
            // Send request to server with page number
            return ApiClient.getAPIInterface()
                    .getJobsByPage(page)
                    .subscribeOn(Schedulers.io())
                    .map(JobsPageItem::getResults)
                    .map(jobs -> toLoadResult(jobs, page))
                    .onErrorReturn(PagingSource.LoadResult.Error::new);
        } catch (Exception e) {
            // Request ran into error return error
            return Single.just(new PagingSource.LoadResult.Error(e));
        }
    }
    private PagingSource.LoadResult<Integer, JobsItem> toLoadResult(List<JobsItem> jobs, int page) {
        return new PagingSource.LoadResult.Page(jobs, page == 1 ? null : page - 1, page + 1);
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, JobsItem> pagingState) {
        return null;
    }
}
