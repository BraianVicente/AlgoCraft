package edificio.edificiosTerran;

import mapa.Posicion;
import recursos.Recursos;
import vida.Vida;
import edificio.Edificio;
import tiempo.Tiempo;
import unidad.Unidad;

public class CentroDeMineral extends Edificio {

    public CentroDeMineral () {
        this.nombreEdificio = "Centro de mineral" ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.vidaEdificio = new Vida(500);
    }

    public CentroDeMineral (Posicion posicion) {
        this.nombreEdificio = "Centro de mineral" ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.vidaEdificio = new Vida(500);
        this.posicion = posicion ;
    }


    @Override
    public Recursos recolectar(){
        Recursos nuevosRecursos = new Recursos();
        nuevosRecursos.inicializarRecursos(10, 0);
        return nuevosRecursos ;
    }

    @Override
    public String getNombre() {
        return nombreEdificio;
    }

    @Override
    public Recursos costoEdificio() {
        costoEdificio = new Recursos();
        costoEdificio.inicializarRecursos(50,0);
        return costoEdificio ;
    }



}
