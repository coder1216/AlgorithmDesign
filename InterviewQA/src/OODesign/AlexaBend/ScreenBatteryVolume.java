package OODesign.AlexaBend;

public class ScreenBatteryVolume implements BatteryVolume {
    String screenMessage = "Show battery volume on Screen: ";
    @Override
    public String getBatteryVolume() {
        return screenMessage;
    }
}
