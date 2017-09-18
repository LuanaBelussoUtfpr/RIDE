package modelo;

import entidade.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import negocio.ILogin;

@ManagedBean
@ViewScoped
public class LoginMB {
    
    private String usuario;
    private String senha;
    
    @EJB
    private ILogin LoginBean;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void validarlogin(){
        
        int retorno;
        
        retorno = LoginBean.login(this.getUsuario(), this.getSenha());
        
        if (retorno==1){
            System.out.println("deu");
        }else{
            System.out.println("não");
        }
    }
}
