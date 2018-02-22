package com.kaneki.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText d_et_1,d_et_2,d_et_3,d_et_4,d_et_5;
    String d_s_1;
    String d_s_2;
    double d_i_1,d_i_2,d_i_3;
    Button d_b_1;
    Details d_d_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d_b_1 = (Button) findViewById(R.id.d_b_1);

        d_et_1 = (EditText) findViewById(R.id.d_et_1);
        d_et_2 = (EditText) findViewById(R.id.d_et_2);
        d_et_3 = (EditText) findViewById(R.id.d_et_3);
        d_et_4 = (EditText) findViewById(R.id.d_et_4);
        d_et_5 = (EditText) findViewById(R.id.d_et_5);


        d_b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d_s_1 = d_et_1.getText().toString();
                d_s_2 = d_et_3.getText().toString();
                d_i_2 = Double.parseDouble(d_et_4.getText().toString());
                d_i_3 = Double.parseDouble(d_et_5.getText().toString());
                d_i_1 =  Double.parseDouble(d_et_2.getText().toString());

                d_d_1 = new Details(d_s_1,d_s_2,d_i_1,d_i_2,d_i_3);

                
            }
        });
    }
}
