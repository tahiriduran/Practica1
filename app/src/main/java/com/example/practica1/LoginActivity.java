package com.example.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

  public static final String USER_NAME = "tduran";
  public static final String PASSWORD = "1234";

  private EditText userName;
  private EditText password;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    userName = (EditText)findViewById(R.id.usser);
    password = (EditText)findViewById(R.id.pass);

  }


  public void login(View view){
    // Usuario validado correctamente
    if(USER_NAME.equals(userName.getText().toString()) && PASSWORD.equals(password.getText().toString())){
      Intent i = new Intent(this, MainActivity.class);
      startActivity(i);
    }else{
      Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
    }
  }

  public void clear(View view){
    userName.setText("");
    password.setText("");
  }
}
