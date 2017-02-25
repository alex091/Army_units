package Interfaces;

import Exceptions.UnitIsDeadException;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver() throws UnitIsDeadException;
}
