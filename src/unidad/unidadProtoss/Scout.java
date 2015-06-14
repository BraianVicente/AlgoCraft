package unidad.unidadProtoss;

import mapa.Posicion;
import escudo.Escudo;
import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import vida.Vida;
import escudo.EscudoInsuficienteException ;
import vida.VidaAgotadaException;

public class Scout extends UnidadProtoss{

    public Scout() {
        this.nombreUnidad = "Scout" ;
        this.vidaUnidad = new Vida(150) ;
        this.escudoUnidad = new Escudo(100) ;
        this.tiempoDeConstruccion = new Tiempo(9) ;
        this.vision = 7 ;
        this.suministro = 3 ;
        this.rangoAtaque = 4 ;
        this.poderAtaqueAereo = 14 ;
        this.poderAtaqueTerrestre = 8 ;
    }

    public Scout(Posicion posicion) {
        this.nombreUnidad = "Scout" ;
        this.vidaUnidad = new Vida(150) ;
        this.escudoUnidad = new Escudo(100) ;
        this.tiempoDeConstruccion = new Tiempo(9) ;
        this.vision = 7 ;
        this.suministro = 3 ;
        this.rangoAtaque = 4 ;
        this.poderAtaqueAereo = 14 ;
        this.poderAtaqueTerrestre = 8 ;
        this.posicion = posicion ;
    }

    @Override
    public  void recibirAtaque(Unidad atacante ) {
        try {
            this.escudoUnidad.reducirEscudo(atacante.poderAtaqueAereo()) ;
        } catch ( EscudoInsuficienteException except ) {
            try {
                this.vidaUnidad.quitarVida( except.escudoFaltante ) ;
            } catch (VidaAgotadaException ex) {

            }
        }
    }

    @Override
    public Recursos costoUnidad() {
        Recursos costoUnidad = new Recursos () ;
        costoUnidad.inicializarRecursos(150,300);
        return costoUnidad;
    }

}
