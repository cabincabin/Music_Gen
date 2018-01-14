package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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

    public String nextNote(String [] in){
        for(node n : heads){//1
            if(n.note.equals(in[0])){
                if(n.lon.isEmpty()){
                    return nextNote2(Arrays.copyOfRange(in, 1, in.length));
                }
                for(node k: n.lon){//2
                    if(k.note.equals(in[1])) {
                        if (k.lon.isEmpty()) {
                            return nextNote3(Arrays.copyOfRange(in, 1, in.length));
                        }
                        for (node f : k.lon) {//3
                            if(f.note.equals(in[2])) {
                                if (f.lon.isEmpty()) {
                                    return nextNote3(Arrays.copyOfRange(in, 1, in.length));
                                }
                                return bestNode(f.lon);
                            }
                        }
                    }
                }
            }
        }
        return "C";
    }

    public String nextNote2(String [] in){
        for(node n : heads){//1
            return bestNode(n.lon);
        }
        return "C";
    }

    public String nextNote3(String [] in){
        for(node n : heads){//1
            if(n.note.equals(in[0])){
                if(n.lon.isEmpty()){
                    return nextNote2(Arrays.copyOfRange(in, 1, in.length));
                }
                return bestNode(n.lon);
            }
        }
        return "C";
    }

    public String nextNote4(String [] in){
        for(node n : heads){//1
            if(n.note.equals(in[0])){
                if(n.lon.isEmpty()){
                    return nextNote2(Arrays.copyOfRange(in, 1, in.length));
                }
                for(node k: n.lon){//2
                    if(k.note.equals(in[1])) {
                        if (k.lon.isEmpty()) {
                            return nextNote3(Arrays.copyOfRange(in, 1, in.length));
                        }
                        return bestNode(k.lon);
                    }
                }
            }
        }
        return "C";
    }

    public String bestNode(Vector<node> in){
        int len = in.size();
        double perTotal = 0;
        double[] percentage = new double[len];
        double[] newPercentage = new double[len];
        double[] range = new double[len];

        for(int i = 0; i < len; i++) {
            percentage[i] = in.get(i).weight;
        }

        for(int i = 0; i < len; i++) {
            perTotal += percentage[i];
        }

        for(int i = 0; i < len; i++) {
            newPercentage[i] = (100/perTotal) * percentage[i];
        }

        for(int i = 0; i < len ; i++) {
            if(i-1 > 0) {
                range[i] = range[i - 1] + newPercentage[i];
            } else {
                range[i] = newPercentage[i];
            }
        }

        long time = System.currentTimeMillis();
        Random rand = new Random(time);
        int random = (int) rand.nextDouble() * 100;

        for (int i = 0; i < len ; i++) {
            if (random > range[i]) {
                return in.get(i).note;
            }
        }
        return in.get(0).note;

    }

}
