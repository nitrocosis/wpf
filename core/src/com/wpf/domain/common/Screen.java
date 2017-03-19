package com.wpf.domain.common;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Screen<T extends ScreenObserver> implements InputProcessor {

    protected final Set<T> observers = new LinkedHashSet<T>();

    private final InputCommandProcessor inputCommandProcessor = new InputCommandProcessor();

    private final InputCommand loseFocusCommand = new InputCommand() {
        @Override
        public boolean execute() {
            notifyObserversOnFocusLost();
            return true;
        }
    };

    protected Screen() {
        inputCommandProcessor.setCommand(Input.ESC, loseFocusCommand);
    }

    @Override
    public boolean processInput(Input input) {
        return inputCommandProcessor.processInput(input);
    }

    public void gainFocus() {
        notifyObserversOnFocusGained();
    }

    public void addObserver(T observer) {
        observers.add(observer);
    }

    public void removeObserver(T observer) {
        observers.remove(observer);
    }

    private void notifyObserversOnFocusGained() {
        for (T observer : observers) {
            observer.onFocusGained();
        }
    }

    private void notifyObserversOnFocusLost() {
        for (T observer : observers) {
            observer.onFocusLost();
        }
    }
}