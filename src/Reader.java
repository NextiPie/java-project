import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Reader {
    String name;
    int id;
    LocalDate dateOfIssue;
    List<Book> borrowedBooks = new ArrayList<>();

    Reader(String name) {
        this.name = name;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public static LocalDate calculateReturnDate(LocalDate issueDate) {
        return issueDate.plusDays(14);
    }
}