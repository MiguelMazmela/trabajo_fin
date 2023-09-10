/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package variables;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguel
 */
public class Var {
    private Connection con;
    private String CreaTablaSistema;
    private String sSistemaOperativo;
    private String CaminoCompletoBD;
    private boolean conectado;
    private String usuario;
    private Boolean UsuarioValido;
    
            
            
    
    
    
    
    
        public Connection conectar() {
        Connection coco = null;
        this.sSistemaOperativo = System.getProperty("os.name");

        String sFichero = "clientes";
        String sDirectorio = "data";

        String sPath = getCurrentDir() + File.separator + sDirectorio + File.separator + sFichero;
        CaminoCompletoBD=sPath;
        try {
            Class.forName("org.h2.Driver");
            coco = DriverManager.getConnection("jdbc:h2:file:" + sPath, "Miguel", "31651918");
            conectado=!coco.isClosed();

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

    
    
}
