package MiBand.DisplayableHardware;

import java.util.Date;

public class Speaker implements IdisplayableHardware{
    private final String equipId;

    public Speaker(final String equipId) {
        this.equipId = equipId;
    }

    public String getEquipId(){
        return equipId;
    }

    private void readNumber(final int num){
        //Do something with the number
        System.out.println(num);
    }

    private void readString(final String str){
        //Do something with the String
        System.out.println(str);
    }

    @Override
    public void displayNumber(final int batteryLife) {
        readNumber(batteryLife);
    }

    @Override
    public String displayMessage(final String message) {
        readString(message);
        return message;
    }

    @Override
    public void displayTime(final Date date) {
        readString(date.toString());
    }


}
