package co.sebasdeveloper.servipet2.fragment;

import android.app.Activity;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.adapter.MascotasAdapter;
import co.sebasdeveloper.servipet2.pojo.Mascota;

public interface IViewPetsFragmentView {

    public void generarLayoutManager();

    public MascotasAdapter crearAdaptador(ArrayList<Mascota> listMascotas, Activity activity);

    public void inicializarAdaptador(MascotasAdapter mascotasAdapter);

}
