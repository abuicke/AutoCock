package lt.soe.androidapp.pumps;

public class Bottle {

    public String name;
    public int fullBottleVolumeMillilitres;
    public int currentVolumeMillilitres;

    public Bottle(String name, int fullBottleVolumeMillilitres, int currentVolumeMillilitres) {
        this.name = name;
        this.fullBottleVolumeMillilitres = fullBottleVolumeMillilitres;
        this.currentVolumeMillilitres = currentVolumeMillilitres;
    }

    public Bottle() {

    }

    @Override
    public String toString() {
        return "Bottle{" +
                "name='" + name + '\'' +
                ", fullBottleVolumeMillilitres=" + fullBottleVolumeMillilitres +
                ", currentVolumeMillilitres=" + currentVolumeMillilitres +
                '}';
    }
    
}
