package LibraryMangement;

import java.util.Date;

public class BookItem extends Book{
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;
    public BookItem bookItem;

    public boolean checkout(String memberId) {

        if(bookItem.getIsReferenceOnly()) {
            ShowError("This book is Reference only and can't be issued");
            return false;
        }
        if(!BookLending.lendBook(this.getBarCode(), memberId)){
            return false;
        }
        this.updateBookItemStatus(BookStatus.LOANED);
        return true;
    }

    private String getBarCode() {
        return "";
    }

    private void updateBookItemStatus(BookStatus loaned) {
    }

    private void ShowError(String s) {
    }

    private boolean getIsReferenceOnly() {
        return false;
    }

    public String getBarcode() {
        return "";
    }
}

