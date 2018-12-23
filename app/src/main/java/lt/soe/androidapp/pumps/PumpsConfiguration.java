package lt.soe.androidapp.pumps;

import java.util.ArrayList;
import java.util.List;

public class PumpsConfiguration {

    public class Bottle {
        public String name;
        public int fullBottleVolumeMillilitres;
        public int currentVolumeMillilitres;
    }

    public static class Pump {
        public int pumpNumber;
        public int millilitresPoured;
        public Bottle bottle;
    }

    public List<Pump> pumps = new ArrayList<>();

}
