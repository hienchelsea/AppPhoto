package com.example.cachua.thuchanhso2;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import com.example.cachua.thuchanhso2.Model.BookModel;


import java.util.ArrayList;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> implements  View.OnClickListener {
    private ArrayList<BookModel>bookModelArrayList;
    private Context mContext;
    int position;

    public BookAdapter(ArrayList<BookModel> bookModelArrayList, Context mContext) {
        this.bookModelArrayList = bookModelArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        View view= layoutInflater.inflate(R.layout.layout_adapter_home_highlight,viewGroup,false);
        BookAdapter.ViewHolder viewHolder = new BookAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        position=i;
        BookModel bookModel= bookModelArrayList.get(i);
        viewHolder.tvName.setText(bookModel.getNameBook());
        viewHolder.tvKind.setText(bookModel.getKindBook());
        viewHolder.imvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(mContext,viewHolder.imvMenu);
                popupMenu.inflate(R.menu.menu_book);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menu_delete:{
                                Toast.makeText(mContext, "xoa", Toast.LENGTH_SHORT).show();
                                return true;
                            }
                            case R.id.menu_Update:{
                                Toast.makeText(mContext, "sua", Toast.LENGTH_SHORT).show();
                                return true;
                            }
                            default:
                                return false;
                        }


                    }
                });
                popupMenu.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return bookModelArrayList.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {


    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvKind;
        private ImageView imvMenu;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvKind=itemView.findViewById(R.id.tvKind);
            imvMenu=itemView.findViewById(R.id.imvMenu);
        }
    }


}
