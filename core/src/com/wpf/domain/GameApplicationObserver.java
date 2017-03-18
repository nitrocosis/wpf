package com.wpf.domain;

import com.wpf.domain.common.Screen;

public interface GameApplicationObserver {
    void onScreenFocusGained(Screen screen);

    void onScreenFocusLost(Screen screen);

    void onBGMToggled(boolean bgmOn);

    void onSFXToggled(boolean sfxOn);
}