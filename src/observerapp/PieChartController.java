package observerapp;

import java.util.ArrayList;
import model.ChartController;
import model.Monitor;
import model.ObserverInterface;
import view.PieChartUI;

public class PieChartController implements ChartController {
    
    ArrayList<ObserverInterface> monitors = new ArrayList<>();
    PieChartUI pie_ui;
    
    public PieChartController() {
        pie_ui = new PieChartUI();
        pie_ui.setVisible(true);
        pie_ui.setModel(monitors);
    }
    
    public void addMonitor( ObserverInterface m ) {
        m.setCallback(pie_ui);
        monitors.add(m);
        pie_ui.update();
    }
    
    public String toString(){
        return "PieChart";
    }

}
