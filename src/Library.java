import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

class Library{
    List<Book> books = new ArrayList<>();
    List<Reader> readers = new ArrayList<>();
    Map<Reader, List<Book>> loans = new HashMap<>();
    List<Integer> ides = new ArrayList<>();



    //Регистрация новых читателей с уникальным идентификатором
    void registerReader(String name, int idReaderForRegister) {
        readers.add(new Reader(name));
        try(FileWriter writer = new FileWriter("readers.txt", false)) {
            writer.write(name);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
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
        try(FileWriter writer = new FileWriter("books.txt", true)) {
            writer.write(title);
            writer.write("\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Книга успешно добавлена");
    }

    //Выдача книг читателям
    void lendBook(String bookTitle, String nameReader) {
        boolean found = false;
        for (Book book : books) {
            if (book.title.equals(bookTitle) && book.isAvaileble) {
                for (Reader reader : readers) {
                    if (reader.name.equals(nameReader)) {
                        book.isAvaileble = false;
                        reader.borrowedBooks.add(book);
                        book.numberOfIssues += 1;
                        reader.setDateOfIssue(java.time.LocalDate.now());
                        loans.computeIfAbsent(reader, k -> new ArrayList<>()).add(book);
                        found = true;
                        System.out.println("Книга " + "'" + book.title + "'" + " выдана читателю: " + reader.name + " | " + reader.getDateOfIssue());
                    }
                }
            }
        }
        try {
            if (!found) throw new Exception("Ошибка в названии книги или имени читателя");
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Возврат книг
    void returnBook(String bookTitle, String nameReader) {
        boolean found = false;
        for (Reader reader : readers) {
            if (reader.name.equals(nameReader)){
                for (Book book : books) {
                    if (book.title.equals(bookTitle)) {
                        book.isAvaileble = true;
                        loans.get(reader).remove(book);
                        System.out.println("Книга возвращена");
                        found = true;
                    }
                }
            }
        }
        try {
            if (!found) throw new Exception("Ошибка в названии книги или в имени читателя");
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Поиск книг по названию
    void searchBook(String titleBook) {
        boolean found = false;
        for (Book book : books) {
            if (book.title.contains(titleBook) || book.author.name.contains(titleBook)) {
                System.out.println("Найдена книга: " + book.title + " " + book.author.name);
                found = true;

            }
            try {
                if (!found) throw new Exception("Книга не найдена");
            }
            catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Поиск по автору
    void searchBook(Author authorName){
        boolean found = false;
        for (Book book: books) {
            if (book.author.equals(authorName)){
                System.out.println("Найден автор: " + book.author + " " + book.title);
                found = true;
            }
        }
        try {
            if (!found) throw new Exception("Книга по автору не найдена");
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }




    //Список взятых книг у конкретного читателя
    void listBorrowedBooks(String nameReaders) {
        boolean found = false;
        for (Reader reader : readers) {
            if (reader.name.equals(nameReaders)) {
                for (int i = 0; i  < reader.borrowedBooks.size(); i++) {
                    System.out.println(reader.borrowedBooks.get(i));
                    found = true;
                }
            }
        }
        try {
            if (!found) throw new Exception("Такой читатель не найден или имя введено неверно");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
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


    //Популярность книги
    void popularityOfBook(String titleBook) {
        boolean found = false;
        for (Book book : books ) {
            if (book.title.equals(titleBook)) {
                System.out.println(book.title + " брали " + book.numberOfIssues + " раз");
                found = true;
            }
        }
        try {
            if (!found) throw new Exception("Неверное название книги");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }



}