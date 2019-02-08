package co.sebasdeveloper.servipet2.pojo;



public class MascotaFoto {

    private int idMascotaFoto;
    private int idMascota;
    private int idFoto;


    private  Mascota mascota;
    private int likes;

    public MascotaFoto(Mascota mascota, int idFoto, int likes) {
        this.mascota = mascota;
        this.idFoto = idFoto;
        this.likes = likes;
    }

    public MascotaFoto() {

    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getIdMascotaFoto() {
        return idMascotaFoto;
    }

    public void setIdMascotaFoto(int idMascotaFoto) {
        this.idMascotaFoto = idMascotaFoto;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
}
