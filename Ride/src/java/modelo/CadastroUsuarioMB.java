package modelo;

import entidade.Usuario;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import negocio.IUsuario;

@ManagedBean
@ViewScoped
public class CadastroUsuarioMB {
    
    private String nome;
    private String sobrenome;
    private String usuario;
    private String email;
    private String senha;
    private String cidade;
    private String estado;
    private String pais="Brasil";
    
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public boolean validarsenha(String senha, String confirmarsenha){
        if(senha==confirmarsenha){
            return true;
        }else{
            return false;
        }
    }

    public String criar() {
        System.out.println(pais);
        if (cadastroUsuarioBean.criar(this.getNome(), this.getSobrenome(), this.getUsuario(), this.getSenha(),
                this.getEmail(), this.getCidade(), this.getEstado(), this.getPais())){
            return "Usuário criado com sucesso!";
        }else{
            return "Ocorreu erro ao criar o usuário!";}
    }
    
}
