package com.example.passcodeviewdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private LineChart mChart;
    private PieChart pChart;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // create object
        mChart = (LineChart) findViewById(R.id.linechart);
        pChart = (PieChart) findViewById(R.id.piechart);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);
        // line charts
        // insert values, which can be placed by children's progress
        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0, 60f));
        yValues.add(new Entry(1, 50f));
        yValues.add(new Entry(2, 70f));
        yValues.add(new Entry(3, 30f));
        yValues.add(new Entry(4, 50f));
        yValues.add(new Entry(5, 60f));
        yValues.add(new Entry(6, 65f));

        // initialise data
        LineDataSet set1 = new LineDataSet(yValues, "Children's progress each week");
        set1.setFillAlpha(110);
        set1.setLineWidth(30f);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        LineData data = new LineData((dataSets));

        // pie charts
        List<PieEntry> pieEntires = new ArrayList<>();
        pieEntires.add(new PieEntry(0, 60f));
        pieEntires.add(new PieEntry(1, 50f));
        pieEntires.add(new PieEntry(2, 70f));
        pieEntires.add(new PieEntry(3, 30f));
        pieEntires.add(new PieEntry(0, 50f));
        pieEntires.add(new PieEntry(1, 60f));
        pieEntires.add(new PieEntry(2, 30f));
        pieEntires.add(new PieEntry(3, 70f));

        PieDataSet dataSet1 = new PieDataSet(pieEntires,"Children's progress each week");
        dataSet1.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data1 = new PieData(dataSet1);
        // set data
        mChart.setData(data);
        pChart.setData(data1);
    }
}