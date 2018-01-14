package sample;

import java.util.Vector;

public class node {
    Vector<node> lon = new Vector<node>();
    String note;
    double weight;

    public node(Vector<node> lon, String note, int weight){
        this.note = note;
        this.lon = lon;
        this.weight = weight;
    }

    public node(Vector<String> in){
        note = in.firstElement();
        in.remove(0);
        weight = Double.parseDouble(in.firstElement());
        in.remove(0);
        if(!in.isEmpty()){
            lon.add(new node(in));
        }
    }

    public node(){}

    public void generate(Vector<String> in){
        if(note != null){
            System.out.println(note + "NOTE");
            System.out.println(lon.firstElement().note);
            this.add(in);
            return;
        }
        note = in.firstElement();
        in.remove(0);
        weight = Double.parseDouble(in.firstElement());
        in.remove(0);
        if(in.isEmpty()){
        }else {
            node x = new node();
            x.generate(in);
            lon.add(x);
        }
    }

    private void add(Vector<String> in){
        int index = -1;
        for(node n : lon){
            if(n.equals(in.firstElement())){
                index = lon.indexOf(n);
            }
        }
        if(index == -1){
            lon.add(new node(in));
        }else{
            if(in.size()>2) {
                in.remove(0);
                in.remove(0);
                lon.elementAt(index).add(in);
            }else{
                System.out.println("DUPLICATE");
            }
        }

    }
}
