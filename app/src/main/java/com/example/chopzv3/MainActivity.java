package com.example.chopzv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton clientUser,restaurantUser,driverUser,adminUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientUser = findViewById(R.id.btn_client_SignIn);
        clientUser.setOnClickListener(this);

        restaurantUser =findViewById(R.id.btn_restaurant_SignIn);
        restaurantUser.setOnClickListener(this);

        driverUser = findViewById(R.id.btn_driver_SignIn);
        driverUser.setOnClickListener(this);

        adminUser =  findViewById(R.id.btn_administrator_SignIn);
        adminUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == clientUser){
            Toast.makeText(this, "Client User Active", Toast.LENGTH_SHORT).show();
        }else if (view == restaurantUser){
            Toast.makeText(this, "Restaurant User Active", Toast.LENGTH_SHORT).show();

        }else if (view == driverUser){
            Toast.makeText(this, "Driver User Active", Toast.LENGTH_SHORT).show();

        }else if (view == adminUser){
            Toast.makeText(this, "Admin User Active", Toast.LENGTH_SHORT).show();

        }
    }
}