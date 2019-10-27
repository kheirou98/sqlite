package com.example.hp.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class PlantesMedicinalesList extends AppCompatActivity {

    GridView gridView;
    ArrayList<PlantesMedicinales> list;
    PlantesMedicinalesListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantesmedicinales_list_activity);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new PlantesMedicinalesListAdapter(this, R.layout.plantesmedicinales_items, list);
        gridView.setAdapter(adapter);
        // get all data from sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM PLANTES");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            byte[] image = cursor.getBlob(2);
            String nomLatin=cursor.getString(3);
            String famille=cursor.getString(4);
            String proprietes=cursor.getString(5);
            String partieUtilises=cursor.getString(6);
            String posologie=cursor.getString(7);
            String precautions=cursor.getString(8);

            list.add(new PlantesMedicinales(name,image, id,nomLatin,famille,proprietes,partieUtilises,posologie,precautions));
        }
        adapter.notifyDataSetChanged();
    }
}
