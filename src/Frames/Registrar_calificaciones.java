
package Frames;

import Clases.Conectar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author misa_
 */
public class Registrar_calificaciones extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_calificaciones
     */
    
    int idAlumno=0;
    String nombre_alumno="";
    String nombre_curso="";
    
    public Registrar_calificaciones() {
        initComponents();
        cerrar();
        
        TextPrompt tarea = new TextPrompt("Ingresa Tarea", txtTarea);
        TextPrompt calificacion = new TextPrompt("Ingresa Tarea", txtCalificacion);
        
        this.setLocationRelativeTo(null);
        
        txtAlumno.setEditable(false);
        cmbCurso.setEnabled(false);
        
        cargarcombocurso(cmbCurso);
        
        idAlumno = Gestion_Alumnos.idAlumno;
        
        try {
            
            var ps = cn.prepareStatement("SELECT nombre FROM alumnos WHERE id_alumno='"+idAlumno+"'");
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                nombre_alumno = rs.getString("nombre");
            }
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "error al consultar nombre del Alumno");
        }
        
        txtAlumno.setText(nombre_alumno);
        
        
        /////////////////////////////////////////
        
        try {
            
            var ps = cn.prepareStatement("SELECT id_curso_asignado FROM alumnos WHERE id_alumno='"+idAlumno+"'");
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                nombre_curso = rs.getString("id_curso_asignado");
            }
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al consultar Curso del Alumno");
        }
        
        cmbCurso.setSelectedItem(nombre_curso);
    
    }
    ////////////////////////////////////////////////////////////////////////////
    
    
    public void cargarcombocurso(JComboBox combodelcurso){
        
        try {
            String sql="SELECT nombre_curso FROM curso";
            Statement st= cn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            
            
            while(rs.next()){
                
                combodelcurso.addItem(rs.getString("nombre_curso"));
            }
         
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al cargar Datos en ComboBox");
        }
        
    }
    
    ///////////////////////////////////////////////////////////////
    
    
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTarea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRAR CALIFICACIONES");

        jLabel2.setText("Alumno:");

        txtAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tarea:");

        txtTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTareaActionPerformed(evt);
            }
        });

        jLabel4.setText("Curso:");

        cmbCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Curso" }));

        jLabel5.setText("Calificacion:");

        txtCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalificacionActionPerformed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(txtAlumno)
                                .addComponent(jLabel3)
                                .addComponent(txtTarea, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(cmbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlumnoActionPerformed

    private void txtTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTareaActionPerformed

    private void txtCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalificacionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        Informacion_Alumnos informacion_Alumnos = new Informacion_Alumnos();
        informacion_Alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

       String curso=cmbCurso.getSelectedItem().toString();
       
        try {
            
            if(txtTarea.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo Tarea Vacio");
            }
            ////////////////////////////////////////////////
            
            else  if(txtCalificacion.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo Calificacion Vacio");
            }
            ///////////////////////////////////////////////////
            
            else{
                var ps = cn.prepareStatement("INSERT INTO notas (id_alumno_nota,id_curso_nota,tarea,calificacion) VALUES (?,?,?,?) ");
                
                ps.setInt(1, idAlumno);
                ps.setString(2, curso);
                ps.setString(3, txtTarea.getText());
                ps.setString(4, txtCalificacion.getText());
                
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al guarda datos de Calificaciones");
            
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_calificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarCalificaciones;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtTarea;
    // End of variables declaration//GEN-END:variables

    Conectar con = new Conectar();
    Connection cn = con.getConexion();


}