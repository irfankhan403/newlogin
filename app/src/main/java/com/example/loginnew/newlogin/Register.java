package com.example.loginnew.newlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {
    private static Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openLogin();
    }
    public void openLogin(){
        btn=(Button)findViewById(R.id.loginpage);
        btn.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent= new Intent("com.example.loginnew.newlogin.Login");
                        startActivity(intent);
                    }
                }
        );

    }
}
