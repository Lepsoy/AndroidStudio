package com.lepsoy.imageeffects;

import android.annotation.TargetApi;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView lepsoysImageView;
    Drawable lepsoysImage;
    Bitmap bitmapImage;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lepsoysImageView = (ImageView)findViewById(R.id.lepsoysImageView);

        //Invert image
        lepsoysImage = getDrawable(R.mipmap.iris_and_me);
        bitmapImage = ((BitmapDrawable) lepsoysImage).getBitmap();
        Bitmap newPhoto = invertImage(bitmapImage);
        lepsoysImageView.setImageBitmap(newPhoto);

        //Add layers
        /*Drawable[] layers = new Drawable[2];
        layers[0] = getDrawable(R.mipmap.iris_and_me);
        layers[1] = getDrawable(R.mipmap.filter);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        lepsoysImageView.setImageDrawable(layerDrawable);*/

        //Save image on device
        MediaStore.Images.Media.insertImage(getContentResolver(), newPhoto, "title", "description");

    }

    //Invert a bitmap image
    public static Bitmap invertImage(Bitmap original){

        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());

        int A, R, G, B;
        int pixelColor;
        int width = original.getWidth();
        int height = original.getHeight();

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                pixelColor = original.getPixel(x,y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        return finalImage;
    }


}
