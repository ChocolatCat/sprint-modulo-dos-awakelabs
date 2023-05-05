import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VisitaTerreno {
    private int id;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String comentarios;

    public VisitaTerreno() {
    }

    public VisitaTerreno(int id, int rutCliente, String dia, String hora, String lugar, String comentarios) throws ParseException {
        setId(id);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setComentarios(comentarios);
    }

    public int getId() {
        return id;
    }

    public final void setId(int id) {
        if(id > 0){
            this.id = id;
        }
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public final void setRutCliente(int rutCliente) {
        if(rutCliente > 0){
            this.rutCliente = rutCliente;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        if(comentarios.length() <= 100){
            this.comentarios = comentarios;
        }
    }
}
