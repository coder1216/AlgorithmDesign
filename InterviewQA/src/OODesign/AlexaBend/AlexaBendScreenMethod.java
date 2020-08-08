package OODesign.AlexaBend;

import javafx.stage.Screen;

public class AlexaBendScreenMethod extends AlexaBendVoiceMethod{
    BatteryVolume screenBatteryVolume;

    public void AlexaBendScreenMethod() {
        System.out.println("Screen Method.");
    }

    public void setScreenBatteryVolume(BatteryVolume ScreenBatteryVolume) {
        this.screenBatteryVolume = screenBatteryVolume;
        this.defaultMethod = screenBatteryVolume;
    }

    public void setDefaultMethod(String method) {
        if (method.equalsIgnoreCase("Screen")) {
            System.out.println("Change display method to: " + method.toUpperCase());
            super.defaultMethod = this.screenBatteryVolume;
        } else if (method.equalsIgnoreCase("Voice")) {
            System.out.println("Change display method to: " + method.toUpperCase());
            super.defaultMethod = this.voiceBatteryVolume;
        }
    }
}
