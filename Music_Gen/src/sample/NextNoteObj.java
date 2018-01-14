package sample;

import java.util.Random;

public class NextNoteObj {
    String prevChord;
    Random generator = new Random(System.currentTimeMillis());

    NextNoteObj(){ prevChord = null;} //should prolly be singleton or permanant

    public String getNextChord(String currChord){
        if(prevChord== null){
            prevChord = currChord;
            return getLayerOne(currChord);
        }
        else{//layer two goes here.
           return getLayerOne(currChord);
        }


    }

    private String getLayerOne(String layerOne){ //can get rid of elses to go to default with no break
        int chooseChord = (int) Math.floor(generator.nextDouble()*100)+1;
        switch (layerOne){
            case "em":
                if(chooseChord>0 && chooseChord<=33)
                    return "f";
                else if(chooseChord>33 && chooseChord<=59)
                    return "am";
                else if(chooseChord>59 && chooseChord<=67)
                    return "g";
                else if(chooseChord>67 && chooseChord<=75)
                    return "dm";
                else if(chooseChord>75 && chooseChord<=80)
                    return "c";
                else
                    return layerOne;
            case "dm":
                if(chooseChord>0 && chooseChord<=18)
                    return "am";
                else if(chooseChord>18 && chooseChord<=34)
                    return "g";
                else if(chooseChord>34 && chooseChord<=50)
                    return "f";
                else if(chooseChord>50 && chooseChord<=63)
                    return "c";
                else if(chooseChord>63 && chooseChord<=72)
                    return "em";
                else
                    return layerOne;
            case "f":
                if(chooseChord>0 && chooseChord<=29)
                    return "g";
                else if(chooseChord>29 && chooseChord<=58)
                    return "c";
                else if(chooseChord>58 && chooseChord<=68)
                    return "am";
                else if(chooseChord>68 && chooseChord<=63)
                    return "dm";
                else
                    return layerOne;

            case "c":
                if(chooseChord>0 && chooseChord<=28)
                    return "g";
                else if(chooseChord>28 && chooseChord<=48)
                    return "f";
                else if(chooseChord>48 && chooseChord<=60)
                    return "am";
                else if(chooseChord>60 && chooseChord<=70)
                    return "dm";
                else
                    return layerOne;
            case "g":
                if(chooseChord>0 && chooseChord<=26)
                    return "am";
                else if(chooseChord>26 && chooseChord<=47)
                    return "c";
                else if(chooseChord>47 && chooseChord<=69)
                    return "f";
                else if(chooseChord>69 && chooseChord<=75)
                    return "dm";
                else
                    return layerOne;
            case "am":
                if(chooseChord>0 && chooseChord<=24)
                    return "f";
                else if(chooseChord>24 && chooseChord<=44)
                    return "g";
                else if(chooseChord>44 && chooseChord<=55)
                    return "c";
                else if(chooseChord>55 && chooseChord<=61)
                    return "dm";
                else if(chooseChord>61 && chooseChord<=67)
                    return "em";
                else
                    return layerOne;
            default:
                return layerOne;
        }

    }

    private String getLayerTwo(String layerOne, String layerTwo){
        return null;
    }
}
