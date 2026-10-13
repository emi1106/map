import java.util.ArrayList;
import java.util.Scanner;

public class Bibliothek {
    public ArrayList<Book> books = new ArrayList<Book>();
    public class Book {
        public String title;
        public String author;
        public int price;
        public int pageCount;
    }
    public void addBook(String title, String author, int price, int pageCount) {
        Book book = new Book();
        book.title = title;
        book.author = author;
        book.price = price;
        book.pageCount = pageCount;
        books.add(book);
    }
    public void printBooksByAuthor(String author) {
    }
    public float getAveragePageCount(ArrayList<String> bookTitles) {
        return 0;
    }
    public void printBooksWithinPriceLimit(int maxPrice) {
    }
    public void printMostExpensiveBook() {
    }
    public void printBooksWithMinPages(int minPageCount) {
    }
    public void printBookPairsWithinBudget(int budget) {
    }
}
