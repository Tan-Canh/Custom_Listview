package com.example.ntc.sesson1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvMonhoc;
    private ArrayAdapter adapter;
    private ArrayList<String> dataMonHoc;
    private EditText edtTenMH;
    private Button btnADdd, btnUpdate;
    private int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonhoc = (ListView) findViewById(R.id.listviewMonHoc);
        edtTenMH = (EditText) findViewById(R.id.edtTen);
        btnADdd = (Button) findViewById(R.id.buttonAdd);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);

        dataMonHoc = new ArrayList<String>();
        dataMonHoc.add("Nodejs");
        dataMonHoc.add("Javascript");
        dataMonHoc.add("Angularjs");
        dataMonHoc.add("ReactJS");

        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, dataMonHoc);
        lvMonhoc.setAdapter(adapter);


        lvMonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtTenMH.setText(dataMonHoc.get(i));
                vitri = i;
            }
        });

        btnADdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTenMH.getText().toString();
                dataMonHoc.add(ten);
                adapter.notifyDataSetChanged();
                edtTenMH.setText("");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = edtTenMH.getText().toString();
                dataMonHoc.set(vitri, t);
                adapter.notifyDataSetChanged();
                edtTenMH.setText("");
            }
        });
        lvMonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Ban vua xoa " + dataMonHoc.get(i), Toast.LENGTH_SHORT).show();
                dataMonHoc.remove(vitri);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
// lấy menu ngữ cảnh của ứng dụng
        MenuInflater inflater = getMenuInflater();
// thiết lập menu
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.mnu_clear:
//                Toast.makeText(MainActivity.this, "Ban vua nhan nut clear", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder message = new AlertDialog.Builder(this);
                message.setTitle("Hello");
                message.setMessage("Thong bao thanh cong");
                message.setNeutralButton("Clear", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText et = (EditText)findViewById(R.id.edtTen);
                                et.setText(""); // xoá nội dung edittext
                            }
                        }).show();
// viết phần xoá ở đây
                break;
            case R.id.mnu_setting:
                Toast.makeText(MainActivity.this, "Ban vua nhan nut setting", Toast.LENGTH_SHORT).show();

// phần setting
                break;
            case R.id.mnu_exit:
//                Toast.makeText(MainActivity.this, "Ban vua nhan nut exist", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setMessage("ban co muon thoat hay khong.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
// thoát ứng dụng
                break;
        } //end switch
        return true;
    }// end onOptionsItemSelected
}
