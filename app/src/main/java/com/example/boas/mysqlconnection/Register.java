package com.example.boas.mysqlconnection;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{

    public static final String SP_NAME = "userDetails";
    Button bRegister;
    EditText etName, etAge, etUsername, etPassword;
    SharedPreferences userLocalDatabase;
    UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bRegister:

                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                //User registeredData = new User(name, age, username, password);
                SharedPreferences.Editor spEditor = userLocalDatabase.edit();
                spEditor.putString("name", name);
                spEditor.putInt("age", age);
                spEditor.putString("username", username);
                spEditor.putString("password", password);
                spEditor.commit();

                startActivity(new Intent(this, Login.class));

                break;
        }
    }
}
