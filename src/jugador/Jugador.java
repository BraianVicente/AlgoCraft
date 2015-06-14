package jugador;


import construcciones.Construcciones;
import poblacion.FaltanAlojamientoException;
import poblacion.LimiteDePoblacionException;
import poblacion.Poblacion;
import jugador.exceptions.NoSeAgregoUnidadException;
import raza.Raza;
import recursos.Recursos ;
import edificio.Edificio ;
import unidad.Unidad ;
import unidad.UnidadMagica ;

public class Jugador {
    public Raza razaJugador ;
    public String nombreJugador ;
    public String colorJugador ;
    public Recursos recursosJugador;
    public Poblacion poblacion ;
    public Construcciones construcciones ;

    public Jugador (String unNombre, String unColor , Raza unaRaza){
        razaJugador = unaRaza ;
        nombreJugador = unNombre ;
        colorJugador = unColor ;
        poblacion = new Poblacion() ;
        recursosJugador = new Recursos();
        recursosJugador.inicializarRecursos(200,0) ;
        construcciones = new Construcciones();

    }

    public Boolean satisfaceRecursos(Recursos costoUnidad) {
        Boolean resultado = recursosJugador.satisfacenRecursos(costoUnidad) ;
        return resultado ;
    }

    public void consumirRecursos(Recursos costo) throws RecursosInsuficientesException {
        if ( !(this.satisfaceRecursos(costo) ) ) {
            throw new RecursosInsuficientesException() ;
        }
        this.recursosJugador.quitarRecursos(costo) ;
    }

    public void agregarUnidad(Unidad unaUnidad) throws NoSeAgregoUnidadException {

        try {
            this.consumirRecursos(unaUnidad.costoUnidad() ) ;
            this.poblacion.agregarUnidad(unaUnidad) ;
        } catch (RecursosInsuficientesException except) {
            throw new NoSeAgregoUnidadException ();
        } catch (LimiteDePoblacionException except) {
            throw new NoSeAgregoUnidadException ();
        } catch (FaltanAlojamientoException except) {
            throw new NoSeAgregoUnidadException ();
        }


    }

    public void recolectar(){

        recursosJugador.agregarRecursos(construcciones.recolectar() ) ;

        construcciones.verificarTiempoDeCreacion() ;

        construcciones.verificarBajas();

        poblacion.verificarTiempoDeCreacion();

        poblacion.actualizarUnidades();

        poblacion.verificarBajas();

    }

    public String getNombre(){
        return nombreJugador;
    }

    public boolean equals(Jugador unJugador){
        return (nombreJugador.equals(unJugador.getNombre()));
    }

    public Raza getRaza(){
        return razaJugador;
    }

    public void agregarEdificio(Edificio unEdificio) throws NoSeAgregoEdificioException {
        try {
            this.construcciones.agregarEdificio(unEdificio) ;
            this.consumirRecursos(unEdificio.costoEdificio());
            this.poblacion.aumentarAlojamiento(unEdificio.alojamientoEdificio());
        } catch (RecursosInsuficientesException except ) {
            throw new NoSeAgregoEdificioException() ;
        } catch (NoSeAgregoEdificioException except) {
            throw new NoSeAgregoEdificioException();
        }

    }

    public void tieneEdificio(Edificio edificio) throws NoContieneEdificioException {
        if ( !( this.construcciones.tieneEdificio(edificio) ) ){
            throw new NoContieneEdificioException();
        }
    }

    public void tieneUnidad(Unidad unidad) throws NoContieneUnidadException {
        if ( !(poblacion.tieneUnidad(unidad)) ) {
            throw new NoContieneUnidadException();
        }
    }

    public void atacarUnidad(Unidad miUnidad, Unidad enemigo ) {
        miUnidad.realizarAtaque(enemigo);
    }

    public void atacarEdificio(Unidad miUnidad, Edificio enemigo ) {
        miUnidad.realizarAtaque(enemigo);
    }

    public void eliminarUnidad(Unidad marine) {
        // TODO Auto-generated method stub

    }




}
