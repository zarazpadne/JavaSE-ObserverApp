package observerapp;

import java.util.ArrayList;
import model.Monitor;
import model.Stock;
import view.BarChartUI;
import view.ObserverUI;


public class ObserverAPP {
    
   
    public static void main(String[] args) {
        Stock s;
        ObserverController oc = new ObserverController();
        BarChartController bcc = new BarChartController();
        PieChartController pcc = new PieChartController();
        oc.addChart(bcc);
        oc.addChart(pcc);
        
        s = new Stock("Google");
        oc.addStock(s);
        oc.addMonitor(s, 0);
        
        s = new Stock("Amazon");
        oc.addStock(s);
        oc.addMonitor(s, 0);
        
        s = new Stock("IBM");
        oc.addStock(s);
        oc.addMonitor(s, 0);
        oc.addMonitor(s, 1);
        
        s = new Stock("INTC");
        oc.addStock(s);
        oc.addMonitor(s, 1);
        
    }
    
}
