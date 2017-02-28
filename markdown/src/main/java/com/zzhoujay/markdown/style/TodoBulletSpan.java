package com.zzhoujay.markdown.style;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
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

    private WeakReference<TextView> textViewWeakReference;

    public TodoBulletSpan(int color, boolean finish, TextView textView) {
        super(mGapWidth, color);
        mFinish = finish;
        mColor = color;
        textViewWeakReference = new WeakReference<>(textView);
    }

    @Override
    public int getLeadingMargin(boolean first) {
        TextView textView = textViewWeakReference.get();
        margin = (int) (tab + mGapWidth + textView.getPaint().measureText("$"));
        return margin;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout l) {
        if (((Spanned) text).getSpanStart(this) == start) {
            GoogleMaterial googleMaterial = new GoogleMaterial();
            p.setTypeface(googleMaterial.getTypeface(textViewWeakReference.get().getContext()));
            if (!mFinish) {
                String checkboxBlank = String.valueOf(GoogleMaterial.Icon.gmd_check_box_outline_blank.getCharacter());
                c.drawText(checkboxBlank, x - p.measureText("$") + margin - mGapWidth, baseline, p);
            } else {
                String checkbox = String.valueOf(GoogleMaterial.Icon.gmd_check_box.getCharacter());
                c.drawText(checkbox, x - p.measureText("$") + margin - mGapWidth, baseline, p);
            }
        }
    }
}
