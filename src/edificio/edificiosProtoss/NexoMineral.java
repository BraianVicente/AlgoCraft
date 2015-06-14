package edificio.edificiosProtoss;

import mapa.Posicion;
import recursos.Recursos;
import vida.Vida;
import vida.VidaAgotadaException;
import edificio.Edificio;
import escudo.Escudo;
import tiempo.Tiempo;
import escudo.EscudoInsuficienteException ;
import unidad.Unidad ;


public class NexoMineral extends Edificio {

    public Escudo escudoEficicio;

    public NexoMineral() {
        this.nombreEdificio = "Nexo mineral" ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.vidaEdificio = new Vida(250);
        this.escudoEficicio = new Escudo(250) ;
    }

    public NexoMineral(Posicion posicion ) {
        this.nombreEdificio = "Nexo mineral" ;
        this.tiempoDeConstruccion = new Tiempo(4) ;
        this.vidaEdificio = new Vida(250);
        this.escudoEficicio = new Escudo(250) ;
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
        costoEdificio = new Recursos();
        costoEdificio.inicializarRecursos(50, 0);
        return costoEdificio ;
    }

    @Override
    public void depends(){

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
        nuevosRecursos.inicializarRecursos(10, 0);
        return nuevosRecursos ;
    }

}
