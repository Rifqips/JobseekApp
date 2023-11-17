package id.rifqipadisiliwangi.jobseekapp.view.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.rifqipadisiliwangi.jobseekapp.R;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityDashboardBinding;
import id.rifqipadisiliwangi.jobseekapp.databinding.ActivityLoginBinding;
import id.rifqipadisiliwangi.jobseekapp.view.dashboard.DashboardActivity;
import id.rifqipadisiliwangi.jobseekapp.view.detail.DetailActivity;
import id.rifqipadisiliwangi.jobseekapp.view.onboarding.OnboardingActivity;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}