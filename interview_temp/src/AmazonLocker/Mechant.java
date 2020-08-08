package AmazonLocker;

public class Mechant {
    // Merchant id
    final String mId;

    // Merchant add
    final String address;

    // Merchant Info
    final String mInfo;

    public Mechant(String mId, String address, String mInfo) {
        this.mId = mId;
        this.address = address;
        this.mInfo = mInfo;
    }

    public String getAddress() {
        return address;
    }

    public String getmId() {
        return mId;
    }

    public String getmInfo() {
        return mInfo;
    }
}
