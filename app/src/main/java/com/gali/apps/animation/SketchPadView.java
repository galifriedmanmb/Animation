package com.gali.apps.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by 1 on 3/30/2017.
 */

public class SketchPadView extends View {

    ArrayList<DrawPath> drawPaths;
    Paint paint;
    Path path;


    public SketchPadView(Context context) {
        super(context);
        init();
    }

    public SketchPadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        drawPaths = new ArrayList<>();
        newPathPaint(Color.RED);
    }

    private void newPathPaint(int color) {
        path = new Path();
        paint = new Paint();

        paint.setColor(color);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);

        drawPaths.add(new DrawPath(path,paint));
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (int i=0;i<drawPaths.size();i++) {
            DrawPath drawPath = drawPaths.get(i);
            canvas.drawPath(drawPath.path, drawPath.paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                invalidate();
                break;
        }
        return true;
    }

    public void setColor(int color) {
        newPathPaint(color);
    }

    class DrawPath {
        Path path;
        Paint paint;

        DrawPath(Path path, Paint paint) {
            this.path = path;
            this.paint = paint;
        }
    }
}
