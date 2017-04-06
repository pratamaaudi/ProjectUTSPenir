package com.example.audi.projectutspenir;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Audi on 4/4/2017.
 */

public class CustomView extends ArrayAdapter{
    private final Context context;
    private final ArrayList<soal> values;

    public CustomView(Context context, ArrayList<soal> values){
        super(context, R.layout.list_layout, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_layout,parent,false);

        int id = ambilidgambar(v,position);

        ImageView imgsoal = (ImageView) v.findViewById(R.id.imgsoal);
        imgsoal.setImageResource(id);

        LinearLayout llbadan = (LinearLayout) v.findViewById(R.id.llbadan);
        TextView txtstatus = (TextView) v.findViewById(R.id.txtstatus);

        if(values.get(position).getStatus()==true){
            llbadan.setBackgroundColor(Color.parseColor("#607D8B"));
            txtstatus.setBackgroundColor(Color.parseColor("#607D8B"));
            txtstatus.setText("TERJAWAB");
        } else {
            llbadan.setBackgroundColor(Color.parseColor("#66BB6A"));
            txtstatus.setBackgroundColor(Color.parseColor("#66BB6A"));
            txtstatus.setText("BELUM TERJAWAB");
        }

        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/font.ttf");
        txtstatus.setTypeface(custom_font);

        return v;
    }

    public int ambilidgambar(View v, int position){
        soal s = values.get(position);
        int resID = v.getResources().getIdentifier(s.getGambar(), "drawable", context.getPackageName());
        return resID;
    }
}
