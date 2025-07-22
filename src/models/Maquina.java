package models;
import java.util.*;
public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        this.riesgo = calcularRiesgo();
        this.subred = calcularSubred();
    }
    private int calcularSubred(){
        String[] av=this.ip.split("\\.");
        return Integer.parseInt(av[2]);
    }
    private int calcularRiesgo(){
        int suma = 0;
        for(Integer x : this.codigos){
            if(x!= null&& x%5==0){
                suma+=x;
            }
        }
        Set<Character> uni= new HashSet<Character>();
        for(char c: this.nombre.toCharArray()){
            if(c != ' '){
                uni.add(Character.valueOf(c));
            }
        }
        return suma * uni.size();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
    }

    public int getSubred() {
        return subred;
    }

    public void setSubred(int subred) {
        this.subred = subred;
    }

    public int getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }
    @Override
    public String toString() {
        return "nombre=" + nombre +  ", subred=" + subred + ", riesgo="
                + riesgo ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre,subred);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if(!(o instanceof Maquina))
            return false;
        Maquina other = (Maquina) o;

        return subred== other.subred && Objects.equals(nombre, other.nombre);
    }

    
    

}
