package com.example.cachua.thuchanhso2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cachua.thuchanhso2.Fragment.LoginFragment;
import com.example.cachua.thuchanhso2.Fragment.RegisterFragment;
import com.example.cachua.thuchanhso2.Model.LoginModel;
import com.example.cachua.thuchanhso2.database.MyDataBaseHelper;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private MyDataBaseHelper dataBaseHelper;
    private LinearLayout llTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        llTab= findViewById(R.id.llTab);
        dataBaseHelper= new MyDataBaseHelper(this);
        dataBaseHelper.addTableAlarm(new LoginModel("HienDo","12345678"));
        Fragment selectedFragment= LoginFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.llTab, selectedFragment);
        transaction.commit();




    }
    public void nextFragment(Fragment fragment, int id, int anim1, int anim2, int anim3, int anim4) {
        String backStateName = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(anim1, anim2, anim3, anim4);
        transaction.replace(id, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
        try {
            Fragment fragmentBackStack = getSupportFragmentManager().findFragmentById(R.id.llTab);
            if (fragmentBackStack instanceof LoginFragment
//                    || fragmentBackStack instanceof TipsFragment
                    ) {
                getSupportFragmentManager().popBackStack(fragmentBackStack.getClass().getName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            } else {
                super.onBackPressed();
            }
        } catch (Exception e) {
            super.onBackPressed();
            System.exit(0);
        }
    }
}
