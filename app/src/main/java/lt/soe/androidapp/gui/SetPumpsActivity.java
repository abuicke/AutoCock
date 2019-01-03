package lt.soe.androidapp.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lt.soe.androidapp.R;
import lt.soe.androidapp.server.JavaServer;

public class SetPumpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configure_pumps_activity);
    }

}
