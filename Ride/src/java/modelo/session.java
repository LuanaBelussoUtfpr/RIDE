/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Luana Belusso
 */
public class session {
    
    private static session instance;
    private static Long idusuario;
    private static String usuario;
    
    private session(){
    }
    
    public static session getInstance() {
        if (instance == null)
            instance = new session();
        return instance;
    }

    public static Long getIdusuario() {
        return idusuario;
    }

    public static void setIdusuario(Long idusuario) {
        session.idusuario = idusuario;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        session.usuario = usuario;
    }

    
    
}
