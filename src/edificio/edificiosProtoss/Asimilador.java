package edificio.edificiosProtoss;

import mapa.Posicion;
import recursos.Recursos;
import vida.Vida;
import edificio.Edificio;
import escudo.Escudo;
import tiempo.Tiempo;
import escudo.EscudoInsuficienteException ;
import unidad.Unidad ;
import vida.VidaAgotadaException ;

public class Asimilador extends Edificio {

    public Escudo escudoEficicio;

    public Asimilador() {
        this.nombreEdificio = "Asimilador" ;
        this.tiempoDeConstruccion = new Tiempo(6) ;
        this.vidaEdificio = new Vida(450) ;
        this.escudoEficicio = new Escudo(450) ;
    }

    public Asimilador(Posicion posicion) {
        this.nombreEdificio = "Asimilador" ;
        this.tiempoDeConstruccion = new Tiempo(6) ;
        this.vidaEdificio = new Vida(450) ;
        this.escudoEficicio = new Escudo(450) ;
        this.posicion = posicion ;
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
        costoEdificio.inicializarRecursos(100, 0);
        return costoEdificio ;
    }

    @Override
    public boolean estaDestruido(){
        this.escudoEficicio.aumentarEscudo();
        return ( this.vidaEdificio.getVida() <= 0 );
    }

    @Override
    public Recursos recolectar(){
        Recursos nuevosRecursos = new Recursos();
        nuevosRecursos = new Recursos() ;
        nuevosRecursos.inicializarRecursos(0, 10);
        return nuevosRecursos;
    }

}
