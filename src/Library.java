import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Library {
    List<Book> books = new ArrayList<>();
    List<Reader> readers = new ArrayList<>();
    Map<Reader, List<Book>> loans = new HashMap<>();


    void registerReader(String name) {
        readers.add(new Reader(name));
        System.out.println("Читатель успешно зарегистрирован");
    }

    void addBook(String title, Author author) {
        books.add(new Book(title, author));
        System.out.println("Книга успешно добавлена");
    }

    void lendBook(String bookTitle, String nameReader) {
        for (Book book : books) {
            if (book.title.equals(bookTitle) && book.isAvaileble) {
                for (Reader reader : readers) {
                    if (reader.name.equals(nameReader)) {
                        book.isAvaileble = false;
                        reader.borrowedBooks.add(book);
                        loans.computeIfAbsent(reader, k -> new ArrayList<>()).add(book);
                        System.out.println("Книга: " + book.title + " выдана читателю: " + reader.name);
                        return;
                    }
                }
            }
        }
        System.out.println("Ошибка в названии книги или имени читателя");
    }

    void returnBook(String bookTitle, String nameReader) {
        for (Reader reader : readers) {
            if (reader.name.equals(nameReader)){
                for (Book book : books) {
                    if (book.title.equals(bookTitle)) {
                        book.isAvaileble = true;
                        loans.get(reader).remove(book);
                        System.out.println("Книга возвращена");
                    }
                }
            }
        }
    }

    void searchBook(String query) {
        for (Book book : books) {
            if (book.title.contains(query) || book.author.name.contains(query)) {
                System.out.println("Найдена книга: " + book.title + " " + book.author.name);
            } else {
                System.out.println("Книга не найдена");
            }
        }
    }

    void listBorrowedBooks(String nameReaders) {
        for (Reader reader : readers) {
            if (reader.name.equals(nameReaders)) {
                for (int i = 0; i  < reader.borrowedBooks.size(); i++) {
                    System.out.println(reader.borrowedBooks.get(i));
                }
            }
        }
    }

}