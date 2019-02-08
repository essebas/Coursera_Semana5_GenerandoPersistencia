package co.sebasdeveloper.servipet2.db;

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "servipet2db";
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_TABLE_MASCOTA = "mascota";
    public static final String DATABASE_TABLE_MASCOTA_ID = "id_mascota";
    public static final String DATABASE_TABLE_MASCOTA_NAME = "nombre";

    public static final String DATABASE_TABLE_FOTO = "foto";
    public static final String DATABASE_TABLE_FOTO_ID = "id_foto";
    public static final String DATABASE_TABLE_FOTO_IDMASCOTA = "id_mascota";
    public static final String DATABASE_TABLE_FOTO_DIRFOTO = "foto";

    public static final String DATABASE_TABLE_LIKEFOTO = "like_foto";
    public static final String DATABASE_TABLE_LIKEFOTO_ID = "id_likefoto";
    public static final String DATABASE_TABLE_LIKEFOTO_NUMLIKES = "numero_likes";
}
