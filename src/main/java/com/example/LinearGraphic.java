package com.example;

import java.awt.Color;
import java.awt.BasicStroke;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class LinearGraphic extends ApplicationFrame {
    public LinearGraphic(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle,
                "x",
                "t",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 700));
        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(4.0f));
        renderer.setSeriesStroke(2, new BasicStroke(4.0f));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    private XYDataset createDataset() {
        final XYSeries series = new XYSeries("x0 = 0.1");
        //final XYSeries series1 = new XYSeries("x0 = 10");
        //final XYSeries series2 = new XYSeries("x0 = 100");

        Calculations calculations = new Calculations();

          ArrayList<Pair> listXY = calculations.modeling1_1_12();
       // ArrayList<Pair> listXY = calculations.modeling_1_2_24(1);
       // ArrayList<Pair> listXY1 = calculations.modeling_1_2_24(10);
       // ArrayList<Pair> listXY2 = calculations.modeling_1_2_24(100);

        for (Pair xy : listXY) {
            series.add(xy.getX(), xy.getY());
        }

      // for (Pair xy : listXY1) {
      //     series1.add(xy.getX(), xy.getY());
      // }


      // for (Pair xy : listXY2) {
      //     series2.add(xy.getX(), xy.getY());
      // }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
       // dataset.addSeries(series1);
       // dataset.addSeries(series2);
        return dataset;
    }


    public static void main(String[] args) {
       // LinearGraphic chart = new LinearGraphic("Modeling", "1.2 №24");
        LinearGraphic chart = new LinearGraphic("Modeling", "1.1 №12");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}