public class Sciatore implements Comparable<Sciatore>{

private String nome;
private int m1;
private int m2;

public Sciatore(String nome, int m1, int m2){
    this.nome = nome;
    this.m1 = m1;
    this.m2 = m2;
    
}
public int getTempoTotale(){
    return m1+m2;
} 
public String getNome(){
    return nome;
}
public int compareTo(Sciatore s){
    return this.getTempoTotale()-s.getTempoTotale();
}
public String toString(){
    int m = getTempoTotale()/60;
    int sec = getTempoTotale()%60;
    return nome + " " + String.format("%02d:%02d",m,sec);
}
}