package pruebasMapa;

import junit.framework.Assert;
import org.junit.Test;
import mapa.Posicion;



public class PosicionTest {

	@Test (expected = Exception.class)
	public void testNoSePuedeCrearSinPosicionInicial() throws Exception{
		Posicion p = new Posicion();
	}

	@Test
	public void testMoverEnXModificaElValorXDePosicion(){
		Posicion pos = new Posicion(0,0);
		pos.moverEnX(3);
		Assert.assertEquals(new Posicion(3,0), pos);
	}

	@Test
	public void testMoverEnYModificaElValorYDePosicion(){
		Posicion pos = new Posicion(0,0);
		pos.moverEnY(5);
		Assert.assertEquals(new Posicion(0,5), pos);
	}

	@Test
	public void testDistanciaEnXBienCalculada(){
		Posicion pos1 = new Posicion(0, 0);
		Posicion pos2 = new Posicion(17, 6);
		Assert.assertEquals(17, pos1.distanciaEnX(pos2));
	}

	@Test
	public void testDistanciaEnYBienCalculada(){
		Posicion pos1 = new Posicion(3, 7);
		Posicion pos2 = new Posicion(1, 21);
		Assert.assertEquals(14, pos1.distanciaEnY(pos2));
	}

	@Test
	public void testDistanciaCalculadaConPitagoras(){
		Posicion pos1 = new Posicion(0, 0);
		Posicion pos2 = new Posicion(4, 3);
		Assert.assertEquals(5, pos1.distancia(pos2));
	}

};
