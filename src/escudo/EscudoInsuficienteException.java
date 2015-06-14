package escudo;

@SuppressWarnings("serial")
public class EscudoInsuficienteException extends Exception {

	public int escudoFaltante ;

	public EscudoInsuficienteException(int escudoFaltante) {
		this.escudoFaltante = escudoFaltante ;
	}

}
