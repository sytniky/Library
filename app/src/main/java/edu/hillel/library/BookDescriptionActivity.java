package edu.hillel.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import edu.hillel.library.model.Book;

public class BookDescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACTION = "edu.hillel.library.action.BOOK_DESC";
    public static final String BOOK_ID = "bookId";
    public static final int AUTHOR_BOOKS_REQUEST_CODE = 1001;
    private long mBookId;
    private DataManager mData;
    ImageView mIvCover;
    TextView mTvName;
    TextView mTvAuthor;
    TextView mTvAnnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_description);

        mBookId = getIntent().getLongExtra(BOOK_ID, 1);
        mData = DataManager.getInstance();

        mIvCover = (ImageView) findViewById(R.id.ivCover);
        mTvName = (TextView) findViewById(R.id.tvName);
        mTvAuthor = (TextView) findViewById(R.id.tvAuthor);
        mTvAnnotation = (TextView) findViewById(R.id.tvAnnotation);

        setDesc(mBookId);

        mTvAuthor.setOnClickListener(this);
    }

    private void setDesc(long bookId) {
        Book book = mData.getBookById(bookId);
        mIvCover.setImageResource(book.getCoverId());
        mTvName.setText(book.getName());
        mTvAuthor.setText(mData.getAuthorByBookId(bookId).toString());
        mTvAnnotation.setText(book.getAnnotation());
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(AuthorBooksActivity.ACTION);
        intent.putExtra(AuthorBooksActivity.AUTHOR_ID, mData.getAuthorByBookId(mBookId).getId());
        intent.putExtra(AuthorBooksActivity.BOOK_ID, mBookId);
        startActivityForResult(intent, AUTHOR_BOOKS_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == AUTHOR_BOOKS_REQUEST_CODE) {
                Log.d("desc", String.valueOf(data.getLongExtra(BOOK_ID, 1)));
                setDesc(data.getLongExtra(BOOK_ID, 1));
            }
        } else {
            Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
        }
    }
}
