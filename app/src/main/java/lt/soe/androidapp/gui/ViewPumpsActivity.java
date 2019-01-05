package lt.soe.androidapp.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import lt.soe.androidapp.R;
import lt.soe.androidapp.server.JavaServer;

public class ViewPumpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pumps_activity);

        TextView pumpsConfigurationView = findViewById(R.id.pumps_configuration);
        new JavaServer().getPumpsConfiguration(pumpsConfiguration -> runOnUiThread(() ->
                pumpsConfigurationView.setText(pumpsConfiguration.toString())
        ));
    }

}
