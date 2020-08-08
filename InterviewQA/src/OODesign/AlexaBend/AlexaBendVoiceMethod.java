package OODesign.AlexaBend;

public class AlexaBendVoiceMethod extends AlexaBend{
    BatteryVolume voiceBatteryVolume;

    public void setVoiceBatteryVolume(BatteryVolume voiceBatteryVolume) {
        this.voiceBatteryVolume = voiceBatteryVolume;
        this.defaultMethod = voiceBatteryVolume;
    }

    public void AlexBendVoiceMethod() {
        System.out.println("Create an Bettery Display Mehod.");
    }
}
