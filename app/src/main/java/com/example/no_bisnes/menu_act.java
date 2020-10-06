package com.example.no_bisnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class menu_act extends AppCompatActivity
{
    private ViewFlipper vf;
    private int[] images ={R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper)findViewById(R.id.slr);

        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }

    }

    public void flip_image( int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(1000);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void maps(View v)
    {
        Intent i = new Intent(this, maps_act.class);
        startActivity(i);

    }

    public void infor(View v)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }

    public void clientes(View v)
    {
        Intent i = new Intent(this, clientes_act.class);
        startActivity(i);
    }
}