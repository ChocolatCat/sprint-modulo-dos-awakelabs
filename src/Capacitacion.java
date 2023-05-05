import java.util.Arrays;

public class Capacitacion {
    //ID Interno de la empresa
    private int id;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private double duracion;
    private int cantAsistentes;

    public Capacitacion() {
        this.id = 0;
        this.rutCliente = 0;
        this.dia = "";
        this.hora = "";
        this.lugar = "";
        this.duracion = 0.0;
        this.cantAsistentes = 0;
    }

    public Capacitacion(int id, int rutCliente, String dia, String hora, String lugar, double duracion, int cantAsistentes) {
        setId(id);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setDuracion(duracion);
        setCantAsistentes(cantAsistentes);
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

    public final void setDia(String dia) {
        String[] diasSemana = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
        if(Arrays.asList(diasSemana).contains(dia.toLowerCase())){
            this.dia= dia;
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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

    public double getDuracion() {
        return duracion;
    }

    public final void setDuracion(double duracion) {
        if(duracion > 0){
            this.duracion = duracion;
        }
    }

    public int getCantAsistentes() {
        return cantAsistentes;
    }

    public final void setCantAsistentes(int cantAsistentes) {
        if(cantAsistentes > 0 && cantAsistentes < 1000){
            this.cantAsistentes = cantAsistentes;
        }
    }

    @Override
    public String toString() {
        return "Capacitacion{" +
                "id=" + id +
                ", rutCliente='" + rutCliente + '\'' +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", duracion=" + duracion +
                ", cantAsistentes=" + cantAsistentes +
                '}';
    }

    public String mostrarDetalle(){
        return "La capacitacion sera en " + this.lugar + " a las " + this.hora + " del dia " + this.dia
                + " y durara " + this.duracion * 60 + " minutos";
    }
}
