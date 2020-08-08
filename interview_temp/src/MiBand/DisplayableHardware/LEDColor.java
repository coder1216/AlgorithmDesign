package MiBand.DisplayableHardware;

import MiBand.NotSupportedException;

import java.util.Date;

public class LEDColor implements IdisplayableHardware {
    private final String equipId;

    public LEDColor(final String equipId) {
        this.equipId = equipId;
    }

    public String getEquipId(){
        return equipId;
    }

    @Override
    public void displayNumber(final int num) {
        if (num > 80) {
            System.out.println("LED Display White");
        } else if (num > 60) {
            System.out.println("LED Display Green");
        } else if(num > 40) {
            System.out.println("LED Display Blue");
        } else if(num > 20) {
            System.out.println("LED Display Yellow");
        } else if(num > 0) {
            System.out.println("LED Display Red");
        } else {
            System.out.println("LED Display Off");
        }
    }

    @Override
    public String displayMessage(final String message) throws NotSupportedException {
        throw new NotSupportedException("ArrayLED doesn't support display message");
    }

    @Override
    public void displayTime(final Date date) throws NotSupportedException{
        throw new NotSupportedException("ArrayLED doesn't support display message");
    }
}
