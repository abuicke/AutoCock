package lt.soe.androidapp.gui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lt.soe.androidapp.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        Button yesButton = findViewById(R.id.yes_button);
        Button noButton = findViewById(R.id.no_button);

        yesButton.setOnClickListener(v -> {
            View signInDialogView = LayoutInflater.from(this)
                    .inflate(R.layout.sign_in_dialog, null, false);
//            new AlertDialog.Builder(this)
//                    .setView(signInDialogView)
//                    .setPositiveButton("Enter", (dialog, which) -> {
//                        EditText passwordView = signInDialogView.findViewById(R.id.password);
//                        String password = passwordView.getText().toString();
//                        if (password.equals("simonas")) {
                            startActivity(new Intent(this, AdminActivity.class));
//                        } else {
//                            Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
//                            dialog.dismiss();
//                        }
//                    })
//                    .show();
        });

        noButton.setOnClickListener(v ->
                startActivity(new Intent(this, CocktailsListActivity.class))
        );
    }
}
