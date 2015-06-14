package edificio.edificiosTerran ;

import mapa.Posicion;
import recursos.Recursos;
import tiempo.Tiempo;
import vida.Vida;
import edificio.Edificio;



public class Refineria extends Edificio {

    public Refineria () {
        this.nombreEdificio = "Refineria" ;
        this.tiempoDeConstruccion = new Tiempo(6) ;
        this.vidaEdificio = new Vida(750);
    }

    public Refineria (Posicion posicion) {
        this.nombreEdificio = "Refineria" ;
        this.tiempoDeConstruccion = new Tiempo(6) ;
        this.vidaEdificio = new Vida(750);
        this.posicion = posicion ;
    }

    @Override
    public Recursos recolectar(){
        Recursos nuevosRecursos = new Recursos();
        nuevosRecursos.inicializarRecursos(0,10);
        return nuevosRecursos ;
    }

    @Override
    public String getNombre() {
        return nombreEdificio;
    }

    @Override
    public Recursos costoEdificio() {
        costoEdificio = new Recursos();
        costoEdificio.inicializarRecursos(100,0);
        return costoEdificio ;
    }



}
