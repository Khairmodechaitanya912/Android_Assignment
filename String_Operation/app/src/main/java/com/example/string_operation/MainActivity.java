package com.example.string_operation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText ed1;
    RadioButton rbtn1,rbtn2,rbtn3,rbtn4;
    TextView te1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbtn1 = findViewById(R.id.r1);
        rbtn2 = findViewById(R.id.r2);
        rbtn3 = findViewById(R.id.r3);
        rbtn4 = findViewById(R.id.r4);

        te1 = findViewById(R.id.t1);

        ed1 = findViewById(R.id.enter);

        btn = findViewById(R.id.Btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable c1 = ed1.getEditableText();
                String str1 = c1.toString();

                if (rbtn1.isChecked())
                {
                    String uc = str1.toUpperCase();
                    te1.setText(uc);
                }
                if (rbtn2.isChecked())
                {
                    String lc = str1.toLowerCase();
                    te1.setText(lc);
                }
                if (rbtn3.isChecked())
                {
                    String rc = str1.substring(str1.length()-5);
                    te1.setText(rc);
                }
                if (rbtn4.isChecked())
                {
                    String llc = str1.substring(0,5);
                    te1.setText(llc);
                }
            }
        });
    }
}