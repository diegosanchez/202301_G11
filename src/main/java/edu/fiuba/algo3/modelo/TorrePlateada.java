package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre {
    
    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion = 2;
    int tiempoConstruyendose;
    


    public TorrePlateada(){

        this.operativa = false;
        this.enConstruccion = true;
        this.tiempoConstruyendose = 0;

    }

    
    public void turno(){
        if (enConstruccion == true){
            this.tiempoConstruyendose = this.tiempoConstruyendose+1;
        }
    
        estado();

    }


    public void estado(){
        if(tiempoConstruyendose == tiempoDeConstruccion){
            this.enConstruccion = false;
            this.operativa = true;
            this.tiempoConstruyendose = 0;
         return;
        }
        


        }

    public boolean operativa(){

            return this.operativa;
        }


    
    @Override
    public Boolean atacar(Pasarela unaPasarela,int y,int x){

        if(rango.CalcularRangoPlateada(unaPasarela,y,x)){

        unaPasarela.AtacadoPorTorrePlateada();
        return true;

        }
        
        return false;

    }

}

