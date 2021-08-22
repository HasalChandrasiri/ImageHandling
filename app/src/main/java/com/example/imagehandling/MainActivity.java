package com.example.imagehandling;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQEST =1888;
    ImageView imageView;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = this.findViewById(R.id.imageView);
        btn1 = this.findViewById(R.id.btn1);

        btn1.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQEST);
        });

    }

    protected void onActivityResult(int requestCode , int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQEST){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}