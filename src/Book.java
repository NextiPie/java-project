public class Book {
    String title;
    Author author;
    String dateOfPublication;
    int numberOfIssues;
    boolean isAvaileble = true;

    Book(String title, Author author) {
        this.title = title;
        this.author = author;
        this.dateOfPublication = "Дата издания неизвестна";
        this.numberOfIssues = 0;
    }

    Book(String title, Author author, String dateOfPublication) {
        this.title = title;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
        this.numberOfIssues = 0;
    }

    @Override
    public String toString() {
        return title + " автор - " + author.name;
    }

}