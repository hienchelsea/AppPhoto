package com.example.cachua.thuchanhso2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cachua.thuchanhso2.Fragment.BookFragment;
import com.example.cachua.thuchanhso2.Fragment.LoginFragment;
import com.example.cachua.thuchanhso2.Model.BookModel;
import com.example.cachua.thuchanhso2.database.MyDataBaseHelper;

public class MainActivity extends AppCompatActivity {
    private MyDataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelper= new MyDataBaseHelper(this);
        dataBaseHelper.addTableBook(new BookModel("Hien","Oc"));
        dataBaseHelper.addTableBook(new BookModel("Hien1","Oc2"));
        dataBaseHelper.addTableBook(new BookModel("Hien2","Oc3"));
        dataBaseHelper.addTableBook(new BookModel("Hien3","Oc4"));
        Fragment selectedFragment= BookFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.llMain, selectedFragment);
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
            if (fragmentBackStack instanceof BookFragment
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
