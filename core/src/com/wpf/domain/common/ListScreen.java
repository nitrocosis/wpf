package com.wpf.domain.common;

public abstract class ListScreen<T> implements Screen {

    private final ListManager<T> itemsManager;
    private final ListInputProcessor<T> inputProcessor;

    protected ListScreen(ListOrientation listOrientation, T[] items) {
        this(listOrientation, items, null);
    }

    protected ListScreen(ListOrientation listOrientation, T[] items, ListObserver<T> itemsObserver) {
        itemsManager = new ListManager<T>(items, itemsObserver);
        inputProcessor = new ListScreenInputProcessor(itemsManager, listOrientation);
    }

    @Override
    public InputProcessor inputProcessor() {
        return inputProcessor;
    }

    protected boolean onProcessInput(Input input) {
        return false;
    }

    protected void setListObserver(ListObserver<T> listObserver) {
        itemsManager.setObserver(listObserver);
    }

    private class ListScreenInputProcessor extends ListInputProcessor<T> {

        private ListScreenInputProcessor(ListManager<T> listManager, ListOrientation listOrientation) {
            super(listManager, listOrientation);
        }

        @Override
        public boolean processInput(Input input) {
            return onProcessInput(input) || super.processInput(input);
        }
    }
}