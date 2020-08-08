package MiBand;

public abstract class MiBand {
    private final String miBandId;

    // Represent for the current battery percentage, range 0 - 100;
    private int batteryLife;

    public MiBand(final String id) {
        this.miBandId = id;
    }

    public void setBatteryLife(final int percentage){
        batteryLife = percentage;
    }

    public int getBatteryLife(){
        return batteryLife;
    }

    public String getMiBandId(){
        return miBandId;
    }

    //Option 1
    public abstract void displayBatteryLife();

    //Option 2
    public abstract void displayBatteryLife(final DisplayOption displayOption);
}
