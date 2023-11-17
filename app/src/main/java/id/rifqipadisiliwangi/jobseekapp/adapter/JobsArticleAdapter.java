package id.rifqipadisiliwangi.jobseekapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import id.rifqipadisiliwangi.jobseekapp.R;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.view.detail.DetailActivity;

public class JobsArticleAdapter extends RecyclerView.Adapter<JobsArticleAdapter.ViewHolder> {

    private Context context;
    ArrayList<JobsItem> articleArrayList;

    public JobsArticleAdapter(Context context, ArrayList<JobsItem> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public JobsArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_jobs,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsArticleAdapter.ViewHolder viewHolder, int i) {
        JobsItem article = articleArrayList.get(i);
        viewHolder.tvTitle.setText(article.getTitle());
        viewHolder.tvDescription.setText(article.getDescription());
        if (article.getCompanyLogo() != null) {
            Glide.with(context)
                    .load(article.getCompanyLogo())
                    .into(viewHolder.imgViewCover);
        } else {
            viewHolder.imgViewCover.setImageResource(R.drawable.ic_image_default);
        }

        viewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Menggunakan Intent untuk memulai aktivitas baru
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("key", article.getId()); // Mengirim data tambahan jika diperlukan
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvTitle;
        private final TextView tvDescription;
        private final ImageView btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewCover=(ImageView) itemView.findViewById(R.id.iv_logo);
            tvTitle=(TextView) itemView.findViewById(R.id.tv_jobs_title);
            tvDescription=(TextView) itemView.findViewById(R.id.tv_jobs_description);
            btnDetail=(ImageView) itemView.findViewById(R.id.ic_detail);
        }
    }
}
