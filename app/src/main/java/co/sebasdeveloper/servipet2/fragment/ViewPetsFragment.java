package co.sebasdeveloper.servipet2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.MainActivity;
import co.sebasdeveloper.servipet2.MascotasLike;
import co.sebasdeveloper.servipet2.R;
import co.sebasdeveloper.servipet2.adapter.MascotasAdapter;
import co.sebasdeveloper.servipet2.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPetsFragment extends Fragment {

    private MascotasAdapter mascotasAdapter;
    private ArrayList<Mascota> listaMAscotas;
    private RecyclerView mascotasRecyclerView;
    private static ArrayList<Mascota> listMascotasLike;
    private static TextView txvCountLikes;

    public ViewPetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_pets, container, false);

        listMascotasLike = new ArrayList<>();
        mascotasRecyclerView = (RecyclerView) v.findViewById(R.id.layRecycler_mascotasList);
        txvCountLikes = (TextView) v.findViewById(R.id.actionbar_txv_countlikes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mascotasRecyclerView.setLayoutManager(linearLayoutManager);
        cargarLista();
        inicializarAdaptador();
        return v;
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
        mascotasAdapter = new MascotasAdapter(listaMAscotas,getActivity());
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

}
