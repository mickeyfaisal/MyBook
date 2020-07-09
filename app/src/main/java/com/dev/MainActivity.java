package com.dev;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ViewPager view_pager;
    Spinner spinner;
    String[] string_array = {"Choose a page number", "Welcome Page", "Page number 1", "Page number 2", "The End"};
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        view_pager = findViewById(R.id.view_pager);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        setViewPager();
        setSpinnerAdapter();
    }

    private void setViewPager() {
        view_pager.setRotationY(180);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getFragmentList());
        view_pager.setAdapter(adapter);
    }

    private List<Fragment> getFragmentList() {
        List<Fragment> list = new ArrayList<>();
        list.add(new WelcomeFragment());
        list.add(new PageNoOne());
        list.add(new PageNoTwo());
        list.add(new TheEnd());
        return list;
    }

    private void setSpinnerAdapter() {
        List<String> list = new ArrayList<>(Arrays.asList(string_array));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.include_spinner_custom_layout, R.id.text_view, list) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 1) {
            view_pager.setCurrentItem(0);
            return;
        } else if (position == 2) {
            view_pager.setCurrentItem(1);
            return;
        } else if (position == 3) {
            view_pager.setCurrentItem(2);
            return;
        } else if (position == 4){
            view_pager.setCurrentItem(3);
            return;
        }
    }

    @Override
    public void onBackPressed() {
        spinner.setSelection(1);
        view_pager.setCurrentItem(0);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}