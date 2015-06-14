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
public class PuertoEstelar extends Edificio {


    public PuertoEstelar () {
        this.nombreEdificio = "Puerto Estelar" ;
        this.tiempoDeConstruccion = new Tiempo(10) ;
        this.vidaEdificio = new Vida(1300);
    }

    public PuertoEstelar (Posicion posicion) {
        this.nombreEdificio = "Puerto Estelar" ;
        this.tiempoDeConstruccion = new Tiempo(10) ;
        this.vidaEdificio = new Vida(1300);
        this.posicion = posicion ;
    }


    @Override
    public String getNombre() {
        return nombreEdificio ;
    }

    @Override
    public Recursos costoEdificio() {
        costoEdificio = new Recursos() ;
        costoEdificio.inicializarRecursos(150,100);
        return costoEdificio ;
    }

    @Override
    public Recursos recolectar() {
        return null ;
    }


    public Unidad crearEspectro() {
        Unidad nuevaUnidad = (Unidad) new Espectro() ;
        return nuevaUnidad;
    }


    public Unidad crearNaveDeCiencia() {
        Unidad nuevaUnidad = new NaveDeCiencia() ;
        return nuevaUnidad;
    }


    public Unidad crearNaveDeTransporte() {
        Unidad nuevaUnidad = (Unidad) new NaveDeTransporte() ;
        return nuevaUnidad;
    }

        @Override
    public void depends() throws NecesitaEdificioException{
        Edificio dependencia = new Acceso();
        throw new NecesitaEdificioException (dependencia );
    }
}
