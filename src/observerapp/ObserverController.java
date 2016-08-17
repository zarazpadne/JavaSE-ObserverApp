package observerapp;

import java.util.ArrayList;
import model.ChartController;
import model.Monitor;
import model.ObservableInterface;
import model.Stock;
import view.ObserverUI;

public class ObserverController {
    private ArrayList<ObservableInterface> stocks;
    private ArrayList<ChartController> charts;
    private ObserverUI ui;
        
    public ObserverController() {
        initialize();
    }
    
    private void initialize() {
        stocks = new ArrayList<>();
        charts = new ArrayList<>();
        
        ui = new ObserverUI();
        ui.setModel(stocks, charts);
        ui.setObserverController(this);
        ui.setVisible(true);
    }
    
    public void addStock( ObservableInterface s ) {
        stocks.add(s);
        ui.setModel(stocks,charts);
    }
  
    public void addChart( ChartController cc ) {
        charts.add(cc);
        ui.setModel(stocks,charts);
    }
    
    public void addMonitor( ObservableInterface s, int chart_id ) {
        Monitor m = new Monitor(s);
        charts.get(chart_id).addMonitor(m);
    }
           
}
