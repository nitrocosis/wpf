package com.wpf.domain;

import com.wpf.domain.credits.CreditsScreen;
import com.wpf.domain.game.GameScreen;
import com.wpf.domain.main_menu.MainMenuScreen;
import com.wpf.domain.settings.SettingsScreen;

public interface WPFDomainDelegate {

    void startPresenting(MainMenuScreen mainMenuScreen);

    void startPresenting(GameScreen gameScreen);

    void startPresenting(SettingsScreen settingsScreen);

    void startPresenting(CreditsScreen creditsScreen);

    void stopPresenting(MainMenuScreen mainMenuScreen);

    void stopPresenting(GameScreen gameScreen);

    void stopPresenting(SettingsScreen settingsScreen);

    void stopPresenting(CreditsScreen creditsScreen);

    void stopPresenting();
}