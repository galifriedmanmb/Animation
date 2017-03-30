package com.gali.apps.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 1 on 3/30/2017.
 */

public class BaloonsView extends View {

    private Paint paint;
    ArrayList<Baloon> baloons;
    Handler handler;
    int curX = 50;
    int step = 15;
    int maxBaloons = 15;
    int addingBaloonsInterval = 10;
    int addingBaloonsIntervalCounter = 0;

    boolean stop = false;

    public BaloonsView(Context context) {
        super(context);
        init();

    }

    public BaloonsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    void init() {
        baloons = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<baloons.size();i++) {
            Baloon baloon = baloons.get(i);
            canvas.drawBitmap(baloon.bitmap,baloon.x,baloon.y,null);
        }

    }

    private void addBaloon() {
        Bitmap baloonBM = BitmapFactory.decodeResource(getResources(),Utils.getRandomBaloonBitmap());
        int newX = (int)Math.ceil(Math.random()*(getWidth()-baloonBM.getWidth()));
        Baloon baloon = new Baloon(baloonBM,newX,getHeight());
        baloons.add(baloon);
    }

    public void start() {
        stop = false;
        //minY = getHeight()+baloonBM.getHeight();
        handler = new Handler();
        Runnable move = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<baloons.size();i++) {
                    Baloon currBaloon = baloons.get(i);
                    currBaloon.y = currBaloon.y-step;
                }

                Iterator<Baloon> i = baloons.iterator();
                while(i.hasNext()){
                    Baloon currBaloon = i.next();
                    if(currBaloon.y <= 0 - currBaloon.bitmap.getHeight()){
                        i.remove();
                    }
                }

                if (baloons.size()<=maxBaloons) {
                    if (addingBaloonsIntervalCounter==0)
                        addBaloon();
                }

                invalidate();

                addingBaloonsIntervalCounter++;
                if (addingBaloonsIntervalCounter==addingBaloonsInterval)
                    addingBaloonsIntervalCounter = 0;

                if (!stop)
                    handler.postDelayed(this,50);
            }
        };
        move.run();
    }

    public void stop() {
        stop = true;
        /*
        for (int i=0;i<baloons.size();i++) {
            Log.d("baloon "+i,""+baloons.get(i).x+"\t"+baloons.get(i).y );
        }
        */
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();


        Iterator<Baloon> i = baloons.iterator();
        while(i.hasNext()){
            Baloon currBaloon = i.next();
            int baloonX = currBaloon.x;
            int baloonY = currBaloon.y;
            int baloonWidth = currBaloon.bitmap.getWidth();
            int baloonHeight = currBaloon.bitmap.getHeight();
            if (x>baloonX && x<(baloonX+baloonWidth) && y>baloonY && y<(baloonY+baloonHeight))
                i.remove();
        }

        return true;
    }

    class Baloon {
        Bitmap bitmap;
        int x;
        int y;

        Baloon(Bitmap bitmap,int x,int y) {
            this.bitmap = bitmap;
            this.x = x;
            this.y = y;
        }


    }


}
