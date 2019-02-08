package co.sebasdeveloper.servipet2.presentador;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.activity.view.IMascotasLikeView;
import co.sebasdeveloper.servipet2.db.ConstructorMascota;
import co.sebasdeveloper.servipet2.pojo.Mascota;

public class MascotasLikePresenter implements IMascotasLikePresenter {

    private IMascotasLikeView iMascotasLikeView;
    private Context context;
    private Activity activity;
    private ArrayList<Mascota> listMascota;
    private ConstructorMascota constructorMascota;

    public MascotasLikePresenter(IMascotasLikeView iMascotasLikeView, Context context, Activity activity) {
        this.iMascotasLikeView = iMascotasLikeView;
        this.context = context;
        this.activity = activity;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascota = new ConstructorMascota(context);
        listMascota = constructorMascota.obtenerMAscotasLikeadas();
        if(!iMascotasLikeView.isEmptyRV(listMascota)){
            mostrarMascotasRV();
        }
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasLikeView.inicializarAdaptador(iMascotasLikeView.crearAdaptador(listMascota, activity));
        iMascotasLikeView.generarLayoutManager();
    }
}
