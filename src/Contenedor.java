import java.util.ArrayList;
import java.util.List;

public class Contenedor {
    public List<IAsesoria> listaAsesorias = new ArrayList<>();
    public List<Capacitacion> listaCapacitacion = new ArrayList<>();
    public int idCapacitacion = 1;

    public Contenedor() {
    }

    public void AlmacenarCliente(Cliente cliente){
        listaAsesorias.add(cliente);
    }

    public void AlmacenarProfesional(Profesional profesional){
        listaAsesorias.add(profesional);
    }

    public void AlmacenarAdministrativo(Administrativo administrativo){
        listaAsesorias.add(administrativo);
    }

    public void EliminarUsuario(String rut){
        try{
            Usuario usuarioBorrar = null;
            int rutNum = Integer.parseInt(rut);
            for(int i=0;i<listaAsesorias.size();i++){
                Usuario user = (Usuario)listaAsesorias.get(i);
                if(user.getRun() == rutNum){
                    usuarioBorrar = user;
                }
            }
            if(usuarioBorrar != null){
                listaAsesorias.remove(usuarioBorrar);
                BorrarCapacitacionesRezagadas(rutNum);
            }
        }
        catch(Exception e){
            System.out.println("Error convirtiendo el RUT a numero!");
        }
    }

    public void ListarUsuario(int rut){
        for(int i=0;i<listaAsesorias.size();i++){
            Usuario user = (Usuario)listaAsesorias.get(i);
            if(user.getRun() == rut){
                System.out.println(user.toString());
            }
        }
    }

    public void ListarUsuarios(){
        if(listaAsesorias.size() == 0){
            System.out.println("No hay usuarios a listar.");
        }
        else{
            for(int i=0;i<listaAsesorias.size();i++){
                Usuario user = (Usuario)listaAsesorias.get(i);
                System.out.println((user.getNombre()));
                System.out.println((user.getFechaNacimiento()));
                System.out.println((user.getRun()));
            }
        }
    }

    public void ListaTipoUsuario(int tipo){
        int count = 0;
        for(int i=0;i<listaAsesorias.size();i++){
            IAsesoria user = listaAsesorias.get(i);
            switch(tipo) {
                case 1:
                    if (user.getClass() == Cliente.class) {
                        System.out.println(user.toString());
                    }
                    break;
                case 2:
                    if (user.getClass() == Profesional.class) {
                        System.out.println(user.toString());
                    }
                    break;
                case 3:
                    if (user.getClass() == Administrativo.class) {
                        System.out.println(user.toString());
                    }
                    break;
                default:
                    break;
            }
            count++;
        }
        if(count == 0){
            System.out.println("No se encontraron usuarios de ese tipo en los registros!");
        }
    }

    public void ListarCapacitaciones(){
        if(listaCapacitacion.size() == 0){
            System.out.println("No hay capacitaciones a listar.");
        }
        else{
            for(Capacitacion cap : listaCapacitacion){
                System.out.println(cap.toString());
                ListarUsuario(cap.getRutCliente());
            }
        }
    }

    public Usuario ExisteUsuario(int rut){
        for(int i=0;i<listaAsesorias.size();i++){
            Usuario user = (Usuario)listaAsesorias.get(i);
            if(user.getRun() == rut){
                return user;
            }
        }
        return null;
    }

    public void BorrarCapacitacionesRezagadas(int rut){
        for(Capacitacion cap : listaCapacitacion){
            if(cap.getRutCliente() == rut){
                listaCapacitacion.remove(cap);
            }
        }
    }
}
