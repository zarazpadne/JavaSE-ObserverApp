package model;

public interface ObservableInterface {  
    public void subscribe(ObserverInterface o);
    public void unsubscribe(ObserverInterface o);
    public Object get();
    public void set(Object p);
    public String getName();
}
