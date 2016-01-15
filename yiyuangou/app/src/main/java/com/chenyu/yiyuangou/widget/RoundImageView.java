package com.chenyu.yiyuangou.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.chenyu.R;

/**
 * Created by ChenYu on 2016/1/14.
 * 绘制圆形边框
 * 可以自定义边框的宽度、外边框的颜色、内边框的颜色
 */
public class RoundImageView extends ImageView {

    /**
     * 边框宽度
     */
    private int borderWidth = 0;
    /**
     * 默认图片宽度
     */
    private int defaultWidth = 0;
    /**
     * 默认图片高度
     */
    private int defaultHeight = 0;
    /**
     * 内边框颜色
     */
    private int insideColor = 0;
    /**
     * 外边框颜色
     */
    private int outsideColor = 0;
    /**
     * 默认边框颜色
     */
    private int defaultColor = 0;

    public RoundImageView(Context context){
        super(context);
    }

    public RoundImageView(Context context,AttributeSet attrs){
        super(context,attrs);
        init(context,attrs);
    }

    /**
     * 初始化自定义属性
     * @param context
     * @param attrs
     */
    public void init(Context context,AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView);
        borderWidth = typedArray.getDimensionPixelOffset(R.styleable.RoundImageView_border_width,borderWidth);
        insideColor = typedArray.getColor(R.styleable.RoundImageView_inside_color, defaultColor);
        outsideColor = typedArray.getColor(R.styleable.RoundImageView_outside_color,defaultColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable() ;
        if (drawable == null) {
            return;
        }
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        this.measure(0, 0);
        if (drawable.getClass() == NinePatchDrawable.class)
            return;
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
        if (defaultWidth == 0) {
            defaultWidth = getWidth();
        }
        if (defaultHeight == 0) {
            defaultHeight = getHeight();
        }
        int radius = 0;
        if (insideColor != defaultColor && outsideColor != defaultColor) {
            // 定义画两个边框，分别为外圆边框和内圆边框
            radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2 - 2 * borderWidth;
            // 画内圆
            drawCircleBorder(canvas, radius + borderWidth / 2,insideColor);
            // 画外圆
            drawCircleBorder(canvas, radius + borderWidth + borderWidth / 2, outsideColor);
        } else if (insideColor != defaultColor && outsideColor == defaultColor) {
            // 定义画一个内边框
            radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2 - borderWidth;
            drawCircleBorder(canvas, radius + borderWidth / 2, insideColor);
        } else if (insideColor == defaultColor && outsideColor != defaultColor) {
            // 定义画一个外边框
            radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2 - borderWidth;
            drawCircleBorder(canvas, radius + borderWidth / 2, outsideColor);
        } else {
            // 没有边框
            radius = (defaultWidth < defaultHeight ? defaultWidth : defaultHeight) / 2;
        }

        Bitmap roundBitmap = getRoundBitmap(bitmap, radius);
        canvas.drawBitmap(roundBitmap, defaultWidth / 2 - radius, defaultHeight / 2 - radius, null);
    }

    /**
     * 获取裁剪后的圆形图片
     * @param bitmap
     * @param radius
     * @return
     */
    private Bitmap getRoundBitmap(Bitmap bitmap,int radius){
        Bitmap roundBitmap;
        int bitmapwidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        //为了防止图片的长宽不相等，导致图片变形。截取了长方形中位于中间位置最大的正方形。
        int squareWidth = 0;
        int squareHeight = 0;
        int x = 0;
        int y = 0;
        Bitmap squareBitmap; //截取的正方形
        if(bitmapHeight > bitmapwidth){
            //高大于宽
            x = 0;
            y = (bitmapHeight - bitmapwidth)/2;
            squareHeight = squareWidth = bitmapwidth;
            squareBitmap = Bitmap.createBitmap(bitmap,x,y,squareWidth,squareHeight);
        }else if(bitmapwidth > bitmapHeight){
            //宽大于高
            x = (bitmapwidth - bitmapHeight)/2;
            y = 0;
            squareHeight = squareWidth = bitmapHeight;
            squareBitmap = Bitmap.createBitmap(bitmap,x,y,squareWidth,squareHeight);
        }else{
            squareBitmap = bitmap;
        }

        if(squareBitmap.getWidth()!=(radius*2) || squareBitmap.getHeight()!=(radius*2)){
            roundBitmap = Bitmap.createScaledBitmap(squareBitmap,radius*2,radius*2,true);
        }else{
            roundBitmap = squareBitmap;
        }

        Bitmap outputBmp = Bitmap.createBitmap(roundBitmap.getWidth(),roundBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(outputBmp);
        Paint paint = new Paint();
        Rect rect = new Rect(0,0,roundBitmap.getWidth(),roundBitmap.getHeight());
        paint.setAntiAlias(true);  //防止边缘锯齿
        paint.setFilterBitmap(true);  //滤波处理
        paint.setDither(true);  //防止抖动
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(roundBitmap.getWidth() / 2, roundBitmap.getHeight() / 2, roundBitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(roundBitmap,rect,rect,paint);
        //回收资源
        bitmap = null;
        squareBitmap = null;
        roundBitmap = null;

        return outputBmp;

    }

    /**
     * 边缘画圆
     */
    private void drawCircleBorder(Canvas canvas, int radius, int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);  //防止边缘锯齿
        paint.setFilterBitmap(true);//滤波处理
        paint.setDither(true); //防止抖动
        paint.setColor(color);
        /* 设置paint的　style　为STROKE：空心 */
        paint.setStyle(Paint.Style.STROKE);
        /* 设置paint的外框宽度 */
        paint.setStrokeWidth(borderWidth);
        canvas.drawCircle(defaultWidth / 2, defaultHeight / 2, radius, paint);
    }
}
