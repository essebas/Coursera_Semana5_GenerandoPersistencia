package co.sebasdeveloper.servipet2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.adapter.MascotasAdapter;
import co.sebasdeveloper.servipet2.adapter.PageAdapter;
import co.sebasdeveloper.servipet2.fragment.ProfilePetFragment;
import co.sebasdeveloper.servipet2.fragment.ViewPetsFragment;
import co.sebasdeveloper.servipet2.pojo.Mascota;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatActionCamera;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.layout_actionBar);
        tabLayout = (TabLayout) findViewById(R.id.toolbar_tab1);
        viewPager = (ViewPager) findViewById(R.id.viewPager_general);
        setUpViewPager();
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        /*txvCountLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.class,MascotasLike.class);
                i.putExtra(getResources().getString(R.string.pArrayListMascotasLike), listMascotasLike);
                startActivity(i);
            }
        });*/

        addFloatingButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.mContext_contact:
                //Toast.makeText(this, "Abierto contacto", Toast.LENGTH_SHORT).show();
                i = new Intent(MainActivity.this, ContactForm.class);
                startActivity(i);
                break;
            case R.id.mContext_about:
                //Toast.makeText(this, "Abierto acerca de", Toast.LENGTH_SHORT).show();
                i = new Intent(MainActivity.this, AboutInfo.class);
                startActivity(i);
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    public void addFloatingButton(){
        floatActionCamera = (FloatingActionButton) findViewById(R.id.floatBtn_camera);
        floatActionCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Abriendo Camara...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ArrayList<Fragment> agragarFragments(){
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new ViewPetsFragment());
        fragmentArrayList.add(new ProfilePetFragment());
        return fragmentArrayList;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agragarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_doghouse);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dogprofile);
    }

}
