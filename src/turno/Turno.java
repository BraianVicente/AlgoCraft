package turno;

import jugador.Jugador;

public class Turno {
	
	private Jugador turno ;    
        
	public Turno(Jugador turno) {
		this.turno = turno ;
	}
	public Jugador getTurno() {
		return turno;
	}
	public void setTurno(Jugador turno) {
		this.turno = turno;
	}

}