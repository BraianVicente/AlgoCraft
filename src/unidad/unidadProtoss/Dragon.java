package unidad.unidadProtoss;

import escudo.Escudo;
import escudo.EscudoInsuficienteException;
import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import vida.Vida;
import vida.VidaAgotadaException;
import mapa.Posicion;


public class Dragon extends UnidadProtoss {

    public Dragon( ) {
        this.nombreUnidad = "Dragon" ;
        this.vidaUnidad = new Vida(100) ;
        this.escudoUnidad = new Escudo(80) ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.transporte = 4 ;
        this.vision = 8 ;
        this.suministro = 2 ;
        this.rangoAtaque = 4 ;
        this.poderAtaqueAereo  = 20 ;
        this.poderAtaqueTerrestre = 20 ;
    }

    public Dragon( Posicion posicion) {
        this.nombreUnidad = "Dragon" ;
        this.vidaUnidad = new Vida(100) ;
        this.escudoUnidad = new Escudo(80) ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.transporte = 4 ;
        this.vision = 8 ;
        this.suministro = 2 ;
        this.rangoAtaque = 4 ;
        this.poderAtaqueAereo  = 20 ;
        this.poderAtaqueTerrestre = 20 ;
        this.posicion = posicion ;
    }



    @Override
    public  void recibirAtaque(Unidad atacante ) {
        try {
            this.escudoUnidad.reducirEscudo(atacante.poderAtaqueTerrestre()) ;
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
        costoUnidad.inicializarRecursos(50,125);
        return costoUnidad;
    }

}
