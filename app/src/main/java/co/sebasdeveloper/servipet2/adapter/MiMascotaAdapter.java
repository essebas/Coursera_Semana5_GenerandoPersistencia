package co.sebasdeveloper.servipet2.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.R;
import co.sebasdeveloper.servipet2.pojo.Mascota;
import co.sebasdeveloper.servipet2.pojo.MascotaFoto;

public class MiMascotaAdapter extends RecyclerView.Adapter<MiMascotaAdapter.MiMascota_ViewHolder> {

    private ArrayList<MascotaFoto> galeriaMascota;
    private Activity activity;

    public MiMascotaAdapter(Mascota mascota, Activity activity) {
        this.galeriaMascota = mascota.getGaleria();
        this.activity = activity;
    }

    @NonNull
    @Override
    public MiMascota_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mypet, viewGroup,false);
        return new MiMascota_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiMascota_ViewHolder miMascota_viewHolder, int i) {
        final MascotaFoto fotoExtraida = galeriaMascota.get(i);
        miMascota_viewHolder.imv_pet.setImageResource(fotoExtraida.getIdFoto());
        miMascota_viewHolder.txv_countLikes.setText(""+fotoExtraida.getLikes());
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return galeriaMascota.size();
    }

    public static class MiMascota_ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imv_pet;
        private TextView txv_countLikes;

        public MiMascota_ViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_pet = (ImageView) itemView.findViewById(R.id.cardview_imv_pet);
            txv_countLikes = (TextView) itemView.findViewById(R.id.cardview_txv_countLikes);
        }
    }

}
