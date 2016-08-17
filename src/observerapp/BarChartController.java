package observerapp;

import java.util.ArrayList;
import model.ChartController;
import model.Monitor;
import model.ObserverInterface;
import view.BarChartUI;

public class BarChartController implements ChartController {
    
    ArrayList<ObserverInterface> monitors = new ArrayList<>();
    BarChartUI bar_ui;
    
    public BarChartController() {
        bar_ui = new BarChartUI();
        bar_ui.setVisible(true);
        bar_ui.setModel(monitors);
    }
    
    public void addMonitor( ObserverInterface m ) {
        m.setCallback(bar_ui);
        monitors.add(m);
        bar_ui.update();
    }
    
    public String toString(){
        return "BarChart";
    }

}
