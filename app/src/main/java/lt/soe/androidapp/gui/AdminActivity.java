package lt.soe.androidapp.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lt.soe.androidapp.R;

public class AdminActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        findViewById(R.id.construct_cocktail_button).setOnClickListener(v ->
                startActivity(new Intent(this, ConstructCocktailActivity.class))
        );

        findViewById(R.id.set_pumps_button).setOnClickListener(v ->
                startActivity(new Intent(this, SetPumpsActivity.class))
        );

        findViewById(R.id.view_pumps_button).setOnClickListener(v ->
                startActivity(new Intent(this, ViewPumpsActivity.class))
        );
    }

}
