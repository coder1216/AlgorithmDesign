package OODesign.AlexaBend;

public abstract class AlexaBend {
    BatteryVolume defaultMethod;

    public String getVolume() {
        return "88%";
    }

    public void showBatteryVolume() {
        System.out.println(defaultMethod.getBatteryVolume() + getVolume());
    }
}
