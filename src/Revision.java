public class Revision {
    private int id;
    private int idVisita;
    private String nombreRevision;
    private String detalle;
    //1: sin problemas, 2: con observaciones, 3: no aprueba
    private int estado;

    public Revision() {
    }

    public Revision(int id, int idVisita, String nombreRevision, String detalle, int estado) {
        setId(id);
        setIdVisita(idVisita);
        setNombreRevision(nombreRevision);
        setDetalle(detalle);
        setEstado(estado);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        }
    }

    public int getIdVisita() {
        return idVisita;
    }

    public final void setIdVisita(int idVisita) {
        if(idVisita > 0){
            this.idVisita = idVisita;
        }
    }

    public String getNombreRevision() {
        return nombreRevision;
    }

    public final void setNombreRevision(String nombreRevision) {
        if(nombreRevision.length() >= 10 && nombreRevision.length() <= 50){
            this.nombreRevision = nombreRevision;
        }
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        if(detalle.length() <= 100){
            this.detalle = detalle;
        }
    }

    public int getEstado() {
        return estado;
    }

    public final void setEstado(int estado) {
        switch (estado){
            case 1:
            case 2:
            case 3:
                this.estado = estado;
                break;
            default:
                break;
        }
    }
}
