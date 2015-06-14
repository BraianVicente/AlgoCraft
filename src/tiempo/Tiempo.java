package tiempo;

public class Tiempo {

    private int tiempo ;

    public Tiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getTiempo() {
		return tiempo;
    }

    public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
    }

    public void sumarTiempo() {
        tiempo++;
    }

    public void restarTiempo() throws TiempoConsumidoException {
        if(tiempo-- == 0)
            throw new TiempoConsumidoException();
    }
}
