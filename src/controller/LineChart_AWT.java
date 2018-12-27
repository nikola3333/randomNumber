package controller;

import org.jfree.chart.ChartPanel;

import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

//za pravljenje diagrama
public class LineChart_AWT extends ApplicationFrame{
	
	public LineChart_AWT(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	//opis diagrama
	public void LineChart_AWT(Map<String, Integer> map) {
		
	      String chartTitle = "Diagram ponavljanja";
	      JFreeChart lineChart = ChartFactory.createLineChart(
	         chartTitle,
	         "Brojevi","Kolicina",
	         createDataset(map),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	         
	      ChartPanel chartPanel = new ChartPanel(lineChart);
	      chartPanel.setPreferredSize(new java.awt.Dimension(560 , 370));
	      setContentPane(chartPanel);
	      pack();
	      RefineryUtilities.centerFrameOnScreen(this);
	      setVisible(true);
	      
	   }

	//pravi se baza na osnovu koje ce se praviti diagram
	   private DefaultCategoryDataset createDataset(Map<String, Integer> map ) {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      
	      for (Map.Entry<String, Integer> entry : map.entrySet()) {
	    	  	//jedna vrednost je value a druga je key, Brojevi je naziv linije po diagramu
				dataset.addValue(Integer.valueOf(entry.getValue()) , "Brojevi" ,  entry.getKey());
			}
	      
	      return dataset;
	   }

}
