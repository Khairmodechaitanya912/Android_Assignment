package com.example.useofdatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText id,name,address,phoneno;
    Button insert,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        id =(EditText) findViewById(R.id.CustID);
        name =(EditText) findViewById(R.id.CustName);
        address =(EditText) findViewById(R.id.CustAdd);
        phoneno =(EditText) findViewById(R.id.CustMob);

        insert =(Button) findViewById(R.id.BtnADD);
        view =(Button) findViewById(R.id.BtnView);

        AddData();
        ViewAll();
    }

    public void AddData()
    {
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isinserted = db.insertdata(id.getText().toString(),name.getText().toString(),address.getText().toString(),phoneno.getText().toString());
                if (isinserted== true)
                    Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ViewAll()
    {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getAllData();
                if (res.getCount() == 0)
                {
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Id : "+ res.getString(0)+"\n");
                    buffer.append("Name : "+ res.getString(1)+"\n");
                    buffer.append("Address : "+ res.getString(2)+"\n");
                    buffer.append("Mobile No : "+ res.getString(3)+"\n\n");
                }
                showMessage("Customer Details",buffer.toString());
            }
        });
    }

    public void showMessage(String title , String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}