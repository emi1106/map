import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert Martin", 45, 464));
        library.addBook(new Book("1984", "George Orwell", 18, 328));
        library.addBook(new Book("Animal Farm", "George Orwell", 12, 112));
        library.addBook(new Book("Java Basics", "Max Müller", 35, 520));
        library.addBook(new Book("The Hobbit", "J. R. R. Tolkien", 28, 310));

        List<Book> books = library.getBooks();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Author: ");
        String author = scanner.nextLine();
        List<Book> booksByAuthor = library.getBooksByAuthor(author);
        if (booksByAuthor.isEmpty()) {
            System.out.println("No books found for this author.");
        }
        for (Book book : booksByAuthor) {
            System.out.println(book.getTitle());
        }

        System.out.println("Titles of books for avg page count: ");
        List<Book> booksForAverage = library.findBooksByTitles(scanner.nextLine());
        System.out.printf("Average page count: %.2f%n", library.getAveragePageCount(booksForAverage));

        System.out.println("Max price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());
        for (Book book : library.getBooksWithinPriceLimit(books, maxPrice)) {
            System.out.println(book.getTitle() + " -> " + book.getPrice() + " Euro");
        }

        System.out.println("Titles of books for most expensive: ");
        List<Book> booksForMostExpensive = library.findBooksByTitles(scanner.nextLine());
        Book mostExpensiveBook = library.getMostExpensiveBook(booksForMostExpensive);
        if (mostExpensiveBook != null) {
            System.out.println("Most expensive book: " + mostExpensiveBook);
        } else {
            System.out.println("No books found.");
        }

        System.out.println("Min number of pages: ");
        int minPageCount = Integer.parseInt(scanner.nextLine());
        for (Book book : library.getBooksWithMinPages(books, minPageCount)) {
            System.out.println(book.getTitle());
        }

        System.out.println("Budget for 2 books: ");
        double budget = Double.parseDouble(scanner.nextLine());
        List<Book> bestPair = library.findBestPairWithinBudget(books, budget);
        if (bestPair.isEmpty()) {
            System.out.println("No two books fit within the budget.");
        } else {
            System.out.println(bestPair.get(0).getTitle() + " + " + bestPair.get(1).getTitle());
            System.out.println("Total price: " + (bestPair.get(0).getPrice() + bestPair.get(1).getPrice()) + " Euro");
        }
        scanner.close();
    }
}
