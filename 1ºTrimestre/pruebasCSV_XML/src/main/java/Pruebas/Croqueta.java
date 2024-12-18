package Pruebas;

import java.util.List;


public class Croqueta {
    private Integer id;
    private String nombre;
    private String textura;
    private String tamaño;
    private List<Ingrediente> ingrediente;

    public Croqueta() {
    }


    public Croqueta(Integer id, String nombre, String textura, String tamaño) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.textura = textura;
        this.tamaño = tamaño;
    }


    public List<Ingrediente> getIngrediente() {
        return ingrediente;
    }


    public void setIngrediente(List<Ingrediente> ingrediente) {
        this.ingrediente = ingrediente;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTextura() {
        return textura;
    }
    public void setTextura(String textura) {
        this.textura = textura;
    }
    public String getTamaño() {
        return tamaño;
    }
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }


    @Override
    public String toString() {
        return "Croqueta [id=" + id + ", nombre=" + nombre + ", textura=" + textura + ", tamaño=" + tamaño
                + ", ingrediente=" + ingrediente + "]";
    }
}
