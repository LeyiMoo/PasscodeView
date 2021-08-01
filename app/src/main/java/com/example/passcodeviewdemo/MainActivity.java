package com.example.passcodeviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hanks.passcodeview.PasscodeView;

public class MainActivity extends AppCompatActivity {
    //Initialise variable
    PasscodeView passcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variable
        passcodeView = findViewById(R.id.passcode_view);
        passcodeView.setPasscodeLength(4) // set password length
                // this bit should use user password info in database
                // therefore i just randomly create a password here
        .setLocalPasscode("1234") //set Password
        .setListener(new PasscodeView.PasscodeViewListener() {
            @Override
            public void onFail() {
                //If password is wrong
                Toast.makeText(getApplicationContext()
                    ,"Password is Wrong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String number) {
                //If the password is correct
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}