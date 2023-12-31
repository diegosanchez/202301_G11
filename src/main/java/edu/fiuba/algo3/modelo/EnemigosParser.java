package edu.fiuba.algo3.modelo;
////import org.json.simple.JSONobject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemigosParser {
    private String path;

    public EnemigosParser(String p) {
        this.path = p;
    }

    private JSONArray setJSON()throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.path);
        Object obj = parser.parse(reader);
        JSONArray jsonArr = (JSONArray) obj;
        reader.close();
        return jsonArr;
    }


    private int turno(int t){
        return ((t-1) % 12) + 1;
    }


    public List<Enemigo> parsear(int t) throws IOException, ParseException {
        
        t = this.turno(t);
        JSONArray map = setJSON();
        List<Enemigo> enemigos = new ArrayList<Enemigo>();
        JSONObject turno = (JSONObject) map.get(t-1);
        JSONObject e = (JSONObject) turno.get("enemigos");
        Object hormiga = e.get("hormiga");

        for(int i = 0; i < (Long) hormiga; i++){

            enemigos.add(asignar("hormiga"));
        }
        Object arana = e.get("arana");
        for(int i = 0; i < (Long) arana; i++){

            enemigos.add(asignar("arana"));

        }
        return enemigos;
    }

    private Enemigo asignar(String s){
        Enemigo e = null;
        switch (s){
            case "arana":
                e = new Arania();
                break;
            case "hormiga":
                e = new Hormiga();
                break;
        }
        return e;
    }

    public void formatoCorrecto() throws IOException, ParseException, JSONVacio, FormatoJSONInvalido{
        JSONArray map = setJSON();
        if(map.isEmpty()) {
            throw new JSONVacio();
        }
        for(int i = 0; i < map.size(); i++){
            JSONObject turnoData = (JSONObject) map.get(i);
            try{
                JSONObject enemigos = (JSONObject) turnoData.get("enemigos");
                Object hormiga = enemigos.get("hormiga");
                Object arana = enemigos.get("arana");
            } catch (Exception e){
                throw new FormatoJSONInvalido();
            }
        }
    }
}
