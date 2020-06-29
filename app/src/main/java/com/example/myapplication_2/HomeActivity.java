package com.example.myapplication_2;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    // 원형 차트 변수 선언
    AnyChartView anyChartView;

    String[] meals = {"아침", "점심", "저녁", "간식", ""};
    int[] calories = {200, 500, 250, 450, 100};

    // 막대 차트 변수 선언
    BarChart stackedChart;
    int[] colorArray = new int[]{Color.rgb(114, 80, 201)};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_home);
        // 원형 차트
        anyChartView = findViewById(R.id.any_chart_view);
        setupPieChart();

// 막대 차트
        stackedChart = findViewById(R.id.stacked_barChart);

        BarDataSet barDataSet = new BarDataSet(dataValues1(), "Bar Set");
        barDataSet.setColors(colorArray);

        BarData barData = new BarData(barDataSet);
        stackedChart.setData(barData);

    }

    // 원형차트 데이터 입력
    public void setupPieChart() {
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < meals.length; i++) {
            dataEntries.add(new ValueDataEntry(meals[i], calories[i]));
        }

        pie.data(dataEntries);
        anyChartView.setChart(pie);
    }

    // 막대 차트 데이터 입력
    private ArrayList<BarEntry> dataValues1() {
        ArrayList<BarEntry> dataVals = new ArrayList<>();

        dataVals.add(new BarEntry(0, new float[]{2, 5.5f, 4}));
        dataVals.add(new BarEntry(1, new float[]{2, 8f, 4.2f}));
        dataVals.add(new BarEntry(2, new float[]{3, 5.5f, 4}));
        dataVals.add(new BarEntry(3, new float[]{4, 6.5f, 4}));
        dataVals.add(new BarEntry(4, new float[]{2, 5.5f, 3.3f}));

        return dataVals;
    }

}
