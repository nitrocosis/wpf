package com.wpf.domain.main_menu;

import com.wpf.domain.common.ListScreen;

public class MainMenuScreen extends ListScreen<MainMenuItems, MainMenuScreenObserver> {

    public MainMenuScreen() {
        super(MainMenuItems.values(), true);
    }
}