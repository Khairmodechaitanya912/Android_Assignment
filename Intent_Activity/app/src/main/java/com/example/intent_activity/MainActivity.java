package com.example.intent_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText UsernameText, PasswordText;
    Button BtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsernameText = (EditText) findViewById(R.id.username_Text);
        PasswordText = (EditText) findViewById(R.id.password_Text);
        BtnLogin = (Button) findViewById(R.id.Login);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Username = UsernameText.getText().toString();
                String Password = PasswordText.getText().toString();

                if (Username.equals("Admin") && (Password.equals("123456")))
                {
                    Toast.makeText(MainActivity.this, "Login Successfully",Toast.LENGTH_SHORT).show();

                    Intent i=new Intent( MainActivity.this, FirstActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Credential",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}