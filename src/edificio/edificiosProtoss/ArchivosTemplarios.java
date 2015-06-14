package edificio.edificiosProtoss;

import mapa.Posicion;
import recursos.Recursos;
import unidad.Unidad;
import edificio.Edificio;
import edificio.NecesitaEdificioException;
import edificio.edificiosProtoss.PuertoEstelar ;
import escudo.Escudo;
import tiempo.Tiempo;
import unidad.unidadProtoss.AltoTemplario ;
import vida.Vida;
import vida.VidaAgotadaException;
import escudo.EscudoInsuficienteException ;


public class ArchivosTemplarios extends Edificio{

    public Escudo escudoEficicio;

    public ArchivosTemplarios(){
        this.nombreEdificio = "Archivos Templarios" ;
        this.tiempoDeConstruccion = new Tiempo(9) ;
        this.vidaEdificio = new Vida(500);
        this.escudoEficicio = new Escudo(500) ;

    }

    public ArchivosTemplarios(Posicion posicion){
        this.nombreEdificio = "Archivos Templarios" ;
        this.tiempoDeConstruccion = new Tiempo(9) ;
        this.vidaEdificio = new Vida(500);
        this.escudoEficicio = new Escudo(500) ;
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
        costoEdificio = new Recursos () ;
        costoEdificio.inicializarRecursos(150, 200);
        return costoEdificio;
    }

    @Override
    public Recursos recolectar() {
        return null ;
    }

    public Unidad crearAltoTemplario() {
        Unidad nuevaUnidad = new AltoTemplario() ;
        return nuevaUnidad;
    }

    @Override
    public boolean estaDestruido(){
        this.escudoEficicio.aumentarEscudo();
        return ( this.vidaEdificio.getVida() <= 0 );
    }

    @Override
    public void depends() throws NecesitaEdificioException{

        throw new NecesitaEdificioException ( new  PuertoEstelar()) ;
    }

}
