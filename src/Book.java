public class Book {
    String title;
    Author author;
    String dateOfPublication;
    boolean isAvaileble = true;

    Book(String title, Author author) {
        this.title = title;
        this.author = author;
        this.dateOfPublication = "Дата издания неизвестна";
    }

    Book(String title, Author author, String dateOfPublication) {
        this.title = title;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    public String toString() {
        return title + " автор - " + author.name;
    }
}