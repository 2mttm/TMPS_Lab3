package io.dmitrirusnac.utm.course4.tmpp.lab3.observer;

public interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}