package lt.soe.androidapp.cocktail;

import java.util.ArrayList;

public class TestCocktails {

    public static Cocktail TEST_COCKTAIL_1 = new Cocktail(
            System.currentTimeMillis(),
            "7 and 7",
            "Seagram's Seven Crown and 7 Up",
            new ArrayList<Ingredient>() {{
                add(new Ingredient(
                        "Seagram's Seven Crown Whiskey",
                        1,
                        28
                ));

                add(new Ingredient(
                        "7up",
                        2,
                        260
                ));
            }}
    );

}
