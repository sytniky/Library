package edu.hillel.library.adapter;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import edu.hillel.library.DataManager;
import edu.hillel.library.R;
import edu.hillel.library.model.Book;
import edu.hillel.library.model.Category;

/**
 * Created by yuriy on 23.07.16.
 */
public class BookListAdapter extends BaseAdapter {

    private DataManager mData;
    private List<Book> mFilteredBooks;
    private LayoutInflater mInflater;

    public BookListAdapter(Context c, DataManager data) {
        this.mData = data;
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        filterByCategory(null);
    }

    @Override
    public int getCount() {
        return mFilteredBooks.size();
    }

    @Override
    public Book getItem(int i) {
        return mFilteredBooks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ItemViewHolder vh;

        if (view == null) {
            view = mInflater.inflate(R.layout.book_list_item, viewGroup, false);
            vh = new ItemViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ItemViewHolder) view.getTag();
        }

        Book book = getItem(i);
        vh.setData(book);
        return view;
    }

    public void filterByCategory(Category category) {

        Map<Long, List<Book>> categoryBooks = mData.getCategoryBooks();
        mFilteredBooks = new ArrayList<>();

        if (category == null) {
            for (List<Book> books : categoryBooks.values()) {
                if (books.size() > 0) {
                    mFilteredBooks.addAll(books);
                }
            }
        } else {
            List<Book> books = categoryBooks.get(category.getId());
            if (books != null) {
                mFilteredBooks = books;
            }
            notifyDataSetChanged();
        }
    }

    private class ItemViewHolder {

        private ImageView ivCover;
        private TextView tvName;
        private TextView tvAuthor;

        ItemViewHolder(View view) {
            ivCover = (ImageView) view.findViewById(R.id.ivCover);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
        }

        void setData(Book book) {
            ivCover.setImageResource(book.getCoverId());
            tvName.setText(book.getName());
            tvAuthor.setText(mData.getAuthorByBookId(book.getId()).toString());
        }
    }
}
