package com.example.cachua.thuchanhso2.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cachua.thuchanhso2.MainActivity;
import com.example.cachua.thuchanhso2.Model.LoginModel;
import com.example.cachua.thuchanhso2.R;
import com.example.cachua.thuchanhso2.database.MyDataBaseHelper;

import java.util.ArrayList;

public class RegisterFragment extends BaseFragment {
    private EditText edtName;
    private EditText edtPassword;
    private Button btnLogin;
    private MyDataBaseHelper dataBaseHelper;


    @Override
    protected int getLayoutResource() {
        return (R.layout.fragment_register);
    }

    @Override
    protected void initVariables(Bundle savedInstanceState, View rootView) {
        edtName= rootView.findViewById(R.id.edtName);
        edtPassword= rootView.findViewById(R.id.edtPassword);
        btnLogin= rootView.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        dataBaseHelper= new MyDataBaseHelper(getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:{
                String name="";
                String pass="";
                int kt=1;
                name= edtName.getText().toString();
                pass= edtPassword.getText().toString();
                ArrayList<LoginModel> loginModelArrayList= new ArrayList<>();
                loginModelArrayList= dataBaseHelper.getAllLogin();
                for(int i=0;i<loginModelArrayList.size();i++){
                    if(name.equals(loginModelArrayList.get(i).getName())==true){
                        Toast.makeText(mContext, "Dang ki khong thanh cong", Toast.LENGTH_SHORT).show();
                        kt=0;
                        break;

                    }
                }
                if(kt==1){
                    dataBaseHelper.addTableAlarm(new LoginModel(name,pass));
                    Intent intent= new Intent(mContext, MainActivity.class);
                    Toast.makeText(mContext, "Dang ki thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

                break;
            }
        }

    }
}
