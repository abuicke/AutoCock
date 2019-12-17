package lt.soe.androidapp.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

import lt.soe.androidapp.R;
import lt.soe.androidapp.pumps.Pump;
import lt.soe.androidapp.server.JavaServer;

public class ViewPumpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pumps_activity);
        BarChart barChart = findViewById(R.id.bar_chart);

        new JavaServer().getPumpsConfiguration(pumpsConfiguration -> runOnUiThread(() -> {
            List<BarEntry> barEntries = new ArrayList<>();

            int i = 0;
            for (Pump pump : pumpsConfiguration.pumps) {
                barEntries.add(new BarEntry(i++, pump.bottle.currentVolumeMillilitres));
            }

            BarDataSet barDataSet = new BarDataSet(barEntries, "one");
            barDataSet.setValueTextSize(16F);
            BarData barData = new BarData(barDataSet);
            barData.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    for (int j = 0; j < pumpsConfiguration.pumps.size(); j++) {
                        if(pumpsConfiguration.pumps.get(j).bottle.currentVolumeMillilitres == value) {
                            return pumpsConfiguration.pumps.get(j).bottle.name;
                        }
                    }

                    return "";
                }
            });
            barChart.setData(barData);
            barChart.invalidate();
        }));
    }

}
