package Clases;

import Conexiones.Conexion;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public final class Registrar extends javax.swing.JInternalFrame {
    
    private Image data;
    FileInputStream Cargar_Archivo;
    int contador = 0;
    static ResultSet res;
    
    public Registrar() {
        initComponents();
        vaciarTabla();
        verDatos();
        desabilitar();
        guardar.setEnabled(false);
        editar.setEnabled(false);
        eliminar.setEnabled(false);
        imagen.setEnabled(false);
        this.jComboBox1.removeAllItems();
        this.jComboBox1.addItem("SELECCIONAR PROVEEDOR");
        try{
            ResultSet rs = null;
            Connection con3 = null;
            Conexion conect3 = new Conexion();
            con3 = conect3.getConnection();
            Statement Sent = con3.createStatement();
            rs = Sent.executeQuery("select * from Registro");
            while(rs.next()){
                this.jComboBox1.addItem(rs.getString("Proveedor"));
            }
            contador++;
        }catch (SQLException e){
        }
    }
    
   public void desabilitar(){
        
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        jTextField10.setEnabled(false);
        jTextField11.setEnabled(false);
        jTextField12.setEnabled(false);
        jTextField13.setEnabled(false);
        jTextField14.setEnabled(false);
        jTextField15.setEnabled(false);
        jTextField16.setEnabled(false);
        jTextField17.setEnabled(false);
        jTextField18.setEnabled(false);
        jTextField19.setEnabled(false);
        jTextField20.setEnabled(false);
        jTextField21.setEnabled(false);
        jTextField22.setEnabled(false);
        jTextField23.setEnabled(false);
        jTextField24.setEnabled(false);
        jTextField25.setEnabled(false);
        jTextField26.setEnabled(false);
        jTextField27.setEnabled(false);
        jComboBox1.setEnabled(false);
    }
    
    public void limpiar(){
        jTextField27.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField21.setText(""); 
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
        jTextField26.setText("");
        
        
        jLabel2.setIcon(null);
        jLabel15.setText("");
    }
    
    public void habilitar(){
        jTextField27.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField5.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(true);
        jTextField10.setEnabled(true);
        jTextField11.setEnabled(true); 
        jTextField12.setEnabled(true);
        jTextField13.setEnabled(true);
        jTextField15.setEnabled(true);
        jTextField16.setEnabled(true);
        jTextField17.setEnabled(true);
        jTextField18.setEnabled(true);
        jTextField19.setEnabled(true);
        jTextField20.setEnabled(true);
        jTextField21.setEnabled(true); 
        jTextField22.setEnabled(true);
        jTextField23.setEnabled(true);
        jTextField24.setEnabled(true);
        jTextField25.setEnabled(true);
        jTextField26.setEnabled(true);
        
        jComboBox1.setEnabled(true);
    }
    
    public void vaciarTabla(){
        DefaultTableModel Modelo = (DefaultTableModel) jTable1.getModel();
        String titulos[] = {"ID","Clasificacion","Número de Activo (Placa Toma Física)","Descripción Español (Auxiliar Anterior)","Descripción Documentos - AFC","Marca","Modelo","Serie","Seccion","Zone","Encargado","Estado","Al Amparo del RZF","Inversión","Importado/Local Exento","Proveedor","Factura","DUA","Fecha de Factura","Fecha DUA","Fecha de Adquisición -AFC","Fecha de Activación","Costo en dólares - AFC","Tipo de Cambio","Costo en Colones","Vida Útil","Ultimo mes depreciación","Meses Depreciados","Depreciación Mensual","Foto"};
        Modelo = new DefaultTableModel(null,titulos);
        jTable1.setModel(Modelo);
    }
    
    public void verDatos(){
        try {
            Connection con1 = null;
            DefaultTableModel miModelo = (DefaultTableModel) jTable1.getModel();
            Conexion conect1 = new Conexion();
            con1 = conect1.getConnection();
            String dts[] = new String[27];
            String sql = "select * from Registro";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dts[0] = rs.getString("ID");
                dts[1] = rs.getString("Clasificacion");
                dts[2] = rs.getString("Número de Activo (Placa Toma Física)");
                dts[3] = rs.getString("Descripción Español (Auxiliar Anterior)");
                dts[4] = rs.getString("Descripción Documentos - AFC");
                dts[5] = rs.getString("Marca");
                dts[6] = rs.getString("Modelo");               
                dts[7] = rs.getString("Serie");
                dts[8] = rs.getString("Seccion");
                dts[9] = rs.getString("Zone");
                dts[10] = rs.getString("Encargado");
                dts[11] = rs.getString("Estado");
                dts[12] = rs.getString("Al Amparo del RZF");
                dts[13] = rs.getString("Inversión");
                dts[14] = rs.getString("Importado/Local Exento");
                dts[15] = rs.getString("Proveedor");
                dts[16] = rs.getString("Factura");
                dts[17] = rs.getString("DUA");
                dts[18] = rs.getString("Fecha de Factura");
                dts[19] = rs.getString("Fecha DUA");
                dts[20] = rs.getString("Fecha de Adquisición -AFC");
                dts[21] = rs.getString("Fecha de Activación");
                dts[22] = rs.getString("Costo en Dólares - AFC");
                dts[23] = rs.getString("Tipo de Cambio");
                dts[24] = rs.getString("Costo en Colones");
                dts[25] = rs.getString("Vida Útil");
                dts[26] = rs.getString("Ultimo mes depreciación");
               // dts[27] = rs.getString("Depreciación Mensual");
               // dts[27] = rs.getString("Valor en Libros");
                
                
                miModelo.addRow(dts);
            }
            jTable1.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; 
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }
   
    public Image recuperarfotos(String usuario) {
        try {
                Connection con = null;
                Conexion conect = new Conexion();
                con = conect.getConnection();
                Statement st = con.createStatement();
                PreparedStatement pst = con.prepareStatement("Select Registro.foto From Registro where Registro.ID= ? ");
                pst.setString(1, usuario);
                res = pst.executeQuery();
                int i = 0;
                    while (res.next()) 
                        {
                            byte[] b = res.getBytes("foto");
                            data = ConvertirImagen(b);       
                            i++;
                        }
                    res.close();
            } catch (IOException | SQLException ex) 
                {
                    Logger.getLogger(Clases.Registrar.class.getName()).log(Level.SEVERE, null, ex);
                }
        return data;
    }
    
    public void cargarfoto(String id) {
        Image dtCat = recuperarfotos(id);
        ImageIcon icon = new ImageIcon(dtCat);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(399, 371, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        if (newIcon == null) 
            {
                JOptionPane.showMessageDialog(null, "EL EQUIPO NO TIENE FOTO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } 
        else 
            {
                jLabel2.setIcon(newIcon);
                jLabel2.setSize(jLabel2.getWidth(), jLabel2.getWidth()); 
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        imagen = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel7.setText("Zone");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField27KeyTyped(evt);
            }
        });

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel8.setText("Encargado");

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel5.setText("Clasificacion");

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel3.setText("Número de Activo (Placa Toma Física)");

        jLabel4.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel4.setText("Descripción Español (Auxiliar Anterior");

        jLabel6.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel6.setText("Estado");

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel9.setText("Marca");

        jLabel10.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel10.setText("Modelo");

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel11.setText("Descripción Documentos - AFC");

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel13.setText("Serie");

        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel14.setText("Seccion");

        jLabel12.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("FOTO");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(399, 371));

        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );

        nuevo.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        nuevo.setText("NUEVO");
        nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        guardar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/interface.png"))); // NOI18N
        guardar.setText("GUARDAR");
        guardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        editar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit-document.png"))); // NOI18N
        editar.setText("MODIFICAR");
        editar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        eliminar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/dvavd.png"))); // NOI18N
        eliminar.setText("ELIMINAR");
        eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clasificacion,Número de Activo (Placa Toma Física),Descripción Español (Auxiliar Anterior),Descripción Documentos - AFC,Marca,Modelo,Serie,Seccion,Zone,Encargado,Estado,Al Amparo del RZF,Inversión,Importado/Local Exento,Proveedor,Factura,DUA,Fecha de Factura,Fecha DUA,Fecha de Adquisición -AFC,Fecha de Activación,Costo en dólares - AFC,Tipo de Cambio,Costo en Colones,Vida Útil,Ultimo mes depreciación,Meses Depreciados,Depreciación Mensual"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel15.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        imagen.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IMAGE.png"))); // NOI18N
        imagen.setText("AÑADIR IMAGEN");
        imagen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel16.setText("Al Amparo del RZF");

        jLabel17.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel17.setText("Inversión");

        jLabel18.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel18.setText("Proveedor");

        jLabel19.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel19.setText("Importado/Local Exento");

        jLabel20.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel20.setText("Factura");

        jLabel21.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel21.setText("DUA");

        jLabel22.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel22.setText("Fecha de Factura");

        jLabel23.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel23.setText("Fecha DUA");

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });

        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField15KeyTyped(evt);
            }
        });

        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField16KeyTyped(evt);
            }
        });

        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });

        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });

        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField19KeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel24.setText("Fecha de Adquisición -AFC");

        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel25.setText("Costo en Dólares - AFC");

        jLabel26.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel26.setText("Tipo de Cambio");

        jLabel27.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel27.setText("Fecha de Activación");

        jLabel28.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel28.setText("Costo en Colones");

        jLabel29.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel29.setText("Vida Útil");

        jLabel30.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel30.setText("Ultimo mes depreciación");

        jLabel31.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        jLabel31.setText("Meses Depreciados");

        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField20KeyTyped(evt);
            }
        });

        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField21KeyTyped(evt);
            }
        });

        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField22KeyTyped(evt);
            }
        });

        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField23KeyTyped(evt);
            }
        });

        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField24KeyTyped(evt);
            }
        });

        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField25KeyTyped(evt);
            }
        });

        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });
        jTextField26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField26KeyTyped(evt);
            }
        });

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField5)
                                        .addGap(121, 121, 121))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jTextField14))
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                            .addGap(3, 3, 3)
                                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel19)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(jLabel17)
                                                                                    .addComponent(jLabel16))
                                                                                .addGap(37, 37, 37)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                    .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                                                                    .addComponent(jTextField15))))))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel24)
                                                                    .addComponent(jLabel25)
                                                                    .addComponent(jLabel27)))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel20)
                                                                            .addComponent(jLabel21)))
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jLabel23))
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(15, 15, 15)
                                                                        .addComponent(jLabel22))
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jLabel18)))
                                                                .addGap(50, 50, 50)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                    .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                                    .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jTextField27)
                                                                    .addComponent(jTextField18))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))))
                                                        .addGap(27, 27, 27)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 43, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addGap(15, 15, 15)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                .addComponent(imagen)
                                .addGap(172, 172, 172))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 11, Short.MAX_VALUE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel17))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel27)))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel19)
                                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25)
                                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel21)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel20))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                                .addGap(36, 36, 36))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel18))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)))
                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel22))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(227, 227, 227)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nuevo)
                            .addComponent(guardar)
                            .addComponent(editar)
                            .addComponent(eliminar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel28)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jComboBox1.transferFocus();
        try{
            if(this.contador>0){
                Connection con2 = null;
                Conexion conect2 = new Conexion();
                con2 = conect2.getConnection();
                Statement st2 = con2.createStatement();
                ResultSet rs1 = st2.executeQuery("select * from Registro where Proveedores = '" + this.jComboBox1.getSelectedIndex() + "'");
                rs1.next();
               // this.jTextField27.setText(String.valueOf(rs1.getInt("Id_proveedores")));
                //this.jTextField6.setText(String.valueOf(rs1.getString("nombre_proveedor")));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        jTextField2.transferFocus();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        jTextField27.transferFocus();
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField27KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyTyped
        char c = evt.getKeyChar();
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_jTextField27KeyTyped

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        jTextField3.transferFocus();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        jTextField6.transferFocus();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        jTextField5.transferFocus();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        jTextField7.transferFocus();
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        jTextField8.transferFocus();
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        jTextField9.transferFocus();
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        jTextField10.transferFocus();
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        char c = evt.getKeyChar();
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        jTextField11.transferFocus();
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextField11KeyTyped

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiar();
        habilitar();
        nuevo.setEnabled(false);
        guardar.setEnabled(true);
        vaciarTabla();
        verDatos();
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (jTextField2.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL No DE CATALOGO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField2.requestFocus();
        }
        else if (jTextField3.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA MARCA", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField3.requestFocus();
        }
        else if (jTextField4.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL MODELO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField4.requestFocus();
        }
        else if (jTextField5.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL NOMBRE", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField5.requestFocus();
        }
        else if (jTextField8.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA DESCRIPCION", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField8.requestFocus();
        }
        else if (jTextField10.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA CANTIDAD", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField10.requestFocus();
        }
        else if (jTextField11.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA UBICACION", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField11.requestFocus();
        }
        else if (jTextField27.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL ID PROVEEDOR", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField27.requestFocus();
        }
        else if (jTextField6.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL NOMBRE DEL PROVEEDOR", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField6.requestFocus();
        }
        else if (jTextField5.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL CODIGO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jTextField5.requestFocus();
        }
        else if (jLabel15.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR UNA IMAGEN", "Advertencia", JOptionPane.WARNING_MESSAGE);
            imagen.setEnabled(true);
        }
        else
        {
            try
            {
                Connection con = null;
                Conexion conect = new Conexion();
                con = conect.getConnection();
                Statement st = con.createStatement();
                String sql = "insert into Registro (ID,Clasificacion,Número de Activo (Placa Toma Física),Descripción Español (Auxiliar Anterior),Descripción Documentos - AFC,Marca,Modelo,Serie,Seccion,Zone,Encargado,Estado,Al Amparo del RZF,Inversión,Importado/Local Exento,Proveedor,Factura,DUA,Fecha de Factura,Fecha DUA,Fecha de Adquisición -AFC,Fecha de Activación,Costo en dólares - AFC,Tipo de Cambio,Costo en Colones,Vida Útil,Ultimo mes depreciación,Meses Depreciados,Depreciación Mensual,foto) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, jTextField2.getText());
                pst.setString(2, jTextField3.getText());
                pst.setString(3, jTextField4.getText());
                pst.setString(4, jTextField5.getText());
                pst.setString(5, jTextField6.getText());
                pst.setString(6, jTextField7.getText());
                pst.setString(7, jTextField8.getText());
                pst.setString(8, jTextField9.getText());
                pst.setString(9, jTextField10.getText());
                pst.setString(10, jTextField11.getText());
                pst.setString(11, jTextField12.getText());
                pst.setString(12, jTextField13.getText());
                pst.setString(13, jTextField14.getText());
                pst.setString(14, jTextField15.getText());
                pst.setString(15, jTextField16.getText());
                pst.setString(16, jTextField17.getText());
                pst.setString(17, jTextField18.getText());
                pst.setString(18, jTextField19.getText());
                pst.setString(19, jTextField20.getText());
                pst.setString(20, jTextField21.getText());
                pst.setString(21, jTextField22.getText());
                pst.setString(22, jTextField23.getText());
                pst.setString(23, jTextField24.getText());
                pst.setString(24, jTextField25.getText());
                pst.setString(25, jTextField26.getText());
                
                
                
                pst.setString(11, jLabel15.getText());
                Cargar_Archivo = new FileInputStream(jLabel15.getText());
                pst.setBinaryStream(12, Cargar_Archivo);
                int n = pst.executeUpdate();
                if (n > 0)
                {
                    JOptionPane.showMessageDialog(this, "DATOS GUARDADOS CORRECTAMENTE");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                    nuevo.setEnabled(true);
                    guardar.setEnabled(false);
                    editar.setEnabled(false);
                    eliminar.setEnabled(false);
                    desabilitar();
                }
            } catch (SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO GUARDADOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try
        {
            Connection con = null;
            Conexion conect = new Conexion();
            con = conect.getConnection();
            Statement st = con.createStatement();
            String sql = "update Registro set ID = ?,Clasificacion = ?,Número de Activo (Placa Toma Física) = ?,Descripción Español (Auxiliar Anterior) = ?,Descripción Documentos - AFC,Marca = ?,Modelo = ?,Serie = ?,Seccion = ?,Zone = ?,Encargado = ?,Estado = ?,Al Amparo del RZF,Inversión = ?,Importado/Local Exento = ?,Proveedor = ?,Factura = ?,DUA = ?,Fecha de Factura = ?,Fecha DUA = ?,Fecha de Adquisición -AFC = ?,Fecha de Activación = ?,Costo en dólares - AFC = ?,Tipo de Cambio = ?,Costo en Colones = ?,Vida Útil = ?,Ultimo mes depreciación = ?,Meses Depreciados= ?,Depreciación Mensual = ?,foto = ? where ID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jTextField2.getText());
            pst.setString(2, jTextField3.getText());
            pst.setString(3, jTextField4.getText());
            pst.setString(4, jTextField5.getText());
            pst.setString(5, jTextField6.getText());
            pst.setString(6, jTextField7.getText());
            pst.setString(7, jTextField8.getText());
            pst.setString(8, jTextField9.getText());
            pst.setString(9, jTextField10.getText());
            pst.setString(10, jTextField11.getText());
            pst.setString(11, jTextField12.getText());
            pst.setString(12, jTextField13.getText());
            pst.setString(13, jTextField14.getText());
            pst.setString(14, jTextField15.getText());
            pst.setString(15, jTextField16.getText());
            pst.setString(17, jTextField17.getText());
            pst.setString(18, jTextField18.getText());
            pst.setString(19, jTextField19.getText());
            pst.setString(20, jTextField20.getText());
            pst.setString(21, jTextField21.getText());
            pst.setString(22, jTextField22.getText());
            pst.setString(23, jTextField23.getText());
            pst.setString(24, jTextField24.getText());
            pst.setString(25, jTextField25.getText());
            pst.setString(26, jTextField26.getText());
            pst.setString(27, jTextField27.getText());
            
            pst.setString(16, jLabel15.getText());
            
            Cargar_Archivo = new FileInputStream(jLabel15.getText());
            pst.setBinaryStream(12, Cargar_Archivo);
            pst.setInt(13, Integer.parseInt(jTextField4.getText()));
            int n = pst.executeUpdate();
            if (n > 0)
            {
                JOptionPane.showMessageDialog(this, "DATOS ACTUALIZADOS CORRECTAMENTE");
                limpiar();
                vaciarTabla();
                verDatos();
                nuevo.setEnabled(true);
                guardar.setEnabled(false);
                editar.setEnabled(false);
                eliminar.setEnabled(false);
                imagen.setEnabled(false);
                desabilitar();
            }
        } catch (SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO ACTUALIZADOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila == -1)
        {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int opc = JOptionPane.showConfirmDialog(this, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION)
            {
                try
                {
                    Connection con = null;
                    Conexion conect = new Conexion();
                    con = conect.getConnection();
                    Statement st = con.createStatement();
                    String sql = "delete from Registro where ID = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(jTextField4.getText()));
                    int n = pst.executeUpdate();
                    if (n > 0)
                    {
                        JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");
                        limpiar();
                        vaciarTabla();
                        verDatos();
                        nuevo.setEnabled(true);
                        guardar.setEnabled(false);
                        editar.setEnabled(false);
                        eliminar.setEnabled(false);
                        desabilitar();
                    }
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try
        {
            int fila = jTable1.getSelectedRow();
            String id = jTable1.getValueAt(fila, 0).toString();
            jTextField2.setText(jTable1.getValueAt(fila, 0).toString());
            jTextField3.setText(jTable1.getValueAt(fila, 1).toString());
            jTextField4.setText(jTable1.getValueAt(fila, 2).toString());
            jTextField5.setText(jTable1.getValueAt(fila, 3).toString());
            jTextField6.setText(jTable1.getValueAt(fila, 4).toString());
            jTextField7.setText(jTable1.getValueAt(fila, 5).toString());
            jTextField8.setText(jTable1.getValueAt(fila, 6).toString());
            jTextField9.setText(jTable1.getValueAt(fila, 7).toString());
            jTextField10.setText(jTable1.getValueAt(fila, 8).toString());
            jTextField11.setText(jTable1.getValueAt(fila, 9).toString());
            jTextField12.setText(jTable1.getValueAt(fila, 10).toString());
            jTextField13.setText(jTable1.getValueAt(fila, 11).toString());
            jTextField14.setText(jTable1.getValueAt(fila, 12).toString());
            jTextField15.setText(jTable1.getValueAt(fila, 13).toString());
            jTextField16.setText(jTable1.getValueAt(fila, 14).toString());
            jTextField17.setText(jTable1.getValueAt(fila, 15).toString());
            jTextField18.setText(jTable1.getValueAt(fila, 16).toString());
            jTextField19.setText(jTable1.getValueAt(fila, 17).toString());
            jTextField20.setText(jTable1.getValueAt(fila,18).toString());
            jTextField21.setText(jTable1.getValueAt(fila, 19).toString());
            jTextField22.setText(jTable1.getValueAt(fila, 20).toString());
            jTextField23.setText(jTable1.getValueAt(fila, 21).toString());
            jTextField24.setText(jTable1.getValueAt(fila, 22).toString());
              jTextField25.setText(jTable1.getValueAt(fila,23).toString());
            jTextField26.setText(jTable1.getValueAt(fila, 24).toString());
            jTextField27.setText(jTable1.getValueAt(fila, 25).toString());
            jTextField6.setText(jTable1.getValueAt(fila, 26).toString());
            jTextField5.setText(jTable1.getValueAt(fila, 27).toString());
          
            
            jLabel15.setText(jTable1.getValueAt(fila, 11).toString());

         
            cargarfoto(id);
            nuevo.setEnabled(false);
            guardar.setEnabled(false);
            editar.setEnabled(true);
            eliminar.setEnabled(true);
            imagen.setEnabled(true);
            habilitar();
        } catch (Exception ex)
        {
            System.out.println("ERROR AL SELECCIONAR UN EQUIPO : " + ex.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenActionPerformed
        FileFilter filter = new FileNameExtensionFilter("JPG","jpg");
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar Imagen De Entrada");
        chooser.setFileFilter(filter);
        int Open = chooser.showOpenDialog(null);
        if (Open == JFileChooser.APPROVE_OPTION)
        {
            File Archivo = chooser.getSelectedFile();
            jLabel15.setText(String.valueOf(Archivo));
            Image Imagen = getToolkit().getImage(jLabel15.getText());
            Imagen = Imagen.getScaledInstance(399, 371, Image.SCALE_SMOOTH);
            jLabel2.setIcon(new ImageIcon(Imagen));
        }
    }//GEN-LAST:event_imagenActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15KeyTyped

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16KeyTyped

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyTyped

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField19KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19KeyTyped

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20KeyTyped

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21KeyTyped

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22KeyTyped

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField23KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23KeyTyped

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24KeyTyped

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField25KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25KeyTyped

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField26KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField26KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26KeyTyped

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton imagen;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton nuevo;
    // End of variables declaration//GEN-END:variables
}
