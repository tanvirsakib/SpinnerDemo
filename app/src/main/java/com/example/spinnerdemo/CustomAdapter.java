package com.example.spinnerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    String[] coutryNames;
    String[] population;
    int[] flags;
    Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(String[] coutryNames, String[] population, int[] flags, Context context) {
        this.coutryNames = coutryNames;
        this.population = population;
        this.flags = flags;
        this.context = context;
    }


    @Override
    public int getCount() {
        return coutryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.sample_view,null,false);
        }

        ImageView imageView = convertView.findViewById(R.id.ImageViewID);
        TextView countryTextView = convertView.findViewById(R.id.countryNameTextID);
        TextView populationTextView = convertView.findViewById(R.id.populationTextID);

        imageView.setImageResource(flags[position]);
        countryTextView.setText(coutryNames[position]);
        populationTextView.setText(population[position]);

        return convertView;
    }
}
