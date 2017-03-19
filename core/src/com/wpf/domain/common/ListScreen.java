package com.wpf.domain.common;

public abstract class ListScreen<K, V extends ListScreenObserver<K>> extends Screen<V> {

    protected final ListManager<K> itemsManager;
    private final ListInputProcessor<K> inputProcessor;

    protected ListScreen(K[] items, boolean isVertical) {
        itemsManager = new ListManager<K>(items);
        inputProcessor = new ListInputProcessor<K>(itemsManager, isVertical);
    }

    @Override
    public void addObserver(V observer) {
        super.addObserver(observer);
        itemsManager.addObserver(observer);
    }

    @Override
    public void removeObserver(V observer) {
        super.removeObserver(observer);
        itemsManager.removeObserver(observer);
    }

    @Override
    public boolean processInput(Input input) {
        return inputProcessor.processInput(input) || super.processInput(input);
    }
}