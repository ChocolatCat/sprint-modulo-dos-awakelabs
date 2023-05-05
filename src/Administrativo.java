import java.text.ParseException;

//Aplicacion de Responsabilidad unica. Se subdivide Cliente para acoplar caracteristicas especificas.
public class Administrativo extends Usuario{
    private String area;
    private String experienciaPrevia;

    public Administrativo() {
    }

    public Administrativo(String nombre, String fechaNacimiento, int run, String area, String experienciaPrevia) {
        super(nombre, fechaNacimiento, run);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    public String getArea() {
        return area;
    }

    public final void setArea(String area) {
        if(area.length() >= 5 && area.length() <= 20){
            this.area = area;
        }
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public final void setExperienciaPrevia(String experienciaPrevia) {
        if(experienciaPrevia.length() <= 100){
            this.experienciaPrevia = experienciaPrevia;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Administrativo{" +
                "area='" + area + '\'' +
                ", experienciaPrevia='" + experienciaPrevia + '\'' +
                '}';
    }

    @Override
    public String analizarUsuario() {
        return super.analizarUsuario() + "\n" + this.area + ", " + this.experienciaPrevia;
    }
}
