package com.wpf.domain.common;

import java.util.LinkedHashSet;
import java.util.Set;

public class ListManager<T> {

    private final T[] items;
    private final Set<ListObserver<T>> observers = new LinkedHashSet<ListObserver<T>>();
    private int focusedItemIndex;

    ListManager(T[] items) {
        this.items = items;
    }

    public void addObserver(ListObserver<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(ListObserver<T> observer) {
        observers.remove(observer);
    }

    void focusPreviousItem() {
        if (focusedItemIndex > 0) {
            focusedItemIndex--;
            notifyObserversItemFocused();
        }
    }

    void focusNextItem() {
        if (focusedItemIndex < items.length - 1) {
            focusedItemIndex++;
            notifyObserversItemFocused();
        }
    }

    void selectFocusedItem() {
        notifyObserversItemSelected();
    }

    private T focusedItem() {
        return items[focusedItemIndex];
    }

    private void notifyObserversItemFocused() {
        for (ListObserver<T> observer : observers) {
            observer.onItemFocused(focusedItem());
        }
    }

    private void notifyObserversItemSelected() {
        for (ListObserver<T> observer : observers) {
            observer.onItemSelected(focusedItem());
        }
    }
}