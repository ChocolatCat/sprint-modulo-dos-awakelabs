import java.util.ArrayList;

public class Listado {
    ArrayList<IAsesoria> lista = new ArrayList<>();

    public Listado() {
    }

    public Listado(ArrayList<IAsesoria> lista) {
        this.lista = lista;
    }

    public ArrayList<IAsesoria> getLista() {
        return lista;
    }

    public void setLista(ArrayList<IAsesoria> lista) {
        this.lista = lista;
    }

    public void AddUsuario(IAsesoria usuario){
        lista.add(usuario);
    }

    public void ListarUsuarios(){
        for(IAsesoria usuario : lista){
            System.out.println(usuario.analizarUsuario());
        }
    }
}
