package id.rifqipadisiliwangi.jobseekapp.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import org.jetbrains.annotations.NotNull;
import id.rifqipadisiliwangi.jobseekapp.databinding.ItemJobsBinding;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.view.detail.DetailActivity;

public class JobsArticleAdapter extends PagingDataAdapter<JobsItem, JobsArticleAdapter.JobsViewHolder> {
    // Define Loading ViewType
    public static final int LOADING_ITEM = 0;
    public static final int JOB_ITEM = 1;
    private Context context;
    RequestManager glide;
    public JobsArticleAdapter(@NotNull DiffUtil.ItemCallback<JobsItem> diffCallback, RequestManager glide, Context context) {
        super(diffCallback);
        this.glide = glide;
        this.context = context;
    }

    @NonNull
    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JobsViewHolder(ItemJobsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JobsViewHolder holder, int position) {
        JobsItem currentJobs = getItem(position);
        // Check for null
        if (currentJobs != null) {
            holder.jobsItemBinding.tvJobsTitle.setText(currentJobs.getTitle());
            holder.jobsItemBinding.tvJobsDescription.setText(currentJobs.getDescription());
            glide.load(currentJobs.getCompanyLogo())
                    .into(holder.jobsItemBinding.ivLogo);
            holder.jobsItemBinding.icDetail.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("KEY_ID", currentJobs.getId());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        // set ViewType
        return position == getItemCount() ?JOB_ITEM : LOADING_ITEM;
    }

    public class JobsViewHolder extends RecyclerView.ViewHolder {
        ItemJobsBinding jobsItemBinding;

        public JobsViewHolder(@NonNull ItemJobsBinding jobsItemBinding) {
            super(jobsItemBinding.getRoot());
            this.jobsItemBinding = jobsItemBinding;
        }
    }

}