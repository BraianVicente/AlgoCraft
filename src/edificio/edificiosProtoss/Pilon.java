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

public class Pilon extends Edificio{

    public Escudo escudoEficicio;

    @Override
    public int alojamientoEdificio(){
        return 5 ;
    }

    public Pilon(){
        this.nombreEdificio = "Pilon" ;
        this.tiempoDeConstruccion = new Tiempo(5) ;
        this.vidaEdificio = new Vida(300);
        this.escudoEficicio = new Escudo(300) ;
    }

    public Pilon(Posicion posicion){
        this.nombreEdificio = "Pilon" ;
        this.tiempoDeConstruccion = new Tiempo(5) ;
        this.vidaEdificio = new Vida(300);
        this.escudoEficicio = new Escudo(300) ;
        this.posicion = posicion ;
    }

    @Override
    public void recibirAtaque(Unidad atacante ) {
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
    public boolean estaDestruido(){
        this.escudoEficicio.aumentarEscudo();
        return ( this.vidaEdificio.getVida() <= 0 );
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
