import java.util.*;

public class App {
    public static void main(String[] args) {
        Author author = new Author("Толстой");

        Book book = new Book("Война и мир", author);
        Book book1 = new Book("Преступление и наказание", author, "1866");

        Reader reader = new Reader("Сергей");

        Library library = new Library();
        library.registerReader("Сергей", 13);
        library.registerReader("Маша", 13);
        library.addBook("Война и мир", author);
        library.addBook("Преступление и наказание", author);
        library.lendBook("Война и мир", "Сергей");
        library.lendBook("Преступление и наказание", "Сергей");
        library.returnBook("Война и мир", "Сергей");
        library.searchBook("Война и мир");
        library.listBorrowedBooks("Сергей");
        java.time.LocalDate currentDate = java.time.LocalDate.now();
        System.out.println(currentDate);

    }
}

