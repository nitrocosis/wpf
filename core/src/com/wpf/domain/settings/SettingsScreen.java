package com.wpf.domain.settings;

import com.wpf.domain.common.ListObserver;
import com.wpf.domain.common.ListScreen;

public class SettingsScreen extends ListScreen<SettingsItem, SettingsScreenObserver> {

    private boolean bgmOn;
    private boolean sfxOn;

    private final ListObserver<SettingsItem> itemsSelectedObserver = new ListObserver<SettingsItem>() {
        @Override
        public void onItemFocused(SettingsItem item) {
        }

        @Override
        public void onItemSelected(SettingsItem item) {
            switch (item) {
                case BGM:
                    bgmOn = !bgmOn;
                    notifyObserversOnBGMToggled();
                    break;
                case SFX:
                    sfxOn = !sfxOn;
                    notifyObserversOnSFXToggled();
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled SettingsItem " + item);
            }
        }
    };

    public SettingsScreen() {
        super(SettingsItem.values(), true);
        itemsManager.addObserver(itemsSelectedObserver);
    }

    private void notifyObserversOnBGMToggled() {
        for (SettingsScreenObserver observer : observers) {
            observer.onBGMToggled(bgmOn);
        }
    }

    private void notifyObserversOnSFXToggled() {
        for (SettingsScreenObserver observer : observers) {
            observer.onSFXToggled(sfxOn);
        }
    }
}