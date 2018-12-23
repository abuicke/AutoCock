package lt.soe.androidapp.pumps;

public class TestPumpsConfiguration extends PumpsConfiguration {

    public TestPumpsConfiguration() {
        Bottle bottleOne = new Bottle();
        bottleOne.name = "Seagram's Seven Crown Whiskey";
        bottleOne.fullBottleVolumeMillilitres = bottleOne.currentVolumeMillilitres = 1000;

        Pump pumpOne = new Pump();
        pumpOne.pumpNumber = 1;
        pumpOne.bottle = bottleOne;

        pumps.add(pumpOne);


        Bottle bottleTwo = new Bottle();
        bottleTwo.name = "7up";
        bottleTwo.fullBottleVolumeMillilitres = bottleTwo.currentVolumeMillilitres = 2000;

        Pump pumpTwo = new Pump();
        pumpTwo.pumpNumber = 2;
        pumpTwo.bottle = bottleTwo;

        pumps.add(pumpTwo);
    }

}
