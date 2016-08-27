package com.example.passwordgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Quick and Dirty Password Generator
 */

public class PasswordGeneratorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextViewTitle;
    private TextView mTextViewPassWord;
    private Button mButtonPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_generator);
        mTextViewTitle = (TextView) findViewById(R.id.textTitle);
        mTextViewPassWord = (TextView) findViewById(R.id.textPassword);
        mButtonPassword = (Button) findViewById(R.id.btnPassword);
        mButtonPassword.setOnClickListener(this);

        mTextViewTitle.setText("Random String: ");
        mTextViewPassWord.setText("Press Button");
        mButtonPassword.setText("Generate Password");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPassword:
                generatePassword();
                break;
        }
    }

    private void generatePassword() {
        String getRandomSring = genRandomString();
        mTextViewPassWord.setText(getRandomSring);
    }

    private String genRandomString() {
        Random random = new Random();
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        int upperCaseLength = 1;
        int lowerCaseLength = 4;
        int numericLength = 3;
        int passwordLength = upperCaseLength + lowerCaseLength + numericLength;

        StringBuilder stringBuilder = new StringBuilder(passwordLength);
        StringBuilder passwordBuilder = new StringBuilder(passwordLength);

        stringBuilder.append(upperCaseChars.charAt(random.nextInt(upperCaseChars.length())));

        for (int i = 0; i < lowerCaseLength; i++) {
            stringBuilder.append(lowerCaseChars.charAt(random.nextInt(lowerCaseChars.length())));
        }

        for (int i = 0; i < numericLength; i++) {
            stringBuilder.append(random.nextInt(10));
        }

//        Log.i("Password", "stringBuilder before: " + stringBuilder + " length: " + stringBuilder.length());

        for (int i = 0; i < passwordLength; i++) {
            int placement = random.nextInt(stringBuilder.length());
            passwordBuilder.append(stringBuilder.charAt(placement));
            stringBuilder.deleteCharAt(placement);
        }

//        Log.i("password", "stringBuilder after: " + stringBuilder + " length: " + stringBuilder.length());

        return passwordBuilder.toString();
    }
}
