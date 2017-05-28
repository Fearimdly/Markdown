package com.zzhoujay.markdown.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.text.style.BackgroundColorSpan;
import android.text.style.ImageSpan;

/**
 * Created by Moki on 2017/5/28.
 */

public class CodeBlockSpan2 extends ImageSpan {

    private Drawable mDrawable;

    public CodeBlockSpan2(Drawable d) {
        super(d);
        mDrawable = d;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        super.draw(canvas, text, start, end, x, top, y, bottom, paint);
        canvas.drawText(text, start, end, x, y, paint);
    }
}
