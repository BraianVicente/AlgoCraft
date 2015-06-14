package edificio.edificiosProtoss;

import mapa.Posicion;
import recursos.Recursos;
import unidad.Unidad;
import unidad.unidadProtoss.NaveDeTransporte;
import unidad.unidadProtoss.Scout;
import vida.Vida;
import edificio.Edificio;
import edificio.NecesitaEdificioException;
import escudo.Escudo;
import tiempo.Tiempo;
import escudo.EscudoInsuficienteException ;
import vida.VidaAgotadaException;

public class PuertoEstelar extends Edificio{

    public Escudo escudoEficicio;

    public PuertoEstelar(){
        this.nombreEdificio = "Puerto Estelar" ;
        this.tiempoDeConstruccion = new Tiempo(10) ;
        this.vidaEdificio = new Vida(600);
        this.escudoEficicio = new Escudo(600) ;
    }

    public PuertoEstelar(Posicion posicion){
        this.nombreEdificio = "Puerto Estelar" ;
        this.tiempoDeConstruccion = new Tiempo(10) ;
        this.vidaEdificio = new Vida(600);
        this.escudoEficicio = new Escudo(600) ;
        this.posicion = posicion ;
    }

    @Override
    public Recursos costoEdificio() {
        this.escudoEficicio.aumentarEscudo();
        costoEdificio = new Recursos () ;
        costoEdificio.inicializarRecursos(150, 150);
        return costoEdificio;
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
    public Recursos recolectar() {
        return null ;
    }

    public Unidad crearScout() {
        Unidad nuevaUnidad = (Unidad) new Scout() ;
        return nuevaUnidad;
    }

    public Unidad crearNaveDeTransporte() {
        Unidad nuevaUnidad = (Unidad) new NaveDeTransporte() ;
        return nuevaUnidad;
    }

    @Override
    public boolean estaDestruido(){
        this.escudoEficicio.aumentarEscudo();
        return ( this.vidaEdificio.getVida() <= 0 );
    }

    @Override
    public void depends() throws NecesitaEdificioException{
        Edificio dependencia = new Acceso();
        throw new NecesitaEdificioException (dependencia );
    }
}
