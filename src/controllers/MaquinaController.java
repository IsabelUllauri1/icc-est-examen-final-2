package controllers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.*;

import models.Maquina;

public class MaquinaController {
    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral){
        Stack<Maquina> pila = new Stack<Maquina>();
        for(Maquina m: maquinas){
            if(m.getSubred()>umbral){
                pila.push(m);
            }
        }
        return pila;
    }

    public Set<Maquina> ordenarPorSubred(Stack<Maquina> pila){
        Comparator<Maquina> comp= new Comparator<Maquina>(){      
        @Override
        public int compare(Maquina a, Maquina b){
            int c = Integer.compare(b.getSubred(), a.getSubred());
            if(c != 0){
                return c;
            }
            c=a.getNombre().compareTo(b.getNombre());
            if (c!= 0) {return c;}
            return 0;
        }
            
    };
    TreeSet<Maquina> ordenado = new TreeSet<Maquina>();
    ordenado.addAll(pila);
    return ordenado;
    }

    public Map<Integer, Queue<Maquina> > agruparPorRiesgo (List<Maquina> maquinas){
        TreeMap<Integer, Queue<Maquina> > map= new TreeMap<Integer, Queue<Maquina> >();
        for(Maquina m: maquinas){
            Integer riesgo = Integer.valueOf(m.getRiesgo());
            Queue<Maquina> q = map.get(riesgo);
            if(q== null){
                q = new LinkedList<Maquina>();
                map.put(riesgo, q);

            }
            q.add(m);

        }
        return map;
    }
    
}
