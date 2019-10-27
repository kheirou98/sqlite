package com.example.hp.sqlite;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnAdd, btnList;
    ImageView imageView;
    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sqLiteHelper = new SQLiteHelper(this, "PlantesDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS PLANTES(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR,image BLOB,nomLatin VARCHAR,famille VARCHAR , proprietes VARCHAR,posologie VARCHAR,precautions VARCHAR, partieUtilises VARCHAR )");
        boolean mboolean;
        SharedPreferences settings = getSharedPreferences("PREFS_NAME",0);
        mboolean= settings.getBoolean("FIRST_RUN",false);
        if (!mboolean)
        {
            edtName.setText("ail");
            imageView.setImageResource(R.drawable.c);
            sqLiteHelper.insertData(
                    edtName.getText().toString().trim(),
                    imageViewToByte(imageView),
                    "a1","b1","c1","d1","e1","f1"

            );
            edtName.setText("ananas");
            imageView.setImageResource(R.drawable.b);
            sqLiteHelper.insertData(
                    edtName.getText().toString().trim(),
                    imageViewToByte(imageView),
                    "a2","b2","c2","d2","e2","f2"
            );
            edtName.setText("bardane");
            imageView.setImageResource(R.drawable.a);
            sqLiteHelper.insertData(
                    edtName.getText().toString().trim(),
                    imageViewToByte(imageView),
                    "a3","b3","c3","d3","e3","f3"
            );

            edtName.setText("Fenouil");
            imageView.setImageResource(R.drawable.fenouil);
            sqLiteHelper.insertData(
                    edtName.getText().toString().trim(),
                    imageViewToByte(imageView),
                    "a4", "b4", "c4", "d4", "e4","f4"
            );

            edtName.setText("Fenugrec");
            imageView.setImageResource(R.drawable.fenugrec);
            sqLiteHelper.insertData(
                    edtName.getText().toString().trim(),
                    imageViewToByte(imageView),
                    "a5", "b5", "c5", "d5", "e5","f5"
            );

            settings =getSharedPreferences("PREFS_NAME",0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("FIRST_RUN",true);
            editor.commit();

        }


        edtName.setText("");
        imageView.setImageResource(R.mipmap.ic_launcher);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    sqLiteHelper.insertData(
                            edtName.getText().toString().trim(),
                            imageViewToByte(imageView),
                            "a","b","c","d","e","f"
                    );
                    Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                    edtName.setText("");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlantesMedicinalesList.class);
                startActivity(intent);
            }
        });
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    private void init(){
        edtName = (EditText) findViewById(R.id.edtName);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnList = (Button) findViewById(R.id.btnList);
        imageView = (ImageView) findViewById(R.id.imageView);
    }


}