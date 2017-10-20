package modelo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import negocio.ILogin;
import negocio.LoginBean;

@ManagedBean
@ViewScoped
public class LoginMB {
    
    private String usuario;
    private String senha;
    private String msgLogin="";
    
    @EJB
    private ILogin loginBean;

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

    public String getMsgLogin() {
        return msgLogin;
    }

    public void setMsgLogin(String msgLogin) {
        this.msgLogin = msgLogin;
    }
        
    public void login(){
        this.setMsgLogin("Validando login");
        int retorno;
        
        retorno = loginBean.login(this.getUsuario(), this.getSenha());
        
        if (retorno>0){
            this.setMsgLogin("Deu certo");
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            this.setMsgLogin("Nao Deu certo");
        }
    }

    
}
