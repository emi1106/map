import java.util.ArrayList;
import java.util.List;

public class Library {
    public static class Book {
        private final String title;
        private final String author;
        private final double price;
        private final int pageCount;

        public Book(String title, String author, double price, int pageCount) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.pageCount = pageCount;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public double getPrice() {
            return price;
        }

        public int getPageCount() {
            return pageCount;
        }

        @Override
        public String toString() {
            return title + " (" + price + " Euro)";
        }
    }

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public double getAveragePageCount(List<Book> books) {
        if (books.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Book book : books) {
            sum += book.getPageCount();
        }
        return (double) sum / books.size();
    }

    public List<Book> getBooksWithinPriceLimit(List<Book> books, double maxPrice) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPrice() <= maxPrice) {
                result.add(book);
            }
        }
        return result;
    }

    public Book getMostExpensiveBook(List<Book> books) {
        if (books.isEmpty()) {
            return null;
        }
        Book mostExpensive = books.get(0);
        for (Book book : books) {
            if (book.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = book;
            }
        }
        return mostExpensive;
    }

    public List<Book> getBooksWithMinPages(List<Book> books, int minPageCount) {
        ArrayList<Book> result = new ArrayList<>();
        if (books.isEmpty()) {
            return new ArrayList<>();
        }
        for (Book book : books) {
            if (book.getPageCount() >= minPageCount) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBestPairWithinBudget(List<Book> books, double budget) {
        ArrayList<Book> bestPair = new ArrayList<>();
        double bestPrice = 0;
        int bestPages = 0;
        for (int i = 0; i < books.size(); i++) {
            for (int j = i + 1; j < books.size(); j++) {
                double totalPrice = books.get(i).getPrice() + books.get(j).getPrice();
                int totalPages = books.get(i).getPageCount() + books.get(j).getPageCount();
                if (totalPrice > budget) {
                    continue;
                }
                boolean isBetter = bestPair.isEmpty()
                        || totalPrice > bestPrice
                        || (totalPrice == bestPrice && totalPages > bestPages);
                if (isBetter) {
                    bestPrice = totalPrice;
                    bestPages = totalPages;
                    bestPair.clear();
                    bestPair.add(books.get(i));
                    bestPair.add(books.get(j));
                }
            }
        }
        return bestPair;
    }
}
