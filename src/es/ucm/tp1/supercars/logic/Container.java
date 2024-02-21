package es.ucm.tp1.supercars.logic;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.*;

public class Container {
    private static List<GameObject> gameobjects; 

    private static int contador;

    public Container() {
        gameobjects = new ArrayList<GameObject>(); 
        contador = 0;
    }
    
    public int getContador() {
    	return contador;
    }

    public void add(GameObject o) {
        gameobjects.add(contador, o);
        o.onEnter();
        contador++;
    }

    public static void delete(GameObject o, int fila, int columna) {
        boolean ok = false; int i = 0;
        
        while(i < contador && !ok) {
            if((fila == gameobjects.get(i).getY()) && (columna == gameobjects.get(i).getX())) {
                gameobjects.remove(i);
                ok = true;
            }
            i++;
        }
        contador--;
    }

    public boolean isOnPosition(int fila, int columna) {
        boolean ok = false; int i = 0;
        
        while(i < contador && !ok) {
            if((fila == gameobjects.get(i).getY()) && (columna == gameobjects.get(i).getX())) ok = true;
            i++;
        }
        return ok;
    }

    public void reset(GameObject o) {
        gameobjects.clear();
    }

    public void update() {
        for(int i = 0; i < contador; i++) gameobjects.get(i).update();
    }
    
    public void Update() {
        for(int i = 0; i < contador; i++) gameobjects.get(i).Update();
    }
    
    public Collider interfazInPos(int columna, int fila) {
    	boolean ok = false; int i = 0;
        
        while(i < contador && !ok) {
            if((fila == gameobjects.get(i).getY()) && (columna == gameobjects.get(i).getX())) ok = true;      
            else i++;
        }
       if(ok) return (Collider) gameobjects.get(i);
       else return null;
    }
    
    public String toString(int fila, int columna) {
        boolean ok = false; int i = 0;
        StringBuilder buffer = new StringBuilder();
        
        while(i < contador) {//&& !ok
            gameobjects.get(i);
            if((fila ==  gameobjects.get(i).getY()) && (columna ==  gameobjects.get(i).getX())) {
            	buffer.append(gameobjects.get(i).toString());}
            	//ok = true;}
            i++;
        }
        return buffer.toString();
        //return gameobjects.get(i - 1).toString();
    }
    
    public void primerUpdate() {
    	int x,y;
    	for (int i = 0; i < contador; i++) {
    		x = gameobjects.get(i).getX();
    		y = gameobjects.get(i).getY();
    		for (int j = i + 1; j < contador; j++) {
    			if(x == gameobjects.get(j).getX() && y == gameobjects.get(j).getY()) {
    				gameobjects.remove(j);
    				contador--;
    			}
    		}
    	}
    }
    
    public int posContainer(int columna, int fila) {
    	boolean ok = false; int i = 0;
        
        while(i < contador && !ok) {
            if((fila == gameobjects.get(i).getY()) && (columna == gameobjects.get(i).getX())) ok = true;      
            else i++;
        }
       if(ok) return i;
       else return -1;
    }
    
    public void moveWave(int pos) {
    	gameobjects.get(pos).waveBack();
    	primerUpdate();
    }
    
    public void deleteThunder(int pos) {
    	gameobjects.remove(pos);
    	contador--;
    }
    
    public int getThunderX(int pos) {
    	return gameobjects.get(pos).getX();
    }
    
    public int getThunderY(int pos) {
    	return gameobjects.get(pos).getY();
    }
    
    public String caidaThunder(int pos) {
    	String s = null;;
    	if (posContainer(getThunderX(pos), getThunderY(pos)) != -1 && posContainer(getThunderX(pos), getThunderY(pos)) != pos) {
    		s = toString(getThunderY(pos), getThunderX(pos));
    		gameobjects.remove(posContainer(getThunderX(pos), getThunderY(pos)));
    		contador--;
    	}
    	return s;
    }
    
    public GameObject crearThunder(int x, int y, Game game) {
    	return new Thunder(game, x, y);
    }
    
    public String info(int x, int y) {
    	int i = posContainer(x, y);
    	return gameobjects.get(i).getInfo();
    }
    
    public void delete(){
    	for (int i = (contador - 1); i >= 0; i--) {
    		gameobjects.remove(i);
    	}
    	contador = 0;
    }
}
