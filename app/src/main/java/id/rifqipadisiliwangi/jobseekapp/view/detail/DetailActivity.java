package id.rifqipadisiliwangi.jobseekapp.view.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;

import id.rifqipadisiliwangi.jobseekapp.R;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityDetailBinding;
import id.rifqipadisiliwangi.jobseekapp.model.JobsItem;
import id.rifqipadisiliwangi.jobseekapp.viewmodel.JobsDetailViewModel;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getDetail();

        binding.tvWebsite.setPaintFlags(binding.tvWebsite.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.icBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void getDetail() {
        Intent intent = getIntent();
        String jobsId = intent.getStringExtra("KEY_ID");

        if (jobsId != "") {
            // Inisialisasi ViewModel
            JobsDetailViewModel viewModel = new ViewModelProvider(this).get(JobsDetailViewModel.class);

            // Mendapatkan detail berdasarkan ID
            viewModel.getDetailById(jobsId).observe(this, new Observer<JobsItem>() {
                @Override
                public void onChanged(JobsItem jobsItem) {
                    if (jobsItem != null) {
                        if(jobsItem.getCompanyLogo() != null) {
                            Glide.with(getApplicationContext())
                                    .load(jobsItem.getCompanyLogo())
                                    .into(binding.ivLogo);
                        } else {
                            binding.ivLogo.setImageResource(R.drawable.ic_image_default);
                        }
                        binding.tvJobsTitle.setText(jobsItem.getCompany());
                        binding.tvJobsLocation.setText(jobsItem.getLocation());
                        binding.tvWebsite.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openChromeWithUrl(jobsItem.getCompanyUrl());
                            }
                        });
                        binding.tvJobsSpesification.setText(jobsItem.getTitle());
                        binding.tvJobsOption.setText(jobsItem.getType());
                        binding.tvContentDescription.setText(jobsItem.getDescription());
                    }
                }

            });
        }
    }

    private void openChromeWithUrl(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        }
    }

}