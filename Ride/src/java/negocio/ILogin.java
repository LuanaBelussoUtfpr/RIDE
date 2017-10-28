package negocio;

import entidade.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ILogin {
    public int login(String user, String senha);
    public List<Usuario> consultar(String user, String senha);
}
