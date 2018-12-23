package lt.soe.androidapp.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import lt.soe.androidapp.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        Button yesButton = findViewById(R.id.yes_button);
        Button noButton = findViewById(R.id.no_button);

        yesButton.setOnClickListener(v ->
                startActivity(new Intent(this, ConfigurePumpsActivity.class))
        );

        noButton.setOnClickListener(v ->
                startActivity(new Intent(this, CocktailsListActivity.class))
        );
    }
}