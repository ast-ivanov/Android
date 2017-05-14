package com.nstu.fami.simplepaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Bitmap mBitmap;
    private Rect mRect;

    public Draw2D(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hungry);
        mRect = canvas.getClipBounds();

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(mRect.right - 30, 30, 25, mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawRect(0, mRect.bottom - 20, mRect.right, mRect.bottom, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(24);
        canvas.drawText("Лужайка только для котов", 30, mRect.bottom - 30, mPaint);

        int x = 760;
        int y = 100;

        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(27);
        String str2rotate = "Лучик";

        canvas.rotate(-45, x, y);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, mPaint);

        canvas.restore();

        canvas.drawBitmap(mBitmap, mRect.right - 400, mRect.bottom - 384, mPaint);
    }
}
