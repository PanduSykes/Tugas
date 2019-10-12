package com.example.rpl2016_21.tugaspandu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

public class Login extends AppCompatActivity {

    public EditText editudername;
    public EditText editpassword;
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editudername = findViewById(R.id.edUsername);
        editpassword = findViewById(R.id.edPassword);
        btn = findViewById(R.id.btnLogin);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (editudername.getText().toString().isEmpty()) {
                            Toast.makeText(Login.this, "email  tidak boleh kosong", Toast.LENGTH_SHORT).show();
                        } else if (editpassword.getText().toString().isEmpty()) {
                            Toast.makeText(Login.this, "password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                        } else {
                            AndroidNetworking.post("http://192.168.6.9/pandu/connect.php")
                                    .addBodyParameter("username", editudername.getText().toString())
                                    .addBodyParameter("password", editpassword.getText().toString())
                                    .setPriority(Priority.MEDIUM)
                                    .build()
                                    .getAsJSONObject(new JSONObjectRequestListener() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            Toast.makeText(Login.this, "sukses", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onError(ANError error) {
                                            Log.e("", "onError: " + error.getErrorDetail());
                                            Toast.makeText(Login.this, "error"+ error.getErrorDetail(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    }
                });
//
    }
}
