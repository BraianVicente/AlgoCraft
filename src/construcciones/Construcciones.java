package construcciones;

import java.util.ArrayList;

import jugador.NoSeAgregoEdificioException;
import recursos.Recursos;
import tiempo.TiempoConsumidoException;
import edificio.Edificio;
import edificio.NecesitaEdificioException;

public class Construcciones {

    private ArrayList<Edificio> listaEdificios ;
    private ArrayList<Edificio> listaEdificiosEspera;

    public Construcciones(){
        listaEdificios = new ArrayList<>() ;
        listaEdificiosEspera = new ArrayList<>();

    }

    public Recursos recolectar(){
        Recursos recursosRecoleccion = new Recursos() ;
        recursosRecoleccion.inicializarRecursos(0,0) ;

        for( Edificio edificio : listaEdificios ){
            try {
                recursosRecoleccion.agregarRecursos( edificio.recolectar() ) ;
            } catch (Exception e) { }
        }
        return recursosRecoleccion ;
    }

    public void verificarTiempoDeCreacion(){
        for(Edificio edificio : listaEdificiosEspera){
            try {
                edificio.restarTiempo() ;
            } catch (TiempoConsumidoException e){
                listaEdificios.add(edificio);
            }
        }

        for(Edificio edificio : listaEdificios){
            if(edificio.construccionFinalizada())
                listaEdificiosEspera.remove(edificio);
        }
    }

    public boolean tieneEdificio(Edificio unEdificio) {
        return (this.listaEdificios.contains(unEdificio) );
    }

    public void agregarEdificio(Edificio edificio) throws NoSeAgregoEdificioException {
        try {
            edificio.depends() ;
        } catch ( NecesitaEdificioException except) {
            Edificio dependencia = except.edificioNecesario ;

            if (! (this.tieneEdificio(dependencia) ) ) {
                throw new NoSeAgregoEdificioException() ;
            }
        }

        listaEdificiosEspera.add(edificio);

    }

    public void verificarBajas() {
        for (Edificio edificio : listaEdificios){
            if (edificio.estaDestruido())
                listaEdificios.remove(edificio) ;

        }

    }

}
