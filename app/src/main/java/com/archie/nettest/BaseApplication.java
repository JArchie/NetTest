package com.archie.nettest;

import android.app.Application;

import com.archie.library.app.Contract;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.nettest
 * 文件名:   BaseApplication
 * 创建者:   Jarchie
 * 创建时间: 17/12/6 上午11:18
 * 描述:     自定义的Application
 */

public class BaseApplication extends Application {
    private static BaseApplication mInstance = null;

    public BaseApplication(){}

    @Override
    public void onCreate() {
        super.onCreate();
        Contract.init(this);
    }

    public static BaseApplication getInstance(){
        if (mInstance == null){
            synchronized (BaseApplication.class){
                mInstance = new BaseApplication();
            }
        }
        return mInstance;
    }

}
