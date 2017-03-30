package com.gali.apps.animation;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gali.apps.animation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrashFragment extends Fragment {


    public TrashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_trash, container, false);


        final float binX = Utils.convertDpToPixel(80, getActivity());
        final float binY = Utils.convertDpToPixel(80,getActivity());
        view.findViewById(R.id.colaV).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView iv = (ImageView)v;

                if (event.getAction()==MotionEvent.ACTION_MOVE) {


                    v.setX(event.getRawX()-iv.getWidth());
                    v.setY(event.getRawY()-iv.getHeight());
                    if (event.getRawX()<=binX+iv.getWidth() && event.getRawY()<=binY+iv.getHeight()) {
                        ((ImageView)view.findViewById(R.id.binIV)).setImageResource(R.drawable.bin_open);
                    } else {
                        ((ImageView)view.findViewById(R.id.binIV)).setImageResource(R.drawable.bin_closed);
                    }

                }

                return true;
            }
        });
        return view;
    }

}
