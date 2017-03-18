package com.wpf.domain.settings;

import com.wpf.domain.common.ExitObserver;
import com.wpf.domain.common.Input;
import com.wpf.domain.common.ListObserver;
import com.wpf.domain.common.ListOrientation;
import com.wpf.domain.common.ListScreen;
import com.wpf.domain.common.SimpleListObserver;

public class Settings extends ListScreen<SettingsItem> {

    private final SettingsObserver observer;
    private boolean bgmOn;
    private boolean sfxOn;

    private final ListObserver<SettingsItem> itemsObserver = new SimpleListObserver<SettingsItem>() {
        @Override
        public void onItemSelected(SettingsItem item) {
            switch (item) {
                case BGM:
                    bgmOn = !bgmOn;
                    observer.onBGMToggled(bgmOn);
                    break;
                case SFX:
                    sfxOn = !sfxOn;
                    observer.onSFXToggled(sfxOn);
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled SettingsItem " + item);
            }
        }
    };

    public Settings(SettingsObserver observer) {
        super(ListOrientation.VERTICAL, SettingsItem.values());
        this.observer = observer;
        setListObserver(itemsObserver);
    }

    @Override
    protected boolean onProcessInput(Input input) {
        switch (input) {
            case ESC:
                observer.onExit();
                return true;
        }
        return super.onProcessInput(input);
    }

    public interface SettingsObserver extends ExitObserver {
        void onBGMToggled(boolean bgmOn);

        void onSFXToggled(boolean sfxOn);
    }
}