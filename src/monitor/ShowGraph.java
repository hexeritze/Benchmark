package monitor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import tests.ChartData;

public class ShowGraph extends ApplicationFrame{

	private static final long serialVersionUID = 1L;
	private static ArrayList<ChartData> array = new ArrayList<>();
	String name;
	public ShowGraph(String title,List<ChartData> listData) {
		super(title);
		name = title;
		CategoryDataset data = createData(listData);
		JFreeChart chart = createChart(data);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(560,480));
		setContentPane(panel);
	}
	public static CategoryDataset createData(List<ChartData> listData) {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 for(var e : listData) {
			 dataset.addValue(e.getTime(),e.getName(),e.getCount());
		 }
		 return dataset;
	}
	private JFreeChart createChart(final CategoryDataset dataset)
    {
        final JFreeChart chart = ChartFactory.createLineChart(
            name,       // chart title
            null,                      // domain axis label
            "Значение",                // range axis label
            dataset,                   // data
            PlotOrientation.VERTICAL,  // orientation
            true,                      // include legend
            true,                      // tooltips
            false                      // urls
        );

        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(
                           NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        LineAndShapeRenderer renderer;
        renderer = (LineAndShapeRenderer) plot.getRenderer();

        renderer.setSeriesStroke(
            0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, 
                                     BasicStroke.JOIN_ROUND,
                      1.0f, new float[] {10.0f, 6.0f}, 0.0f)
        );
        renderer.setSeriesStroke(
            1, new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
                                     BasicStroke.JOIN_ROUND,
                      1.0f, new float[] {6.0f, 6.0f}, 0.0f)
        );        
        return chart;
    }
	public static ArrayList<ChartData> getArray() {
		return array;
	}
	
}
