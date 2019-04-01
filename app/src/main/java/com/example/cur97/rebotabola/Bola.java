package com.example.cur97.rebotabola;

import android.widget.ImageView;

public class Bola {
    ImageView bola;
    float velY,  velX;

    public Bola(float velY, float velX) {
        this.velY = velY;
        this.velX = velX;
    }

    public ImageView getPelota() {
        return bola;
    }

    public void setPelota(ImageView pelota) {
        this.bola = pelota;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void movimientoPelota(float x, float y) {
        //left
        float sigPosX = bola.getX() + x * velX;
        if ((bola.getX() > 0)) {
            if (sigPosX + bola.getWidth() < MainActivity.width) {
                bola.setX(sigPosX);
            } else {
                bola.setX(MainActivity.width - bola.getWidth());
                velX = (-1) * velX;
            }
            //rigth
        }else{
            if(sigPosX>0){
                bola.setX(sigPosX);
            }else{
                bola.setX(0);
                velX =(-1)* velX;
            }


        }
        //Bottom
        float sigPosY = bola.getY() + y * velY;
        if ((bola.getY() > 0)) {
            if (sigPosY + bola.getHeight() < MainActivity.height) {
                bola.setY(sigPosY);
            } else {
                bola.setY(MainActivity.height - bola.getHeight());
                velY = (-1) * velY;
            }
            //Top
        }else{
            if(sigPosY>0){
                bola.setY(sigPosY);
            }else{
                bola.setY(0);
                velY =(-1)* velY;
            }
        }
    }

}
