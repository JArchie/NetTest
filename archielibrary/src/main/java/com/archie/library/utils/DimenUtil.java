package com.archie.library.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.archie.library.app.Contract;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.utils
 * 文件名:   DimenUtil
 * 创建者:   Jarchie
 * 创建时间: 17/12/6 上午10:25
 * 描述:     测量的工具类
 */

public class DimenUtil {

    //获取屏幕的宽
    public static int getScreenWidth() {
        final Resources resources = Contract.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    //获取屏幕的高
    public static int getScreenHeight() {
        final Resources resources = Contract.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
