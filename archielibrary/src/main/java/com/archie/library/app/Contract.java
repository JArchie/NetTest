package com.archie.library.app;

import android.app.Application;
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
    public static Configurator init(Context context) {
        Configurator.getInstance().getContractConfigs()
                .put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Application getApplicationContext() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

}
