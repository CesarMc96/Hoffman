package Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame {
    
    private final JButton btnArchivo;
    private final JButton btnComprimir;
    private final JButton btnDescomprimir;
    private final JPanel pnlArriba;
    private final JLabel lblArchivo;
    private final JLabel lblNombreArchivo;
    private final JPanel pnlAA;
    private final JPanel pnlAB;
    private final JPanel pnlAbajo;
    
    public Ventana() {
        super.setSize(420, 150);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setTitle("Huffman");
        super.getContentPane().setBackground(Color.WHITE);

        //*************************************
        
        btnArchivo = new JButton("Seleccionar Archivo.");
        lblArchivo = new JLabel("Nombre: ");
        lblNombreArchivo = new JLabel();
        
        pnlArriba = new JPanel();
        pnlArriba.setLayout(new BorderLayout());
        pnlAA = new JPanel();
        pnlAB = new JPanel();
        pnlAA.setBackground(Color.WHITE);
        pnlAB.setBackground(Color.WHITE);
        pnlAB.add(btnArchivo);
        pnlAA.add(lblArchivo);
        pnlAA.add(lblNombreArchivo);
        pnlArriba.add(pnlAA, BorderLayout.PAGE_START);
        pnlArriba.add(pnlAB, BorderLayout.PAGE_END);
        
        btnArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fc = new JFileChooser();
                int seleccion = fc.showOpenDialog(fc);
                
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    //Seleccionamos el fichero
                    File fichero = fc.getSelectedFile();

                    //Escribe el nombre del fichero
                    lblNombreArchivo.setText(fichero.getName());
                }
            }
        });

        //*************************************
        
        btnComprimir = new JButton("Comprimir");
        btnDescomprimir = new JButton("Descomprimir");
        
        pnlAbajo = new JPanel();
        pnlAbajo.setBackground(Color.WHITE);
        pnlAbajo.add(btnComprimir);
        pnlAbajo.add(btnDescomprimir);
        
        super.add(pnlArriba, BorderLayout.PAGE_START);
        super.add(pnlAbajo, BorderLayout.PAGE_END);
        super.setVisible(true);
    }
    
}
