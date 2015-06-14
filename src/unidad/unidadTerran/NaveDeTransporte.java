package unidad.unidadTerran;

import java.util.ArrayList;
import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import unidad.unidadProtoss.NaveDeTransporteCompletaException;
import vida.Vida;
import vida.VidaAgotadaException;
import mapa.Posicion;

public class NaveDeTransporte extends UnidadTerran {

    public int capacidadTransporte;
    public ArrayList<Unidad> cantidadTransportados;

    public  NaveDeTransporte(){
        this.nombreUnidad = "Nave de Transporte" ;
        this.vidaUnidad = new Vida(150) ;
        this.tiempoDeConstruccion = new Tiempo(7) ;
        this.transporte = 8 ;
        this.vision = 8 ;
        this.suministro = 2 ;
        this.rangoAtaque = 0 ;
        this.poderAtaqueAereo = 0 ;
        this.poderAtaqueTerrestre = 0 ;
        this.capacidadTransporte = 8;
        this.cantidadTransportados = new ArrayList<Unidad>() ;
    }

    public  NaveDeTransporte(Posicion posicion){
        this.nombreUnidad = "Nave de Transporte" ;
        this.vidaUnidad = new Vida(150) ;
        this.tiempoDeConstruccion = new Tiempo(7) ;
        this.transporte = 8 ;
        this.vision = 8 ;
        this.suministro = 2 ;
        this.rangoAtaque = 0 ;
        this.poderAtaqueAereo = 0 ;
        this.poderAtaqueTerrestre = 0 ;
        this.capacidadTransporte = 8;
        this.cantidadTransportados = new ArrayList<Unidad>() ;
        this.posicion = posicion ;
    }


    @Override
    public Recursos costoUnidad() {
        Recursos costoUnidad = new Recursos () ;
        costoUnidad.inicializarRecursos(100,100) ;
        return costoUnidad ;
    }


    @Override
    public  void recibirAtaque(Unidad atacante ) {
        try {
            this.vidaUnidad.quitarVida( atacante.poderAtaqueTerrestre() ) ;
            } catch (VidaAgotadaException ex) {

            }
    }

    @Override
    public String getNombre() {
        return nombreUnidad;
    }

    public boolean agregarUnidadParaTransportar(Unidad unidad){

        try{
            if(this.cantidadTransportados.size() == this.capacidadTransporte)
                throw new NaveDeTransporteCompletaException();
            this.cantidadTransportados.add(unidad);
            return true;
        }catch(NaveDeTransporteCompletaException e){
            return false;
        }
    }

}
