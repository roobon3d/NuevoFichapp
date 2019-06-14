package edu.cftic.fichapp.bean;

import java.util.List;

public class Programador  {

    private String imagen;
    private String nombre;
    private List<Social> social;

public Programador (String imagen, String nombre, List<Social> social){
    this.imagen = imagen;
    this.nombre = nombre;
    this.social = social;


}

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Social> getSocial() {
        return social;
    }

    public void setSocial(List<Social> social) {
        this.social = social;
    }
}
