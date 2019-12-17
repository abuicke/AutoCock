package lt.soe.androidapp.gui;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

public class MyValueFormatter extends ValueFormatter {

    @Override
    public String getFormattedValue(float value) {
        return "derp";
    }

    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        return "herp";
    }
}
