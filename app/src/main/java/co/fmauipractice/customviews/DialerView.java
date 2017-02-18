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
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Toast;

import co.fmauipractice.R;


/**
 * Created by Shal on 08-05-2016.
 */
public class DialerView extends View {

    private int circleCol, labelCol;
    private String circleText;
    private Paint circlePaint;
    private Drawable drawableId;
    private int selectedItem = 1;
    int radius;
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
        } finally {
            a.recycle();
        }
    }

    private boolean checkBounds( MotionEvent event) {
        // here you will have to get a reference of the global view (the View that holds the UI)
        updateListener(event);
//        DisplayMetrics dm = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int topOffset = dm.heightPixels - relativeLayout.getMeasuredHeight();
//        int sideOffet = dm.widthPixels - relativeLayout.getMeasuredWidth();
//
//        int[] origin = new int[2];
//        v.getLocationOnScreen(origin);
//        int[] windowOrigin = new int[2];
//        v.getLocationInWindow(windowOrigin);
//        final int x = origin[0];
//        final int y = origin[1] - topOffset;
//
//
//        if ((event.getX() > x) && (event.getX() < (x + v.getMeasuredWidth()))) {
//            if ((event.getY() > y) && (event.getY() < (y + v.getMeasuredHeight()))) {
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("tag","onTouchEvent() :: called");
                checkBounds(event);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void updateListener(MotionEvent event) {
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;
//        int radius;
        ViewParent viewParent = this.getParent();
        int parentWidth = ((View) viewParent).getMeasuredWidth();
        int parentHeight = ((View) viewParent).getMeasuredHeight();
//        System.out.println(parentHeight + parentWidth);
//        if (viewWidthHalf > viewHeightHalf)
//            radius = viewHeightHalf - 80;
//        else
//            radius = viewWidthHalf - 180;

        int clickX = (int) event.getX();
        int clickY = (int) event.getY() - 50;
        boolean xtrue = false;
        boolean ytrue = false;

        int screenCenterWidth =  parentWidth/2;
        int screenCenterHeight = parentHeight / 2;

        Log.i("Dialer", "selected width " + screenCenterWidth);
        Log.i("Dialer", "selected height " + screenCenterHeight);
        if (clickX > screenCenterWidth) {
            Log.i("Dialer", "selected second half of width");
        } else {
            Log.i("Dialer", "selected first half of width");
        }
        if (clickY > screenCenterHeight) {
            Log.i("Dialer", "selected second half of height");
        } else {
            Log.i("Dialer", "selected first half of height");
        }

        //if within outer circle
        if (calculateClickPosition(clickX, clickY, screenCenterWidth, screenCenterHeight, radius)) {
            //if outside inner circle
            if (!calculateClickPosition(clickX, clickY, screenCenterWidth, screenCenterHeight, radius-95)) {
                double val = Math.toDegrees(Math.atan2((clickY - viewHeightHalf), (clickX - viewWidthHalf)));
                checkAreaSelected(val);
                System.out.println(val);
            } else {
                Log.i("Dialer", "missed the target");
            }
        } else {
            Log.i("Dialer", "missed the target");
        }
    }

    int height;
    int width;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        final int min = Math.min(width, height);
        int arcDiameter = min - getPaddingLeft();

        radius = arcDiameter / 2;
    }

    private void checkAreaSelected(double angle) {
        if (angle >= 0 && angle < 45) {
//            Toast.makeText(context, "Hit the spot - 5", Toast.LENGTH_SHORT).show();
            Log.i("Dialer","Hit the spot - 5");
        } else if (angle >= 45 && angle < 90) {
//            Toast.makeText(context, "Hit the spot - 6", Toast.LENGTH_SHORT).show();
            Log.i("Dialer","Hit the spot - 6");
        } else if (angle >= 90 && angle < 135) {
//            Toast.makeText(context, "Hit the spot - 7", Toast.LENGTH_SHORT).show();
            Log.i("Dialer","Hit the spot - 7");
        } else if (angle >= 135 && angle < 180) {
//            Toast.makeText(context, "Hit the spot - 8", Toast.LENGTH_SHORT).show();
            Log.i("Dialer","Hit the spot - 8");
        } else if (angle < -135 && angle > -180) {
            Log.i("Dialer","Hit the spot - 1");
//            Toast.makeText(context, "Hit the spot - 1", Toast.LENGTH_SHORT).show();
        } else if (angle <= -90 && angle > -135) {
//            Toast.makeText(context, "Hit the spot - 2", Toast.LENGTH_SHORT).show();
            Log.i("Dialer","Hit the spot - 2");
        } else if (angle <= -45 && angle > -90) {
//            Toast.makeText(context, "Hit the spot - 3", Toast.LENGTH_SHORT).show();
            Log.i("Dialer","Hit the spot - 3");
        } else if (angle < 0 && angle > -45) {
//            Toast.makeText(context, "Hit the spot - 4", Toast.LENGTH_SHORT).show();
            Log.i("Dialer","Hit the spot - 4");
        }
    }

    boolean calculateClickPosition(int clickX, int clickY, int viewWidthHalf, int viewHeightHalf, int radius) {
        return Math.pow((clickX - viewWidthHalf),2) + Math.pow((clickY - viewHeightHalf),2) < Math.pow(radius,2);
    }

    //TODO: create new view for options
    //TODO: create view group for adding all the views
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;
        int radius = 0;
        if (viewWidthHalf > viewHeightHalf)
            radius = viewHeightHalf - 80;
        else
            radius = viewWidthHalf - 180;
        circlePaint.setStyle(Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.WHITE);
        Bitmap bm = drawableToBitmap(drawableId);

        for (int i = 0; i < 80; i++) {
            canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius + 15 + i, circlePaint);
        }
        circlePaint.setStyle(Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);
        for (int i = 0; i < 15; i++) {
            canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius + i, circlePaint);
        }

        double lineWidthStartPoint;
        double lineHeightEndPoint;
        double lineWidthStartFinalPoint;
        double lineHeightEndFinalPoint;
        circlePaint.setColor(Color.BLACK);
        for (int i = 0; i < 8; i++) {
            lineWidthStartPoint = (float) ((radius + 15) * Math.cos(i * 45 * Math.PI / 180F)) + viewWidthHalf;
            lineHeightEndPoint = (float) ((radius + 15) * Math.sin(i * 45 * Math.PI / 180F)) + viewHeightHalf;
            lineWidthStartFinalPoint = (float) ((radius + 95) * Math.cos(i * 45 * Math.PI / 180F)) + viewWidthHalf;
            lineHeightEndFinalPoint = (float) ((radius + 95) * Math.sin(i * 45 * Math.PI / 180F)) + viewHeightHalf;
            canvas.drawLine((float) lineWidthStartPoint, (float) lineHeightEndPoint, (float) lineWidthStartFinalPoint, (float) lineHeightEndFinalPoint, circlePaint);
        }

        //canvas.drawCircle((float)lineWidthStartPoint , (float)lineHeightEndPoint,50,circlePaint);
        Path path = new Path();
        path.addCircle(viewWidthHalf, viewHeightHalf, radius, Path.Direction.CW);
        canvas.clipPath(path);

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
