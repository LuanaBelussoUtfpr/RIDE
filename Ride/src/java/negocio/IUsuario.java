package negocio;

import javax.ejb.Local;

@Local
public interface IUsuario {
 
    boolean criar (String nome, String sobrenome, String usuario, String senha, String email);
    
}
