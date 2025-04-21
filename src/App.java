import java.util.*;

public class App {
    public static void main(String[] args) throws Exception{
        Author author = new Author("Толстой");
        Author author1 = new Author("Пушкин");

        Book book = new Book("Война и мир", author);
        Book book1 = new Book("Преступление и наказание", author, "1866");

        Reader reader = new Reader("Сергей");
        Reader reader1 = new Reader("Маша");

        Library library = new Library();

        library.registerReader("Сергей", 13);
        //library.registerReader("Маша", 14);

        library.addBook("Война и мир", author);
        //library.addBook("Преступление и наказание", author);

        //library.lendBook("Война и мир", "Сергей");
        //library.lendBook("Преступление и наказание", "Сергей");

        //library.returnBook("Война и мир", "Сергей");

        library.searchBook("Война и мир");
        library.searchBook(author1);

        //library.listBorrowedBooks("Сергей");

        //library.checkRemainingTime("Сергей");

        //library.popularityOfBook("Война и мир");
    }
}

