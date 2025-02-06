import java.util.*;



class Author {
    String name;

    Author(String name) {
        this.name = name;
    }
}


class Reader {
    String name;
    List<Book> borrowedBooks = new ArrayList<>();

    Reader(String name) {
        this.name = name;
    }
}




public class App {
    public static void main(String[] args) {
        Author author = new Author("Толстой");

        Book book = new Book("Война и мир", author);
        Book book1 = new Book("Преступление и наказание", author);

        Reader reader = new Reader("Сергей");

        Library library = new Library();
        library.registerReader("Сергей");
        library.addBook("Война и мир", author);
        library.addBook("Преступление и наказание", author);
        library.lendBook("Война и мир", "Сергей");
        library.lendBook("Преступление и наказание", "Сергей");
        library.returnBook("Война и мир", "Сергей");
        library.searchBook("Война и мир");
        library.listBorrowedBooks("Сергей");

    }
}

