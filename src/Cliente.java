import java.text.ParseException;

//Principio de Sustitución de Liskov - Podemos usar el metodo analizarUsuario de Usuario o Cliente aca
public class Cliente extends Usuario{
    private String nombres;
    private String apellidos;
    private String telefono;
    private String afp;
    private int sisSalud;
    private String direccion;
    private String comuna;
    private int edad;

    public Cliente() {
    }

    public Cliente(String nombre, String fechaNacimiento, int run, String nombres, String apellidos, String telefono, String afp, int sisSalud, String direccion, String comuna, int edad){
        super(nombre, fechaNacimiento, run);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sisSalud = sisSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public String getNombres() {
        return nombres;
    }

    public final void setNombres(String nombres) {
        if(nombres.length() >= 5 && nombres.length() <= 30){
            this.nombres = nombres;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public final void setApellidos(String apellidos) {
        if(apellidos.length() >= 5 && nombres.length() <= 30){
            this.apellidos = apellidos;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public final void setTelefono(String telefono) {
        if(telefono.length() > 0){
            this.telefono = telefono;
        }
    }

    public String getAfp() {
        return afp;
    }

    public final void setAfp(String afp) {
        if(afp.length() >= 4 && afp.length() <= 30){
            this.afp = afp;
        }
    }

    public int getSisSalud() {
        return sisSalud;
    }

    public void setSisSalud(int sisSalud) {
        this.sisSalud = sisSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public final void setDireccion(String direccion) {
        if(direccion.length() <= 70){
            this.direccion = direccion;
        }
    }

    public String getComuna() {
        return comuna;
    }

    public final void setComuna(String comuna) {
        if(comuna.length() <= 50){
            this.comuna = comuna;
        }
    }

    public int getEdad() {
        return edad;
    }

    public final void setEdad(int edad) {
        if(edad >= 0 && edad < 150){
            this.edad = edad;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Cliente{" +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", afp='" + afp + '\'' +
                ", sisSalud=" + sisSalud +
                ", direccion='" + direccion + '\'' +
                ", comuna='" + comuna + '\'' +
                ", edad=" + edad +
                '}';
    }

    public String obtenerNombre(){
        return this.nombres + " " + this.apellidos;
    }

    public String obtenerSistemaSalud(){
        switch(this.sisSalud){
            case 1:
                return "Fonasa";
            case 2:
                return "Isapre";
            default:
                return "ERROR";
        }
    }

    @Override
    public String analizarUsuario() {
        return super.analizarUsuario() + ".\n" + this.direccion + ", " + this.comuna;
    }
}
