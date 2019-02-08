package co.sebasdeveloper.servipet2.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mascota implements Parcelable {

    private int id;
    private String nombre;

    private int idImage;
    private int countLikes;

    //Actualizacion con la clase MascotaFoto
    private ArrayList<MascotaFoto> galeria;

    public Mascota(String nombre) {
        this.nombre = nombre;
    }
    //Actualizacion con la clase MascotaFoto

    public Mascota(int idImage, String nombre, int countLikes) {
        this.idImage = idImage;
        this.nombre = nombre;
        this.countLikes = countLikes;
    }

    public Mascota(int idImage, String nombre) {
        this.idImage = idImage;
        this.nombre = nombre;
        this.countLikes = 0;
    }


    protected Mascota(Parcel in) {
        idImage = in.readInt();
        nombre = in.readString();
        countLikes = in.readInt();
    }

    public Mascota() {
        this.galeria = new ArrayList<>();
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public ArrayList<MascotaFoto> getGaleria() {
        return galeria;
    }

    public void setGaleria(ArrayList<MascotaFoto> galeria) {
        this.galeria = galeria;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(int countLikes) {
        this.countLikes = countLikes;
    }

    public void simulacionLike(){
        this.countLikes = this.countLikes + 1 ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idImage);
        dest.writeString(nombre);
        dest.writeInt(countLikes);
    }

    public void addFoto(MascotaFoto mascotaFoto){
        galeria.add(mascotaFoto);
    }

}
