package lt.soe.androidapp.cocktail;

public class Ingredient {

    public String bottleName;
    public int pumpNumber;
    public int pouringOrder;
    public int millilitresInADrink;
    public int millilitresInAFullBottle;

    public Ingredient(
            String bottleName,
            int pumpNumber,
            int pouringOrder,
            int millilitresInADrink,
            int millilitresInAFullBottle
    ) {
        this.bottleName = bottleName;
        this.pumpNumber = pumpNumber;
        this.pouringOrder = pouringOrder;
        this.millilitresInADrink = millilitresInADrink;
        this.millilitresInAFullBottle = millilitresInAFullBottle;
    }
}
