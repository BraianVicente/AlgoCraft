package unidad.unidadTerran;

import energia.Energia;
import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import unidad.UnidadMagica;
import vida.Vida;
import vida.VidaAgotadaException;
import mapa.Posicion;

public class NaveDeCiencia extends UnidadTerran implements UnidadMagica {

public Energia energiaUnidad;

    public  NaveDeCiencia(){
        this.nombreUnidad = "Nave de Ciencia" ;
        this.vidaUnidad = new Vida(200) ;
        this.tiempoDeConstruccion = new Tiempo(10) ;
        this.energiaUnidad = new Energia(50);
        this.transporte = 0 ;
        this.vision = 10 ;
        this.suministro = 2 ;
        this.rangoAtaque = 0 ;
        this.poderAtaqueAereo = 0 ;
        this.poderAtaqueTerrestre = 0 ;
    }

    public  NaveDeCiencia(Posicion posicion){
        this.nombreUnidad = "Nave de Ciencia" ;
        this.vidaUnidad = new Vida(200) ;
        this.tiempoDeConstruccion = new Tiempo(10) ;
        this.energiaUnidad = new Energia(50);
        this.transporte = 0 ;
        this.vision = 10 ;
        this.suministro = 2 ;
        this.rangoAtaque = 0 ;
        this.poderAtaqueAereo = 0 ;
        this.poderAtaqueTerrestre = 0 ;
        this.posicion = posicion ;
    }
    @Override
    public String getNombre() {
        return nombreUnidad;
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
        costoUnidad.inicializarRecursos(100,225);
        return costoUnidad;
    }

    @Override
    public void realizarAtaque(Unidad acatado ){


    }

    public void sumarEnergia(){
        energiaUnidad.aumentarEnergia(10);
    }

}
