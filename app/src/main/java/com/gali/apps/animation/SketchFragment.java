package com.gali.apps.animation;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gali.apps.animation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SketchFragment extends Fragment implements View.OnClickListener {


    SketchPadView sketchPadView;

    public SketchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sketch, container, false);

        sketchPadView = (SketchPadView)view.findViewById(R.id.sketchPadView);
        view.findViewById(R.id.blueIV).setOnClickListener(this);
        view.findViewById(R.id.redIV).setOnClickListener(this);
        view.findViewById(R.id.yellowIV).setOnClickListener(this);
        view.findViewById(R.id.greenIV).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int color=0;
        switch (v.getId()) {
            case R.id.redIV:
                color = Color.RED;
                break;
            case R.id.blueIV:
                color = Color.BLUE;
                break;
            case R.id.greenIV:
                color = Color.GREEN;
                break;
            case R.id.yellowIV:
                color = Color.YELLOW;
                break;
        }
        sketchPadView.setColor(color);
    }
}
