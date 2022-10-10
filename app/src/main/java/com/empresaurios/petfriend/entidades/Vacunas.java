package com.empresaurios.petfriend.entidades;

public class Vacunas {

    private String nombreVacuna;
    private String fechaVacuna;
    private String proxVacuna;
    private  int idMascota;

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(String fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public String getProxVacuna() {
        return proxVacuna;
    }

    public void setProxVacuna(String proxVacuna) {
        this.proxVacuna = proxVacuna;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }


}
