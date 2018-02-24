package com.kaneki.firebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private EditText user,Email,pass,conpass;
    CardView card;
    TextView al;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    //private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        //databaseReference= FirebaseDatabase.getInstance().getReference();


        progressDialog=new ProgressDialog(this);


        user=(EditText)findViewById(R.id.editText);
        Email=(EditText)findViewById(R.id.editText3);
        pass=(EditText)findViewById(R.id.editText4);
        conpass=(EditText)findViewById(R.id.editText5);
        card=(CardView)findViewById(R.id.cardView);
        al=(TextView)findViewById(R.id.textView3);

        card.setOnClickListener(this);
        al.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v==card)
        {
            registeruser();
        }

        if(v==al)
        {
            Intent a=new Intent(Register.this,Login.class);
            startActivity(a);
        }
    }

    private void registeruser() {
        final String name=user.getText().toString().trim();
        final String email=Email.getText().toString().trim();
        final String password=pass.getText().toString().trim();
        final String confirm=conpass.getText().toString().trim();



        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please enter username",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(confirm)){
            Toast.makeText(this,"Please enter password again",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering.....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            //String user_id=firebaseAuth.getCurrentUser().getUid();
                            //DatabaseReference database_ref=databaseReference.child(user_id);
                            //database_ref.child("Name").setValue(name);
                            //database_ref.child("Email Id").setValue(email);
                            //database_ref.child("Password").setValue(password);
                            Toast.makeText(Register.this,"Registration successful",Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                            Intent a=new Intent(Register.this,Login.class);
                            startActivity(a);
                        }
                        else
                        {
                            Toast.makeText(Register.this,"Registration unsuccessful",Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                        }
                    }
                });

    }
}