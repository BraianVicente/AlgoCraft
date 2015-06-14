package unidad.unidadTerran;

import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import vida.Vida;
import vida.VidaAgotadaException;
import mapa.Posicion;

public class Marine extends UnidadTerran {

    public  Marine(){
        this.nombreUnidad = "Marine" ;
        this.vidaUnidad = new Vida(40) ;
        this.tiempoDeConstruccion = new Tiempo(3) ;
        this.transporte = 1 ;
        this.vision = 7 ;
        this.suministro = 1 ;
        this.rangoAtaque = 4 ;
        this.poderAtaqueAereo = 6 ;
        this.poderAtaqueTerrestre = 6 ;
    }
    public  Marine(Posicion posicion){
        this.nombreUnidad = "Marine" ;
        this.vidaUnidad = new Vida(40) ;
        this.tiempoDeConstruccion = new Tiempo(3) ;
        this.transporte = 1 ;
        this.vision = 7 ;
        this.suministro = 1 ;
        this.rangoAtaque = 4 ;
        this.poderAtaqueAereo = 6 ;
        this.poderAtaqueTerrestre = 6 ;
        this.posicion = posicion ;
    }

    @Override
    public  void recibirAtaque(Unidad atacante )  {
        try {
            this.vidaUnidad.quitarVida( atacante.poderAtaqueTerrestre() ) ;
        } catch (VidaAgotadaException ex) {

        }

    }

    @Override
    public String getNombre() {
        return nombreUnidad;
    }

    @Override
    public Recursos costoUnidad() {
        Recursos costoUnidad = new Recursos () ;
        costoUnidad.inicializarRecursos(50,0);
        return costoUnidad;
    }

}
