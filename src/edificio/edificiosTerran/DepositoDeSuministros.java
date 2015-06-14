package edificio.edificiosTerran;

import mapa.Posicion;
import recursos.Recursos;
import vida.Vida;
import edificio.Edificio;
import tiempo.Tiempo;
import unidad.Unidad;

public class DepositoDeSuministros extends Edificio {

    public DepositoDeSuministros(){
        nombreEdificio = "Deposito de Suministros" ;
        this.tiempoDeConstruccion = new Tiempo(6) ;
        this.vidaEdificio = new Vida(500);
    }

    public DepositoDeSuministros(Posicion posicion){
        nombreEdificio = "Deposito de Suministros" ;
        this.tiempoDeConstruccion = new Tiempo(6) ;
        this.vidaEdificio = new Vida(500);
        this.posicion = posicion ;
    }

    @Override
    public int alojamientoEdificio(){
        return 5 ;
    }


    @Override
    public String getNombre() {
        return nombreEdificio;
    }

    @Override
    public Recursos costoEdificio() {
        costoEdificio = new Recursos() ;
        costoEdificio.inicializarRecursos(100,0) ;
        return costoEdificio;
    }

    @Override
    public Recursos recolectar() {
        return null ;
    }
}
