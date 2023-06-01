package edu.fiuba.algo3.modelo;
import java.util.*;

public class Pasarela extends Casillero {

    List<Enemigo> enemigos = new ArrayList<Enemigo>();
	Pasarela pasarelaSiguiente;

    public Pasarela(int nuevay,int nuevax){

        this.x = nuevax;
        this.y = nuevay;

    }

    @Override
    public Boolean esPasarela(){

        return true;
    }

    
    public void establecerEnemigo(Enemigo unEnemigo){

        this.enemigos.add(unEnemigo);
    }

    public void AtacadoPorTorreBlanca(Jugador jugador){

		for (Enemigo enemigo : enemigos) {
			enemigo.AtacadoPorTorreBlanca(jugador);
		}
    }

    public void AtacadoPorTorrePlateada(Jugador jugador){

		for (Enemigo enemigo : enemigos) {
			enemigo.AtacadoPorTorrePlateada(jugador);
		}
    }

    /////////////////En estos dos metodos se viola el encapsulamiento -> refactorizar ////////////////////

    public int obtenerx(){

        return this.x;
    }

    public int obtenery(){

        return this.y;
    }

    //////// En el refactor Casillero de por si va a conocer si siguiente //////////////

    
    public void moverEnemigos() {

		for (Enemigo enemigo : enemigos) {
			this.mover(enemigo);
			//enemigo = null;
			//enemigos.remove(enemigo);
		}

		enemigos.removeAll(enemigos);

    }

	public Boolean ocupado() {
		return !enemigos.isEmpty();
	}
	
	public Boolean vacio() {
		return enemigos.isEmpty();
	}

	public void establecerSiguiente(Pasarela unaPasarela) {
		pasarelaSiguiente = unaPasarela;
	}

	public Pasarela obtenerSiguiente() {
		return pasarelaSiguiente;
	}

	public void mover(Enemigo enemigo) {
		Pasarela pasarelaDestino = enemigo.mover(this);
		pasarelaDestino.establecerEnemigo(enemigo);
	}

}
