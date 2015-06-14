package recursos;

public class Recursos {

	private int minerales;
	private int gas ;

	public void inicializarRecursos(int minerales, int gas){
		this.setMinerales( minerales ) ;
		this.setGas(gas) ;
	}

	public Boolean satisfacenRecursos(Recursos recursosRequeridos) {
		if ( this.getMinerales() < recursosRequeridos.getMinerales() )
			return false ;
		if ( this.getGas() < recursosRequeridos.getGas() )
			return false ;
		return true ;
	}

	public void quitarRecursos(Recursos costo) {
		this.setMinerales(this.getMinerales() - costo.getMinerales())   ;
		this.setGas(this.getGas() - costo.getGas())   ;

	}

	public void agregarRecursos(Recursos agregado){
		this.setMinerales(this.getMinerales() + agregado.getMinerales() ) ;
		this.setGas(this.getGas() + agregado.getGas() ) ;
	}

	private void setMinerales(int cantidadMinerales) {
		minerales = cantidadMinerales ;
	}

	private void setGas(int cantidadGas) {
		gas = cantidadGas ;
	}


	private int getGas() {
		return gas;
	}

	public int getMinerales() {
		return minerales;
	}




}
