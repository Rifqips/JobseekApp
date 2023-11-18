package id.rifqipadisiliwangi.jobseekapp.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;

public class JobsComparator extends DiffUtil.ItemCallback<JobsItem> {
    @Override
    public boolean areItemsTheSame(@NonNull JobsItem oldItem, @NonNull JobsItem newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull JobsItem oldItem, @NonNull JobsItem newItem) {
        return oldItem.getId().equals(newItem.getId());
    }
}