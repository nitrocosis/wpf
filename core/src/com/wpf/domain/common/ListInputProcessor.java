package com.wpf.domain.common;

public class ListInputProcessor<T> implements InputProcessor {

    private final ListManager<T> listManager;

    private final InputCommandProcessor inputCommandProcessor = new InputCommandProcessor();

    private final InputCommand selectFocusedItemCommand = new InputCommand() {
        @Override
        public boolean execute() {
            listManager.selectFocusedItem();
            return true;
        }
    };

    private final InputCommand focusPreviousItemCommand = new InputCommand() {
        @Override
        public boolean execute() {
            listManager.focusPreviousItem();
            return true;
        }
    };

    private final InputCommand focusNextItemCommand = new InputCommand() {
        @Override
        public boolean execute() {
            listManager.focusNextItem();
            return true;
        }
    };

    public ListInputProcessor(ListManager<T> listManager, boolean isVertical) {
        this.listManager = listManager;
        inputCommandProcessor.setCommand(Input.ENTER, selectFocusedItemCommand);
        inputCommandProcessor.setCommand(isVertical ? Input.UP : Input.LEFT, focusPreviousItemCommand);
        inputCommandProcessor.setCommand(isVertical ? Input.DOWN : Input.RIGHT, focusNextItemCommand);
    }

    @Override
    public boolean processInput(Input input) {
        return inputCommandProcessor.processInput(input);
    }
}