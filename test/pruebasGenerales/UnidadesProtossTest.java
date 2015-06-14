package pruebasGenerales;

import junit.framework.Assert;

import org.junit.Test;

import edificio.Edificio ;
import edificio.edificiosProtoss.Acceso;
import raza.protoss.Protoss ;
import jugador.AgregarEdificioException;
import jugador.Jugador ;
import jugador.NoContieneEdificioException;
import jugador.NoContieneUnidadException;
import jugador.NoSeAgregoEdificioException;
import unidad.Unidad ;
import unidad.unidadProtoss.Dragon;
import jugador.RecursosInsuficientesException;
import jugador.exceptions.NoSeAgregoUnidadException;
import unidad.unidadProtoss.UnidadProtoss;
import vida.VidaAgotadaException;

public class UnidadesProtossTest {

    @Test
    public void testJugadorProtossAgregaEdificios() throws AgregarEdificioException{
        Protoss unaRaza = new Protoss() ;
        Jugador unJugador = new Jugador("nombre","color",unaRaza) ;
        Edificio recolectorMinerales = ((Protoss)unJugador.razaJugador).crearNexoMineral() ;
        Edificio recolectorGas = ((Protoss)unJugador.razaJugador).crearAsimilador() ;
        Edificio unAcceso = ((Protoss)unJugador.razaJugador).crearAcceso() ;
        Edificio unPuertoEstelar = ((Protoss)unJugador.razaJugador).crearPuertoEstelar();

        try {
            unJugador.agregarEdificio(recolectorMinerales);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        try {
            unJugador.agregarEdificio(recolectorGas);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0; i <= 200; i++){
            unJugador.recolectar();
        }

        try {
            unJugador.agregarEdificio(unPuertoEstelar) ;
            Assert.assertFalse(true);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertTrue(true);
        }

        try {
            unJugador.agregarEdificio(unAcceso) ;
            Assert.assertTrue(true);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertTrue(false);

        }

        try {
            unJugador.tieneEdificio(new Acceso());
            Assert.assertTrue(false);
        } catch (NoContieneEdificioException except) {
            Assert.assertTrue(true);
        }

        try {
            unJugador.agregarEdificio(unPuertoEstelar) ;
            Assert.assertFalse(true);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testJugadorProtossRecolectaMinerales() {
        Protoss raza = new Protoss();
        Jugador jugador = new Jugador("nombre","color",raza);
        Edificio recolectorMinerales = ((Protoss)jugador.razaJugador).crearNexoMineral() ;
        Edificio recolectorGas = ((Protoss)jugador.razaJugador).crearAsimilador() ;
        Edificio edificio = ((Protoss)jugador.razaJugador).crearAcceso() ;

        try {
            jugador.agregarEdificio(recolectorMinerales);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        try {
            jugador.agregarEdificio(recolectorGas);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0; i <= 20; i++){
            jugador.recolectar();
        }

        try {
            jugador.agregarEdificio(edificio);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testJugadorProtossCreaUnidades() {
        Protoss raza = new Protoss();
        Jugador jugador = new Jugador("nombre","color",raza);
        Edificio recolectorMinerales = ((Protoss)jugador.razaJugador).crearNexoMineral() ;
        Edificio recolectorGas = ((Protoss)jugador.razaJugador).crearAsimilador() ;
        Edificio acceso = ((Protoss)jugador.razaJugador).crearAcceso() ;
        Edificio pilon = ((Protoss)jugador.razaJugador).crearPilon() ;

        try {
            jugador.agregarEdificio(recolectorMinerales);
            jugador.agregarEdificio(recolectorGas);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0; i <= 1000; i++){
            jugador.recolectar();
        }

        try {
            jugador.agregarEdificio(acceso);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        try {
            jugador.agregarEdificio(pilon);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }


        Unidad nuevaUnidad = ((Acceso) acceso).crearZealot() ;

        try {
            jugador.agregarUnidad(nuevaUnidad);
        } catch (NoSeAgregoUnidadException except) {
            except.printStackTrace(System.out);
            Assert.assertFalse(true);
        }


    }

    @Test
    public void testJugadorProtossAtaca() throws VidaAgotadaException{
        Protoss raza = new Protoss();
        Jugador jugador = new Jugador("nombre","color",raza);
        Edificio recolectorMinerales = ((Protoss)jugador.razaJugador).crearNexoMineral() ;
        Edificio recolectorGas = ((Protoss)jugador.razaJugador).crearAsimilador() ;
        Edificio acceso = ((Protoss)jugador.razaJugador).crearAcceso() ;
        Edificio pilon = ((Protoss)jugador.razaJugador).crearPilon() ;

        try {
            jugador.agregarEdificio(recolectorMinerales);
            jugador.agregarEdificio(recolectorGas);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0; i <= 100; i++){
            jugador.recolectar();
        }

        try {
            jugador.agregarEdificio(acceso);
            jugador.agregarEdificio(pilon);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        int alojamiento = jugador.poblacion.getAlojamiento();
        Assert.assertEquals(5,alojamiento);


        Unidad zealot = ((Acceso) acceso).crearZealot() ;
        Unidad dragon = ((Acceso) acceso).crearDragon() ;

        try {
            jugador.agregarUnidad(zealot);
            jugador.agregarUnidad(dragon);
        } catch (NoSeAgregoUnidadException e) {
            Assert.assertFalse(true);
        }

        alojamiento = jugador.poblacion.getAlojamiento();
        Assert.assertEquals(1,alojamiento);

        zealot.realizarAtaque(dragon) ;
        Assert.assertEquals(((UnidadProtoss)dragon).vidaUnidad.getVida() ,100);

        int escudo = ((Dragon) dragon).escudoUnidad.getEscudo() ;
        Assert.assertEquals(escudo ,72);
        jugador.recolectar();
        jugador.recolectar();
        jugador.recolectar();
        jugador.recolectar();
        jugador.recolectar();
        jugador.recolectar();
        try {
            jugador.tieneUnidad(new Dragon());
        } catch (NoContieneUnidadException ex) {
            Assert.assertFalse(true);
        }
        int otroEscudo = ((Dragon) dragon).escudoUnidad.getEscudo() ;
        Assert.assertEquals(80,otroEscudo);
        zealot.realizarAtaque(dragon) ;
        otroEscudo = ((Dragon) dragon).escudoUnidad.getEscudo() ;
        Assert.assertEquals(72,otroEscudo);
        jugador.recolectar();
        otroEscudo = ((Dragon) dragon).escudoUnidad.getEscudo() ;
        Assert.assertEquals(77,otroEscudo);
        jugador.recolectar();
        otroEscudo = ((Dragon) dragon).escudoUnidad.getEscudo() ;
        Assert.assertEquals(80,otroEscudo);

        for (int i = 0 ; i < 100; i++) {
            zealot.realizarAtaque(dragon) ;
        }

        otroEscudo = ((Dragon) dragon).escudoUnidad.getEscudo() ;
        Assert.assertEquals(0,otroEscudo);

        int vida = ((Dragon) dragon).vidaUnidad.getVida() ;
        Assert.assertEquals(0,vida);
        jugador.recolectar();

        try {
            jugador.tieneUnidad(new Dragon());
        } catch (NoContieneUnidadException ex) {
            Assert.assertTrue(true);
        }

        alojamiento = jugador.poblacion.getAlojamiento();
        Assert.assertEquals(3,alojamiento);

        zealot.realizarAtaque(acceso) ;
        zealot.realizarAtaque(acceso) ;
        zealot.realizarAtaque(acceso) ;

        int edificioEscudo = ((Acceso) acceso).escudoEficicio.getEscudo() ;


        Assert.assertEquals(476,edificioEscudo);

        jugador.recolectar();
        edificioEscudo = ((Acceso) acceso).escudoEficicio.getEscudo() ;

        Assert.assertEquals(481,edificioEscudo);


    }



}
