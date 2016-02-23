package com.example.android.dragndrop;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {
    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySound = MediaPlayer.create(this, R.raw.krishna);
        findViewById(R.id.textView1).setOnTouchListener(this);
        findViewById(R.id.pinkLayout).setOnDragListener(this);
        findViewById(R.id.yellowLayout).setOnDragListener(this);
    }
    /* Implementation of onTouch Method*/
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }

    public boolean onDrag(View layoutview, DragEvent dragevent) {
        int action = dragevent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d("MainActivity", "Drag event started");
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d("MainActivity", "Drag event entered into "+layoutview.toString());
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d("MainActivity", "Drag event exited from "+layoutview.toString());
                break;
            case DragEvent.ACTION_DROP:
                Log.d("MainActivity", "Dropped");
                View view = (View) dragevent.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                LinearLayout container = (LinearLayout) layoutview;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d("MainActivity", "Drag ended");
                break;
            default:
                break;
        }
        return true;
    }
    private static String value="Maja_Aaya_kya";
    public void startNewActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(value, "Babu Maja aaya Dabane maine");
        startActivity(intent);
    }

    public void MusicPlay(View view) {
        mySound.start();
    }
    public void StopPlaying(View view){
        mySound.pause();
    }
}
