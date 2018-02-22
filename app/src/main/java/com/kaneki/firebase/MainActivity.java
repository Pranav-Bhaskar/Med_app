package com.kaneki.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    TextView d_tv_1;
    EditText d_et_1,d_et_2,d_et_3,d_et_4,d_et_5;
    String d_s_1, d_s_2;
    int d_i_1,d_i_2,d_i_3;
    Button d_b_1;
    Details d_d_1;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d_tv_1 = (TextView) findViewById(R.id.d_tv_1) ;

        d_b_1 = (Button) findViewById(R.id.d_b_1);

        d_et_1 = (EditText) findViewById(R.id.d_et_1);
        d_et_2 = (EditText) findViewById(R.id.d_et_2);
        d_et_3 = (EditText) findViewById(R.id.d_et_3);
        d_et_4 = (EditText) findViewById(R.id.d_et_4);
        d_et_5 = (EditText) findViewById(R.id.d_et_5);



        databaseReference = FirebaseDatabase.getInstance().getReference();




        d_b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                d_s_1 = d_et_1.getText().toString().trim();
                d_s_2 = d_et_3.getText().toString().trim();

                d_i_1 = Integer.parseInt( d_et_2.getText().toString() );
                d_i_2 = Integer.parseInt(d_et_4.getText().toString().trim());
                d_i_3 = Integer.parseInt(d_et_5.getText().toString().trim());


                String id = databaseReference.push().getKey();
                d_d_1 = new Details(id,d_s_1,d_s_2,d_i_1,d_i_2,d_i_3);
                databaseReference.child(id).setValue(d_d_1);

                Toast.makeText (getApplicationContext(), "Donated", Toast.LENGTH_LONG).show();

            }
        });
    }
}
