package MiBand.DisplayableHardware;

import MiBand.NotSupportedException;

import java.util.Date;

public class LEDArray implements IdisplayableHardware{
    private final String equipId;
    private final int ledNumber;

    public LEDArray(final String equipId) {
        this.equipId = equipId;
        ledNumber = 5;
    }

    public String getEquipId(){
        return equipId;
    }

    public int getLedNumber(){
        return ledNumber;
    }

    @Override
    public void displayNumber(final int batteryLife) {
        if (batteryLife > 80) {
            System.out.println("Turn on 5 LEDs");
        } else if (batteryLife > 60) {
            System.out.println("Turn on 4 LEDs");
        } else if(batteryLife > 40) {
            System.out.println("Turn on 3 LEDs");
        } else if(batteryLife > 20) {
            System.out.println("Turn on 2 LEDs");
        } else if(batteryLife > 0) {
            System.out.println("Turn on 1 LEDs");
        } else {
            System.out.println("Turn on 0 LEDs");
        }
    }

    @Override
    public String displayMessage(final String message) throws NotSupportedException {
        throw new NotSupportedException("ArrayLED doesn't support display message");
    }

    @Override
    public void displayTime(final Date date) throws NotSupportedException{
        throw new NotSupportedException("ArrayLED doesn't support display time");
    }



}
