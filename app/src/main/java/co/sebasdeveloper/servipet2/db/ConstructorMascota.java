package co.sebasdeveloper.servipet2.db;

import android.content.ContentValues;
import android.content.Context;
import android.widget.ListView;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.R;
import co.sebasdeveloper.servipet2.pojo.Mascota;
import co.sebasdeveloper.servipet2.pojo.MascotaFoto;

public class ConstructorMascota {

    private static final int LIKE = 1;
    private Context context;
    private ArrayList<Mascota> listMascota;

    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*listMascota = new ArrayList<>();
        listMascota.add(new Mascota(R.drawable.dog1,"Jeronimo"));
        listMascota.add(new Mascota(R.drawable.dog2,"Max", 1));
        listMascota.add(new Mascota(R.drawable.dog3,"Luna"));
        listMascota.add(new Mascota(R.drawable.dog4,"Anais", 5));
        listMascota.add(new Mascota(R.drawable.dog5,"Guffias"));
        listMascota.add(new Mascota(R.drawable.dog6,"Tobie", 3));
        listMascota.add(new Mascota(R.drawable.dog7,"Bella"));
        listMascota.add(new Mascota(R.drawable.dog8,"Jacob", 16));
        listMascota.add(new Mascota(R.drawable.dog9,"Estrella", 56));
        listMascota.add(new Mascota(R.drawable.dog10,"Mat", 8));*/
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerMascotas();
        //return listMascota;
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValuesMascota = new ContentValues();
        ContentValues contentValuesFoto = new ContentValues();
        ContentValues contentValuesLikeFoto = new ContentValues();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Jeronimo");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 1);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog1);
        db.insertarFoto(contentValuesFoto);



        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Max");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 2);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog2);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Luna");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 3);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog3);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Anais");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 4);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog4);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Guffias");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 5);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog5);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Tobie");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 6);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog6);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Bella");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 7);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog7);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Jacob");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 8);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog8);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Estrella");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 9);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog9);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        contentValuesMascota.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME,"Mat");
        db.insertarMascota(contentValuesMascota);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID, 10);
        contentValuesFoto.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO, R.drawable.dog10);
        db.insertarFoto(contentValuesFoto);
        contentValuesMascota.clear();
        contentValuesFoto.clear();

        db.close();
    }

    public void putLikeContacto(MascotaFoto fotoLikeada){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.DATABASE_TABLE_FOTO_ID, fotoLikeada.getIdMascotaFoto());
        contentValues.put(ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO_NUMLIKES, LIKE);
        db.insertarLikeFoto(contentValues);
    }

    public int getCountLikes(MascotaFoto mascotaFoto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikeMascotaFoto(mascotaFoto);
    }

    public ArrayList<Mascota> obtenerMAscotasLikeadas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasLikeadas();
    }

}
