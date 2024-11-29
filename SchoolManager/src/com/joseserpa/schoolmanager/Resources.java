package com.joseserpa.schoolmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.JButton;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author joses
 */

public class Resources {

    // Elementos compartidos
    public static final Image LOGO = new ImageIcon("/images/LogoLenisremovebg.png").getImage();
    public static final ImageIcon LOGO_LENIS = new ImageIcon(Resources.class.getResource("/images/LogoLenisremovebg.png"));
    public static final JLabel LOGO_LENIS_LABEL = new JLabel("Texto del JLabel con logo");

    private static List<ImageIcon> imagenes;
    private static int indiceActual;

    static {
        // Ruta de las imágenes
        String[] nombresImagenes = {"/images/principal1(recortada).jpg", "/images/principal2(recortada).jpg", "/images/principal3(recortada).jpg"};
        imagenes = new ArrayList<>();

        for (String nombre : nombresImagenes) {
            ImageIcon imagen = new ImageIcon(Resources.class.getResource(nombre));
            imagenes.add(imagen);
        }
    }

    public static ImageIcon obtenerSiguienteImagen() {
        if (imagenes.isEmpty()) {
            return null;  // No hay imágenes para mostrar
        }

        // Obtener la siguiente imagen
        ImageIcon siguienteImagen = imagenes.get(indiceActual);

        // Incrementar el índice para la próxima imagen
        indiceActual = (indiceActual + 1) % imagenes.size();

        return siguienteImagen;
    }

    static {
        // Configurar propiedades del JLabel, por ejemplo, agregar el icono
        LOGO_LENIS_LABEL.setIcon(LOGO_LENIS);
        LOGO_LENIS_LABEL.setBounds(25, 50, 270, 280);
    }

    // Método para crear un botón redondeado configurado
    public static RoundButton crearBoton(String texto, ActionListener actionListener) {
        RoundButton boton = new RoundButton(texto);
        configurarBoton(boton);
        boton.addActionListener(actionListener);
        return boton;
    }

    // Método para crear un botón de inicio de sesión configurado
    public static RoundButton crearBoton(String texto, int x, int y, int width, int height, ActionListener actionListener) {
        RoundButton boton = new RoundButton(texto);
        configurarBoton(boton);
        boton.setBounds(x, y, width, height);
        boton.addActionListener(actionListener);
        return boton;
    }

    // Método privado para configurar la apariencia común de los botones
    private static void configurarBoton(RoundButton boton) {
        boton.setBackground(new Color(242, 175, 14));
        boton.setFont(new Font("Arial", Font.BOLD, 20));
        boton.setForeground(Color.WHITE);
    }

    // Label estructura General
    public static JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, width, height);
        return label;
    }

    // Label estructura Inicio de Sesión
    public static JLabel createLabel_Inicio_Sesion(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", 2, 30));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, width, height);
        return label;
    }

    // JMenu Estructura General
    public static JMenu menu(String texto, JMenuBar menubar) {
        JMenu menu = new JMenu(texto);
        menu.setForeground(Color.WHITE);
        menu.setFont(new Font("Arial", Font.BOLD, 15));
        menubar.add(menu);
        return menu;
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new Welcome();
            new Profile();
            new Login();
            new Main();
            new Complaints();
        });
    }
}
