package com.wpf.domain.settings;

import com.wpf.domain.common.ListScreenObserver;

public abstract class SettingsScreenObserver extends ListScreenObserver<SettingsItem> {
    protected void onBGMToggled(boolean bgmOn) {
    }

    protected void onSFXToggled(boolean sfxOn) {
    }
}