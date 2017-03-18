package com.wpf.domain.common;

public abstract class SimpleListObserver<T> implements ListObserver<T> {

    @Override
    public void onItemFocused(T item) {
    }

    @Override
    public void onItemSelected(T item) {
    }
}