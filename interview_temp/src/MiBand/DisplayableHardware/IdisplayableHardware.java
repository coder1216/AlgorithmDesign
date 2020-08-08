package MiBand.DisplayableHardware;

import MiBand.NotSupportedException;

import java.util.Date;

public interface IdisplayableHardware {
    void displayNumber(final int batteryLife);

    String displayMessage(final String message) throws NotSupportedException;

    void displayTime(final Date date) throws NotSupportedException;

}
