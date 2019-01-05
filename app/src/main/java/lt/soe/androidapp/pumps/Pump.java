package lt.soe.androidapp.pumps;

public class Pump {

    public int pumpNumber;
    public Bottle bottle;

    @Override
    public String toString() {
        return "Pump{" +
                "pumpNumber=" + pumpNumber +
                ", bottle=" + bottle +
                '}';
    }
}
