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
import model.Monitor;
import model.CallbackInterface;
import model.ObserverInterface;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartUI extends javax.swing.JFrame implements CallbackInterface {
    ArrayList<ObserverInterface> monitors;
    DefaultCategoryDataset dataset;
    JLabel label;
    
    JFreeChart chart;
    CategoryPlot plot;
    BarRenderer renderer;
    BufferedImage image;
    
    public BarChartUI() {
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

        dataset = new DefaultCategoryDataset();
        fillData(dataset);
        chart  = ChartFactory.createBarChart("Bar Chart", "", "", dataset, PlotOrientation.VERTICAL,false,false,false);
        plot = chart.getCategoryPlot();
        
        renderer = (BarRenderer)plot.getRenderer(); 
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    private void fillData(DefaultCategoryDataset dataset) {
        if( monitors != null ) {
            int i = 0;
            for( ObserverInterface m : monitors ) {
                dataset.addValue(Double.parseDouble(m.get().toString().replace(",", ".")), "", (Comparable) m.getName());
                ++i;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
