package com.example.ntc.sesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    Button btnSave, btnUpdate;
    EditText txtName, txtAddress;
    ListView listView;
    RadioGroup radioGroup;
    RadioButton _radioSitDown, _radioTakeOut, _radioDelivery;
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();
    private RestaurantAdapter adapter;
    private int positionClickCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        initElement();
        btnSaveFunc();

        adapter = new RestaurantAdapter(this, restaurants);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                positionClickCurrent = i;
                Restaurant r = restaurants.get(i);

                txtName.setText(r.getName().toString());
                txtAddress.setText(r.getAddress().toString());

                if (r.getType().equals("1")) {
                    _radioDelivery = (RadioButton) findViewById(R.id.radioDelivery);
                    _radioDelivery.setChecked(true);
                } else if (r.getType().equals("2")) {
                    _radioSitDown = (RadioButton) findViewById(R.id.radioSitDown);
                    _radioSitDown.setChecked(true);
                } else if (r.getType().equals("3")) {
                    _radioTakeOut = (RadioButton) findViewById(R.id.radioTakeout);
                    _radioTakeOut.setChecked(true);
                }

                btnSave.setVisibility(View.INVISIBLE);
                btnUpdate.setVisibility(View.VISIBLE);
            }
        });

       btnUpdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Restaurant r = restaurants.get(positionClickCurrent);

               r.setName(txtName.getText().toString());
               r.setAddress(txtAddress.getText().toString());

               switch (radioGroup.getCheckedRadioButtonId()) {
                   case R.id.radioDelivery:
                       r.setType("1");
                       break;
                   case R.id.radioSitDown:
                       r.setType("2");
                       break;
                   case R.id.radioTakeout:
                       r.setType("3");
                       break;
               }
               restaurants.set(positionClickCurrent, r);
               adapter.notifyDataSetChanged();
               txtName.setText("");
               txtAddress.setText("");
               btnSave.setVisibility(View.VISIBLE);
               btnUpdate.setVisibility(View.INVISIBLE);
           }
       });
    }

    private void btnSaveFunc() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restaurant r = new Restaurant();

                r.setName(txtName.getText().toString());
                r.setAddress(txtAddress.getText().toString());

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioDelivery:
                        r.setType("1");
                        break;
                    case R.id.radioSitDown:
                        r.setType("2");
                        break;
                    case R.id.radioTakeout:
                        r.setType("3");
                        break;
                }
                restaurants.add(r);
                adapter.notifyDataSetChanged();
            }

        });

    }

    private void initElement() {
        btnSave = (Button) findViewById(R.id.buttonSave);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        txtName = (EditText) findViewById(R.id.edtName);
        txtAddress = (EditText) findViewById(R.id.edtAddress);
        listView   = (ListView) findViewById(R.id.lvData);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        btnSave.setVisibility(View.VISIBLE);
        btnUpdate.setVisibility(View.INVISIBLE);
    }

}
