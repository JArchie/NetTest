package com.archie.library.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.app
 * 文件名:   Configurator
 * 创建者:   Jarchie
 * 创建时间: 17/12/6 上午10:36
 * 描述:     配置文件的存储和获取
 */

public final class Configurator {
    private static final HashMap<Object, Object> CONTRACT_CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        CONTRACT_CONFIGS.put(ConfigType.CONFIG_READY, false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    final HashMap<Object, Object> getContractConfigs() {
        return CONTRACT_CONFIGS;
    }

    public final void configure() {
        initIcons();
        CONTRACT_CONFIGS.put(ConfigType.CONFIG_READY, true);
    }

    public final Configurator withApiHost(String host) {
        CONTRACT_CONFIGS.put(ConfigType.API_HOST, host);
        return this;
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) CONTRACT_CONFIGS.get(ConfigType.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = CONTRACT_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + "IS NULL");
        }
        return (T) CONTRACT_CONFIGS.get(key);
    }

}
