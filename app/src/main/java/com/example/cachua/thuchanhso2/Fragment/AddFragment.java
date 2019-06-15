package com.example.cachua.thuchanhso2.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cachua.thuchanhso2.Model.BookModel;
import com.example.cachua.thuchanhso2.R;
import com.example.cachua.thuchanhso2.database.MyDataBaseHelper;

import java.util.Objects;

public class AddFragment extends BaseFragment {
    EditText edtKind;
    EditText edtName;
    Button btnAdd;
    private MyDataBaseHelper dataBaseHelper;
    @Override
    protected int getLayoutResource() {
        return (R.layout.fragment_book_add);
    }

    @Override
    protected void initVariables(Bundle savedInstanceState, View rootView) {
        edtKind= rootView.findViewById(R.id.edtKind);
        edtName= rootView.findViewById(R.id.edtName);
        btnAdd= rootView.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        dataBaseHelper= new MyDataBaseHelper(mContext);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:{
                dataBaseHelper.addTableBook(new BookModel(edtName.getText().toString(),edtKind.getText().toString()));
                callBack.addBook(new BookModel(edtName.getText().toString(),edtKind.getText().toString()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            }
        }

    }
    public interface CallBack{
        void addBook(BookModel bookModel);
    }
    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
