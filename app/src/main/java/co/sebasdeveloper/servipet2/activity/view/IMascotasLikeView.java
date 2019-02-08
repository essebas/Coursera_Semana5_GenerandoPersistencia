package co.sebasdeveloper.servipet2.activity.view;

import android.app.Activity;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.adapter.MascotasAdapter;
import co.sebasdeveloper.servipet2.pojo.Mascota;

public interface IMascotasLikeView {

    public void generarLayoutManager();

    public MascotasAdapter crearAdaptador(ArrayList<Mascota> listContactos, Activity activity);

    public void inicializarAdaptador(MascotasAdapter mascotaAdapter);

    public boolean isEmptyRV(ArrayList<Mascota> listMascotasLike);

}
