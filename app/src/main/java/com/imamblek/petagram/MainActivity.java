package com.imamblek.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.imamblek.petagram.adapter.PageAdapter;
import com.imamblek.petagram.vistafragment.PerfilFragment;
import com.imamblek.petagram.vistafragment.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public ImageButton btnEstrella;
    private  Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar miActionBarbtn = findViewById(R.id.miActionBarbtn);
        setSupportActionBar(miActionBarbtn);


        toolbar = (Toolbar)  findViewById(R.id.toolbar);
        tabLayout = (TabLayout)  findViewById(R.id.tabLayout);
        viewPager = (ViewPager)  findViewById(R.id.viewPager);
        setUpViewPager();

        btnEstrella = (ImageButton)  findViewById(R.id.btnEstrella);


        if ((toolbar != null)){
            setSupportActionBar(toolbar);
        }


        btnEstrella.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Top 5 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
                startActivity(intent);

            }
        });
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    // poner en orbita los fragments
    private void setUpViewPager(){
    viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
    tabLayout.setupWithViewPager(viewPager);

    tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_home);
    tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_perfil);
    }
    private void setSupportActionBar(Toolbar miActionBarbtn) {
    }


    //para llamar al menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }
    //para darle vida a los menus
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    switch (item.getItemId()){
        case R.id.mAbout:
            Intent intent = new Intent(this, ActivityAcercade.class);
            startActivity(intent);
            break;
        case R.id.mContacto:
            Intent i = new Intent(this, ActivityContacto.class);
            startActivity(i);
            break;
    }

        return super.onOptionsItemSelected(item);
    }
}