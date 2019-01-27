package com.runzhi.workplacedemo.notification.dots;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class NotificationPriorityMidDotView extends View {

    public NotificationPriorityMidDotView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = 160;
        int width = 140;
        int radius = 30;
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(height/2, width/2, radius, paint);
    }
}
