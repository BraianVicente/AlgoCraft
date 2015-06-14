package poblacion;

import java.util.ArrayList;
import jugador.NoContieneUnidadException;
import recursos.Recursos;
import tiempo.TiempoConsumidoException;
import unidad.Unidad;
import unidad.UnidadMagica;
import unidad.unidadProtoss.UnidadProtoss ;

public class Poblacion {

    private ArrayList<Unidad> listaUnidades ;
    private int alojamientoDisponible ;
    private int limitePoblacion ;
    private ArrayList<Unidad> listaUnidadesEspera;

    public Poblacion(){
        listaUnidades = new ArrayList<Unidad>() ;
        alojamientoDisponible = 0 ;
        limitePoblacion = 200 ;
        listaUnidadesEspera = new ArrayList<>();
    }


    public int getAlojamiento() {
        return this.alojamientoDisponible;
    }

    public void setAlojamiento(int nuevoAlojamiento ) {
        this.alojamientoDisponible = nuevoAlojamiento ;

    }

    public void agregarUnidad(Unidad unidad)
    throws FaltanAlojamientoException, LimiteDePoblacionException{

        if (unidad.suministro() > alojamientoDisponible ) {
            throw new FaltanAlojamientoException();
        }

        if ( (unidad.suministro() + alojamientoDisponible ) > limitePoblacion) {
            throw new LimiteDePoblacionException();
        }
        this.disminuirAlojamiento(unidad.suministro());
        this.listaUnidadesEspera.add(unidad) ;
    }

    public void verificarTiempoDeCreacion(){

        for(Unidad unidad : listaUnidadesEspera){
            try {
                unidad.restarTiempo() ;

            } catch (TiempoConsumidoException e){
                listaUnidades.add(unidad);
            }
        }

        for(Unidad unidad : listaUnidades){
            if(unidad.construccionFinalizada())
                listaUnidadesEspera.remove(unidad);
        }
    }

    public void disminuirAlojamiento(int suministro) {
        this.setAlojamiento(this.getAlojamiento() - suministro);
    }

    public void aumentarAlojamiento(int alojamientoEdificio) {
        this.setAlojamiento(this.getAlojamiento() + alojamientoEdificio);
    }

    public void actualizarUnidades() {
        this.sumarEnergia();
        this.sumarEscudo();
    }

    public void sumarEnergia() {
        for(Unidad unidad : listaUnidades){
            try{
                ((UnidadMagica)unidad).sumarEnergia();
            } catch (ClassCastException e){
            }
        }
    }

    public void sumarEscudo() {
        for(Unidad unidad : listaUnidades){
            try{
                ((UnidadProtoss)unidad).sumarEscudo();
            } catch (ClassCastException e){

            }
        }
    }

    public boolean tieneUnidad(Unidad unidad)  {
        return  ( this.listaUnidades.contains(unidad) )  ;
    }

    public void verificarBajas() {
        ArrayList<Unidad> listaAuxiliar = new ArrayList<Unidad>() ;

        for(Unidad unidad : listaUnidades){
            if(! (unidad.estaMuerta()) ){
                listaAuxiliar.add(unidad);
            } else {
                this.aumentarAlojamiento(unidad.suministro()) ;
            }
        }
        listaUnidades = listaAuxiliar ;
    }



}
