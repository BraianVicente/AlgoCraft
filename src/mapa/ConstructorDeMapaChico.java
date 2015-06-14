package mapa;



public class ConstructorDeMapaChico extends ConstructorDeMapas{

	public ConstructorDeMapaChico(){
		maxX = 25;
		maxY = 25;
		bases = 2;
		minerales = volcanes = 4;
		this.generarRecursosMapa();
	}
};
