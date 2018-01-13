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
        for(String i: sets){
            String temp = i.split(",")[0];
            if(found.contains(temp)){
                for(node n : heads){
                    if(n.note.equals(temp)){
                        n.generate(new Vector(Arrays.asList(i.split(","))));
                    }
                }
            }else{
                found.add(temp);
                node x = new node();
                x.generate(new Vector(Arrays.asList(i.split(","))));
                heads.add(x);
            }
        }

    }
}
