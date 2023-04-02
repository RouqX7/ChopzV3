package com.example.chopzv3.AdminUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chopzv3.AdminUser.Model.UserAdministrator;
import com.example.chopzv3.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminSignIn extends AppCompatActivity {

    TextInputEditText edtPhone, edtPassword;
    MaterialButton btnSignInAppAdmin;
    FirebaseDatabase database;
    DatabaseReference appAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_in);

        edtPhone = findViewById(R.id.admin_user_phone);
        edtPassword = findViewById(R.id.admin_user_password);

        database = FirebaseDatabase.getInstance();
        appAdmin = database.getReference("Administrator");

        btnSignInAppAdmin = findViewById(R.id.btn_admin_user_Sign_in);
        btnSignInAppAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInAppAdministrator(edtPhone.getText().toString(), edtPassword.getText().toString());
            }
        });
    }

        private void signInAppAdministrator(String phone, String password) {
        final String localPhone = phone;
        final String localPassword = password;
            appAdmin.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.child(localPhone).exists()) {

                        UserAdministrator user = snapshot.child(localPhone).getValue(UserAdministrator.class);
                        user.setPhone(localPhone);
                        if (user.getPassword().equals(localPassword)) {
                            Intent login = new Intent(AdminSignIn.this, AddRestaurantsActivity.class);
                            ConstantAdmin.currentUser = user;
                            startActivity(login);
                            finish();

                        } else {
                            Toast.makeText(AdminSignIn.this, "wrong Password", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(AdminSignIn.this, "User not exist in database", Toast.LENGTH_SHORT).show();
                    }
        }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });

        }


}