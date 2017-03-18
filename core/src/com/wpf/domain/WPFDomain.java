package com.wpf.domain;

import com.wpf.domain.common.ExitObserver;
import com.wpf.domain.common.Input;
import com.wpf.domain.common.InputProcessor;
import com.wpf.domain.common.ListObserver;
import com.wpf.domain.common.Screen;
import com.wpf.domain.common.SimpleListObserver;
import com.wpf.domain.credits.Credits;
import com.wpf.domain.main_menu.MainMenu;
import com.wpf.domain.main_menu.MenuItem;
import com.wpf.domain.settings.Settings;

public class WPFDomain implements InputProcessor {

    private final GameApplicationObserver observer;

    private final Screen mainMenu;
    private final Screen settings;
    private final Screen credits;

    private Screen focusedScreen;

    private final ListObserver<MenuItem> menuItemsObserver = new SimpleListObserver<MenuItem>() {
        @Override
        public void onItemSelected(MenuItem item) {
            switch (item) {
                case PLAY:
                    // TODO
                    break;
                case SETTINGS:
                    focusScreen(settings);
                    break;
                case CREDITS:
                    focusScreen(credits);
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled MenuItem " + item);
            }
        }
    };

    private final Settings.SettingsObserver settingsObserver = new Settings.SettingsObserver() {
        @Override
        public void onBGMToggled(boolean bgmOn) {
            observer.onBGMToggled(bgmOn);
        }

        @Override
        public void onSFXToggled(boolean sfxOn) {
            observer.onSFXToggled(sfxOn);
        }

        @Override
        public void onExit() {
            focusScreen(mainMenu);
        }
    };

    private final ExitObserver creditsExitObserver = new ExitObserver() {
        @Override
        public void onExit() {
            focusScreen(mainMenu);
        }
    };

    public WPFDomain(GameApplicationObserver observer) {
        this.observer = observer;

        mainMenu = new MainMenu(menuItemsObserver);
        settings = new Settings(settingsObserver);
        credits = new Credits(creditsExitObserver);
        focusedScreen = mainMenu;
    }

    @Override
    public boolean processInput(Input input) {
        return focusedScreen.inputProcessor().processInput(input);
    }

    private void focusScreen(Screen screen) {
        if (focusedScreen == screen) {
            return;
        }

        observer.onScreenFocusLost(focusedScreen);
        focusedScreen = screen;
        observer.onScreenFocusGained(focusedScreen);
    }
}