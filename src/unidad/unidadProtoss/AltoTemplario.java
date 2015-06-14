package unidad.unidadProtoss;

import energia.Energia;
import escudo.Escudo;
import recursos.Recursos;
import tiempo.Tiempo;
import unidad.Unidad;
import vida.Vida;
import escudo.EscudoInsuficienteException ;
import energia.Energia;
import mapa.Posicion;


import java.util.ArrayList;

import mapa.Posicion;
import unidad.UnidadMagica;
import vida.VidaAgotadaException;
import jugador.Jugador;

public class AltoTemplario extends UnidadProtoss implements UnidadMagica {

    public Energia energiaUnidad;

    public AltoTemplario(){
        this.nombreUnidad = "Alto Templario" ;
        this.vidaUnidad = new Vida(40) ;
        this.escudoUnidad = new Escudo(40) ;
        this.tiempoDeConstruccion = new Tiempo(8) ;
        this.energiaUnidad = new Energia(50);
        this.poderAtaqueAereo = 100 ;
        this.poderAtaqueTerrestre = 100 ;
        this.transporte = 2 ;
        this.rangoAtaque = 0 ;
        this.suministro = 2 ;
        this.vision = 7 ;
    }

    public AltoTemplario(Posicion posicion){
        this.nombreUnidad = "Alto Templario" ;
        this.vidaUnidad = new Vida(40) ;
        this.escudoUnidad = new Escudo(40) ;
        this.tiempoDeConstruccion = new Tiempo(8) ;
        this.energiaUnidad = new Energia(50);
        this.poderAtaqueAereo = 100 ;
        this.poderAtaqueTerrestre = 100 ;
        this.transporte = 2 ;
        this.rangoAtaque = 0 ;
        this.suministro = 2 ;
        this.vision = 7 ;
        this.posicion = posicion ;
    }

    public AltoTemplario(int tiempo){

        this.nombreUnidad = "Alto Templario" ;
        this.escudoUnidad = new Escudo(40) ;
        this.tiempoDeConstruccion = new Tiempo(tiempo) ;
        this.transporte = 2 ;
        this.rangoAtaque = 0 ;
        this.suministro = 0 ;
        this.vision = 7 ;
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
        costoUnidad.inicializarRecursos(150,50);
        return costoUnidad;
    }

    @Override
    public void realizarAtaque(Unidad acatado ){

    }

    public ArrayList<Unidad> magiaAlucinacion(){

        AltoTemplario alucinacion_0 = new AltoTemplario(0);
        AltoTemplario alucinacion_1 = new AltoTemplario(0);
        ArrayList<Unidad> lista = new ArrayList<>() ;
        return lista ;
    }


    public void sumarEnergia(){
        energiaUnidad.aumentarEnergia(15);
    }

}
