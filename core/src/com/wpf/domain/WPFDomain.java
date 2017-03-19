package com.wpf.domain;

import com.wpf.domain.common.Input;
import com.wpf.domain.common.InputProcessor;
import com.wpf.domain.common.Screen;
import com.wpf.domain.credits.CreditsScreen;
import com.wpf.domain.credits.CreditsScreenObserver;
import com.wpf.domain.game.GameScreen;
import com.wpf.domain.game.GameScreenObserver;
import com.wpf.domain.main_menu.MainMenuItems;
import com.wpf.domain.main_menu.MainMenuScreen;
import com.wpf.domain.main_menu.MainMenuScreenObserver;
import com.wpf.domain.settings.SettingsScreen;
import com.wpf.domain.settings.SettingsScreenObserver;

public class WPFDomain implements InputProcessor {

    private final WPFDomainDelegate delegate;

    private final MainMenuScreen mainMenuScreen;
    private final GameScreen gameScreen;
    private final SettingsScreen settingsScreen;
    private final CreditsScreen creditsScreen;

    private Screen focusedScreen;

    private final MainMenuScreenObserver mainMenuScreenObserver = new MainMenuScreenObserver() {
        @Override
        public void onFocusGained() {
            delegate.startPresenting(mainMenuScreen);
        }

        @Override
        public void onItemSelected(MainMenuItems item) {
            switch (item) {
                case PLAY:
                    focusScreen(gameScreen);
                    break;
                case SETTINGS:
                    focusScreen(settingsScreen);
                    break;
                case CREDITS:
                    focusScreen(creditsScreen);
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled MainMenuItems " + item);
            }
        }

        @Override
        public void onFocusLost() {
            delegate.stopPresenting();
        }
    };

    private final GameScreenObserver gameScreenObserver = new GameScreenObserver() {
        @Override
        public void onFocusGained() {
            delegate.startPresenting(gameScreen);
        }

        @Override
        public void onFocusLost() {
            delegate.stopPresenting(gameScreen);
            focusScreen(mainMenuScreen);
        }
    };

    private final SettingsScreenObserver settingsScreenObserver = new SettingsScreenObserver() {
        @Override
        public void onFocusGained() {
            delegate.startPresenting(settingsScreen);
        }

        @Override
        public void onFocusLost() {
            delegate.stopPresenting(settingsScreen);
            focusScreen(mainMenuScreen);
        }
    };

    private final CreditsScreenObserver creditsScreenObserver = new CreditsScreenObserver() {
        @Override
        public void onFocusGained() {
            delegate.startPresenting(creditsScreen);
        }

        @Override
        public void onFocusLost() {
            delegate.stopPresenting(creditsScreen);
            focusScreen(mainMenuScreen);
        }
    };

    public WPFDomain(WPFDomainDelegate delegate) {
        this.delegate = delegate;

        mainMenuScreen = new MainMenuScreen();
        gameScreen = new GameScreen();
        settingsScreen = new SettingsScreen();
        creditsScreen = new CreditsScreen();

        mainMenuScreen.addObserver(mainMenuScreenObserver);
        gameScreen.addObserver(gameScreenObserver);
        settingsScreen.addObserver(settingsScreenObserver);
        creditsScreen.addObserver(creditsScreenObserver);

        focusScreen(mainMenuScreen);
    }

    @Override
    public boolean processInput(Input input) {
        return focusedScreen.processInput(input);
    }

    private void focusScreen(Screen screen) {
        if (focusedScreen == screen) {
            return;
        }

        focusedScreen.gainFocus();
        focusedScreen = screen;
    }
}