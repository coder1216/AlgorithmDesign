package MiBand.DisplayableHardware;

import MiBand.NotSupportedException;

import java.util.Date;

public class Screen implements IdisplayableHardware{
    private final String equipId;

    public Screen(final String equipId) {
        this.equipId = equipId;

    }

    public String getEquipId(){
        return equipId;
    }

    private void showNumber(final int num){
        //Do something with the number
        System.out.println(num);
    }

    private void showString(final String str){
        //Do something with the String
        System.out.println(str);
    }


    @Override
    public void displayNumber(int batteryLife) {
        showNumber(batteryLife);
    }

    @Override
    public String displayMessage(String message) throws NotSupportedException {
       if (message != null) {
           showString(message);
       } else {
           throw new NotSupportedException("eee");
       }
       return null;
    }

    @Override
    public void displayTime(Date date) throws NotSupportedException {

    }
}
