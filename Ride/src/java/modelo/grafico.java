/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
@ViewScoped
public class grafico {
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
     
    @PostConstruct
    public void init() {
        createLineModels();
    }

    public LineChartModel getLineModel2() {
        return lineModel2;
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
     
private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Caronas por Mês - Geral");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis(""));
        yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(500);
         
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Locais de Saída - Dois Vizinhos");
        lineModel2.setShowPointLabels(false);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis(""));
        yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set("Outubro", 100);
        series1.set("Novembro", 250);
 
 
        model.addSeries(series1);
         
        return model;
    }
     
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.set("UTFPR", 120);
        boys.set("QUADRI", 100);
        boys.set("PRAÇA CENTRO NORTE", 44);
        boys.set("ÍTALO", 150);
        boys.set("PREFEITURA", 25);
        
        model.addSeries(boys);
         
        return model;
    }
 
}