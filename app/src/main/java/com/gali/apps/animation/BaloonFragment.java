package com.gali.apps.animation;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaloonFragment extends Fragment {

    BaloonsView baloonsView;

    public BaloonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baloon, container, false);
        baloonsView = (BaloonsView)view.findViewById(R.id.baloonsView);
        view.findViewById(R.id.startBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baloonsView.start();
            }
        });
        view.findViewById(R.id.stopBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baloonsView.stop();
            }
        });
        return view;
    }

}
