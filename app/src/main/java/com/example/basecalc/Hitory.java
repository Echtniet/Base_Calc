package com.example.basecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Hitory extends AppCompatActivity {

    private HitModel hitModel;
    private HitoryAdapter hitoryServer = null;
    private RecyclerView hitoryRecycler = null;
    private GestureDetectorCompat detector = null;

    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onSingleTapConfirmed(MotionEvent e){
            View view = hitoryRecycler.findChildViewUnder(e.getX(), e.getY());
            if (view != null){
                RecyclerView.ViewHolder holder = hitoryRecycler.getChildViewHolder(view);
                if (holder instanceof HitoryAdapter.HitoryViewHolder){
                    int position = holder.getAdapterPosition();
                    // go to sam's page
                    return true;
                }
            }
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitory);
        hitModel = HitModel.getModel();

        hitoryServer = new HitoryAdapter(hitModel);

        hitoryRecycler = findViewById(R.id.rvHistory);
        hitoryRecycler.setAdapter(hitoryServer);

        final LinearLayoutManager myManager = new LinearLayoutManager(this);
        hitoryRecycler.setLayoutManager(myManager);

        detector = new GestureDetectorCompat(this, new RecyclerViewOnGestureListener());

        hitoryRecycler.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e){
                return detector.onTouchEvent(e);
            }
        });

    }
}
