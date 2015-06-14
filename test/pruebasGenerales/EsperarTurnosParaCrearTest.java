package pruebasGenerales;

import junit.framework.Assert;

import org.junit.Test;

import edificio.Edificio;
import edificio.edificiosProtoss.Acceso;
import edificio.edificiosProtoss.NexoMineral;
import edificio.edificiosProtoss.Pilon;
import jugador.Jugador;
import jugador.NoContieneEdificioException;
import jugador.NoContieneUnidadException;
import jugador.NoSeAgregoEdificioException;
import jugador.exceptions.NoSeAgregoUnidadException;
import mapa.Mapa;
import raza.protoss.Protoss;
import raza.terran.Terran;
import sistema.AlgoCraft;
import unidad.Unidad;
import unidad.unidadProtoss.Zealot;
import unidad.unidadTerran.Marine;

public class EsperarTurnosParaCrearTest {

    @Test
    public void CrearEdificioDesdeSistemaTest(){

        Jugador j1 = new Jugador("jugador1","azul",new Protoss());
        Jugador j2 = new Jugador("jugador2","oro",new Terran());
        Jugador turno;
        AlgoCraft sistema = new AlgoCraft(j1,j2,j1);
        turno = sistema.turnoDe();
        Edificio nexo = ((Protoss)turno.getRaza()).crearNexoMineral();

        try {
           turno.agregarEdificio(nexo);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        try {
            turno.tieneEdificio(new NexoMineral());
            Assert.assertFalse(true);
        } catch (NoContieneEdificioException except) {
            Assert.assertTrue(true);
        }

        for(int i=0;i<=9;i++)
            sistema.pasarTurno();
        turno = sistema.turnoDe();

        try {
            turno.tieneEdificio(new NexoMineral());
            Assert.assertTrue(true);
        } catch (NoContieneEdificioException except) {
            except.printStackTrace(System.out);
            Assert.assertFalse(true);
        }
    }

    @Test
    public void CrearUnidadDesdeSistemaTest(){

        Jugador j1 = new Jugador("jugador1","azul",new Protoss());
        Jugador j2 = new Jugador("jugador2","oro",new Terran());
        Jugador turno;
        AlgoCraft sistema = new AlgoCraft(j1,j2,j1);
        turno = sistema.turnoDe();
        Edificio nexo = ((Protoss)turno.getRaza()).crearNexoMineral();
        Edificio pilon = ((Protoss)turno.getRaza()).crearPilon();

        try {
            turno.agregarEdificio(nexo);
            turno.agregarEdificio(pilon);
            Assert.assertTrue(true);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        for( int i = 0; i <= 31 ; i++ )
            sistema.pasarTurno();
        turno = sistema.turnoDe();


        try {
            turno.tieneEdificio(new NexoMineral());
            turno.tieneEdificio(new Pilon());
            Assert.assertTrue(true);
        } catch (NoContieneEdificioException except) {
            Assert.assertFalse(true);
        }

        Edificio acceso = ((Protoss)turno.getRaza()).crearAcceso();

        try {
            turno.agregarEdificio(acceso);
            Assert.assertTrue(true);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        for(int i=0;i<=17;i++)
            sistema.pasarTurno();
        turno = sistema.turnoDe();

        try {
            turno.tieneEdificio(new Acceso());
            Assert.assertTrue(true);
        } catch (NoContieneEdificioException except) {
            Assert.assertFalse(true);
        }

        Unidad zealot = ((Acceso) acceso).crearZealot() ;

        try {
            turno.agregarUnidad(zealot);
            Assert.assertTrue(true);
        } catch (NoSeAgregoUnidadException except) {
            Assert.assertFalse(true);
        }

        for(int i = 0; i <= 10 ; i++ )
            sistema.pasarTurno();
        turno = sistema.turnoDe();

        try {
            turno.tieneUnidad(new Zealot());
            Assert.assertFalse(true);
        } catch (NoContieneUnidadException except) {
            Assert.assertTrue(true);
        }

        zealot.realizarAtaque(new Marine());

    }



}
