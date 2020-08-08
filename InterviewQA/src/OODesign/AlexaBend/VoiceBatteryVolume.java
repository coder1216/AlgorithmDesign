package OODesign.AlexaBend;

public class VoiceBatteryVolume implements BatteryVolume{
    String message = "Show battery volume by Voice: ";
    @Override
    public String getBatteryVolume() {
        return message;
    }
}
