import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // Aufgabe 1 : Bibliothek
        Bibliothek bibliothek = new Bibliothek();
        bibliothek.addBook("Clean Code", "Robert Martin", 45, 464);
        bibliothek.addBook("1984", "George Orwell", 18, 328);
        bibliothek.addBook("Animal Farm", "George Orwell", 12, 112);
        bibliothek.addBook("Java Basics", "Max Müller", 35, 520);
        bibliothek.addBook("The Hobbit", "J. R. R. Tolkien", 28, 310);



        System.out.println("Author: ");
        Scanner scanner = new Scanner(System.in);
        String author = scanner.nextLine();
        bibliothek.printBooksByAuthor(author);
        scanner.close();

        System.out.println("Enter books to calculate average page count (space-separated): ");
        String input = scanner.nextLine();
        String[] bookTitles = input.split(" ");
        ArrayList<String> bookList = new ArrayList<>();
        for (String title : bookTitles) {
            bookList.add(title);
        }
        System.out.println("Average page count: " + bibliothek.getAveragePageCount(bookList));


        System.out.println("Max price: ");
        int maxPrice = scanner.nextInt();
        bibliothek.printBooksWithinPriceLimit(maxPrice);

        bibliothek.printMostExpensiveBook();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter min nr of pages: ");
        int minPages = scanner2.nextInt();
        bibliothek.printBooksWithMinPages(minPages);
        scanner2.close();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Enter budget for 2 books: ");
        int budget = scanner3.nextInt();
        bibliothek.printBookPairsWithinBudget(budget);
        scanner3.close();

        
        
        

    }

}
