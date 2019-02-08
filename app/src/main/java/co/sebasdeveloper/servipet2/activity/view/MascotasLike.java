package co.sebasdeveloper.servipet2.activity.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.R;
import co.sebasdeveloper.servipet2.adapter.MascotasAdapter;
import co.sebasdeveloper.servipet2.pojo.Mascota;
import co.sebasdeveloper.servipet2.presentador.IMascotasLikePresenter;
import co.sebasdeveloper.servipet2.presentador.MascotasLikePresenter;

public class MascotasLike extends AppCompatActivity implements IMascotasLikeView {

    //private ArrayList<Mascota> listMascotasLike;
    private RecyclerView mascotasLikeRecyclerView;
    private MascotasAdapter mascotasAdapter;
    private Toolbar toolbar;
    private TextView txvCountLikes;
    private TextView txvEmpty;
    private IMascotasLikePresenter iMascotasLikePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_like);
        Intent intent = getIntent();
        //listMascotasLike            = intent.getParcelableArrayListExtra(getResources().getString(R.string.pArrayListMascotasLike));
        mascotasLikeRecyclerView    = (RecyclerView) findViewById(R.id.layRecycler_mascotasLikeList);
        toolbar                     = (Toolbar)findViewById(R.id.layout_actionBar);
        txvEmpty                    = (TextView) findViewById(R.id.layRecycler_txv_emptymessage);
        //txvCountLikes = (TextView) findViewById(R.id.actionbar_txv_countlikes);
        //txvCountLikes.setVisibility(View.INVISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iMascotasLikePresenter = new MascotasLikePresenter(this, this.getApplicationContext(), this);
    }

    private void inicializarAdaptador(){

        mascotasLikeRecyclerView.setAdapter(mascotasAdapter);
    }


    @Override
    public void generarLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mascotasLikeRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotasAdapter crearAdaptador(ArrayList<Mascota> listMascotasLike, Activity activity) {
        if(listMascotasLike.isEmpty()){
            Log.w("Lista Adaptador", "Esta vacio");
        }else {
            Log.w("Lista Adaptador", "Esta lleno con" + listMascotasLike.get(0).getNombre());
        }
        mascotasAdapter = new MascotasAdapter(listMascotasLike,this);
        return mascotasAdapter;
    }

    @Override
    public void inicializarAdaptador(MascotasAdapter mascotaAdapter) {
        mascotasLikeRecyclerView.setAdapter(mascotaAdapter);
    }


    @Override
    public boolean isEmptyRV(ArrayList<Mascota> listMascotasLike) {
        if(listMascotasLike.isEmpty()){
            mascotasLikeRecyclerView.setVisibility(View.GONE);
            txvEmpty.setVisibility(View.VISIBLE);
            return true;
        }else {
            mascotasLikeRecyclerView.setVisibility(View.VISIBLE);
            txvEmpty.setVisibility(View.GONE);
            return false;
        }
    }
}
