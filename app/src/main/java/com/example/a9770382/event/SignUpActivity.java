package com.example.a9770382.event;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.RequestQueue;

import android.widget.ProgressBar;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText userText = (EditText) findViewById(R.id.userText);
        final EditText emailSignUpText = (EditText) findViewById(R.id.emailSignUpText);
        final EditText confirmEmailText = (EditText) findViewById(R.id.confirmEmailText);
        final EditText passwordSignUpText = (EditText) findViewById(R.id.passwordSignUpText);
        final EditText confirmPasswordText = (EditText) findViewById(R.id.confirmPasswordText);
        final Button registerButton = (Button) findViewById(R.id.registerButton);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBarSignUp);
        progressBar.setVisibility(View.INVISIBLE);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String user = userText.getText().toString();
                String email = emailSignUpText.getText().toString();
                String confirmEmail = confirmEmailText.getText().toString();
                String password = passwordSignUpText.getText().toString();
                String confirmPassword = confirmPasswordText.getText().toString();

                if(user.isEmpty()){//if the user textbox is empty
                    AlertDialog.Builder alertEmail = new AlertDialog.Builder(SignUpActivity.this);
                    alertEmail.setMessage("You must fill the username  textbox. Please, try again.")
                            .setNegativeButton("Try Again",null).create().show();
                }
               else if(email.isEmpty()){//if the email textbox is empty
                    AlertDialog.Builder alertEmail = new AlertDialog.Builder(SignUpActivity.this);
                    alertEmail.setMessage("You must fill the email textbox. Please, try again.")
                            .setNegativeButton("Try Again",null).create().show();
                }
                else if(confirmEmail.isEmpty()){//if the confirm email textbox is empty
                    AlertDialog.Builder alertEmail = new AlertDialog.Builder(SignUpActivity.this);
                    alertEmail.setMessage("You must fill the confirm email textbox. Please, try again.")
                            .setNegativeButton("Try Again",null).create().show();
                }
                else if(!email.equals(confirmEmail)){    // If the emails are not equals.
                    AlertDialog.Builder alertEmail = new AlertDialog.Builder(SignUpActivity.this);
                    alertEmail.setMessage("The e-mails are not equals. Please, try again.")
                            .setNegativeButton("Try Again",null).create().show();
                }
                else if(password.isEmpty()){    // If the password textbox is empty.
                    AlertDialog.Builder alertEmail = new AlertDialog.Builder(SignUpActivity.this);
                    alertEmail.setMessage("You must fill the password textbox. Please, try again.")
                            .setNegativeButton("Try Again",null).create().show();
                }
                else if(confirmPassword.isEmpty()){    // If the confirm password textbox is empty.
                    AlertDialog.Builder alertEmail = new AlertDialog.Builder(SignUpActivity.this);
                    alertEmail.setMessage("You must fill the confirm password textbox. Please, try again.")
                            .setNegativeButton("Try Again",null).create().show();
                }
                else if(!password.equals(confirmPassword)){     // If the passwords are not equals.
                    AlertDialog.Builder alertPassword = new AlertDialog.Builder(SignUpActivity.this);
                    alertPassword.setMessage("The Passwords are not equals. Please, try again.")
                            .setNegativeButton("Try Again",null).create().show();
                }
                else{   // The datas are OK.
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                Log.e("REGISTER", "Entrou no Try");
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean conSuccess = jsonResponse.getBoolean("ConSuccess");//Get the response of the  String request
                                boolean userSuccess = jsonResponse.getBoolean("UserSuccess");
                                Log.e("REGISTER", "User success: " + jsonResponse.get("UserSuccess"));
                                boolean emailSuccess = jsonResponse.getBoolean("EmailSuccess");
                                VerifyResponse(conSuccess, userSuccess, emailSuccess, user);
                            } catch (JSONException e) {
                                Log.e("REGISTER", "Algum erro");
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                builder.setMessage("Register Failed. Could not connect.")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        }
                    };
                    RegisterRequest registerRequest = new RegisterRequest(user, email, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
                    queue.add(registerRequest);
                }
            }
        });
    }

    public void VerifyResponse(boolean conSuccess, boolean userSuccess, boolean emailSuccess, String user){
        if (conSuccess) {//If the Json object is sucess
            Log.e("REGISTER", "Entrou no if consuccess");
            if(emailSuccess && userSuccess){
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage("Registered Succesfully")
                        .setNegativeButton("Ok", null)
                        .create()
                        .show();
                Intent intent = new Intent(SignUpActivity.this, UserActivity.class);
                intent.putExtra("name",user);
                SignUpActivity.this.startActivity(intent);//Start the user Activity
            }
            else if(!userSuccess){
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage("The username already exists. Please, try again.")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                builder.setMessage("The email already exists. Please, try again.")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
            builder.setMessage("We couldn't make this operation. Please, verify your connection or try again later.")
                    .setNegativeButton("Retry", null)
                    .create()
                    .show();
        }
    }
}
