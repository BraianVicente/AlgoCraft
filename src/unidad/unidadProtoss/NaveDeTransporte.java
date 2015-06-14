package unidad.unidadProtoss;

import escudo.Escudo;
import java.util.ArrayList;
import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import vida.Vida;
import escudo.EscudoInsuficienteException ;
import vida.VidaAgotadaException;
import mapa.Posicion;


public class NaveDeTransporte extends UnidadProtoss{

    public int capacidadTransporte;
    public ArrayList<Unidad> cantidadTransportados;

    public NaveDeTransporte() {
        this.nombreUnidad = "Nave de Transporte" ;
        this.vidaUnidad = new Vida(80) ;
        this.escudoUnidad = new Escudo(60) ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.transporte = 0 ;
        this.vision = 8 ;
        this.suministro = 2 ;
        this.rangoAtaque = 0 ;
        this.poderAtaqueAereo  = 0 ;
        this.poderAtaqueTerrestre = 0 ;
        this.capacidadTransporte = 8;
        this.cantidadTransportados = new ArrayList<>() ;
    }

    public NaveDeTransporte(Posicion posicion) {
        this.nombreUnidad = "Nave de Transporte" ;
        this.vidaUnidad = new Vida(80) ;
        this.escudoUnidad = new Escudo(60) ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.transporte = 0 ;
        this.vision = 8 ;
        this.suministro = 2 ;
        this.rangoAtaque = 0 ;
        this.poderAtaqueAereo  = 0 ;
        this.poderAtaqueTerrestre = 0 ;
        this.capacidadTransporte = 8;
        this.cantidadTransportados = new ArrayList<>() ;
        this.posicion = posicion ;
    }


    @Override
    public Recursos costoUnidad() {
        Recursos costoUnidad = new Recursos () ;
        costoUnidad.inicializarRecursos(0,200);
        return costoUnidad;
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

    public boolean agregarUnidadParaTransportar(Unidad unidad){
        try {
            if(this.cantidadTransportados.size() == this.capacidadTransporte){
                throw new NaveDeTransporteCompletaException();
            }
            this.cantidadTransportados.add(unidad);
            return true;
        } catch (NaveDeTransporteCompletaException e) {
            return false;
        }
    }

}
