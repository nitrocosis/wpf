package com.wpf.domain.credits;

import com.wpf.domain.common.ExitObserver;
import com.wpf.domain.common.Input;
import com.wpf.domain.common.InputProcessor;
import com.wpf.domain.common.Screen;

public class Credits implements Screen {

    private final ExitObserver exitObserver;

    private final InputProcessor inputProcessor = new InputProcessor() {
        @Override
        public boolean processInput(Input input) {
            exitObserver.onExit();
            return true;
        }
    };

    public Credits(ExitObserver exitObserver) {
        this.exitObserver = exitObserver;
    }

    @Override
    public InputProcessor inputProcessor() {
        return inputProcessor;
    }
}