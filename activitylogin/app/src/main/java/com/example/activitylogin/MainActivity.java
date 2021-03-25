package com.example.activitylogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick (View v) {

                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("admin") && passwordKey.equals("1234")){
                //jika berhasil login
                Toast.makeText(getApplicationContext(), "login sukses",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, welcome.class);
                MainActivity.this.startActivity(intent);
                finish();
            }else {
                    //jika login gagal
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Username atau password anda salah!")
                        .setNegativeButton("retry", null).create().show();
            }
            }
        });
    }
}
