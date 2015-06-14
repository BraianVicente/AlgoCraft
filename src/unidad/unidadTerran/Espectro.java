package unidad.unidadTerran;

import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import vida.Vida;
import vida.VidaAgotadaException;
import mapa.Posicion;

public class Espectro extends UnidadTerran {

    public  Espectro(){
        this.nombreUnidad = "Espectro" ;
        this.vidaUnidad = new Vida(120) ;
        this.tiempoDeConstruccion = new Tiempo(8) ;
        this.transporte = 0 ;
        this.vision = 7 ;
        this.suministro = 2 ;
        this.rangoAtaque = 5 ;
        this.poderAtaqueAereo = 20 ;
        this.poderAtaqueTerrestre = 8 ;
    }

    public  Espectro(Posicion posicion){
        this.nombreUnidad = "Espectro" ;
        this.vidaUnidad = new Vida(120) ;
        this.tiempoDeConstruccion = new Tiempo(8) ;
        this.transporte = 0 ;
        this.vision = 7 ;
        this.suministro = 2 ;
        this.rangoAtaque = 5 ;
        this.poderAtaqueAereo = 20 ;
        this.poderAtaqueTerrestre = 8 ;
        this.posicion = posicion ;
    }

    @Override
    public String getNombre() {
        return this.nombreUnidad;
    }

    @Override
    public  void recibirAtaque(Unidad atacante ) {
        try {
            this.vidaUnidad.quitarVida( atacante.poderAtaqueAereo() ) ;
        } catch (VidaAgotadaException ex) {

        }
    }

    @Override
    public Recursos costoUnidad() {
        Recursos costoUnidad = new Recursos () ;
        costoUnidad.inicializarRecursos(150,100);
        return costoUnidad;
    }

}
