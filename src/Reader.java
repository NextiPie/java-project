import java.util.ArrayList;
import java.util.List;

class Reader {
    String name;
    int id;
    List<Book> borrowedBooks = new ArrayList<>();

    Reader(String name) {
        this.name = name;
    }
}