package Ejercicioo14;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class App {

    private JFrame frame;
    private Bienvenida bienvenida;
    private Pantalla1 pantalla1;
    private Pantalla2 pantalla2;
    private Pantalla3 pantalla3;
    private String texto;
    private boolean guardarTexto;
    private Map<String, Runnable> pantallasMap;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App window = new App();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    	e.printStackTrace();
                }
            }
        });
    }

    public App() {
        pantalla1 = new Pantalla1(this);
        pantalla2 = new Pantalla2(this);
        pantalla3 = new Pantalla3(this);
        pantallasMap = new HashMap<>();
        pantallasMap.put("Pantalla 1", this::lanzarPantalla1);
        pantallasMap.put("Pantalla 2", this::lanzarPantalla2);
        pantallasMap.put("Pantalla 3", this::lanzarPantalla3);
        bienvenida = new Bienvenida(this);

        guardarTexto = false; 


        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(bienvenida);
    }

    public void lanzarBienvenida() {
        frame.setContentPane(bienvenida);
        frame.revalidate();
    }

    public void lanzarPantalla1() {
        frame.setContentPane(pantalla1);
        pantalla1.cambiarTexto(getJTtexto());
        frame.revalidate();
    }

    public void lanzarPantalla2() {
        frame.setContentPane(pantalla2);
        pantalla2.cambiarTexto(getJTtexto());
        frame.revalidate();
    }

    public void lanzarPantalla3() {
        frame.setContentPane(pantalla3);
        pantalla3.cambiarTexto(getJTtexto());
        frame.revalidate();
    }

    public String getJTtexto() {
        return texto;
    }

    public void setJTtexto(String texto) {
        this.texto = texto;
    }

    public boolean getGuardarTexto() {
        return guardarTexto;
    }

    public void setGuardarTexto(boolean guardarTexto) {
        this.guardarTexto = guardarTexto;
    }

    public Map<String, Runnable> getPantallasMap() {
        return pantallasMap;
    }
}
