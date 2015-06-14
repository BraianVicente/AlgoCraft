package unidad.unidadTerran;

import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import vida.Vida;
import vida.VidaAgotadaException;
import mapa.Posicion;

public class Golliat extends UnidadTerran{

    public Golliat(){
        this.nombreUnidad = "Golliat" ;
        this.vidaUnidad = new Vida(125) ;
        this.tiempoDeConstruccion = new Tiempo(6) ;
        this.transporte = 8 ;
        this.vision = 8 ;
        this.suministro = 2 ;
        this.rangoAtaque = 5 ;
        this.poderAtaqueAereo = 10 ;
        this.poderAtaqueTerrestre = 12 ;
    }

    public Golliat(Posicion posicion){
        this.nombreUnidad = "Golliat" ;
        this.vidaUnidad = new Vida(125) ;
        this.tiempoDeConstruccion = new Tiempo(6) ;
        this.transporte = 8 ;
        this.vision = 8 ;
        this.suministro = 2 ;
        this.rangoAtaque = 5 ;
        this.poderAtaqueAereo = 10 ;
        this.poderAtaqueTerrestre = 12 ;
        this. posicion = posicion ;
    }

    @Override
    public String getNombre() {
        return nombreUnidad;
    }

    @Override
    public  void recibirAtaque(Unidad atacante ) {
        try {
            this.vidaUnidad.quitarVida( atacante.poderAtaqueTerrestre() ) ;
        } catch (VidaAgotadaException ex) {

        }
    }

    @Override
    public Recursos costoUnidad() {
        Recursos costoUnidad = new Recursos();
        costoUnidad.inicializarRecursos(100,50);
        return costoUnidad;
    }


}
