package co.sebasdeveloper.servipet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MascotasLike extends AppCompatActivity {

    private ArrayList<Mascota> listMascotasLike;
    private RecyclerView mascotasLikeRecyclerView;
    private MascotasAdapter mascotasAdapter;
    private Toolbar toolbar;
    private TextView txvCountLikes;
    private TextView txvEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_like);
        Intent intent = getIntent();
        listMascotasLike = intent.getParcelableArrayListExtra(getResources().getString(R.string.pArrayListMascotasLike));
        mascotasLikeRecyclerView = (RecyclerView) findViewById(R.id.layRecycler_mascotasLikeList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mascotasLikeRecyclerView.setLayoutManager(linearLayoutManager);
        toolbar = (Toolbar)findViewById(R.id.layout_actionBar);
        txvCountLikes = (TextView) findViewById(R.id.actionbar_txv_countlikes);
        txvEmpty = (TextView) findViewById(R.id.layRecycler_txv_emptymessage);
        txvCountLikes.setVisibility(View.INVISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializarAdaptador();
        comprobarRecyclerView();
    }

    private void inicializarAdaptador(){
        mascotasAdapter = new MascotasAdapter(listMascotasLike,this);
        mascotasLikeRecyclerView.setAdapter(mascotasAdapter);
    }

    public void comprobarRecyclerView(){
        if(listMascotasLike.isEmpty()){
            mascotasLikeRecyclerView.setVisibility(View.GONE);
            txvEmpty.setVisibility(View.VISIBLE);
        }else {
            mascotasLikeRecyclerView.setVisibility(View.VISIBLE);
            txvEmpty.setVisibility(View.GONE);
        }
    }

}
