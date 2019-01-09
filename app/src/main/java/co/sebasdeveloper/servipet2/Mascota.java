package co.sebasdeveloper.servipet2;

import android.os.Parcel;
import android.os.Parcelable;

public class Mascota implements Parcelable {

    private int idImage;
    private String nombre;
    private int countLikes;

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
}
