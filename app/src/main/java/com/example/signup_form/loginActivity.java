package com.example.signup_form;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class loginActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button login_btn;
    int counter=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText=(EditText)findViewById(R.id.EmaileditText);
        passwordEditText=(EditText)findViewById(R.id.passEditText);
        login_btn=(Button)findViewById(R.id.loginBtn);
        String registeredEmail = getIntent().getStringExtra("email");
        String registeredPassword= getIntent().getStringExtra("password");
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                assert registeredEmail != null;
                if(registeredEmail.equals(email) && Objects.equals(registeredPassword, password))
                {
                    Intent intent= new Intent(loginActivity.this,success.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(loginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
                counter--;
                if(counter==0){
                    Toast.makeText(getBaseContext(),"failed to login attempts",Toast.LENGTH_SHORT).show();
                            login_btn.setEnabled(false);
                }
            }
        });
    }
}
