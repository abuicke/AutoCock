package lt.soe.androidapp.pumps;

public class Bottle {

    public String name;
    public int fullBottleVolumeMillilitres;
    public int currentVolumeMillilitres;

    @Override
    public String toString() {
        return "Bottle{" +
                "name='" + name + '\'' +
                ", fullBottleVolumeMillilitres=" + fullBottleVolumeMillilitres +
                ", currentVolumeMillilitres=" + currentVolumeMillilitres +
                '}';
    }
    
}
