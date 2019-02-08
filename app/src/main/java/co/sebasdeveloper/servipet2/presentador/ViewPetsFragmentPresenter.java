package co.sebasdeveloper.servipet2.presentador;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.db.ConstructorMascota;
import co.sebasdeveloper.servipet2.fragment.IViewPetsFragmentView;
import co.sebasdeveloper.servipet2.pojo.Mascota;


public class ViewPetsFragmentPresenter implements IViewPetsFragmentPresenter{

    private IViewPetsFragmentView iViewPetsFragmentView;
    private Context context;
    private Activity activity;
    private ArrayList<Mascota> listMascotas;
    private ConstructorMascota constructorMascota;

    public ViewPetsFragmentPresenter(IViewPetsFragmentView iViewPetsFragmentView, Context context, Activity activity) {
        this.iViewPetsFragmentView = iViewPetsFragmentView;
        this.context = context;
        this.activity = activity;
        obtenerMascotas();
    }


    @Override
    public void obtenerMascotas() {
        constructorMascota = new ConstructorMascota(context);
        listMascotas = constructorMascota.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iViewPetsFragmentView.inicializarAdaptador(iViewPetsFragmentView.crearAdaptador(listMascotas, activity));
        iViewPetsFragmentView.generarLayoutManager();
    }
}
