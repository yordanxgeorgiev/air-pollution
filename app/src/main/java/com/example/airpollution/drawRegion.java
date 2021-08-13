package com.example.airpollution;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;


public class drawRegion extends View {

    private Paint fillPaint;
    private Paint borderPaint;
    CornerPathEffect corEffect = new CornerPathEffect(5);
    private Path path;
    private float[] points;

    public drawRegion(Context context, float[] newPoints, Paint newPaint) {
        super(context);

        fillPaint = new Paint();
        path = new Path();
        borderPaint = new Paint();

        points = new float[newPoints.length];

        for(int i = 0; i < newPoints.length; i++)
        {
            points[i] = newPoints[i];
        }

        fillPaint = newPaint;
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setPathEffect(corEffect);
        borderPaint.setStrokeWidth(2);
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setPathEffect(corEffect);
    }

    public void onDraw(Canvas c){

        super.onDraw(c);

        //c.drawPaint(paint);

        path.moveTo(points[0],points[1]);

        for(int i = 2; i < points.length; i+=2)
        {
            path.lineTo(points[i],points[i+1]);
        }

        path.close();

        c.drawPath(path, fillPaint);

        c.drawPath(path, borderPaint);
    }

}
