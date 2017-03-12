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

        uname=(EditText)findViewById(R.id.usernamel);
        pass=(EditText)findViewById(R.id.passwordl);

        openRegister();
        final SQLiteDB db=new SQLiteDB(Login.this);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                db.open();
                String password=db.getEntry(uname.getText().toString());
                if (password.equals(pass.getText().toString())){
                    Toast.makeText(getApplicationContext(), "AUTHENTICATION SUCCESS", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "AUTHENTICATION FALIED", Toast.LENGTH_SHORT).show();
                }
                db.close();
                uname.setText("");
                pass.setText("");
            }
        });

    }

    public void openRegister(){
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
