package com.archie.library.app;

import android.content.Context;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.app
 * 文件名:   Contract
 * 创建者:   Jarchie
 * 创建时间: 17/12/6 上午10:34
 * 描述:     项目全局的配置管理类
 */

public final class Contract {
    private static Context mContext;

    private Contract() {
        throw new UnsupportedOperationException("you can't instantiate me...");
    }

    //初始化配置
    public static void init(Context context) {
        Contract.mContext = context.getApplicationContext();
    }

    //获取全局上下文对象
    public static Context getContext() {
        if (mContext != null)
            return mContext;
        throw new NullPointerException("you should init first!");
    }

}
