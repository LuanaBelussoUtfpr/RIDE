/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidade.Carona;
import entidade.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import negocio.ICarona;
import negocio.IUsuario;

/**
 *
 * @author Luana Belusso
 */
@ManagedBean
@ViewScoped
public class CaronaClienteMB {
    
    private Carona carona;
    private Usuario usuario;
    
    @EJB
    private IUsuario usuarioBean;
    private ICarona caronaBean;

    public IUsuario getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(IUsuario usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public ICarona getCaronaBean() {
        return caronaBean;
    }

    public void setCaronaBean(ICarona caronaBean) {
        this.caronaBean = caronaBean;
    }
    
    
    
}
