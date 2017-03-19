package com.wpf.domain;

import com.wpf.domain.credits.CreditsScreen;
import com.wpf.domain.game.GameScreen;
import com.wpf.domain.main_menu.MainMenuScreen;
import com.wpf.domain.settings.SettingsScreen;

public interface WPFDomainObserver {

    void onFocusGained(MainMenuScreen mainMenuScreen);

    void onFocusGained(GameScreen gameScreen);

    void onFocusGained(SettingsScreen settingsScreen);

    void onFocusGained(CreditsScreen creditsScreen);
    
    void onFocusLost(MainMenuScreen mainMenuScreen);

    void onFocusLost(GameScreen gameScreen);

    void onFocusLost(SettingsScreen settingsScreen);

    void onFocusLost(CreditsScreen creditsScreen);
}