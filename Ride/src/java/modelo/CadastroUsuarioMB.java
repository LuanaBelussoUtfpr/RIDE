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
    private String msgValidacao="teste";
    
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

    public String getMsgValidacao() {
        return msgValidacao;
    }

    public void setMsgValidacao(String msgValidacao) {
        this.msgValidacao = msgValidacao;
    }
    
    public boolean validarsenha(){
        String password = this.getSenha();
        String confirma = this.getConfirmaSenha();
        
        return password.equals(confirma);
    }

    public void criar() {
        
        this.setMsgValidacao("validando");
        
        if(!validarsenha()){
            this.setMsgValidacao("Senha e confirmação não conferem!");
        }else{
            if (cadastroUsuarioBean.criar(this.getNome(), this.getSobrenome(), this.getUsuario(), this.getSenha(),
                    this.getEmail())){

                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Falha ao cadastrar usuário!",  "") );

            }
        }      
    } 
}
