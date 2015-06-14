package edificio;
import edificio.Edificio ;

public class NecesitaEdificioException extends Exception {

	public Edificio edificioNecesario;

	public NecesitaEdificioException(Edificio unEdificio){
		this.edificioNecesario = unEdificio ;
	}

}
