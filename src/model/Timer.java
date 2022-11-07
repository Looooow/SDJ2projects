package model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Timer implements Runnable, UnnamedPropertyChangeSubject {
    private int second;
    private final PropertyChangeSupport property;

    public Timer(int second) {
        this.second = second;
        this.property = new PropertyChangeSupport(this);
    }

    @Override
    public void run() {
        while (second > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(second);
            property.firePropertyChange("timer", 0, second);
            second--;
        }

    }

    public int getSecond() {
        return second;
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
