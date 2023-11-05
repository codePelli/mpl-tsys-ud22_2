package Ej02.UD22_2.Asignado;

public class Asignado {
	
    private String cientifico;
    private String proyecto;

    public Asignado(String cientifico, String proyecto) {
    	super();
        this.cientifico = cientifico;
        this.proyecto = proyecto;
    }

    public String getCientifico() {
        return cientifico;
    }

    public void setCientifico(String cientifico) {
        this.cientifico = cientifico;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }
}
