//  * alexa设备显示电量的feature
//  * 比如有些是没屏幕的，有些是有屏幕的，有些是平板电脑
//  * 然后你设计的这个东西，在这些设备上都能用
//  * 
//  * * 我就说设计个abstract class，里面有个function默认是用语音播放的，因为每个设备都有音响。
//  * 然后对有屏幕的设备可以override掉这个method，用屏幕显示
//  * 然后他说那如果有屏幕的话，我要既可以用音响播放电量，又能用屏幕显示, 但是用户可以做选择

public class Client{
    public static void main(String[] args) {
        System.out.println("Testing a new Alexa equiment which only has voice");
        VoiceEquipment VoiceEquipment = new VoiceEquipment();
        VoiceEquipment.setVoiceBatteryVolume(new VoiceBatteryVolume);
        VoiceEquipment.showBatteryVolume();

        System.out.println("\n Testing a new Alexa equitment which has screen and voice");
        screenEquipment screenEquipment = new ScreenEquipment();
        screenEquipment.setVoiceBatteryVloume(new VoiceBatteryVolume);
        screenEquipment.setScreenBatteryVolume(new ScreenBatteryVolume);

        //screenEquipment.showBatteryVolume();
        screenEquipment.setDefaultMethod("Screen");
        screenEquipment.showBatteryVolume();

        screenEquipment.setDefaultMethod("Voice");
        screenEquipment.showBatteryVolume();

    }
    public interface BatteryVolume {
        public String getBatteryVolume();
    }
    public class ScreenBatteryVolume implements BatteryVolume {
        String message = "show battery volume on the screen";
        @Override
        public String getBatteryVolume() {
            return message;
        }
    }
    public class VoiceBatteryVolume implements BatteryVolume {
        String message = "show battery volume on the screen";
        @Override
        public String getBatteryVolume() {
            return message;
        }
    }
    public class AlexaEquipment {
        BatteryVolume defaultMethod;

        public void showBattery() {
            System.out.println(defaultMethod.getBatteryVolume()+ getCurrentBatteryVolume);
        }

        public String getCurrenString() {
            return "88%";
        }
    }
    public class VoiceEquipment extends AlexaEquipment {
        BatteryVolume voiceBatteryVolume;
        public VoiceEquipment() {
            System.out.println();
        }
        public void setVoiceBatteryVloume(BatteryVolume voiceBatteryVolume) {
            this.voiceBatteryVolume = voiceBatteryVolume;
            this.defaultMethod = voiceBatteryVolume;
        }
    }
    public class ScreenEquipment extends VoiceEquipment {
        BatteryVolume screenBatteryVolume;

        public ScreenEquipment() {

        }
        public void setScreenBatteryVolume(BatteryVolume screenBatteryVolume) {
            this.screenBatteryVolume - screenBatteryVolume;
        }
        public void setDefaultMethod(String functionType) {
            if(functionType.equalsIgnoreCase("Screen")) {
                super.defaultMethod = this.screenBatteryVolume;
            }else if(functionType.equalIgnoreCase("Voice")) {
                System.out.println();
                defaultMehod = this.voiceBatteryVolume;
            }
        }
    }
}