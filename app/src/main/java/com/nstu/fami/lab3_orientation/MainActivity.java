package com.nstu.fami.lab3_orientation;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Surface;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getScreenOrientation(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Портретная ориентация";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Альбомная ориентация";
        else
            return "";
    }

    private String getRotateOrientation() {
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate) {
            case Surface.ROTATION_0:
                return "Не поворачивали";
            case Surface.ROTATION_90:
                return "Повернули на 90 градусов по часовой стрелке";
            case Surface.ROTATION_180:
                return "Повернули на 180 градусов";
            case Surface.ROTATION_270:
                return "Повернули на 90 градусов против часовой стрелки";
            default:
                return "Не понятно";
        }
    }

    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        int duration;
        Toast toast;
        LinearLayout toastContainer;
        ImageView catImageView;

        switch (id) {
            case R.id.button1:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(MainActivity.this, StylesActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                toast = Toast.makeText(getApplicationContext(),
                        R.string.catfood, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toastContainer = (LinearLayout) toast.getView();
                catImageView = new ImageView(getApplicationContext());
                catImageView.setImageResource(R.drawable.hungry);
                toastContainer.addView(catImageView, 0);
                toast.show();
                break;
            case R.id.button7:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.button8:
                intent = new Intent(MainActivity.this, StylesActivity.class);
                startActivity(intent);
                break;
            case R.id.button9:
                toast = Toast.makeText(getApplicationContext(),
                        R.string.catfood, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toastContainer = (LinearLayout) toast.getView();
                catImageView = new ImageView(getApplicationContext());
                catImageView.setImageResource(R.drawable.hungry);
                toastContainer.addView(catImageView, 0);
                toast.show();

            default:
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "Альбомная ориентация", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "Портретная ориентация", Toast.LENGTH_SHORT).show();
        }
    }
}
