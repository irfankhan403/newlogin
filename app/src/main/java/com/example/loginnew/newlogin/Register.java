package com.example.loginnew.newlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    Button register,loginpage;
    EditText et_name,et_password,et_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openLogin();

        et_name=(EditText)findViewById(R.id.name);
        et_username=(EditText)findViewById(R.id.usernamel);
        et_password=(EditText)findViewById(R.id.passwordl);
        register =(Button)findViewById(R.id.button);

        final SQLiteDB db=new SQLiteDB(Register.this);
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                db.open();
                db.insert(et_name.getText().toString(),et_username.getText().toString(),et_password.getText().toString());
                db.close();
            }
        });



    }
    public void openLogin(){
        loginpage=(Button)findViewById(R.id.loginpage);
        loginpage.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent= new Intent("com.example.loginnew.newlogin.Login");
                        startActivity(intent);
                    }
                }
        );

    }
}
