package edificio.edificiosProtoss;

import mapa.Posicion;
import recursos.Recursos;
import vida.Vida;
import edificio.Edificio;
import unidad.Unidad;
import unidad.unidadProtoss.Dragon ;
import unidad.unidadProtoss.Zealot ;
import escudo.Escudo;
import tiempo.Tiempo;
import escudo.EscudoInsuficienteException ;
import vida.VidaAgotadaException ;


public class Acceso extends Edificio {

    public Escudo escudoEficicio;

    public Acceso() {
        this.nombreEdificio = "Acceso" ;
        this.tiempoDeConstruccion = new Tiempo(8) ;
        this.vidaEdificio = new Vida(500);
        this.escudoEficicio = new Escudo(500) ;
    }

    public Acceso(Posicion posicion){
        this.posicion = posicion ;
        this.nombreEdificio = "Acceso" ;
        this.tiempoDeConstruccion = new Tiempo(8) ;
        this.vidaEdificio = new Vida(500);
        this.escudoEficicio = new Escudo(500) ;
    }

    @Override
    public  void recibirAtaque(Unidad atacante ) {
        try {
            this.escudoEficicio.reducirEscudo(atacante.poderAtaqueTerrestre()) ;
        } catch ( EscudoInsuficienteException except ) {
            try {
                this.vidaEdificio.quitarVida( except.escudoFaltante ) ;
            } catch (VidaAgotadaException ex) {

            }
        }
    }


    @Override
    public Recursos costoEdificio() {
        costoEdificio = new Recursos() ;
        costoEdificio.inicializarRecursos(150, 0);
        return costoEdificio;
    }

    @Override
    public Recursos recolectar() {
        return null ;
    }

    public Unidad crearZealot() {
        Unidad nuevaUnidad = (Unidad) new Zealot() ;
        return nuevaUnidad;
    }

    @Override
    public boolean estaDestruido(){
        this.escudoEficicio.aumentarEscudo();
        return ( this.vidaEdificio.getVida() <= 0 );
    }


    public Unidad crearDragon() {
        Unidad nuevaUnidad = (Unidad) new Dragon( ) ;
        return nuevaUnidad;
    }
}
