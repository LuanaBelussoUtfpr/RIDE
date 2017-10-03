
package modelo;
import entidade.Carona;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import negocio.ICarona;

@ManagedBean
@ViewScoped
public class CadastroCaronaMB {
    
    private String descricao;
    private String localOrigem;
    private String localDestino;
    private Long vagasDisponiveis;
    private Long valorCarona;
    private String dataCarona;
    private String horarioCarona;
    private String cidade;
    private String estado;

    @EJB
    private ICarona CadastroCaronaBean;

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

    public void setVagasDisponiveis(Long vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Long getValorCarona() {
        return valorCarona;
    }

    public void setValorCarona(Long valorCarona) {
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
    
    public String criar(){
        System.out.println(estado);
        if (CadastroCaronaBean.criar(this.getDescricao(),this.getLocalOrigem(),this.getLocalDestino(),
                this.getVagasDisponiveis(),this.getValorCarona(),this.getDataCarona(),this.getHorarioCarona(),
                this.getCidade(),this.getEstado()))
            return "Carona Cadastrada com Sucesso";
        else 
            return "Carona Não Cadastrada, Verifique!";
        
    }
}
