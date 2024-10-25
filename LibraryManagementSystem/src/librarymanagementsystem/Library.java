
package librarymanagementsystem;

import java.util.ArrayList;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Add a new member
    public void addMember(Member member) {
        members.add(member);
    }

    // Borrow a book
    public String borrowBook(String isbn, String memberId) {
        Book book = findBookByIsbn(isbn);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
            return "Book borrowed successfully.";
        } else {
            return "Book is not available.";
        }
    }

    // Return a book
    public String returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
            return "Book returned successfully.";
        } else {
            return "Book is not borrowed.";
        }
    }

    // Find a book by ISBN
    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // List all books
    public ArrayList<Book> listBooks() {
        return books;
    }

    // List borrowed books
    public ArrayList<Book> listBorrowedBooks() {
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isBorrowed()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    // List available (not borrowed) books
    public ArrayList<Book> listAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // Get the total number of books
    public int getTotalBooks() {
        return books.size();
    }
}
