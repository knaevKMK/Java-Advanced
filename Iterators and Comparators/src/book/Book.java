package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book<Book extends Comparable<Book>> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... author) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<String>();
        } else {
            this.authors = new ArrayList<String>(Arrays.asList(authors));
        }
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print
                .append("Tite: ").append(this.title).append(System.lineSeparator())
                .append("Year: ").append(this.year).append(System.lineSeparator())
                .append("Authors: ").append(this.authors.toString().replaceAll("[\\[\\]]", ""))
                .append(System.lineSeparator());
        return print.toString();
    }

    public int compareTo(book.Book book) {
        int result = this.getTitle().compareTo(book.getTitle());
        if (result == 0) {
            if (this.getYear() > book.getYear()) {
                return 1;
            }
            if (this.getYear() < book.getYear()) {
                return -1;
            }
        }
        return result;
    }
}
