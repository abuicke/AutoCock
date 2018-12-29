package lt.soe.androidapp.gui;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lt.soe.androidapp.R;
import lt.soe.androidapp.cocktail.Cocktail;
import lt.soe.androidapp.cocktail.Ingredient;
import lt.soe.androidapp.server.JavaServer;

public class ConstructCocktailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.construct_cocktail_activity);

        List<Ingredient> ingredients = new ArrayList<>();
        LinearLayout ingredientsListView = findViewById(R.id.ingredients);

        findViewById(R.id.add_ingredient_button).setOnClickListener(v -> {
            View addIngredientView = getLayoutInflater().inflate(R.layout.new_ingredient_view, null);
            new AlertDialog.Builder(this)
                    .setTitle("New ingredient")
                    .setView(addIngredientView)
                    .setPositiveButton("Add", (dialog, which) -> {
                        TextView ingredientNameView = addIngredientView.findViewById(R.id.ingredient_name);
                        TextView pouringNumberView = addIngredientView.findViewById(R.id.pouring_number);
                        TextView drinkMillilitresView = addIngredientView.findViewById(R.id.millilitres_in_a_drink);
                        TextView textView = new TextView(ConstructCocktailActivity.this);
                        textView.setTextSize(18);
                        textView.setPadding(12, 20, 0, 50);
                        textView.setBackgroundColor(Color.rgb(93, 188, 210));
                        textView.setText(ingredientNameView.getText());
                        ingredientsListView.addView(textView);
                        ingredients.add(new Ingredient(
                                ingredientNameView.getText().toString(),
                                Integer.valueOf(pouringNumberView.getText().toString()),
                                Integer.valueOf(drinkMillilitresView.getText().toString())
                        ));
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.cancel())
                    .show();
        });

        findViewById(R.id.save_cocktail_button).setOnClickListener(v -> {
            String cocktailName = ((TextView) findViewById(R.id.cocktail_name)).getText().toString();
            String cocktailDescription = ((TextView) findViewById(R.id.cocktail_description)).getText().toString();
            Cocktail cocktail = new Cocktail(System.currentTimeMillis(), cocktailName, cocktailDescription, ingredients);
            new JavaServer().constructCocktail(cocktail);
            Toast.makeText(this, "Constructed cocktail " + cocktailName, Toast.LENGTH_LONG).show();
            finish();
        });
    }

}
