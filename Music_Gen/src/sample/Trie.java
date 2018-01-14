package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Trie {
    Vector<node> heads = new Vector<node>();
    public Trie(){
    }
    public void read(String in){
        String [] sets = in.split("\n");
        Vector<String> found = new Vector<String>();
        for(String s: sets){
            String temp = s.split(",")[0];
            if(found.contains(temp)){
                for(int i = 0; i<heads.size();i++){
                    if(found.elementAt(i).equals(temp));
                }
            }else{
                found.add(temp);
                System.out.println(temp + "HEAD");
                heads.add(new node(new Vector(Arrays.asList(s.split(",")))));
            }
        }

    }

}
