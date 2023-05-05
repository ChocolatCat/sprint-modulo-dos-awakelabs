import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Accidente {
    private int id;
    private String dia;
    private String hora;
    private String lugar;
    private String origen;
    private String[] consecuencias;

    public Accidente() {
    }

    public Accidente(int id, String dia, String hora, String lugar, String origen, String[] consecuencias) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.origen = origen;
        this.consecuencias = consecuencias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        }
    }

    public String getDia() {
        return dia;
    }

    public final void setDia(String dia) throws ParseException {
        this.dia = new SimpleDateFormat("dd/MM/yyyy").parse(dia).toString();
    }

    public String getHora() {
        return hora;
    }

    public final void setHora(String hora) {
        if(hora.matches("^(?:\\d|[01]\\d|2[0-3]):[0-5]\\d$")){
            this.hora = hora;
        }
    }

    public String getLugar() {
        return lugar;
    }

    public final void setLugar(String lugar) {
        if(lugar.length() >= 10 && lugar.length() <= 50){
            this.lugar = lugar;
        }
    }

    public String getOrigen() {
        return origen;
    }

    public final void setOrigen(String origen) {
        if(origen.length() <= 100){
            this.origen = origen;
        }
    }

    public String[] getConsecuencias() {
        return consecuencias;
    }

    public final void setConsecuencias(String[] consecuencias) {
        if(consecuencias.length <= 100){
            this.consecuencias = consecuencias;
        }
    }
}
