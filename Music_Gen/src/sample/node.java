package sample;

import java.util.Vector;

public class node {
    Vector<node> lon = new Vector<node>();
    String note;
    int weight;

    public node(Vector<node> lon, String note, int weight){
        this.note = note;
        this.lon = lon;
        this.weight = weight;
    }

    public node(){
    }

    public void generate(Vector<String> in){
        if(note != null){
            this.add(in);
            return;
        }
        note = in.firstElement();
        in.remove(0);
        weight = Integer.parseInt(in.firstElement());
        in.remove(0);
        if(in.isEmpty()){
        }else {
            node x = new node();
            x.generate(in);
            lon.add(x);
        }
    }

    private void add(Vector<String> in){
        in.remove(0);
        in.remove(0);
        for(node i : lon){
            if(i.note.equals(in.firstElement())){
                i.add(in);
            }else{
                node x = new node();
                x.generate(in);
                lon.add(x);
            }
        }
    }
}
