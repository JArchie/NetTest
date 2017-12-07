package com.archie.nettest;

import android.app.Application;

import com.archie.library.app.Contract;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.nettest
 * 文件名:   BaseApplication
 * 创建者:   Jarchie
 * 创建时间: 17/12/6 上午11:18
 * 描述:     自定义的Application
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Contract.init(this)
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
