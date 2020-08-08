package LibraryMangement;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public static BookReservation fetchReservationDetails(String barcode) {
        return null;
    }

    public boolean getMemberId() {
        return false;
    }

    public void updateStatus(ReservationStatus completed) {
    }
}

