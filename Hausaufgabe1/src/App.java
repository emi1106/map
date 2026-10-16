import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Library.Book("Clean Code", "Robert Martin", 45, 464));
        library.addBook(new Library.Book("1984", "George Orwell", 18, 328));
        library.addBook(new Library.Book("Animal Farm", "George Orwell", 12, 112));
        library.addBook(new Library.Book("Java Basics", "Max Müller", 35, 520));
        library.addBook(new Library.Book("The Hobbit", "J. R. R. Tolkien", 28, 310));
        
        List<Library.Book> books = library.getBooks();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Author: ");
            String author = scanner.nextLine();
            List<Library.Book> booksByAuthor = library.getBooksByAuthor(author);
            if (booksByAuthor.isEmpty()) {
                System.out.println("No books found for this author.");
            }
            for (Library.Book book : booksByAuthor) {
                System.out.println(book.getTitle());
            }


            System.out.println("Titles of books for avg page count: ");
            String[] titles = scanner.nextLine().split(",");
            ArrayList<Library.Book> selectedBooks = new ArrayList<>();
            for (String title : titles) {
                for (Library.Book book : books) {
                    if (book.getTitle().equals(title.trim())) {
                        selectedBooks.add(book);
                        break;
                    }
                }
            }
            System.out.println("Average page count: " + library.getAveragePageCount(selectedBooks));

            
            System.out.println("Max price: ");
            double maxPrice = scanner.nextDouble();
            for (Library.Book book : library.getBooksWithinPriceLimit(books, maxPrice)) {
                System.out.println(book.getTitle() + " -> " + book.getPrice() + " Euro");
            }

            System.out.println("Books for most expensive: ");
            String [] titlesForMostExpensive = scanner.nextLine().split(",");
            ArrayList<Library.Book> selectedBooksForMostExpensive = new ArrayList<>();
            for (String title : titlesForMostExpensive) {
                for (Library.Book book : books) {
                    if (book.getTitle().equals(title.trim())) {
                        selectedBooksForMostExpensive.add(book);
                        break;
                    }
                }
            }
            Library.Book mostExpensiveBook = library.getMostExpensiveBook(selectedBooksForMostExpensive);
            if (mostExpensiveBook != null) {
                System.out.println("Most expensive book: " + mostExpensiveBook.getTitle() + "(" + mostExpensiveBook.getPrice() + ") Euro");
            } else {
                System.out.println("No books found.");
            }

            System.out.println("Min number of pages: ");
            int minPageCount = scanner.nextInt();
            for (Library.Book book : library.getBooksWithMinPages(books, minPageCount)) {
                System.out.println(book.getTitle());
            }

            System.out.println("Budget for 2 books: ");
            double budget = scanner.nextDouble();
            List<Library.Book> bestPair = library.findBestPairWithinBudget(books, budget);
            if (bestPair.isEmpty()) {
                System.out.println("No two books fit within the budget.");
            } else {
                System.out.println(bestPair.get(0).getTitle() + " + " + bestPair.get(1).getTitle());
                System.out.println("Total price: " + (bestPair.get(0).getPrice() + bestPair.get(1).getPrice()) + " Euro");
            }
            scanner.close();
        }
    }   
