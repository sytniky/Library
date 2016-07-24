package edu.hillel.library;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.hillel.library.model.Book;

public class AuthorBooksActivity extends ListActivity {

    public static final String ACTION = "edu.hillel.library.action.AUTHOR_BOOKS";
    public static final String AUTHOR_ID = "authorId";
    public static final String BOOK_ID = "bookId";
    private Long mAuthorId;
    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_books);

        mAuthorId = getIntent().getLongExtra(AUTHOR_ID, 1);
        DataManager mData = DataManager.getInstance();

        mAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mData.getBooksByAuthorId(mAuthorId)
        );
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent();
        Book book = (Book) mAdapter.getItem(position);
        intent.putExtra(BookDescriptionActivity.BOOK_ID, book.getId());
        setResult(RESULT_OK, intent);
        finish();
    }
}
