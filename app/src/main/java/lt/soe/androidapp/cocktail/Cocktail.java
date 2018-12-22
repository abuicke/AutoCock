package lt.soe.androidapp.cocktail;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Cocktail {

    public static Cocktail TEST_COCKTAIL(long id, String name) {
        return new Cocktail(
                id,
                name,
                "The jimmy whiskey cocktail",
                new ArrayList<Ingredient>() {{
                    add(new Ingredient(
                            "Jack Daniels",
                            1,
                            1,
                            35,
                            700
                    ));
                }});
    }

    public long id;
    public String name;
    public String description;
    public List<Ingredient> ingredients;

    public Cocktail(long id, String name, String description, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

}
