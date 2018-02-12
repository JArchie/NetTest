package com.archie.library.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.archie.library.R;

/**
 * Created by Jarchie on 2017\12\7.
 * 动画的加载类
 */

public class DialogLoader {

    private static CommonDialog mCommonDialog;
    private static AnimationDrawable animationDrawable;

    //Dialog加载
    public static void show(Context context) {
        mCommonDialog = new CommonDialog(context, R.layout.dialog_loading_layout);
        ImageView mImage = mCommonDialog.findViewById(R.id.frame_animation);
        TextView mText = mCommonDialog.findViewById(R.id.tip_text);
        mImage.setImageResource(R.drawable.frame_animation);
        animationDrawable = (AnimationDrawable) mImage.getDrawable();
        animationDrawable.start();
        mText.setText("努力加载中，请稍后。。。");
        mCommonDialog.setCanceledOnTouchOutside(false);
        mCommonDialog.show();
    }

    //Dialog消失
    public static void dismiss() {
        if (animationDrawable != null) {
            animationDrawable.stop(); //停止动画
            if (mCommonDialog != null) { //关闭Dialog
                mCommonDialog.cancel();
            }
        }
    }

}
