package energia;

public class Energia {

    private int energiaActual ;
    private int energiaMaxima ;

    public Energia(int energiaInicial) {
        energiaActual = energiaInicial ;
                energiaMaxima = 200;
    }
// Unidades no pierden energia.
    public int getEnergia(){
        return energiaActual ;
    }

    public void setEnergia(int nuevaVida) {
        energiaActual = nuevaVida ;
    }

    public void aumentarEnergia(int energia){
        if( energiaActual + energia > energiaMaxima ){
            energiaActual = energiaMaxima;
        } else {
            energiaActual = energiaActual + energia;
        }
    }

}
