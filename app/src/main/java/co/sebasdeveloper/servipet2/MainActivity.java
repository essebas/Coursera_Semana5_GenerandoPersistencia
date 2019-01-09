package co.sebasdeveloper.servipet2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatActionCamera;
    private static ArrayList<Mascota> listMascotasLike;
    private ArrayList<Mascota> listaMAscotas;
    private Toolbar toolbar;
    private RecyclerView mascotasRecyclerView;
    private MascotasAdapter mascotasAdapter;
    private static TextView txvCountLikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.layout_actionBar);
        setSupportActionBar(toolbar);
        listMascotasLike = new ArrayList<>();
        mascotasRecyclerView = (RecyclerView) findViewById(R.id.layRecycler_mascotasList);
        txvCountLikes = (TextView)findViewById(R.id.actionbar_txv_countlikes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mascotasRecyclerView.setLayoutManager(linearLayoutManager);

        txvCountLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MascotasLike.class);
                i.putExtra(getResources().getString(R.string.pArrayListMascotasLike), listMascotasLike);
                startActivity(i);
            }
        });

        addFloatingButton();
        cargarLista();
        inicializarAdaptador();

    }

    public static void setCountLikes(int i, Mascota m){
        try {
            txvCountLikes.setText(""+i);
            listMascotasLike.add(m);
        }catch (Exception ex){
            Log.d("Exception", "" + ex.getMessage());
        }
    }

    private void inicializarAdaptador(){
        mascotasAdapter = new MascotasAdapter(listaMAscotas,this);
        mascotasRecyclerView.setAdapter(mascotasAdapter);
    }


    private void cargarLista(){
        listaMAscotas = new ArrayList<>();
        listaMAscotas.add(new Mascota(R.drawable.dog1,"Jeronimo"));
        listaMAscotas.add(new Mascota(R.drawable.dog2,"Max", 1));
        listaMAscotas.add(new Mascota(R.drawable.dog3,"Luna"));
        listaMAscotas.add(new Mascota(R.drawable.dog4,"Anais", 5));
        listaMAscotas.add(new Mascota(R.drawable.dog5,"Guffias"));
        listaMAscotas.add(new Mascota(R.drawable.dog6,"Tobie", 3));
        listaMAscotas.add(new Mascota(R.drawable.dog7,"Bella"));
        listaMAscotas.add(new Mascota(R.drawable.dog8,"Jacob", 16));
        listaMAscotas.add(new Mascota(R.drawable.dog9,"Estrella", 56));
        listaMAscotas.add(new Mascota(R.drawable.dog10,"Mat", 8));
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
}
