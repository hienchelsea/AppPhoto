package com.example.cachua.thuchanhso2.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cachua.thuchanhso2.LoginActivity;
import com.example.cachua.thuchanhso2.MainActivity;
import com.example.cachua.thuchanhso2.Model.LoginModel;
import com.example.cachua.thuchanhso2.R;
import com.example.cachua.thuchanhso2.database.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.Objects;

public class LoginFragment extends BaseFragment {
    private EditText edtName;
    private EditText edtPassword;
    private TextView tvRegistration;
    private Button btnLogin;
    private MyDataBaseHelper dataBaseHelper;


    public static LoginFragment sInstance;
    public static LoginFragment newInstance() {
        if (sInstance == null) {
            sInstance = new LoginFragment();
        }
        return sInstance;
    }
    @Override
    protected int getLayoutResource() {
        return (R.layout.fragment_login);
    }

    @Override
    protected void initVariables(Bundle savedInstanceState, View rootView) {
        edtName= rootView.findViewById(R.id.edtName);
        edtPassword= rootView.findViewById(R.id.edtPassword);
        btnLogin= rootView.findViewById(R.id.btnLogin);
        tvRegistration= rootView.findViewById(R.id.tvRegistration);

        btnLogin.setOnClickListener(this);
        tvRegistration.setOnClickListener(this);

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
                name= edtName.getText().toString();
                pass= edtPassword.getText().toString();
                ArrayList<LoginModel> loginModelArrayList= new ArrayList<>();
                loginModelArrayList= dataBaseHelper.getAllLogin();
                for(int i=0;i<loginModelArrayList.size();i++){
                    if(name.equals(loginModelArrayList.get(i).getName())==true&&(pass.equals(loginModelArrayList.get(i).getPassword())==true)){
                        Toast.makeText(mContext, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(mContext, MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                }

                break;
            }
            case R.id.tvRegistration:{
                Toast.makeText(mContext, "hien", Toast.LENGTH_SHORT).show();
                RegisterFragment registerFragment= new RegisterFragment();
                ((LoginActivity) Objects.requireNonNull(getActivity())).nextFragment(registerFragment, R.id.llTab, 0, 0, 0, 0);
                break;
            }
        }

    }
}
