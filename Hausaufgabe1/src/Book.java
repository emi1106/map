public class Book {
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
