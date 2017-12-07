package com.archie.library.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.archie.library.R;
import com.archie.library.utils.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.ui
 * 文件名:   DialogLoader
 * 创建者:   Jarchie
 * 创建时间: 17/12/6 上午10:09
 * 描述:     动画的加载类
 */

public class DialogLoader {

    //缩放比和偏移量
    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;

    //集合存储dialog，统一管理
    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();

    //默认样式
    private static final String DEFAULT_LOADER = LoaderStyle.BallGridPulseIndicator.name();

    //重载枚举数据类型
    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }

    //创建show方法
    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);

        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    //写一个重载方法，默认样式
    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    //停止显示的方法
    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }

}
