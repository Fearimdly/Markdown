package com.zzhoujay.markdown.style;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.text.style.DynamicDrawableSpan;
import android.widget.TextView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.zzhoujay.markdown.util.NumberKit;

import java.lang.ref.WeakReference;

/**
 * Created by moki on 2017/2/24.
 */

public class TodoBulletSpan extends BulletSpan {
    private static final int tab = 40;
    private static final int mGapWidth = 40;
    private static final int BULLET_RADIUS = 6;

    private final boolean mFinish;
    private final int mColor;
    private int margin;

    private Context mContext;
    private Paint mPaint;

    public TodoBulletSpan(int color, boolean finish, Context context) {
        super(mGapWidth, color);
        mFinish = finish;
        mColor = color;
        mContext = context;
    }

    @Override
    public int getLeadingMargin(boolean first) {
        if (mPaint != null) {
            margin = (int) (tab + mGapWidth + mPaint.measureText("$"));
        } else {
            margin = (int) (tab + mGapWidth + 20);
        }
        return margin;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout l) {
        mPaint = p;
        if (((Spanned) text).getSpanStart(this) == start) {
            Typeface originalTypeface = p.getTypeface();
            GoogleMaterial googleMaterial = new GoogleMaterial();
            p.setTypeface(googleMaterial.getTypeface(mContext));
            if (!mFinish) {
                String checkboxBlank = String.valueOf(GoogleMaterial.Icon.gmd_check_box_outline_blank.getCharacter());
                c.drawText(checkboxBlank, x - p.measureText("$") + margin - mGapWidth, baseline, p);
            } else {
                String checkbox = String.valueOf(GoogleMaterial.Icon.gmd_check_box.getCharacter());
                c.drawText(checkbox, x - p.measureText("$") + margin - mGapWidth, baseline, p);
            }
            p.setTypeface(originalTypeface);
        }
    }
}
