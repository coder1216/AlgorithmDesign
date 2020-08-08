package MiBand;

import MiBand.DisplayableHardware.*;

import java.util.HashMap;
import java.util.Map;

public class MiBandV3 extends MiBand{
    //Option 1
    private final Screen screen;

    //Option 2
    private final Map<DisplayOption, IdisplayableHardware> hardwareMap;

    public MiBandV3(String id) {
        super(id);
        //Option 1
        screen = new Screen("SC-123");

        //Option 2
        hardwareMap = new HashMap<>();
        initHardware();
    }

    private void initHardware() {
        hardwareMap.put(DisplayOption.LED_ARRAY,new LEDArray("LA-123"));
        hardwareMap.put(DisplayOption.SCREEN, new Screen("SC-123"));
        hardwareMap.put(DisplayOption.VOICE, new Speaker("SP-123"));
    }

    //Option 1 - Limited options
    @Override
    public void displayBatteryLife() {
        screen.displayNumber(getBatteryLife());
    }

    @Override
    public void displayBatteryLife(final DisplayOption displayOption) {
        displayNumber(getBatteryLife(), displayOption);
    }

    //Re-usability
    private void displayNumber(final int num, final DisplayOption displayOption) {
        final IdisplayableHardware hardware = hardwareMap.get(displayOption);

        if(hardware != null) {
            hardware.displayNumber(num);
        } else {
            System.out.println(String.format("Error, %s is not supported for this device", displayOption.toString()));
        }
    }

}
