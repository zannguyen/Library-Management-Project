
package librarymanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryManagementGUI {
    private Library library;

    public LibraryManagementGUI() {
        library = new Library();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Create buttons
        JButton addBookButton = new JButton("Add Book");
        JButton addMemberButton = new JButton("Add Member");
        JButton borrowBookButton = new JButton("Borrow Book");
        JButton returnBookButton = new JButton("Return Book");
        JButton listBooksButton = new JButton("List All Books");
        JButton listBorrowedBooksButton = new JButton("List Borrowed Books");
        JButton listAvailableBooksButton = new JButton("List Available Books");
        JButton totalBooksButton = new JButton("Total Books");

        // Panel
        JPanel panel = new JPanel();
        panel.add(addBookButton);
        panel.add(addMemberButton);
        panel.add(borrowBookButton);
        panel.add(returnBookButton);
        panel.add(listBooksButton);
        panel.add(listBorrowedBooksButton);
        panel.add(listAvailableBooksButton);
        panel.add(totalBooksButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        // Button actions
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter Book Title:");
                String author = JOptionPane.showInputDialog("Enter Book Author:");
                String isbn = JOptionPane.showInputDialog("Enter Book ISBN:");
                library.addBook(new Book(title, author, isbn));
                JOptionPane.showMessageDialog(frame, "Book added successfully.");
            }
        });

        addMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter Member Name:");
                String memberId = JOptionPane.showInputDialog("Enter Member ID:");
                library.addMember(new Member(name, memberId));
                JOptionPane.showMessageDialog(frame, "Member added successfully.");
            }
        });

        borrowBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog("Enter Book ISBN to Borrow:");
                String memberId = JOptionPane.showInputDialog("Enter Member ID:");
                String message = library.borrowBook(isbn, memberId);
                JOptionPane.showMessageDialog(frame, message);
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog("Enter Book ISBN to Return:");
                String message = library.returnBook(isbn);
                JOptionPane.showMessageDialog(frame, message);
            }
        });

        listBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Book> books = library.listBooks();
                StringBuilder message = new StringBuilder("Books in the Library:\n");
                for (Book book : books) {
                    message.append(book.getTitle()).append(" by ").append(book.getAuthor()).append(" (ISBN: ").append(book.getIsbn()).append(")\n");
                }
                JOptionPane.showMessageDialog(frame, message.toString());
            }
        });

        listBorrowedBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Book> borrowedBooks = library.listBorrowedBooks();
                StringBuilder message = new StringBuilder("Borrowed Books:\n");
                for (Book book : borrowedBooks) {
                    message.append(book.getTitle()).append(" by ").append(book.getAuthor()).append(" (ISBN: ").append(book.getIsbn()).append(")\n");
                }
                JOptionPane.showMessageDialog(frame, message.toString());
            }
        });

        listAvailableBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Book> availableBooks = library.listAvailableBooks();
                StringBuilder message = new StringBuilder("Available Books:\n");
                for (Book book : availableBooks) {
                    message.append(book.getTitle()).append(" by ").append(book.getAuthor()).append(" (ISBN: ").append(book.getIsbn()).append(")\n");
                }
                JOptionPane.showMessageDialog(frame, message.toString());
            }
        });

        totalBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalBooks = library.getTotalBooks();
                JOptionPane.showMessageDialog(frame, "Total books in the library: " + totalBooks);
            }
        });
    }

    public static void main(String[] args) {
        new LibraryManagementGUI();
    }
}
