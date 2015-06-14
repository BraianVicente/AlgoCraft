package pruebasMapa;

import junit.framework.Assert;
import org.junit.Test;
import mapa.ConstructorDeMapaChico;
import mapa.Mineral;
import mapa.Posicion;
import mapa.Volcan;


public class ConstructorDeMapasTest {

	private int ladoBase = 4;
	private int ladoMapaChico = 25;

	@Test
	public void testMapaChicoTieneDosBases(){
		int i, j;
		int nBase, minerales, volcanes;
		ConstructorDeMapaChico cMapa = new ConstructorDeMapaChico();
		Posicion posBase, pos;
		for(nBase = 0; nBase <= 1; nBase++){
			minerales = 0;
			volcanes = 0;
			posBase = cMapa.getPosicionBase(nBase);
			for(pos = posBase.copiar(), i = 0; i < ladoBase; pos.moverEnX(1), i++){
				for(j = 0; j < ladoBase; pos.moverEnY(1), j++){
					if((cMapa.getTerreno(pos)) instanceof Mineral)
						minerales++;
					else if((cMapa.getTerreno(pos)) instanceof Volcan)
						volcanes++;
				}
				pos.moverEnY(-ladoBase);
			}
			Assert.assertEquals(3, minerales);
			Assert.assertEquals(1, volcanes);
		}
	}

	@Test
	public void testMapaTieneMineralesCercaDeTodasLasBases(){
		int i, j;
		int nBase;
		int mineralesProxBase1 = 0;
		int mineralesProxBase2 = 0;
		Posicion pos;
		ConstructorDeMapaChico cMapa = new ConstructorDeMapaChico();
		Posicion posBase1 = cMapa.getPosicionBase(0);
		Posicion posBase2 = cMapa.getPosicionBase(1);
		posBase2.moverEnX(4);
		posBase2.moverEnY(4);
		for(i= 0; i < ladoMapaChico; i++){
			for(j = 0; j < ladoMapaChico; j++){
				pos = new Posicion(i, j);
				if(cMapa.getTerreno(pos) instanceof Mineral &&  (pos.distanciaEnX(posBase1) > ladoBase || pos.distanciaEnY(posBase1) > ladoBase) && (pos.distanciaEnX(posBase2) > ladoBase || pos.distanciaEnY(posBase2) > ladoBase)){
					if(pos.distancia(posBase1) > pos.distancia(posBase2))
						mineralesProxBase1 ++;
					else
						mineralesProxBase2 ++;
				}
			}
		}
		Assert.assertEquals(mineralesProxBase1, mineralesProxBase2);
	}
};
