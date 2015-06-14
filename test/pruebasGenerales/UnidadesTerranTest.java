package pruebasGenerales;

import junit.framework.Assert;

import org.junit.Test;

import edificio.Edificio ;
import edificio.edificiosTerran.*;
import raza.terran.Terran ;
import jugador.AgregarEdificioException;
import jugador.Jugador ;
import jugador.NoSeAgregoEdificioException;
import unidad.Unidad ;
import unidad.unidadTerran.* ;
import jugador.RecursosInsuficientesException;
import jugador.exceptions.NoSeAgregoUnidadException;

public class UnidadesTerranTest {

    @Test
    public void testJugadorTerranAgregaEdificios() throws AgregarEdificioException {
        Terran unaRaza = new Terran() ;
        Jugador unJugador = new Jugador("nombre","color",unaRaza) ;

        Edificio barraca = ((Terran)unJugador.razaJugador).crearBarraca() ;

        Edificio unPuertoEstelar = ((Terran)unJugador.razaJugador).crearPuertoEstelar();

        try {
            unJugador.agregarEdificio(barraca) ;
        } catch (NoSeAgregoEdificioException except) {
            throw new AgregarEdificioException() ;
        }

        try {
            unJugador.agregarEdificio(unPuertoEstelar) ;
            Assert.assertFalse(true);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertTrue(true);
        }


    }

    @Test
    public void testJugadorTerranRecolectaMinerales() {
        Terran raza = new Terran();
        Jugador jugador = new Jugador("nombre","color",raza);
        Edificio recolectorMinerales = ((Terran)jugador.razaJugador).crearCentroDeMineral() ;
        Edificio recolectorGas = ((Terran)jugador.razaJugador).crearRefineria() ;
        Edificio edificio = ((Terran)jugador.razaJugador).crearBarraca() ;

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
    public void testJugadorTerranCreaUnidades() {
        Terran raza = new Terran();
        Jugador jugador = new Jugador("nombre","color",raza);
        Edificio recolectorMinerales = ((Terran)jugador.razaJugador).crearCentroDeMineral() ;
        Edificio recolectorGas = ((Terran)jugador.razaJugador).crearRefineria() ;
        Edificio barraca = ((Terran)jugador.razaJugador).crearBarraca() ;
        Edificio casa = ((Terran)jugador.razaJugador).crearDepositoDeSuministros() ;

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
            jugador.agregarEdificio(barraca);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        try {
            jugador.agregarEdificio(casa);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }



        Unidad nuevaUnidad = ((Barraca) barraca).crearMarine() ;

        try {
            jugador.agregarUnidad(nuevaUnidad);
        } catch (NoSeAgregoUnidadException e) {
            Assert.assertFalse(true);
        }


    }

    @Test
    public void testJugadorTerranAtaca(){
        Terran raza = new Terran();
        Jugador jugador = new Jugador("nombre","color",raza);
        Edificio recolectorMinerales = ((Terran)jugador.razaJugador).crearCentroDeMineral() ;
        Edificio recolectorGas = ((Terran)jugador.razaJugador).crearRefineria() ;
        Edificio barraca = ((Terran)jugador.razaJugador).crearBarraca() ;
        Edificio casa = ((Terran)jugador.razaJugador).crearDepositoDeSuministros() ;

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
            jugador.agregarEdificio(barraca);
            jugador.agregarEdificio(casa);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }


        Unidad marine_0 = ((Barraca) barraca).crearMarine() ;
        Unidad marine_1 = ((Barraca) barraca).crearMarine() ;
        try {
            jugador.agregarUnidad(marine_0);
            jugador.agregarUnidad(marine_1);
        } catch (NoSeAgregoUnidadException e) {
            Assert.assertFalse(true);
        }
// Faltaria ver como se restringue la cantidad de ataques.
        jugador.atacarUnidad(marine_0,marine_1) ;
        Assert.assertEquals(34,((UnidadTerran)marine_1).vidaUnidad.getVida());
        Assert.assertFalse(marine_1.estaMuerta());
        marine_0.realizarAtaque(barraca) ;
        Assert.assertEquals(994,barraca.vidaEdificio.getVida());

    }
}

