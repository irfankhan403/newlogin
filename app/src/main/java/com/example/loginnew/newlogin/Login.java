package com.example.loginnew.newlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static Button btn;
    private static EditText uname;
    private static EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
        openRegistor();
    }
    public void login(){
        uname=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);

        btn=(Button)findViewById(R.id.signin);
        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(uname.getText().toString().equals("admin")&&pass.getText().toString().equals("admin")){
                            Toast.makeText(Login.this, "Valid Credential", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Login.this, "InvValid Credential", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
    public void openRegistor(){
        btn=(Button)findViewById(R.id.registerpage);
        btn.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent= new Intent("com.example.loginnew.newlogin.Register");
                        startActivity(intent);
                    }
                }
        );
    }

}
