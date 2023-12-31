package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {
    int relantizado;
    int velocidad;

    
    public Hormiga(){
        this.credito = new Credito(1);
        this.vida = 1;
        this.danio = 1;
        this.relantizado = 0;
        this.velocidad = 1;

    }

	//@Override
	public Pasarela mover(Pasarela unaPasarela) {
		return unaPasarela.obtenerSiguiente();
	}

    @Override
    public boolean esHormiga() {
        return true;
    }

    @Override
    public boolean equals(Object o){
        return o.getClass().equals(this.getClass());
    }

    public Pasarela moverRelantizado(Pasarela unaPasarela){

		this.relantizado = this.relantizado + 1;

        if(this.relantizado%2 == 0){
		    return unaPasarela.obtenerSiguiente();
         } else{
            return unaPasarela;
        
	    }
    }

}
