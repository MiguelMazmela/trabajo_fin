/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package variables;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author miguel
 */
public class Var {

    private Connection con;
    private String CreaTablaSistema;
    private String sSistemaOperativo;
    private String CaminoCompletoBD;
    private boolean conectado = false;
    private String usuario;
    private Boolean UsuarioValido;
    private boolean edicion = false;

    public Connection conectar() {
        Connection coco = null;
        this.sSistemaOperativo = System.getProperty("os.name");

        String sFichero = "clientes";
        String sDirectorio = "data";

        String sPath = getCurrentDir() + File.separator + sDirectorio + File.separator + sFichero;
        CaminoCompletoBD = sPath;
        try {
            Class.forName("org.h2.Driver");
            coco = DriverManager.getConnection("jdbc:h2:file:" + sPath, "Miguel", "31651918");
            conectado = !coco.isClosed();
            con = coco;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Var.class.getName()).log(Level.SEVERE, null, ex);
        }

        return coco;

    }

    public String getCurrentDir() {
        File currentDirFile = new File(".");
        String helper = currentDirFile.getAbsolutePath();
        String dir;
//        System.out.print(helper);
        dir = helper.substring(0, helper.length() - 2); //this line may need a try-catch
        return dir;
    }

    public String getsSistemaOperativo() {
        return sSistemaOperativo;
    }

    public String getCaminoCompletoBD() {
        return CaminoCompletoBD;
    }

    public boolean isConectado() {
        return conectado;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getUsuarioValido() {
        return UsuarioValido;
    }

    public void setUsuarioValido(Boolean UsuarioValido) {
        this.UsuarioValido = UsuarioValido;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getCreaTablaSistema() {
        return CreaTablaSistema;
    }

    public void setCreaTablaSistema(String CreaTablaSistema) {
        this.CreaTablaSistema = CreaTablaSistema;
    }

    public java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public java.sql.Date fecFormatoDate(String fe) {

        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            java.sql.Date fecFormatoDate = new java.sql.Date(sdf.parse(fe).getTime());

//            System.out.println("Fecha con el formato java.sql.Date: " + fecFormatoDate);
            return fecFormatoDate;
        } catch (ParseException ex) {
            System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
        }
        return null;
    }

    public DecimalFormat MyFormatter() {

        DecimalFormat df;

        df = new DecimalFormat("#,###,##0.00");
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');
        df.setDecimalFormatSymbols(otherSymbols);
        return df;

    }
    
    public java.util.Date fecha(){
        
        return new Date();
    }

    public String deFechaSqlATexto(java.sql.Date fecha) {
        String fecha_salida;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        fecha_salida = dateFormat.format(fecha);

        return fecha_salida;
    }

    public java.util.Date FechaSqlUtil(java.sql.Date uDate) {
        java.util.Date sDate = new java.util.Date(uDate.getTime());
        return sDate;
    }

    public void borratabla(DefaultTableModel modelo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    public boolean isEdicion() {
        return edicion;
    }

    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }
    public float DeTextoAFloat(String tex){
        float numero=(float) 0.00;
         try {
            float f = Float.parseFloat(tex);
            numero=f;
//            System.out.println(f);                // 1.1
        } catch (NumberFormatException e) {
            // la string no se puede analizar para que flote
        }
        
        
        return numero;
    }

}
