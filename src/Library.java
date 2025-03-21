import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Library {
    List<Book> books = new ArrayList<>();
    List<Reader> readers = new ArrayList<>();
    Map<Reader, List<Book>> loans = new HashMap<>();
    List<Integer> ides = new ArrayList<>();

    //Регистрация новых читателей с уникальным идентификатором
    void registerReader(String name, int idReaderForRegister) {
        readers.add(new Reader(name));
        if (ides.contains(idReaderForRegister)) {
            System.out.println("Читатель с таким id уже зарегистрирован");
        } else {
            ides.add(idReaderForRegister);
            for (Reader reader : readers) {
                if (reader.id == idReaderForRegister) {
                    reader.id = idReaderForRegister;
                }
            }
            System.out.println("Читатель успешно зарегистрирован с id: " + idReaderForRegister);
        }
    }

    //Добавление новой книги в библиотеку
    void addBook(String title, Author author) {
        books.add(new Book(title, author));
        System.out.println("Книга успешно добавлена");
    }

    //Выдача книг читателям
    void lendBook(String bookTitle, String nameReader) {
        for (Book book : books) {
            if (book.title.equals(bookTitle) && book.isAvaileble) {
                for (Reader reader : readers) {
                    if (reader.name.equals(nameReader)) {
                        book.isAvaileble = false;
                        reader.borrowedBooks.add(book);
                        book.numberOfIssues += 1;
                        reader.setDateOfIssue(java.time.LocalDate.now());
                        loans.computeIfAbsent(reader, k -> new ArrayList<>()).add(book);
                        System.out.println("Книга " + "'" + book.title + "'" + " выдана читателю: " + reader.name + " | " + reader.getDateOfIssue());
                        return;
                    }
                }
            }
        }
        System.out.println("Ошибка в названии книги или имени читателя");
    }

    //Возврат книг
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

    //Поиск книг по названию
    void searchBook(String titleBook) {
        for (Book book : books) {
            if (book.title.contains(titleBook) || book.author.name.contains(titleBook)) {
                System.out.println("Найдена книга: " + book.title + " " + book.author.name);
            }
        }
    }

    // Поиск по автору
    void searchBook(Author authorName) {
        for (Book book: books) {
            if (book.author.equals(authorName)) {
                System.out.println("Найден автор: " + book.author + " " + book.title);
            }
        }
    }




    //Список взятых книг у конкретного читателя
    void listBorrowedBooks(String nameReaders) {
        for (Reader reader : readers) {
            if (reader.name.equals(nameReaders)) {
                for (int i = 0; i  < reader.borrowedBooks.size(); i++) {
                    System.out.println(reader.borrowedBooks.get(i));
                }
            }
        }
    }

    //Просмотр оставшегося времени до возврата
    void checkRemainingTime(String nameReader) {
        for (Reader reader : readers) {
            if (reader.name.equals(nameReader)) {
                System.out.println("Читатель: " + reader.name + " взял книгу " + reader.getDateOfIssue() + " и должен вернуть ее до " + reader.calculateReturnDate(reader.getDateOfIssue()));
            }
        }
    }



    void popularityOfBook(String titleBook) {
        for (Book book : books ) {
            if (book.title.equals(titleBook)) {
                System.out.println(book.title + " брали " + book.numberOfIssues + " раз");
            }
        }
    }



}