package com.example.manipulatingbitmaps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    ImageView myImageView;
    Bitmap myBlankBitmap;
    Bitmap bobBitmap;
    Canvas myCanvas;
    Paint myPaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int widthInPixels = 2000;
        int heightInPixels = 1000;

        myBlankBitmap = Bitmap.createBitmap(widthInPixels,heightInPixels, Bitmap.Config.ARGB_8888);
        bobBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bob);
        myCanvas = new Canvas(myBlankBitmap);
        myImageView = new ImageView(this);
        myPaint = new Paint();

        myCanvas.drawColor(Color.argb(255,0,0,255));
        DrawRotatedBitmap();
        DrawEnlargedBitmap();
        DrawShrunkenBitmap();
        myImageView.setImageBitmap(myBlankBitmap);
        super.onCreate(savedInstanceState);
        setContentView(myImageView);
    }

    void DrawRotatedBitmap(){
        float rotation = 0f;
        int horizontalPosition = 350;
        int verticalPostion = 25;
        Matrix matrix = new Matrix();
        Bitmap rotatedBitmap = Bitmap.createBitmap(100,200, Bitmap.Config.ARGB_8888);
        for(rotation=0; rotation<360; rotation+=30){
            matrix.reset();
            matrix.preRotate(rotation);
            rotatedBitmap = Bitmap.createBitmap(bobBitmap,0,0,bobBitmap.getWidth()-1,bobBitmap.getHeight()-1,matrix,true);

            myCanvas.drawBitmap(rotatedBitmap,horizontalPosition,verticalPostion,myPaint);
            horizontalPosition+=120;
            verticalPostion+=70;
        }
    }

    void DrawEnlargedBitmap(){
        bobBitmap = Bitmap.createScaledBitmap(bobBitmap,50,70,false);
        myCanvas.drawBitmap(bobBitmap,25,25,myPaint);
    }
    void DrawShrunkenBitmap(){
        bobBitmap = Bitmap.createScaledBitmap(bobBitmap,50,75,false);
        myCanvas.drawBitmap(bobBitmap,250,25,myPaint);
    }

}