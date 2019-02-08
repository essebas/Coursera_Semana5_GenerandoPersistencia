package co.sebasdeveloper.servipet2.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.R;
import co.sebasdeveloper.servipet2.adapter.MascotasAdapter;
import co.sebasdeveloper.servipet2.pojo.Mascota;
import co.sebasdeveloper.servipet2.presentador.IViewPetsFragmentPresenter;
import co.sebasdeveloper.servipet2.presentador.ViewPetsFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPetsFragment extends Fragment implements IViewPetsFragmentView{

    private MascotasAdapter mascotasAdapter;
    private ArrayList<Mascota> listaMAscotas;
    private RecyclerView mascotasRecyclerView;
    private View v;
    private IViewPetsFragmentPresenter iViewPetsFragmentPresenter;
    private static ArrayList<Mascota> listMascotasLike;
    private static TextView txvCountLikes;

    public ViewPetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_view_pets, container, false);
        listMascotasLike = new ArrayList<>();
        mascotasRecyclerView = (RecyclerView) v.findViewById(R.id.layRecycler_mascotasList);
        txvCountLikes = (TextView) v.findViewById(R.id.actionbar_txv_countlikes);
        //Este objeto de tipo Interfaz Presenter es instanciado por su determinada clase Peesenter, al ser instanciada es cuando
        //llama a todos los metodos para que los datos sean traidos.
        iViewPetsFragmentPresenter = new ViewPetsFragmentPresenter(this, getContext(), getActivity());
        return v;
    }

    /*public static void setCountLikes(int i, Mascota m){
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
    }*/


    @Override
    public void generarLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mascotasRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotasAdapter crearAdaptador(ArrayList<Mascota> listMascotas, Activity activity) {
        mascotasAdapter = new MascotasAdapter(listMascotas, activity);
        return mascotasAdapter;
    }

    @Override
    public void inicializarAdaptador(MascotasAdapter mascotasAdapter) {
        mascotasRecyclerView.setAdapter(mascotasAdapter);
    }
}
