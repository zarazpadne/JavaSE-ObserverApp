package view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Renderer;
import model.Monitor;
import model.CallbackInterface;
import model.ObserverInterface;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;

public class PieChartUI extends javax.swing.JFrame implements CallbackInterface {
    ArrayList<ObserverInterface> monitors;
    DefaultPieDataset dataset;
    JLabel label;
    
    JFreeChart chart;
    PiePlot plot;
    Renderer renderer;
    BufferedImage image;
  
    public PieChartUI() {
        initComponents();
        this.setSize(400, 300);
        this.setLayout(new java.awt.BorderLayout());
    }
    
    public void setModel( ArrayList<ObserverInterface> monitors ) {
        this.monitors = monitors;
        for( ObserverInterface m : this.monitors ) {
            m.setCallback(this);
        }
        this.update();
    }
    
    private JLabel getChart() {

        dataset = new DefaultPieDataset();
        fillData(dataset);
        chart  = ChartFactory.createPieChart("Pie Chart", dataset,false,false,false);
        plot = (PiePlot) chart.getPlot();

        image = chart.createBufferedImage(this.getWidth(), this.getHeight()-50);
        return new JLabel(new ImageIcon(image));    
    }
    
    @Override
    public void update() {
        if( label != null ) this.remove(label); 
        label = getChart();
        this.add(label);
        this.revalidate();
        this.repaint(10);
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }


    private void fillData(DefaultPieDataset dataset) {
        if( monitors != null ) {
            int i = 0;
            for( ObserverInterface m : monitors ) {
                dataset.setValue((Comparable) m.getName(), Double.parseDouble(m.get().toString().replace(",", ".")));
                ++i;
            }
        }
    }

}
