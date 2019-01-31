package co.sebasdeveloper.servipet2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.R;
import co.sebasdeveloper.servipet2.adapter.MiMascotaAdapter;
import co.sebasdeveloper.servipet2.pojo.Mascota;
import co.sebasdeveloper.servipet2.pojo.MascotaFoto;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePetFragment extends Fragment {

    private MiMascotaAdapter miMascotaAdapter;
    private Mascota miMascota;
    private RecyclerView galeriaRecyclerView;


    public ProfilePetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_pet, container, false);
        galeriaRecyclerView = (RecyclerView) v.findViewById(R.id.layRecycler_miMascotaList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        galeriaRecyclerView.setLayoutManager(gridLayoutManager);
        cargarMascota();
        inicializarAdaptador();
        return v;
    }

    private void inicializarAdaptador(){
        miMascotaAdapter = new MiMascotaAdapter(miMascota,getActivity());
        galeriaRecyclerView.setAdapter(miMascotaAdapter);
    }

    public void cargarMascota(){
        ArrayList<MascotaFoto> galeria = new ArrayList<>();
        Mascota mascota = new Mascota("Stuart");
        galeria.add(new MascotaFoto(mascota, R.drawable.dog11, 40));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog12, 15));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog13, 80));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog11, 77));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog12, 66));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog13, 50));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog11, 32));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog12, 27));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog13, 165));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog11, 11));
        galeria.add(new MascotaFoto(mascota, R.drawable.dog12, 5));
        mascota.setGaleria(galeria);
        this.miMascota = mascota;
    }

}
