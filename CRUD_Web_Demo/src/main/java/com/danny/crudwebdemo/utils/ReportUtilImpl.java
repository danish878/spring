package com.danny.crudwebdemo.utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ReportUtilImpl implements ReportUtil {

    @Override
    public void generatePieChart(String path, List<Object[]> date) {

        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Object[] objects : date) {
            dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
        }

        JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report", dataset);

        try {
            ChartUtils.saveChartAsJPEG(new File(path + "/pieChart.jpeg"), chart, 300, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
