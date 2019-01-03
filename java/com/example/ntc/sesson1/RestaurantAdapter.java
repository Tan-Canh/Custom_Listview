package com.example.ntc.sesson1;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant>{
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();
    Context context;
    TextView txtAdderss, txtName;
    RadioGroup radioGroup;
    ImageView iconShow;
    Button btnRemove;

    public RestaurantAdapter(@NonNull Context context, @NonNull List<Restaurant> restaurants) {
        super(context, 0, 0);
        this.restaurants = restaurants;
        this.context = context;
    }

        @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        }

        txtAdderss = (TextView) row.findViewById(R.id.addressShow);
        txtName    = (TextView) row.findViewById(R.id.titleShow);
        btnRemove = (Button) row.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restaurants.remove(position);
                notifyDataSetChanged();
            }
        });
        Restaurant r = restaurants.get(position);
        txtAdderss.setText(r.getAddress().toString());
        txtName.setText(r.getName().toString());

//        XU LY ANH
        iconShow = (ImageView) row.findViewById(R.id.iconShow);
        if (r.getType().equals("1")) {
            Picasso.get().load("data:image/png;base64,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").into(iconShow);
        } else if (r.getType().equals("2")) {
            Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Node.js_logo.svg/1200px-Node.js_logo.svg.png").into(iconShow);
        } else if (r.getType().equals("3")) {
            Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Python.svg/1200px-Python.svg.png").into(iconShow);
        }
        return row;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }
}
