package co.sebasdeveloper.servipet2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.Mascotas_ViewHolder>{

    private ArrayList<Mascota> mascotasLike;
    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotasAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
        this.mascotasLike = new ArrayList<>();
    }

    //Va a manejar la parte de darle vida a nuestro layout (cardview_contacto)
    @NonNull
    @Override
    public Mascotas_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Estamos asosiando el layout donde se encuentra el cardview a nuestro RecyclarView
        //Inflar el layout y lo pasara al viewholder para que el obtemga los views
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_pet, viewGroup, false);
        return new Mascotas_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Mascotas_ViewHolder mascotas_viewHolder, int i) {
        //Aqui es donde estaremos pasando cada parametro que contenga la lista de objetos de contacto a su determinado view del layout cardview_contact
        //Aqui es donde recorremos el array de objetos y vamos capturando uno por uno, para que todas las variables del objetos sean puestas en su respectivo view.
        final Mascota mascotaExtraida = mascotas.get(i);
        final TextView txvCountLikes = mascotas_viewHolder.txvCountLikes;
        mascotas_viewHolder.imvMascotaPicture.setImageResource(mascotaExtraida.getIdImage());
        mascotas_viewHolder.txvNombre.setText(mascotaExtraida.getNombre());
        txvCountLikes.setText(""+mascotaExtraida.getCountLikes());

        mascotas_viewHolder.imgBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mascotasLike.contains(mascotaExtraida)){
                    //Toast.makeText(activity, mascotaExtraida.getNombre() + " fue añadido a favoritos", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v,R.string.snackbar_favMessage, Snackbar.LENGTH_SHORT).show();
                    mascotaExtraida.simulacionLike();
                    //Esto solo hara una simulacion del cambio del texto del TextView para que se vea e like agregado.
                    txvCountLikes.setText(""+mascotaExtraida.getCountLikes());
                    mascotasLike.add(mascotaExtraida);
                    MainActivity.setCountLikes(mascotasLike.size(),mascotaExtraida);
                }else {
                    Toast.makeText(activity, "Ya te gusta " + mascotaExtraida.getNombre(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Cantidad de elementos que contiene mi lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public int getItemLikeCount(){
        return mascotasLike.size();
    }

    public static class Mascotas_ViewHolder extends RecyclerView.ViewHolder {
        // Clase para manejar la logica para darle vida a los views
        // Esta Clase manejara todos los elementos view que contenga el layout que vamos a reciclar, para este caso todos los elementos que conforman el CardView (cardview_pet).

        private ImageView imvMascotaPicture;
        private ImageButton imgBtnLike;
        private TextView txvNombre;
        private TextView txvCountLikes;
        private ImageView imvLikeIcon;

        public Mascotas_ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvMascotaPicture = (ImageView) itemView.findViewById(R.id.cardview_imv_pet);
            imgBtnLike = (ImageButton) itemView.findViewById(R.id.cardview_imgBtn_like);
            txvNombre = (TextView) itemView.findViewById(R.id.cardview_txv_name);
            txvCountLikes = (TextView) itemView.findViewById(R.id.cardview_txv_countLikes);
            imvLikeIcon = (ImageView) itemView.findViewById(R.id.cardview_imv_countLikes);
        }
    }

}
