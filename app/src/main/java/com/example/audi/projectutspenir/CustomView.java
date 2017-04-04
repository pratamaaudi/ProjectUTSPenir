package com.example.audi.projectutspenir;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Audi on 4/4/2017.
 */

public class CustomView extends ArrayAdapter{
    private final Context context;
    private final String[] values;

    public CustomView(Context context, String[] values){
        super(context, R.layout.list_layout, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_layout,parent,false);

        return v;
    }
}
