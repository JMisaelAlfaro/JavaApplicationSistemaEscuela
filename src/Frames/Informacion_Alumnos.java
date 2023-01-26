
package Frames;

import Clases.Conectar;
import static Frames.Gestion_Alumnos.idAlumno;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author misa_
 */
public class Informacion_Alumnos extends javax.swing.JFrame {
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    int idAlumno=0;
    
    public static int idCalificacion=0;
    
    
    /**
     * Creates new form Informacion_Alumnos
     */
    public Informacion_Alumnos() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        //cerrar();
        
        txtNombre.setEditable(false);
        txtApelldios.setEditable(false);
        txtTelefono.setEditable(false);
        txtCalificacion.setEditable(false);
        txtEstatus.setEditable(false);
        cmbGrado.setEnabled(false);
        
        idAlumno = Gestion_Alumnos.idAlumno;
        
        try {
            
            Connection cn = con.getConexion();
            var ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno='"+idAlumno+"'");
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                setTitle("Información de Alumno "+ rs.getString("nombre"));
                lblinfo_Alumno.setText("Informacion del Alumno: "+ rs.getString("nombre"));
                
                txtNombre.setText(rs.getString("nombre"));
                txtApelldios.setText(rs.getString("apellido"));
                cmbGrado.setSelectedItem(rs.getString("grado"));
                txtTelefono.setText(rs.getString("telefono"));
             
            }
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar Alumno... Contacte al Administrador");
        }
            
        /////////////////////////////////////////////////////
        
        try {
            var pst = cn.prepareStatement(
            "SELECT id_nota,tarea,calificacion FROM notas WHERE id_alumno_nota='"+idAlumno+"'");
            
            ResultSet rs=pst.executeQuery();
            
            tablaCalificaciones = new JTable(modelo);
            jScrollPane1.setViewportView(tablaCalificaciones);
            
            
            modelo.addColumn("Id nota");
            modelo.addColumn("Tarea");
            modelo.addColumn("Calificacion");
            
            while(rs.next()){
                
                Object[] fila = new Object[3];
                for(int i = 0; i < 3; i++){
                    fila[i] = rs.getObject(i+1);
                }
                modelo.addRow(fila);
                
         //////////////////////////////////////////////
         
         int filax=0;
         int total=0;
                
                
                for(int i = 0; i < tablaCalificaciones.getRowCount(); i++){
                    filax = Integer.parseInt(tablaCalificaciones.getValueAt(i, 2).toString());
                    total+=filax;
                    
                    txtCalificacion.setText(""+total);
                }
                
                int califa = Integer.parseInt(txtCalificacion.getText());
                
                if(califa >= 8){
                    txtEstatus.setText(String.valueOf("Aprobado"));
                    txtCalificacion.setBackground(Color.green);
                }else{
                    txtEstatus.setText(String.valueOf("Reprobado"));
                    txtCalificacion.setBackground(Color.red);
                }
                
            }
            
        } catch (Exception e) {
            System.err.println("Error en el llenado de la tabla Calificaciones");
        }
        
           tablaCalificaciones.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked (MouseEvent e){
                
                int fila_point = tablaCalificaciones.rowAtPoint(e.getPoint());
                int columna_point = 0;
                
                if(fila_point >-1){
                    
                    idCalificacion = (int) modelo.getValueAt(fila_point, columna_point);
                    Informacion_Calificaciones  informacion_Calificaciones = new Informacion_Calificaciones();
                    informacion_Calificaciones.setVisible(true);
                    dispose();
                }
            }
        }); 
    }
    
    
    
    public void cerrar(){
        try {
            
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
            addWindowListener(new WindowAdapter(){
            
                public void windowClosing(WindowEvent e){
                    
                    confirmarSalida();
                }
            });
            
        } catch (Exception e) {
        }
    }
    
    public void confirmarSalida(){
        
        int valor = JOptionPane.showConfirmDialog
        (this, "¿Desea cerrar la aplicacion?","Adevertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        
        if(valor == JOptionPane.YES_OPTION){
            
            JOptionPane.showMessageDialog(null, "Hasta Pronto","",JOptionPane.INFORMATION_MESSAGE);
            
            System.exit(0);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblinfo_Alumno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApelldios = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbGrado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCalificaciones = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtEstatus = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnRegistrarCalificaciones = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblinfo_Alumno.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblinfo_Alumno.setText("INFORMACION ALUMNO");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Grado:");

        cmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel5.setText("Telefono:");

        tablaCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCalificaciones);

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("Estatus:");

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnRegistrarCalificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btnRegistrarCalificaciones.setText("Registrar Calificaciones");
        btnRegistrarCalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCalificacionesActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setText("Calificación:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(txtNombre)
                                .addComponent(jLabel3)
                                .addComponent(txtApelldios, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(cmbGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarCalificaciones)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblinfo_Alumno)
                .addGap(307, 307, 307))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblinfo_Alumno)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApelldios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        Gestion_Alumnos gestion_Alumnos = new Gestion_Alumnos();
        gestion_Alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
      
        Document documento = new Document();
        
        Calendar cal = Calendar.getInstance();
        Date fecha = new Date(cal.getTimeInMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String verfecha = formato.format(fecha);
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/OneDrive/Escritorio/"+txtNombre.getText()+".pdf"));
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial",20, BaseColor.BLACK));
            parrafo.add("Informacion del Alumno. \n \n");
            
            Paragraph poner_fecha = new Paragraph();
            poner_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            poner_fecha.add("Fecha: "+verfecha+"\n \n");
            
            documento.open();
            documento.add(parrafo);
            
            documento.add(poner_fecha);
            
            PdfPTable tablaAlumno = new PdfPTable(4);
            
            tablaAlumno.addCell("Nombre");
            tablaAlumno.addCell("Apellido");
            tablaAlumno.addCell("Grado");
            tablaAlumno.addCell("Materia");
            
            try {
                 var ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno='"+idAlumno+"'");
                 
                 var rs = ps.executeQuery();
                 
                 if(rs.next()){
                     
                     do{
                         tablaAlumno.addCell(rs.getString(2));
                         tablaAlumno.addCell(rs.getString(3));
                         tablaAlumno.addCell(rs.getString(4));
                         tablaAlumno.addCell(rs.getString(6));
                         
                     }while(rs.next());
                             {
                     documento.add(tablaAlumno);
                     
                 }
                     
                 }
                 
                 Paragraph parrafo2 = new Paragraph();
                 parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                 parrafo2.setFont(FontFactory.getFont("Arial", 20, BaseColor.BLACK));
                 parrafo2.add("\n \n Tareas Registradas \n \n");
                 
                 documento.add(parrafo2);
                 PdfPTable tablaTareas = new PdfPTable(2);
                 
                 tablaTareas.addCell("Tarea");
                 tablaTareas.addCell("Calificacion");
                 
                 try {
                     Connection cn2 = con.getConexion();
                    var ps2 = cn2.prepareStatement("SELECT tarea,calificacion FROM notas WHERE id_alumno_nota='"+idAlumno+"'");
                    
                    ResultSet rs2 = ps2.executeQuery();
                    
                    if(rs2.next()){
                        
                        do{
                            tablaTareas.addCell(rs2.getString(1));
                            tablaTareas.addCell(rs2.getString(2));
                       
                        } while(rs2.next());
                                {
                                    documento.add(tablaTareas);
                    }
                    }
                    
                } catch (SQLException e) {
                     System.err.println("Error al cargar Tareas "+e);
                }
              ////////////////////////////////////////////////////////////   
            } catch (SQLException e) {
                System.err.println("Error al obtener datos del Alumno "+e);
            }
            /////////////////////////////////////////////////////////////
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Documento creado con exito");
            
        } catch (DocumentException | IOException e) {
            
            System.err.println("Error en el PDF o en la Ruta "+e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF...Contactar al Administrador");
        }
        
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnRegistrarCalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCalificacionesActionPerformed
        
        Registrar_calificaciones registrar_calificaciones = new Registrar_calificaciones();
        registrar_calificaciones.setVisible(true);
        dispose();
        
        
    }//GEN-LAST:event_btnRegistrarCalificacionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Informacion_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_Alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegistrarCalificaciones;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbGrado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblinfo_Alumno;
    private javax.swing.JTable tablaCalificaciones;
    private javax.swing.JTextField txtApelldios;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtEstatus;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    Conectar con = new Conectar();
    Connection cn = con.getConexion();

}
