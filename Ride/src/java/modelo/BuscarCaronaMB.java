
package modelo;

import entidade.Carona;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import negocio.IBuscarCarona;

@ManagedBean
@ViewScoped
public class BuscarCaronaMB{
    private List<Carona> caronas;
    private Date dt;
    private String descricao;
    private List<Carona> filteredCarona;
    private Carona selectedCar;
    
    @EJB
    private IBuscarCarona buscarCaronaBean;
    
    public List<Carona> consultar(){
        return buscarCaronaBean.consultar();
    }
    
    public void setFilteredCarona(List<Carona> filteredCarona) {
        this.filteredCarona = filteredCarona;
    }

    public List<Carona> getFilteredCarona() {
        return filteredCarona;
    }
    
    public Date getDt() {
         return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Carona getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Carona selectedCar) {
        this.selectedCar = selectedCar;
    }

}
