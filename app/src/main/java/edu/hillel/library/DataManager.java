package edu.hillel.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.hillel.library.model.Author;
import edu.hillel.library.model.Book;
import edu.hillel.library.model.Category;

/**
 * Created by yuriy on 22.07.16.
 */
public class DataManager {

    private static DataManager instance;

    private List<Category> mCategories;
    private Map<Long, List<Book>> mCategoryBooks;
    private Map<Long, Book> mBooks;
    private Map<Long, Author> mBookAuthor;
    private Map<Long, List<Book>> mAuthorBooks;

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    private DataManager() {
        initData();
    }

    public List<Category> getCategories() {
        return mCategories;
    }

    public Map<Long, List<Book>> getCategoryBooks() {
        return mCategoryBooks;
    }

    public Author getAuthorByBookId(long bookId) {
        return mBookAuthor.get(bookId);
    }

    public Book getBookById(long bookId) {
        return mBooks.get(bookId);
    }

    public List<Book> getBooksByAuthorId(long authorId) {
        return mAuthorBooks.get(authorId);
    }

    private void initData() {
        Category category1 = new Category(1, "Programming");
        Category category2 = new Category(2, "Detective");
        Category category3 = new Category(3, "Novel");
        Category category4 = new Category(4, "Fantastic");

        Author author1 = new Author(1, "Bruce", "Eckel");
        Author author2 = new Author(2, "Eric", "Freeman");
        Author author3 = new Author(3, "Arthur", "Conan Doyle");

        Book book1 = new Book(1, R.drawable.ic_thincking_in_java, "Thinking in Java", "Thinking in Java should be read cover to cover by every Java programmer, then kept close at hand for frequent reference. The exercises are challenging, and the chapter on Collections is superb! Not only did this book help me to pass the Sun Certified Java Programmer exam; it’s also the first book I turn to whenever I have a Java question.");
        Book book2 = new Book(2, R.drawable.ic_head_first_design_patterns, "Head First Design Patterns", "At any given moment, somewhere in the world someone struggles with the same software design problems you have. You know you don't want to reinvent the wheel (or worse, a flat tire), so you look to Design Patterns--the lessons learned by those who've faced the same problems. With Design Patterns, you get to take advantage of the best practices and experience of others, so that you can spend your time on...something else. Something more challenging. Something more complex. Something more fun.");
        Book book3 = new Book(3, R.drawable.ic_the_new_annotated_sherlock_holmes, "The Adventures of Sherlock Holmes", "Collects two volumes of Doyle's short stories starring Sherlock Holmes, each of which is annotated to provide definitions and further explanations of Sherlock's theories, as well as literary and cultural details about Victorian society.");
        Book book4 = new Book(4, R.drawable.ic_thinking_in_c_plus_plus, "Thinking in C++", "In the first edition ofThinking in C++, Bruce Eckel synthesized years of C++ teaching and programming experience into a beautifully structured course in making the most of the language. The book became an instant classic, winning the 1995Software Development Jolt ColaAward for best book of the year. Now, inThinking in C++, Volume I, Second Edition, Eckel has thoroughly rewritten his masterpiece to reflect all the changes introduced in C++ by the final ANSI/ISO C++ standard. Every page has been revisited and rethought, with many new examples and exercises throughout -- all with a single goal: to help you understand C++ \"down to the bare metal,\" so you can solve virtually any development problem you encounter. Eckel begins with a detailed look at objects and their rationale, then shows how C++ programs can be constructed from off-the-shelf object libraries. This edition includes a new, chapter-length overview of the C features that are used in C++ -- plus a new CD-ROM containing an outstanding C seminar that covers all the foundations developers need before they can truly take advantage of C++. Eckel next introduces key object-oriented techniques such as data abstraction and implementation hiding. He then walks through initialization and cleanup; function overloading and default arguments; constants; inline functions; name control; references and the copy constructor; operator overloading; and more. There are chapters on dynamic object creation; inheritance and composition; polymorphism and virtual functions, and templates. (Bonus coverage of string, templates, and the Standard Template Library, can be found at Eckel's web site.) Every chapter contains many modular, to-the-point examples, plus exercises based on Eckel's extensive experience teaching C++ seminars. Put simply, Eckel has made an outstanding book on C++ even better. For all C++ programmers, and for programmers experienced in other languages who want to strengthen their C++ and object development skills.");
        Book book5 = new Book(5, R.drawable.ic_mastering_python_design_patterns, "Mastering Python Design Patterns", "This book is for Python programmers with an intermediate background and an interest in design patterns implemented in idiomatic Python.");

        mCategories = new ArrayList<>();
        mCategories.add(category1);
        mCategories.add(category2);
        mCategories.add(category3);
        mCategories.add(category4);

        mCategoryBooks = new HashMap<>();
        mCategoryBooks.put(category1.getId(), Arrays.asList(book1, book2, book4, book5));
        mCategoryBooks.put(category2.getId(), Arrays.asList(book3));

        mBooks = new HashMap<>();
        mBooks.put(book1.getId(), book1);
        mBooks.put(book2.getId(), book2);
        mBooks.put(book3.getId(), book3);
        mBooks.put(book4.getId(), book4);
        mBooks.put(book5.getId(), book5);

        mBookAuthor = new HashMap<>();
        mBookAuthor.put(book1.getId(), author1);
        mBookAuthor.put(book2.getId(), author2);
        mBookAuthor.put(book3.getId(), author3);
        mBookAuthor.put(book4.getId(), author1);
        mBookAuthor.put(book5.getId(), author1);

        mAuthorBooks = new HashMap<>();
        mAuthorBooks.put(author1.getId(), Arrays.asList(book1, book4, book5));
        mAuthorBooks.put(author2.getId(), Arrays.asList(book2));
        mAuthorBooks.put(author3.getId(), Arrays.asList(book3));
    }
}

