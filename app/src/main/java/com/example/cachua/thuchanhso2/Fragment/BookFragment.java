package com.example.cachua.thuchanhso2.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.cachua.thuchanhso2.BookAdapter;
import com.example.cachua.thuchanhso2.LoginActivity;
import com.example.cachua.thuchanhso2.MainActivity;
import com.example.cachua.thuchanhso2.Model.BookModel;
import com.example.cachua.thuchanhso2.R;
import com.example.cachua.thuchanhso2.database.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.Objects;

public class BookFragment extends BaseFragment {
    private RecyclerView rcBook;
    private ImageView imvAdd;
    ArrayList<BookModel> bookFragmentArrayList= new ArrayList<>();
    BookAdapter bookAdapter;
    MyDataBaseHelper dataBaseHelper;

    public static BookFragment sInstance;
    public static BookFragment newInstance() {
        if (sInstance == null) {
            sInstance = new BookFragment();
        }
        return sInstance;
    }
    @Override
    protected int getLayoutResource() {
        return (R.layout.fragment_book);
    }

    @Override
    protected void initVariables(Bundle savedInstanceState, View rootView) {
        rcBook= rootView.findViewById(R.id.rcBook);
        imvAdd= rootView.findViewById(R.id.imvAdd);

        imvAdd.setOnClickListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        dataBaseHelper= new MyDataBaseHelper(mContext);
        bookFragmentArrayList= dataBaseHelper.getAllBook();
        bookAdapter= new BookAdapter(bookFragmentArrayList,mContext);
        rcBook.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        rcBook.setAdapter(bookAdapter);






    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imvAdd:{
                AddFragment addFragment= new AddFragment();
                ((MainActivity) Objects.requireNonNull(getActivity())).nextFragment(addFragment, R.id.llMain, 0, 0, 0, 0);
                addFragment.setCallBack(new AddFragment.CallBack() {
                    @Override
                    public void addBook(BookModel bookModel) {
                        bookFragmentArrayList= dataBaseHelper.getAllBook();
                        bookAdapter= new BookAdapter(bookFragmentArrayList,mContext);
                        rcBook.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                        rcBook.setAdapter(bookAdapter);
                    }
                });
                break;
            }
        }
    }


}
