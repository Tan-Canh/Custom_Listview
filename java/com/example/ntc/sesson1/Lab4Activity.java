package com.example.ntc.sesson1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Lab4Activity extends AppCompatActivity {
    private Restaurant r = new Restaurant();
    Button btnsave;
    EditText edtName, edtAddress;
    RadioGroup type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);
        btnsave = (Button) findViewById(R.id.buttonSave);
        edtName = (EditText) findViewById(R.id.edtName) ;
        edtAddress = (EditText) findViewById(R.id.edtAddress);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r.setName(edtName.getText().toString());
                r.setAddress(edtAddress.getText().toString());
                RadioGroup type = (RadioGroup)findViewById(R.id.type);
                switch (type.getCheckedRadioButtonId())
                {
                    case R.id.take_out:
                        r.setType("Take out");
                        break;
                    case R.id.sit_down:
                        r.setType("Sit down");
                        break;
                    case R.id.delivery:
                        r.setType("Delivery");
                        break;
                }
                Toast.makeText(Lab4Activity.this, r.getName() + r.getAddress()+ r.getType(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
