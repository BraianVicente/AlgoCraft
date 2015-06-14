package unidad.unidadProtoss;

import mapa.Posicion;
import escudo.Escudo;
import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import vida.Vida;
import escudo.EscudoInsuficienteException ;
import vida.VidaAgotadaException;

public class Zealot extends UnidadProtoss {

    public Zealot(){
        this.nombreUnidad = "Zealot" ;
        this.vidaUnidad = new Vida(100) ;
        this.escudoUnidad = new Escudo(60) ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.transporte = 2 ;
        this.vision = 7 ;
        this.suministro = 2 ;
        this.rangoAtaque = 1 ;
        this.poderAtaqueAereo = 0 ;
        this.poderAtaqueTerrestre = 8 ;
    }

    public Zealot(Posicion posicion){
        this.nombreUnidad = "Zealot" ;
        this.vidaUnidad = new Vida(100) ;
        this.escudoUnidad = new Escudo(60) ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.transporte = 2 ;
        this.vision = 7 ;
        this.suministro = 2 ;
        this.rangoAtaque = 1 ;
        this.poderAtaqueAereo = 0 ;
        this.poderAtaqueTerrestre = 8 ;
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
        Recursos costoUnidad = new Recursos() ;
        costoUnidad.inicializarRecursos(100,0);
        return costoUnidad;
    }

}
