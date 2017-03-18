package com.wpf.domain.main_menu;

import com.wpf.domain.common.ListObserver;
import com.wpf.domain.common.ListOrientation;
import com.wpf.domain.common.ListScreen;

public class MainMenu extends ListScreen<MenuItem> {

    public MainMenu(ListObserver<MenuItem> itemsObserver) {
        super(ListOrientation.VERTICAL, MenuItem.values(), itemsObserver);
    }
}