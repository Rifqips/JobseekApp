package id.rifqipadisiliwangi.jobseekapp.view.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.rifqipadisiliwangi.jobseekapp.R;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityDashboardBinding;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityOnboardingBinding;
import id.rifqipadisiliwangi.jobseekapp.view.auth.LoginActivity;
import id.rifqipadisiliwangi.jobseekapp.view.detail.DetailActivity;

public class OnboardingActivity extends AppCompatActivity {

    ActivityOnboardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}