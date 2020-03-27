package ubb.jorge.fastfoodapp;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Sandwiches {
    private String nombre;
    private String precio;
    private String descripcion;
    private Drawable nombre_archivo;

    public Sandwiches(String nombre, String descripcion, String precio, Drawable nombre_archivo) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre_archivo = nombre_archivo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Drawable getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(Drawable nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }
}
