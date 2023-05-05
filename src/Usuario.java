import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//Principio de Abierto-Cerrado - Es la base de sus hijas
public class Usuario implements IAsesoria{
    private String nombre;
    private String fechaNacimiento;
    private int run;

    public Usuario() {
        this.nombre = "";
        this.fechaNacimiento = "";
        this.run = 0;
    }

    public Usuario(String nombre, String fechaNacimiento, int run) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if(nombre.length() >= 10 && nombre.length() <= 50){
            this.nombre = nombre;
        }
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public final void setFechaNacimiento(String fechaNacimiento) throws ParseException {
        this.fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento).toString();
    }

    public int getRun() {
        return run;
    }

    public final void setRun(int run) {
        if(run < 99999999){
            this.run = run;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", run='" + run + '\'' +
                '}';
    }

    public String mostrarEdad(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        LocalDate dob = LocalDate.parse(fechaNacimiento, formatter);
        Period period = Period.between(dob, now);
        return "El usuario tiene " + period.getYears() + " anios";
    }

    public String analizarUsuario(){
        return this.nombre + ", " + this.run;
    }
}
