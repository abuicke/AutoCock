package lt.soe.androidapp.pumps;

public class Pump {

    public Bottle bottle;

    public Pump(Bottle derp) {
        bottle = derp;
    }

    public Pump() {

    }

    @Override
    public String toString() {
        return bottle.toString();
    }
}
