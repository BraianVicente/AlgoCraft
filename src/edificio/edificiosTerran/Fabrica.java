package edificio.edificiosTerran;

import mapa.Posicion;
import recursos.Recursos;
import vida.Vida;
import edificio.Edificio;
import edificio.NecesitaEdificioException;
import edificio.edificiosProtoss.Acceso;
import tiempo.Tiempo;
import unidad.Unidad;
import unidad.unidadTerran.* ;

public class Fabrica extends Edificio {

    public Fabrica(){
        this.nombreEdificio = "Fabrica" ;
        this.tiempoDeConstruccion = new Tiempo(12) ;
        this.vidaEdificio = new Vida(1250);
    }

    public Fabrica(Posicion posicion){
        this.nombreEdificio = "Fabrica" ;
        this.tiempoDeConstruccion = new Tiempo(12) ;
        this.vidaEdificio = new Vida(1250);
        this.posicion = posicion ;
    }

    @Override
    public String getNombre() {
        return nombreEdificio ;
    }

    @Override
    public Recursos costoEdificio() {
        costoEdificio = new Recursos() ;
        costoEdificio.inicializarRecursos(200,100);
        return costoEdificio ;
    }

    @Override
    public Recursos recolectar() {
        return null ;
    }

    public Unidad crearGolliat() {
        Unidad nuevaUnidad = (Unidad) new Golliat() ;
        return nuevaUnidad ;
    }

        @Override
    public void depends() throws NecesitaEdificioException{
        Edificio dependencia = new Acceso();
        throw new NecesitaEdificioException (dependencia );
    }
}
