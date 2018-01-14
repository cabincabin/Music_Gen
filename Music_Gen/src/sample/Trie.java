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
            String temp = s.split(",")[0].toLowerCase();
            if(found.contains(temp.toLowerCase())){
                for(int i = 0; i<heads.size();i++){
                    if(found.elementAt(i).toLowerCase().equals(temp.toLowerCase())) {
                        Vector<String> lis = new Vector(Arrays.asList(s.split(",")));
                        lis.remove(0);
                        lis.remove(0);
                        heads.elementAt(i).add(lis);
                    }
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
            if(n.note.toLowerCase().equals(in[0].toLowerCase())){
                if(n.lon.isEmpty()){
                    return nextNote2(Arrays.copyOfRange(in, 1, in.length));
                }
                for(node k: n.lon){//2
                    if(k.note.toLowerCase().equals(in[1].toLowerCase())) {
                        if (k.lon.isEmpty()) {
                            return nextNote3(Arrays.copyOfRange(in, 1, in.length));
                        }
                        for (node f : k.lon) {//3
                            if(f.note.toLowerCase().equals(in[2].toLowerCase())) {
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
        return "e";
    }

    public String nextNote2(String [] in){
        for(node n : heads){//1
            return bestNode(n.lon);
        }
        return "F";
    }

    public String nextNote3(String [] in){
        for(node n : heads){//1
            if(n.note.toLowerCase().equals(in[0].toLowerCase())){
                if(n.lon.isEmpty()){
                    return nextNote2(Arrays.copyOfRange(in, 1, in.length));
                }

                return bestNode(n.lon);
            }
        }
        return "F";
    }

    public String nextNote4(String [] in){
        for(node n : heads){//1
            if(n.note.toLowerCase().equals(in[0].toLowerCase())){
                if(n.lon.isEmpty()){
                    System.out.println("Emp");
                    return nextNote2(Arrays.copyOfRange(in, 1, in.length));

                }
                for(node k: n.lon){//2
                    if(k.note.toLowerCase().equals(in[1].toLowerCase())) {
                        if (k.lon.isEmpty()) {
                            System.out.println("ty");
                            return nextNote3(Arrays.copyOfRange(in, 1, in.length));
                        }
                        return bestNode(k.lon);
                    }
                }
            }
        }
        return "F";
    }

    public String bestNode(Vector<node> in){
        int len = in.size();
        double perTotal = 0;
        double[] percentage = new double[len];
        double[] newPercentage = new double[len];
        double[] range = new double[len];

        for(int i = 0; i < len; i++) {
            percentage[i] = in.get(i).weight;
            //System.out.println("Ni" + in.get(i).note);
        }

        for(int i = 0; i < len; i++) {
            perTotal += percentage[i];
        }

        for(int i = 0; i < len; i++) {
            newPercentage[i] = (100/perTotal) * percentage[i];
        }

        for(int i = 0; i < len; i++) {
            if(i-1 >= 0) {
                range[i] = range[i - 1] + newPercentage[i];
            } else {
                range[0] = newPercentage[i];
            }
           // System.out.println("Ni" + range[i]);
        }

        long time = System.currentTimeMillis();
        Random rand = new Random(time);
        int random = (int) (rand.nextDouble() * 100);
        //System.out.println(random);


        for (int i = 0; i < len; i++) {
            if(i == 0){
                if(random > 0 && random <= range[0]){
                    return in.get(0).note.toLowerCase();
                }
            }
            else if (random > range[i-1] && random <= range[i]) {
                return in.get(i).note.toLowerCase();
            }

        }
        return "F";

    }

}
