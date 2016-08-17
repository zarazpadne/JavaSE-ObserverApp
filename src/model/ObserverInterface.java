package model;

public interface ObserverInterface {
    public void notify_update();
    public void setCallback(CallbackInterface c);
    public void free();
    public Object get();
    public String getName();
}
