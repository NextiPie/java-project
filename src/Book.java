public class Book {
    String title;
    Author author;
    boolean isAvaileble = true;

    Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " автор - " + author.name;
    }
}