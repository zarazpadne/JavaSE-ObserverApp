package model;

public class Monitor implements ObserverInterface {
    private ObservableInterface ob;
    private Object value;
    private CallbackInterface callback;
    
    public Monitor(ObservableInterface o){
        this.ob = o;
        this.value = this.ob.get();
        o.subscribe(this);
    }
    
    @Override
    public void notify_update() {
        this.value = ob.get();
        System.out.println("Observable has changed: "+ob+" value: "+this.value);
        callback.update();
    }   
    
    public String toString() {
        return "Monitor(" + ob.hashCode() + ")";
    }
    
    public Object get() {
        return value;
    }
    
    public String getName() {
        return ob.getName();
    }
    
    public void free() {
        ob = null;
    }
    
    public void close(){
        ob.unsubscribe(this);
    }
    
    public void setCallback(CallbackInterface c) {
        this.callback = c;
    }
    
    @Override
    protected void finalize() throws Throwable{
        try {
            this.close();
        } finally {
            super.finalize();
        }
    }
}
