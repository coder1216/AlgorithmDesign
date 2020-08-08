package AmazonLocker;

public class Client {
    // id
    private final String clientID;

    // service
    private final AmazonLockerServer service;


    public Client(String clientID, AmazonLockerServer service) {
        this.clientID = clientID;
        this.service = service;
    }

    public AmazonLockerServer getService() {
        return service;
    }

    public String getClientID() {
        return clientID;
    }

    public boolean checkUserInfo(String id) {
        return id.equals(clientID);
    }

    public String recieveMessage() {
        return service.sendNotification(clientID);
    }
}
