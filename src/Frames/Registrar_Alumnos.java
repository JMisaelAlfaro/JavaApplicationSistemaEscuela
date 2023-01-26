
package Frames;

import Clases.Conectar;
import com.mysql.cj.PreparedQuery;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author misa_
 */
public class Registrar_Alumnos extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_Alumnos
     */
    public Registrar_Alumnos() {
        initComponents();
        
        TextPrompt nombre = new TextPrompt("Escribe tu Nombre", txtNombre);
        TextPrompt apellidos = new TextPrompt("Escribe tu Aepliidos", txtApellidos);
        TextPrompt telefono = new TextPrompt("Escribe tu Telefono", txtTelefono);
        TextPrompt buscar = new TextPrompt("Buscar", txtBuscar);
        
        this.setLocationRelativeTo(null);
        
        limpiar();
        txtIdAlumno.setEnabled(false);
        txtCantidad.setEditable(false);
        mostrarTabla("");
        cerrar();
        cargarComboCurso(cmbMaterias);
        
        for(int i=0; i <=tabla_registro_alumnos.getRowCount(); i++ ){
                    txtCantidad.setText(" " + i);
                }
        
    }
    
    
    void limpiar(){
        
        txtIdAlumno.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        cmbGrados.setSelectedIndex(0);
        cmbMaterias.setSelectedIndex(0);
    }
    
    void mostrarTabla(String valor){
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Grado");
        modelo.addColumn("Telefono");
        modelo.addColumn("Materia");
        
        tabla_registro_alumnos.setModel(modelo);
        
        String sql = "SELECT * FROM alumnos WHERE CONCAT (nombre,' ',apellido,' ',grado,' ',id_curso_asignado) LIKE '%"+valor+"%'";
        
        String datos[] = new String[6];
        Statement st;
        
        try {
            st = cn.createStatement();
            var rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            
            tabla_registro_alumnos.setModel(modelo);
            
        } catch (SQLException e) {
            System.err.println(e);
        }
      }
    
    public void cargarComboCurso(JComboBox comboDelCurso){
        
        try {
            String sql = "SELECT nombre_curso FROM curso";
            Statement st = cn.createStatement();
            var rs = st.executeQuery(sql);
            
            while(rs.next()){
                comboDelCurso.addItem(rs.getString("nombre_curso"));
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
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

        popborrar = new javax.swing.JPopupMenu();
        popeliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdAlumno = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        cmbGrados = new javax.swing.JComboBox<>();
        cmbMaterias = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_registro_alumnos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        popeliminar.setText("Eliminar");
        popeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popeliminarActionPerformed(evt);
            }
        });
        popborrar.add(popeliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRO DE ALUMNOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setText("Id Alumno:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Grado:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Materia:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        cmbGrados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Grado", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cmbMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Materia" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtApellidos)
                    .addComponent(txtTelefono)
                    .addComponent(cmbGrados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbMaterias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbGrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/update.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tabla_registro_alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_registro_alumnos.setComponentPopupMenu(popborrar);
        tabla_registro_alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_registro_alumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_registro_alumnos);

        jLabel8.setText("Buscar:");

        jLabel9.setText("Cantidad:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(340, 340, 340))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String id_curso_asignado = cmbMaterias.getSelectedItem().toString();
        String materia = (String) cmbMaterias.getSelectedItem();
        String grado = (String) cmbGrados.getSelectedItem();
        
        try {
             if(txtNombre.getText().isEmpty()){
                 
                 JOptionPane.showMessageDialog(null, "No puede dejar el campo Nombre vacio");
             }
             
             else if(txtApellidos.getText().isEmpty()){
                 
                 JOptionPane.showMessageDialog(null, "No puede dejar el campo Apellidos vacio");
             }
             
            else  if(txtTelefono.getText().isEmpty()){
                 
                 JOptionPane.showMessageDialog(null, "No puede dejar el campo Telefono vacio");
             }
             
            else  if(grado.equals("Seleccione Grado")){
                 
                 JOptionPane.showMessageDialog(null, "Debe seleccionar un Grado");
             }
             
             else  if(materia.equals("Seleccione Materia")){
                 
                 JOptionPane.showMessageDialog(null, "Debe seleccionar una Materia");
             }
             
             else{
                 
                 var ps = cn.prepareStatement("INSERT INTO alumnos(nombre,apellido,grado,telefono,id_curso_asignado) VALUES (?,?,?,?,?)");
                 
                  ps.setString(1, txtNombre.getText());
                  ps.setString(2, txtApellidos.getText());
                  ps.setString(3, cmbGrados.getSelectedItem().toString());
                  ps.setString(4, txtTelefono.getText());
                  ps.setString(5, id_curso_asignado);
                  
                  
                  ps.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Alumno resgistrado con exito");
                  mostrarTabla("");
                  limpiar();
                  
                  for(int i=0; i <=tabla_registro_alumnos.getRowCount(); i++ ){
                    txtCantidad.setText(" " + i);
                }
             }
             
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al guardar Alumno");
        }
       
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

       String materia = (String) cmbMaterias.getSelectedItem();
       String grado = (String) cmbGrados.getSelectedItem();
       
        try {
              if(txtNombre.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null,"No puedes dejar el campo Nombre vacio");
              }
              
               else if(txtApellidos.getText().isEmpty()){
                 
                 JOptionPane.showMessageDialog(null, "No puede dejar el campo Apellidos vacio");
             }
             
            else  if(txtTelefono.getText().isEmpty()){
                 
                 JOptionPane.showMessageDialog(null, "No puede dejar el campo Telefono vacio");
             }
             
            else  if(grado.equals("Seleccione Grado")){
                 
                 JOptionPane.showMessageDialog(null, "Debe seleccionar un Grado");
             }
             
             else  if(materia.equals("Seleccione Materia")){
                 
                 JOptionPane.showMessageDialog(null, "Debe seleccionar una Materia");
             }
              
             else{
                 
                 var ps = cn.prepareStatement("UPDATE alumnos SET nombre='"+txtNombre.getText()+"',apellido='"+txtApellidos.getText()+"',grado='"+cmbGrados.getSelectedItem().toString()+"',telefono='"+txtTelefono.getText()+"',id_curso_asignado='"+cmbMaterias.getSelectedItem().toString()+"' WHERE id_alumno='"+txtIdAlumno.getText()+"'");                                                  
                 
                 int respuesta = ps.executeUpdate();
                 
                 if(respuesta>0){
                     JOptionPane.showMessageDialog(null, "Datos del Alumno modificados");
                     limpiar();
                     mostrarTabla("");
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "No ha seleccionado Fila");
                 }
               }
              
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al actualizar Alumno... Contacte al Administrador");
        }
       
       
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void popeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popeliminarActionPerformed

        try {
            var ps = cn.prepareStatement("DELETE FROM alumnos WHERE id_alumno='"+txtIdAlumno.getText()+"'");
            
            int respuesta = ps.executeUpdate();
            
            if(respuesta>0){
                
                JOptionPane.showMessageDialog(null, "Alumno eleminado");
                limpiar();
                mostrarTabla("");
                
                for(int i=0; i <=tabla_registro_alumnos.getRowCount(); i++ ){
                    txtCantidad.setText(" " + i);
                }
                
                
            }
            
            else{
                
                JOptionPane.showMessageDialog(null, "No ha seleccionado fila");
            }
            
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al eliminar Alumno...Contactar al Administrador");
        }
        
    }//GEN-LAST:event_popeliminarActionPerformed

    private void tabla_registro_alumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_registro_alumnosMouseClicked
     
        int fila = this.tabla_registro_alumnos.getSelectedRow();
        
        this.txtIdAlumno.setText(this.tabla_registro_alumnos.getValueAt(fila, 0).toString());
        this.txtNombre.setText(this.tabla_registro_alumnos.getValueAt(fila, 1).toString());
        this.txtApellidos.setText(this.tabla_registro_alumnos.getValueAt(fila, 2).toString());
        this.cmbGrados.setSelectedItem(this.tabla_registro_alumnos.getValueAt(fila, 3).toString());
        this.txtTelefono.setText(this.tabla_registro_alumnos.getValueAt(fila, 4).toString());
        this.cmbMaterias.setSelectedItem(this.tabla_registro_alumnos.getValueAt(fila, 5).toString());
        
        
    }//GEN-LAST:event_tabla_registro_alumnosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        mostrarTabla(txtBuscar.getText());
        
        for(int i=0; i <=tabla_registro_alumnos.getRowCount(); i++ ){
                    txtCantidad.setText(" " + i);
                }
        
        
        
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A') | c>'Z' && c!=KeyEvent.VK_SPACE) evt.consume();
       
        
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        
        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A') | c>'Z' && c!=KeyEvent.VK_SPACE) evt.consume();
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        
        char c = evt.getKeyChar();
        
        if(c<'0' || c>'9') evt.consume();
                
    }//GEN-LAST:event_txtTelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(Registrar_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_Alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbGrados;
    private javax.swing.JComboBox<String> cmbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popborrar;
    private javax.swing.JMenuItem popeliminar;
    private javax.swing.JTable tabla_registro_alumnos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdAlumno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

 Conectar con = new Conectar();
    Connection cn = con.getConexion();
}
