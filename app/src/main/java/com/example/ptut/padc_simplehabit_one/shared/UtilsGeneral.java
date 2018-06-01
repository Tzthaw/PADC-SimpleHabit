package com.example.ptut.padc_simplehabit_one.shared;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class UtilsGeneral {

    public static void LoadImageWithGlide(ImageView imageView, Context context, String imageUrl){
        Glide.with(context).load(imageUrl)
                .into(imageView);
    }

    public static String timeFormat(int second){
        String time = null;
        int minute=second/60;
        int hour=minute/60;


        return hour+":"+ minute;
    }


}
