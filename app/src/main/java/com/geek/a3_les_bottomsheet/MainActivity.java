package com.geek.a3_les_bottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Button btnShowBottomSheet;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowBottomSheet = findViewById(R.id.btn_show_bottom_sheet);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        btnShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog();
                dialog.show(getSupportFragmentManager(), "BottomSheet");

            }
        });

        loadFragment(new HomeFragment());


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();


                switch (item.getItemId()){
                    case R.id.item_home:
                        manager.beginTransaction()
                                .replace(R.id.container_main, HomeFragment.newInstance("Value 1", "Value 2"))
                                .commit();
                        break;
                    case R.id.item_camera:

                        break;
                    case R.id.item_profile:
                        manager.beginTransaction()
                                .replace(R.id.container_main, ProfileFragment.newInstance("Value 1", "Value 2"))
                                .commit();
                        break;
                }
                return false;
            }
        });


    }
    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_main, fragment).commit();
            return true;
        }
        return false;
    }
}