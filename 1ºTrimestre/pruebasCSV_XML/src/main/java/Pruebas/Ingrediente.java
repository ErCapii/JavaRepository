package Pruebas;

public class Ingrediente {
    private Integer cantidad;
    private String tipo;

    public Ingrediente() {
    }

    public Ingrediente(Integer cantidad, String tipo) {
        super();
        this.cantidad = cantidad;
        this.tipo = tipo;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Ingrediente [cantidad=" + cantidad + ", tipo=" + tipo + "]";
    }

}
