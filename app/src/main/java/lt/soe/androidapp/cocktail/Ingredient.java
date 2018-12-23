package lt.soe.androidapp.cocktail;

public class Ingredient {

    public String bottleName;
    public int pouringOrder;
    public int millilitresInADrink;

    public Ingredient(
            String bottleName,
            int pouringOrder,
            int millilitresInADrink
    ) {
        this.bottleName = bottleName;
        this.pouringOrder = pouringOrder;
        this.millilitresInADrink = millilitresInADrink;
    }
}
