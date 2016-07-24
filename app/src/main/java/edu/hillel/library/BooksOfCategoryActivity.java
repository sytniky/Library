package edu.hillel.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import edu.hillel.library.adapter.BookListAdapter;
import edu.hillel.library.model.Category;

public class BooksOfCategoryActivity
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    private DataManager mData = DataManager.getInstance();
    private ArrayAdapter mCategoryAdapter;
    private BookListAdapter mBookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_of_category);


        Spinner spCategory = (Spinner) findViewById(R.id.spCategory);
        spCategory.setOnItemSelectedListener(this);

        mCategoryAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                mData.getCategories()
        );
        spCategory.setAdapter(mCategoryAdapter);


        ListView lvBooks = (ListView) findViewById(R.id.lvBooks);
        lvBooks.setOnItemClickListener(this);

        mBookListAdapter = new BookListAdapter(this, mData);
        lvBooks.setAdapter(mBookListAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Category category = (Category) mCategoryAdapter.getItem(i);
        mBookListAdapter.filterByCategory(category);
        Toast.makeText(this, category.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        long bookId = mBookListAdapter.getItemId(i);
        Intent intent = new Intent(BookDescriptionActivity.ACTION);
        intent.putExtra(BookDescriptionActivity.BOOK_ID, bookId);
        startActivity(intent);
    }
}
