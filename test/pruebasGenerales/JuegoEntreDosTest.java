package pruebasGenerales;

import org.junit.Test;

import edificio.Edificio;
import edificio.edificiosProtoss.Acceso;
import edificio.edificiosProtoss.NexoMineral;
import edificio.edificiosProtoss.Pilon;
import edificio.edificiosTerran.Barraca;
import edificio.edificiosTerran.CentroDeMineral;
import edificio.edificiosTerran.DepositoDeSuministros;
import junit.framework.Assert;
import raza.protoss.Protoss;
import raza.terran.Terran;
import sistema.AlgoCraft;
import unidad.Unidad;
import unidad.unidadProtoss.Zealot;
import unidad.unidadTerran.Marine;
import jugador.Jugador;
import jugador.NoContieneEdificioException;
import jugador.NoContieneUnidadException;
import jugador.NoSeAgregoEdificioException;
import jugador.exceptions.NoSeAgregoUnidadException;

public class JuegoEntreDosTest {


    @Test
    public void SistemaTest(){

        Jugador j1 = new Jugador("jugador1","azul",new Protoss());
        Jugador j2 = new Jugador("jugador2","oro",new Terran());
        AlgoCraft sistema = new AlgoCraft(j1,j2,j1);
        j1 = sistema.turnoDe();

        try {
            j1.agregarEdificio(((Protoss)j1.getRaza()).crearNexoMineral());
            j1.agregarEdificio(((Protoss)j1.getRaza()).crearNexoMineral());
            j1.agregarEdificio(((Protoss)j1.getRaza()).crearNexoMineral());
            j1.agregarEdificio(((Protoss)j1.getRaza()).crearNexoMineral());
            Assert.assertTrue(true);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        sistema.pasarTurno();
        j2 = sistema.turnoDe();
        try {
            j2.agregarEdificio(((Terran)j2.getRaza()).crearCentroDeMineral());
            j2.agregarEdificio(((Terran)j2.getRaza()).crearCentroDeMineral());
            j2.agregarEdificio(((Terran)j2.getRaza()).crearCentroDeMineral());
            j2.agregarEdificio(((Terran)j2.getRaza()).crearCentroDeMineral());
            Assert.assertTrue(true);
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0 ; i <= 4 ; i ++){
            sistema.pasarTurno();
            j1 = sistema.turnoDe();
            sistema.pasarTurno();
            j2 = sistema.turnoDe();
        }

        sistema.pasarTurno();
        j1 = sistema.turnoDe();

        try {
            j1.tieneEdificio(new NexoMineral());
            Assert.assertTrue(true);
        } catch (NoContieneEdificioException except) {
            Assert.assertFalse(true);
        }

        sistema.pasarTurno();
        j2 = sistema.turnoDe();

        try {
            j2.tieneEdificio(new CentroDeMineral());
            Assert.assertTrue(true);
        } catch (NoContieneEdificioException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0 ; i <= 8 ; i ++){
            sistema.pasarTurno();
            j1 = sistema.turnoDe();
            sistema.pasarTurno();
            j2 = sistema.turnoDe();
        }

        Edificio barraca = ((Terran)j2.getRaza()).crearBarraca() ;
        try {
            j2.agregarEdificio(barraca);
            j2.agregarEdificio(((Terran)j2.getRaza()).crearDepositoDeSuministros());
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }
        sistema.pasarTurno();
        j1 = sistema.turnoDe();

        Edificio acceso = ((Protoss)j1.getRaza()).crearAcceso() ;
        try {
            j1.agregarEdificio(acceso);
            j1.agregarEdificio(((Protoss)j1.getRaza()).crearPilon());
        } catch (NoSeAgregoEdificioException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0 ; i <= 20 ; i ++){
            sistema.pasarTurno();
            j2 = sistema.turnoDe();
            sistema.pasarTurno();
            j1 = sistema.turnoDe();
        }
        try {
            j1.tieneEdificio(new Acceso() );
            j1.tieneEdificio(new Pilon());
        } catch (NoContieneEdificioException except) {
            Assert.assertFalse(true);
        }

        sistema.pasarTurno();
        j2 = sistema.turnoDe();
        try {
            j2.tieneEdificio(new Barraca());
            j2.tieneEdificio(new DepositoDeSuministros());
        } catch (NoContieneEdificioException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0 ; i <= 20 ; i ++){
            sistema.pasarTurno();
            j1 = sistema.turnoDe();
            sistema.pasarTurno();
            j2 = sistema.turnoDe();
        }

        Unidad marine = ((Barraca) barraca).crearMarine() ;
        try {
            j2.agregarUnidad(marine);
        } catch (NoSeAgregoUnidadException e) {
            Assert.assertFalse(true);
        }

        sistema.pasarTurno();
        j1 = sistema.turnoDe();

        Unidad zealot = ((Acceso) acceso).crearZealot() ;
        try {
            j1.agregarUnidad(zealot);
        } catch (NoSeAgregoUnidadException e) {
            Assert.assertFalse(true);
        }

        sistema.pasarTurno();
        j2 = sistema.turnoDe();
        for (int i = 0 ; i <= 4 ; i ++){
            sistema.pasarTurno();
            j1 = sistema.turnoDe();
            sistema.pasarTurno();
            j2 = sistema.turnoDe();
        }

        sistema.pasarTurno();
        j1 = sistema.turnoDe() ;
        try {
            j1.tieneUnidad((Unidad) new Zealot());
        } catch (NoContieneUnidadException except) {
            Assert.assertFalse(true);
        }

        sistema.pasarTurno();
        j2 = sistema.turnoDe();

        try {
            j2.tieneUnidad((Unidad) new Marine());
            Assert.assertTrue(true);
        } catch (NoContieneUnidadException except) {
            Assert.assertFalse(true);
        }

        for (int i = 0 ; i <= 11 ; i ++){
            sistema.pasarTurno();
            j1 = sistema.turnoDe();
            j1.atacarUnidad(zealot,marine);
            sistema.pasarTurno();
            j2 = sistema.turnoDe();
            j2.atacarUnidad(marine,zealot);
        }

        try {
            j2.tieneUnidad((Unidad) new Marine());
        } catch (NoContieneUnidadException except) {
            Assert.assertTrue(true);
        }

        sistema.pasarTurno();
        j1 = sistema.turnoDe() ;
        try {
            j1.tieneUnidad((Unidad) new Zealot());
        } catch (NoContieneUnidadException except) {
            Assert.assertFalse(true);
        }
        sistema.pasarTurno();
        sistema.pasarTurno();











    }


}
