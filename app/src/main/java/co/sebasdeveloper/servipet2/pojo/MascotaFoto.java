package co.sebasdeveloper.servipet2.pojo;



public class MascotaFoto {

    private  Mascota mascota;
    private int idFoto;
    private int likes;

    public MascotaFoto(Mascota mascota, int idFoto, int likes) {
        this.mascota = mascota;
        this.idFoto = idFoto;
        this.likes = likes;
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
}
