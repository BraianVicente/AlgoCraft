package unidad.unidadProtoss;

import mapa.Posicion;
import edificio.Edificio;
import escudo.Escudo;
import recursos.Recursos;
import tiempo.Tiempo;
import tiempo.TiempoConsumidoException;
import unidad.Unidad;
import vida.Vida;

public abstract class UnidadProtoss implements Unidad {

    public Escudo escudoUnidad;
    public String nombreUnidad ;
    public int transporte ;
    public int vision ;
    public int suministro ;
    public int rangoAtaque ;
    public int poderAtaqueAereo ;
    public int poderAtaqueTerrestre ;
    public Vida vidaUnidad ;
    public Recursos costoUnidad ;
    public Tiempo tiempoDeConstruccion ;
    public int ataquesPorTurno = 1 ;
    public Posicion posicion ;

    @Override
    public void actualizarAtaque(){
        this.ataquesPorTurno = 1 ;
    }

    public void sumarEscudo() {
        this.escudoUnidad.aumentarEscudo();
    }

    @Override
    public String getNombre(){

        return nombreUnidad;
    }

    @Override
    public abstract Recursos costoUnidad();

    @Override
    public abstract void recibirAtaque(Unidad atacante );

    @Override
    public  void realizarAtaque(Unidad atacado ) {
        if (!(atacado.estaMuerta() ))
            atacado.recibirAtaque(this) ;

    }

    @Override
    public  void realizarAtaque(Edificio atacado ) {
        atacado.recibirAtaque(this) ;
    }

    @Override
    public int suministro(){
        return this.suministro ;
    }

    @Override
    public int poderAtaqueAereo() {
        return this.poderAtaqueAereo ;
    }

    @Override
    public int poderAtaqueTerrestre() {
        return this.poderAtaqueTerrestre ;
    }

    @Override
    public void restarTiempo() throws TiempoConsumidoException {

        tiempoDeConstruccion.restarTiempo();
    }

    @Override
    public boolean construccionFinalizada() {

        return (tiempoDeConstruccion.getTiempo() == 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UnidadProtoss other = (UnidadProtoss) obj;
        if (nombreUnidad != other.nombreUnidad )
            return false;
        return true;
    }

    @Override
    public boolean estaMuerta(){
        return (this.vidaUnidad.getVida() <= 0) ;
    }

    @Override
    public boolean esTerrestre(){

        return (transporte != 0);
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
