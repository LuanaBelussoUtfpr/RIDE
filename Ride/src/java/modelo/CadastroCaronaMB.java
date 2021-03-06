
package modelo;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import negocio.ICarona;

@ManagedBean
@ViewScoped
public class CadastroCaronaMB {
    
    private String descricao;
    private String localOrigem;
    private String localDestino;
    private Long vagasDisponiveis;
    private double valorCarona;
    private String dataCarona;
    private String horarioCarona;
    private String cidadeOrigem;
    private String estadoOrigem;
    private String paisOrigem;
    private String cidadeDestino;
    private String estadoDestino;
    private String paisDestino;
    private String enderecoOrigem;
    private String enderecoDestino;
    private String telefone;
    private String email;
   
    @EJB
    private ICarona CadastroCaronaBean;

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(String enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public Long getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public void setVagasDisponiveis(Long vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public double getValorCarona() {
        return valorCarona;
    }

    public void setValorCarona(double valorCarona) {
        this.valorCarona = valorCarona;
    }

    public String getDataCarona() {
        return dataCarona;
    }

    public void setDataCarona(String dataCarona) {
        this.dataCarona = dataCarona;
    }

    public String getHorarioCarona() {
        return horarioCarona;
    }

    public void setHorarioCarona(String horarioCarona) {
        this.horarioCarona = horarioCarona;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(String estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public void criar(){
        FacesContext context = FacesContext.getCurrentInstance();
         
        if (CadastroCaronaBean.criar(this.getDescricao(),this.getLocalOrigem(),this.getLocalDestino(),
                this.getVagasDisponiveis(),this.getValorCarona(),this.getDataCarona(),this.getHorarioCarona(),
                this.getCidadeOrigem(),this.getEstadoOrigem(), this.getPaisOrigem(),
                this.getCidadeDestino(), this.getEstadoDestino(), this.getPaisDestino(),
                this.getTelefone(), this.getEmail())){
            
               context.addMessage(null, new FacesMessage("Carona registrada com sucesso!", ""));
               limpar();               
        }else{
            context.addMessage(null, new FacesMessage("Falha ao registrar carona!", ""));
        }   
    }
    
    public void limpar(){
        this.setDescricao(null);
        this.setLocalOrigem(null);
        this.setLocalDestino(null);
        this.setVagasDisponiveis(null);
        this.setValorCarona(0);
        this.setDataCarona(null);
        this.setHorarioCarona(null);
        this.setCidadeOrigem(null);
        this.setEstadoOrigem(null);
        this.setPaisOrigem(null);
        this.setCidadeDestino(null); 
        this.setEstadoDestino(null);
        this.setPaisDestino(null);
        this.setTelefone(null); 
        this.setEmail(null);
                
    }
}
