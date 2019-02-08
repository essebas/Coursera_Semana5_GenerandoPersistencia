package co.sebasdeveloper.servipet2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import co.sebasdeveloper.servipet2.pojo.Mascota;
import co.sebasdeveloper.servipet2.pojo.MascotaFoto;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA
                + "("
                + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_NAME + " TEXT "
                + ")";

        String queryCrearTablaFoto = "CREATE TABLE " + ConstantesBaseDatos.DATABASE_TABLE_FOTO
                +"("
                + ConstantesBaseDatos.DATABASE_TABLE_FOTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID + " INTEGER, "
                + ConstantesBaseDatos.DATABASE_TABLE_FOTO_DIRFOTO + " INTEGER, "
                + " FOREIGN KEY (" + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID + ") "
                + " REFERENCES " + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA
                + "(" + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID + ")"
                +")";

        String queryCrearTablaLikeFoto = "CREATE TABLE " + ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO
                +"("
                + ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.DATABASE_TABLE_FOTO_ID + " INTEGER, "
                + ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO_NUMLIKES + " INTEGER, "
                + " FOREIGN KEY (" + ConstantesBaseDatos.DATABASE_TABLE_FOTO_ID + ") "
                + " REFERENCES " + ConstantesBaseDatos.DATABASE_TABLE_FOTO
                + "(" + ConstantesBaseDatos.DATABASE_TABLE_FOTO_ID + ")"
                +")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaFoto);
        db.execSQL(queryCrearTablaLikeFoto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.DATABASE_TABLE_FOTO);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO);
        onCreate(db);
    }

    //Consulta de mascotas
    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> listMascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA;
        //Ahora debemos abrir nuestra db, deberemos definir en que modo queremos abrirla, escritura o lectura.
        SQLiteDatabase db = this.getWritableDatabase();
        //Manejamos un rawQuery porque necesitamos que nos devuelva la coleccion de datos que encontro.
        //Primer parametro lleva el query, el segundo es si tenemos argumentos o si estamos haciendo algun filtro
        //La interfaz Cursor nos ayudara a recorer los registros, por ello necesitaremos una instancia de ella.
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascota = new Mascota();
            ArrayList<MascotaFoto> listMascotaFoto = new ArrayList<>();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));

            String queryFoto = "SELECT * FROM " + ConstantesBaseDatos.DATABASE_TABLE_FOTO
                    + " WHERE " + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID
                    + "=" + mascota.getId();

            Cursor registrosFotos = db.rawQuery(queryFoto, null);
            if(registrosFotos.moveToNext()){
                MascotaFoto mascotaFoto = new MascotaFoto();
                mascotaFoto.setIdMascotaFoto(registrosFotos.getInt(0));
                mascotaFoto.setIdMascota(registrosFotos.getInt(1));
                mascotaFoto.setMascota(mascota);
                mascotaFoto.setIdFoto(registrosFotos.getInt(2));
                listMascotaFoto.add(mascotaFoto);
            }else {
                //nothing
            }
            mascota.setGaleria(listMascotaFoto);
            listMascotas.add(mascota);
        }

        db.close();
        return listMascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.DATABASE_TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarFoto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.DATABASE_TABLE_FOTO, null, contentValues);
        db.close();
    }

    public void insertarLikeFoto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO, null, contentValues);
        db.close();
    }

    public ArrayList<Mascota> obtenerMascotasLikeadas(){
        ArrayList<Mascota> listMascotasLikeadas = new ArrayList<>();
        String query = "SELECT DISTINCT " + ConstantesBaseDatos.DATABASE_TABLE_FOTO_ID
                + " FROM " + ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO
                + " ORDER BY " + ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO_ID
                + " DESC LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            int idMascotaFoto = registros.getInt(0);
            Mascota mascota = new Mascota();
            //SELECT * FROM foto INNER JOIN mascota on mascota.id_mascota = foto.id_mascota WHERE id_foto = idMascotaFoto;
            String queryMascotaFoto = "SELECT * FROM " + ConstantesBaseDatos.DATABASE_TABLE_FOTO
                    + " INNER JOIN " + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA
                    +" on " + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA + "." + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID
                    + "=" + ConstantesBaseDatos.DATABASE_TABLE_FOTO + "." + ConstantesBaseDatos.DATABASE_TABLE_MASCOTA_ID
                    + " WHERE " + ConstantesBaseDatos.DATABASE_TABLE_FOTO_ID
                    + " = " + idMascotaFoto
                    ;
            Cursor registrosMascotaFoto = db.rawQuery(queryMascotaFoto, null);
            if (registrosMascotaFoto.moveToNext()){
                mascota.setId(registrosMascotaFoto.getInt(3));
                mascota.setNombre(registrosMascotaFoto.getString(4));
                MascotaFoto mascotaFoto  = new MascotaFoto();
                mascotaFoto.setIdMascotaFoto(registrosMascotaFoto.getInt(0));
                mascotaFoto.setIdMascota(registrosMascotaFoto.getInt(1));
                mascotaFoto.setIdFoto(registrosMascotaFoto.getInt(2));
                mascota.addFoto(mascotaFoto);
            }
            listMascotasLikeadas.add(mascota);
        }
        db.close();
        return listMascotasLikeadas;
    }

    public int obtenerLikeMascotaFoto(MascotaFoto mascotaFoto){
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO_NUMLIKES+")"
                + " FROM " + ConstantesBaseDatos.DATABASE_TABLE_LIKEFOTO
                + " WHERE " + ConstantesBaseDatos.DATABASE_TABLE_FOTO_ID
                + "=" + mascotaFoto.getIdMascotaFoto();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

}
