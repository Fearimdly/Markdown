package com.zzhoujay.markdowndemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;

/**
 * Created by Moki on 2017/5/28.
 */

public class MarkdownTextView extends AppCompatTextView {
    public MarkdownTextView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(true);
        setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    public MarkdownTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setHorizontalScrollBarEnabled(true);
        setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    public MarkdownTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setHorizontalScrollBarEnabled(true);
        setMovementMethod(ScrollingMovementMethod.getInstance());
    }

}
