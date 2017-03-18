package com.wpf.domain.common;

public class ListInputProcessor<T> implements InputProcessor {

    private final ListManager<T> listManager;
    private final ListOrientation listOrientation;

    public ListInputProcessor(ListManager<T> listManager, ListOrientation listOrientation) {
        this.listManager = listManager;
        this.listOrientation = listOrientation;
    }

    @Override
    public boolean processInput(Input input) {
        switch (input) {
            case ENTER:
                listManager.selectFocusedItem();
                return true;
        }

        switch (listOrientation) {
            case VERTICAL:
                return handleVerticalInput(input);
            case HORIZONTAL:
                return handleHorizontalInput(input);
            default:
                throw new IllegalArgumentException("Unhandled list orientation");
        }
    }

    private boolean handleVerticalInput(Input input) {
        switch (input) {
            case UP:
                listManager.focusPreviousItem();
                return true;
            case DOWN:
                listManager.focusNextItem();
                return true;
            default:
                return false;
        }
    }

    private boolean handleHorizontalInput(Input input) {
        switch (input) {
            case LEFT:
                listManager.focusPreviousItem();
                return true;
            case RIGHT:
                listManager.focusNextItem();
                return true;
            default:
                return false;
        }
    }
}