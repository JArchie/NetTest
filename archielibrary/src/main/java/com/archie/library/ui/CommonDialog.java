package com.archie.library.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.archie.library.R;

/**
 * Created by Jarchie on 2017\12\20.
 * 创建通用的自定义Dialog
 */

public class CommonDialog extends Dialog {

    //定义UI模板
    public CommonDialog(Context context, int layout) {
        this(context, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT, layout, R.style.Theme_dialog, Gravity.CENTER);
    }

    //定义属性
    public CommonDialog(Context context, int width, int height, int layout, int style, int gravity) {
        super(context, style);
        //设置属性
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = width;
        layoutParams.height = height;
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
    }
}
