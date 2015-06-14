package edificio;

import mapa.Mapeable;
import mapa.Posicion;
import recursos.Recursos;
import tiempo.Tiempo;
import tiempo.TiempoConsumidoException;
import unidad.Unidad;
import vida.Vida;
import vida.VidaAgotadaException;

public abstract class Edificio implements Mapeable{

    public String nombreEdificio ;
    public Recursos costoEdificio ;
    public abstract Recursos costoEdificio() ;
    public abstract Recursos recolectar() ;
    public Tiempo tiempoDeConstruccion ;
    public Vida vidaEdificio ;
    public int alojamientoEdificio ;
    public Posicion posicion ;

    public int alojamientoEdificio(){
        return 0 ;
    }

    public void recibirAtaque(Unidad atacante ){
        try {
            vidaEdificio.quitarVida(atacante.poderAtaqueTerrestre());
        } catch (VidaAgotadaException ex) {

        }
    }

    public String getNombre(){
        return this.nombreEdificio ;
    }

    public Tiempo getTiempo(){

        return tiempoDeConstruccion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edificio other = (Edificio) obj;
        if (nombreEdificio != other.nombreEdificio)
            return false;
        return true;
    }

    public void depends() throws NecesitaEdificioException{
        return ;
    }

    public void restarTiempo() throws TiempoConsumidoException {

        tiempoDeConstruccion.restarTiempo();
    }

    public boolean construccionFinalizada() {
        return (tiempoDeConstruccion.getTiempo() == 0);
    }

    public boolean estaDestruido(){
        return ( this.vidaEdificio.getVida() <= 0 );
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion ;
    }

    @Override
    public Posicion obtenerPosicion() {
        return this.posicion;
    }

}
