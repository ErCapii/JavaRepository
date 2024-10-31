package Ejercicioo14;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Bienvenida extends JPanel {

    private static final long serialVersionUID = 1L;
    private App app;
    private JCheckBox checkbtGuardarTexto;

    /**
     * Create the panel.
     */
    public Bienvenida(App app) {
        this.app = app;
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Bienvenido a mi aplicación");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        lblNewLabel.setBounds(10, 11, 430, 94);
        add(lblNewLabel);

        Map<String, Runnable> pantallasMap = app.getPantallasMap();
        String[] pantallas = pantallasMap.keySet().toArray(new String[0]);

        JComboBox<String> cbPantallas = new JComboBox<>(pantallas);
        cbPantallas.setPreferredSize(new Dimension(100, 20));
        cbPantallas.setBounds(129, 121, 150, 22);
        add(cbPantallas);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pantallaSeleccionada = cbPantallas.getSelectedItem().toString();
                pantallasMap.get(pantallaSeleccionada).run(); 
            }
        });
        btnEntrar.setBounds(155, 154, 89, 23);
        add(btnEntrar);

        checkbtGuardarTexto = new JCheckBox("Guardar Texto");
        checkbtGuardarTexto.setBounds(155, 184, 150, 23);
        add(checkbtGuardarTexto);
        checkbtGuardarTexto.setSelected(app.getGuardarTexto());

        checkbtGuardarTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.setGuardarTexto(checkbtGuardarTexto.isSelected());
            }
        });
    }
}
