package edificio.edificiosTerran;

import mapa.Posicion;
import recursos.Recursos;
import vida.Vida;
import edificio.Edificio;
import tiempo.Tiempo;
import unidad.Unidad;
import unidad.unidadTerran.Marine ;

public class Barraca extends Edificio {


    public Barraca () {
        this.nombreEdificio = "Barraca" ;
        this.tiempoDeConstruccion = new Tiempo(15) ;
        this.vidaEdificio = new Vida(1000);
    }

    public Barraca (Posicion posicion) {
        this.nombreEdificio = "Barraca" ;
        this.tiempoDeConstruccion = new Tiempo(15) ;
        this.vidaEdificio = new Vida(1000);
        this.posicion = posicion ;
    }

    @Override
    public String getNombre() {
        return nombreEdificio;
    }

    @Override
    public Recursos costoEdificio() {
        costoEdificio = new Recursos() ;
        costoEdificio.inicializarRecursos(150, 0);
        return costoEdificio ;
    }

    @Override
    public Recursos recolectar() {
        return null ;
    }

    public Unidad crearMarine() {
        Unidad nuevaUnidad = (Unidad) new Marine() ;
        return nuevaUnidad ;
    }

}
