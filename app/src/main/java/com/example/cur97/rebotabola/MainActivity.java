package com.example.cur97.rebotabola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    static int statusBar, width, height;
    Bola[] bola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = findViewById(R.id.bolaLayout);
        // Obtenemos las dimensiones que tiene la pantalla de nuestro dsipositivo
        DisplayMetrics display = this.getBaseContext().getResources().getDisplayMetrics();
        width = display.widthPixels;
        height = display.heightPixels;
        //VELOCIDADES
        float[] velo = {-3,2,5,-5,3,1,-3,-4};

        bola = new Bola[5];

        for(int i = 0; i<bola.length;i++){
            bola[i] = new Bola(velo[new Random().nextInt(4)],velo[new Random().nextInt(4)]);
            bola[i].bola = new ImageView(getApplicationContext());
            layout.addView(bola[i].bola);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) bola[i].bola.getLayoutParams();
            params.width = 100;
            params.height = 100;
            bola[i].bola.setLayoutParams(params);
            bola[i].bola.setImageResource(R.drawable.bola);
            bola[i].bola.setX(height/10*2);
            bola[i].bola.setY(width/10*2);
        }
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for(int i =0; i<bola.length; i++) {
                    bola[i].movimientoPelota(5, 5);
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 0,30);
    }
}