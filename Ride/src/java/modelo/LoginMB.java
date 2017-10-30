package modelo;

import entidade.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import negocio.ILogin;

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
        
        List<Usuario> lista;     
        lista = loginBean.consultar(this.getUsuario(), this.getSenha());
                      
        if(!lista.isEmpty()){
            
            session secao = session.getInstance();
            secao.setIdusuario(lista.get(0).getId());
            secao.setUsuario(lista.get(0).getUsuario());
            
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("telainicial.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            this.setMsgLogin("Usuário e Senha Inválidos!");
        }
    }
    

    
}
