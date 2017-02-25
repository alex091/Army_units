package Interfaces;

public interface Observer {
    void addObservable(Observable observable);
    void removeObservable(Observable observable);
    void sendNotification();
}
