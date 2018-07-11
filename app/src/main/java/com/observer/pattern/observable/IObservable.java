package com.observer.pattern.observable;

import com.observer.pattern.observers.IObservers;

public interface IObservable {

    void add(IObservers oservers);
    void remove(IObservers oservers);
    void performNotify(int oldKey);
    void success(IObservers observer);
}
