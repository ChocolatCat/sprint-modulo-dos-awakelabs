import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Profesional extends Usuario{
    private String titulo;
    private String fechaIngreso;

    public Profesional() {
    }

    public Profesional(String nombre, String fechaNacimiento, int run, String titulo, String fechaIngreso) {
        super(nombre, fechaNacimiento, run);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public final void setTitulo(String titulo) {
        if(titulo.length() >= 10 && titulo.length() <= 50){
            this.titulo = titulo;
        }
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public final void setFechaIngreso(String fechaIngreso) throws ParseException {
        this.fechaIngreso = new SimpleDateFormat("dd/MM/yyyy").parse(fechaIngreso).toString();
    }

    @Override
    public String toString() {
        return super.toString() + ", Profesional{" +
                "titulo='" + titulo + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                '}';
    }

    @Override
    public String analizarUsuario() {
        return super.analizarUsuario() + "\n" + this.titulo + ", " + this.fechaIngreso;
    }
}
