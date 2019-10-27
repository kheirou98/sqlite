package com.example.hp.sqlite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class PlantesMedicinalesListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<PlantesMedicinales> plantesList;

    public PlantesMedicinalesListAdapter(Context context, int layout, ArrayList<PlantesMedicinales> plantesList) {
        this.context = context;
        this.layout = layout;
        this.plantesList = plantesList;
    }

    @Override
    public int getCount() {
        return plantesList.size();
    }

    @Override
    public Object getItem(int position) {
        return plantesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.imageView = (ImageView) row.findViewById(R.id.imgPlante);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        PlantesMedicinales plantes = plantesList.get(position);

        holder.txtName.setText(plantes.getName());

        byte[] plantesImage = plantes.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(plantesImage, 0, plantesImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
