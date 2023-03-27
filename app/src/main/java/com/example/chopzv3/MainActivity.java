package com.example.chopzv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chopzv3.AdminUser.AdminSignIn;
import com.example.chopzv3.ClientUser.ClientUserSignIn;
import com.example.chopzv3.DriverUser.DriverSignIn;
import com.example.chopzv3.RestaurantUser.RestaurantSignIn;
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
           Intent clientUser = new Intent(MainActivity.this, ClientUserSignIn.class);
           startActivity(clientUser);
        }else if (view == restaurantUser){
            Intent restaurantUser = new Intent(MainActivity.this, RestaurantSignIn.class);
            startActivity(restaurantUser);
        }else if (view == driverUser){
            Intent driverUser = new Intent(MainActivity.this, DriverSignIn.class);
            startActivity(driverUser);
        }else if (view == adminUser){
            Intent adminUser = new Intent(MainActivity.this, AdminSignIn.class);
            startActivity(adminUser);
        }
    }
}