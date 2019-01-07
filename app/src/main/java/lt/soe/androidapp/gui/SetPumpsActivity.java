package lt.soe.androidapp.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import lt.soe.androidapp.R;
import lt.soe.androidapp.pumps.Bottle;
import lt.soe.androidapp.pumps.Pump;
import lt.soe.androidapp.server.JavaServer;

public class SetPumpsActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout setPumpsView;
    EditText ingredientNameView;
    EditText quantityView;
    Button setPumpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configure_pumps_activity);

        setPumpsView = findViewById(R.id.set_pumps_view);
        ingredientNameView = findViewById(R.id.ingredient_name);
        quantityView = findViewById(R.id.quantity);
        setPumpButton = findViewById(R.id.set_pump_button);

        Button pumpOneButton = findViewById(R.id.pump_1);
        Button pumpTwoButton = findViewById(R.id.pump_2);
        Button pumpThreeButton = findViewById(R.id.pump_3);
        Button pumpFourButton = findViewById(R.id.pump_4);
        Button pumpFiveButton = findViewById(R.id.pump_5);
        Button pumpSixButton = findViewById(R.id.pump_6);

        pumpOneButton.setOnClickListener(this);
        pumpTwoButton.setOnClickListener(this);
        pumpThreeButton.setOnClickListener(this);
        pumpFourButton.setOnClickListener(this);
        pumpFiveButton.setOnClickListener(this);
        pumpSixButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int pumpNumber;
        switch (v.getId()) {
            case R.id.pump_1:
                pumpNumber = 0;
                break;
            case R.id.pump_2:
                pumpNumber = 1;
                break;
            case R.id.pump_3:
                pumpNumber = 2;
                break;
            case R.id.pump_4:
                pumpNumber = 3;
                break;
            case R.id.pump_5:
                pumpNumber = 4;
                break;
            case R.id.pump_6:
                pumpNumber = 5;
                break;
            default:
                Toast.makeText(this, "Unrecognised pump number", Toast.LENGTH_SHORT).show();
                setPumpsView.setVisibility(View.GONE);
                ingredientNameView.setText("");
                quantityView.setText("");
                return;

        }

        setPumpButton.setOnClickListener(v1 -> {
            String ingredientName = ingredientNameView.getText().toString();
            int quantity = Integer.valueOf(quantityView.getText().toString());

            JavaServer javaServer = new JavaServer();
            javaServer.getPumpsConfiguration(pumpsConfiguration -> {
                Pump pump;
                if (pumpNumber < pumpsConfiguration.pumps.size()) {
                    pump = pumpsConfiguration.pumps.get(pumpNumber);
                } else {
                    pump = new Pump();
                    pump.bottle = new Bottle();
                    pumpsConfiguration.pumps.add(pumpNumber, pump);
                }
                pump.bottle.name = ingredientName;
                pump.bottle.fullBottleVolumeMillilitres = pump.bottle.currentVolumeMillilitres = quantity;
                new JavaServer().setPumpsConfiguration(pumpsConfiguration);

                runOnUiThread(() -> {
                    Toast.makeText(this, "Set pump " + (pumpNumber + 1) + " to " + pump.bottle.name, Toast.LENGTH_SHORT).show();
                    setPumpsView.setVisibility(View.GONE);
                    ingredientNameView.setText("");
                    quantityView.setText("");
                });
            });
        });
        setPumpsView.setVisibility(View.VISIBLE);
    }

}
