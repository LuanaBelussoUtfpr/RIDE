package modelo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import negocio.IUsuario;

@ManagedBean
@ViewScoped
public class CadastroUsuarioMB {
    
    private String nome;
    private String sobrenome;
    private String usuario;
    private String email;
    private String senha;
    private String confirmaSenha;
    
    @EJB
    private IUsuario cadastroUsuarioBean;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

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
    
    public String getEmail() {
        return email;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmasenha) {
        this.confirmaSenha = confirmasenha;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean validarsenha(){
        String password = this.getSenha();
        String confirma = this.getConfirmaSenha();
        
        return password.equals(confirma);
    }
    
    public boolean caracterSenha(){
        String password = this.getSenha();
        
        return password.length() >= 6;
    }
    

    public void criar() {
        FacesContext context = FacesContext.getCurrentInstance();
       
        if(!validarsenha()){
            context.addMessage(null, new FacesMessage("Senha e confirmação não conferem!",  "") );
        }else if(!caracterSenha()){
            context.addMessage(null, new FacesMessage("A senha deve conter no mínimo 6 caracteres!",  "") );
        }else{
             
            if (cadastroUsuarioBean.criar(this.getNome(), this.getSobrenome(), this.getUsuario(), this.getSenha(),
                    this.getEmail())){

                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }else{
                context.addMessage(null, new FacesMessage("Falha ao cadastrar usuário!",  "") );
            }
        }      
    } 
}
