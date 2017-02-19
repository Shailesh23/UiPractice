package co.fmauipractice.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

import co.fmauipractice.R;


/**
 * Created by Shal on 08-05-2016.
 */
public class DialerView extends View {

    private int circleCol, labelCol;
    private String circleText;
    private Paint circlePaint;
    private Drawable drawableId;
    private int circleRadius;
    private final int numberOfSections;
    private final float angleOfItems;
    Path path = new Path();
    private final static int THUMB_SIZE_SPACE = 120;
    private final static int INNER_CIRCLE_SPACE = 20;
    int height;
    int width;
    int centerX;
    int centerY;

    public DialerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circlePaint = new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.DialerView, 0, 0);

        try {
            //get the text and colors specified using the names in attrs.xml
            circleText = a.getString(R.styleable.DialerView_circleLabel);
            circleCol = a.getInteger(R.styleable.DialerView_circleColor, 0);//0 is default
            labelCol = a.getInteger(R.styleable.DialerView_labelColor, 0);
            drawableId = a.getDrawable(R.styleable.DialerView_imageSet);
            circleRadius = a.getInteger(R.styleable.DialerView_circleRadius, 0);
            numberOfSections = a.getInteger(R.styleable.DialerView_circleSections, 1);
            angleOfItems = 360 / numberOfSections;
        } finally {
            a.recycle();
        }
    }

    private boolean checkBounds(MotionEvent event) {
        updateListener(event);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("tag", "onTouchEvent() :: called");
                checkBounds(event);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(event);
    }

    public void updateListener(MotionEvent event) {
        int clickX = (int) event.getX();
        int clickY = (int) event.getY() - 50;

        //if within outer circle
        if (calculateClickPosition(clickX, clickY, centerX, centerY, circleRadius)) {
            //if outside inner circle
            if (!calculateClickPosition(clickX, clickY, centerX, centerY, circleRadius - THUMB_SIZE_SPACE)) {
                double selectedAngle = Math.toDegrees(Math.atan2((clickY - centerY), (clickX - centerX)));
                checkAreaSelected(selectedAngle);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = this.getMeasuredWidth();
        height = this.getMeasuredHeight();

        ViewParent viewParent = this.getParent();
        centerX = ((View) viewParent).getMeasuredWidth() / 2;
        centerY = ((View) viewParent).getMeasuredHeight() / 2;
    }

    private void checkAreaSelected(double angle) {
        angle += 180;
        for (int index = 0; index < numberOfSections; index++) {
            float sectionAngle = index * angleOfItems;
            if ((sectionAngle <= angle) && ((sectionAngle + angleOfItems) >= angle)) {
                Log.i("Dialer", "Hit spot - " + (index + 1));
                break;
            }
        }
    }

    boolean calculateClickPosition(int clickX, int clickY, int circleCenterX, int circleCenterY, int radius) {
        return Math.pow((clickX - circleCenterX), 2) + Math.pow((clickY - circleCenterY), 2) < Math.pow(radius, 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        double lineStartXPoint;
        double lineStartYPoint;
        double lineEndXPoint;
        double lineEndYPoint;

        circlePaint.setStyle(Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.WHITE);
        Bitmap bm = drawableToBitmap(drawableId);

        //create outer circle
        canvas.drawCircle(centerX, centerY, circleRadius, circlePaint);
        circlePaint.setStyle(Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);

        //create inner circle
        canvas.drawCircle(centerX, centerY, circleRadius - THUMB_SIZE_SPACE, circlePaint);

        //create spokes
        circlePaint.setColor(Color.BLACK);
        for (int i = 0; i < numberOfSections; i++) {
            lineStartXPoint = (float) ((circleRadius - THUMB_SIZE_SPACE) * Math.cos(i * angleOfItems * Math.PI / 180F)) + centerX;
            lineStartYPoint = (float) ((circleRadius - THUMB_SIZE_SPACE) * Math.sin(i * angleOfItems * Math.PI / 180F)) + centerY;

            lineEndXPoint = (float) ((circleRadius) * Math.cos(i * angleOfItems * Math.PI / 180F)) + centerX;
            lineEndYPoint = (float) ((circleRadius) * Math.sin(i * angleOfItems * Math.PI / 180F)) + centerY;

            canvas.drawLine((float) lineStartXPoint, (float) lineStartYPoint, (float) lineEndXPoint, (float) lineEndYPoint, circlePaint);
        }

        path.addCircle(centerX, centerY, circleRadius - THUMB_SIZE_SPACE - INNER_CIRCLE_SPACE, Path.Direction.CW);
        canvas.clipPath(path);

        //add image
        canvas.drawBitmap(bm, 0, 0, circlePaint);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
