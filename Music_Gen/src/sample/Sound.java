package sample;

import javax.sound.midi.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Vector;

public class Sound implements Runnable{

    private Sequencer sequencer;
    private Synthesizer synth;
    private MidiChannel[] midiChannels;
    private Sequence currentSequence;
    public  int noteNum;
    public  int noteType; //0 major3 1 minor3
    public  int BPM;
    Random generator = new Random(System.currentTimeMillis());

    public Sound() throws Exception{
        noteNum = 48;
        noteType = 0;
        BPM = 88;
        this.sequencer = MidiSystem.getSequencer();
        this.synth = MidiSystem.getSynthesizer();

        synth.open();

        Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
        midiChannels = synth.getChannels();

        //midiChannels[0].programChange(inst[10].getPatch().getProgram());

        sequencer.open();

        //playSong();

        }

    @Override
    public void run(){
        int curr = 0;
        int total = 16;
        int note = 0;
        Vector<Integer> possibilities = new Vector<Integer>();
            
        possibilities.add(2);
        possibilities.add(4);
        possibilities.add(8);
        possibilities.add(16);
        //possibilities.add(1);
            while(total > 0){
                try{
                note = (int)Math.floor(generator.nextDouble()*4);
                if(note == 1){
                    if(noteType == 0){
                        Display.getInstance().incrementNoteHeight(noteNum + 12 + 4 - 36);
                        midiChannels[1].noteOn(noteNum+12+4, 100);
                    }
                    if(noteType == 1){
                        Display.getInstance().incrementNoteHeight(noteNum + 12 + 3 - 36);
                        midiChannels[1].noteOn(noteNum+12+3, 100);
                    }
                }
                else if(note  == 2){
                    Display.getInstance().incrementNoteHeight(noteNum + 12 + 7 - 36);
                    midiChannels[1].noteOn(noteNum+12+7, 100);
                }
                else if(note == 3){
                    if(noteType == 0){
                        Display.getInstance().incrementNoteHeight(noteNum + 12 + 7 - 36);
                        midiChannels[1].noteOn(noteNum+12+7+4, 100);
                    }
                    if(noteType == 1){
                        Display.getInstance().incrementNoteHeight(noteNum + 12 + 7 + 3 - 36);
                        midiChannels[1].noteOn(noteNum+12+7+3, 100);
                    }
                }
                else {
                    Display.getInstance().incrementNoteHeight(noteNum + 12 - 36);
                    midiChannels[1].noteOn(12, 100);
                }

                int randVal = (int)Math.floor(generator.nextDouble()*possibilities.size());
                curr = possibilities.get(randVal);
                total = total - curr;
                if(total < 8) {
                    for(int i = 0; i < possibilities.size(); i++) {
                        if(possibilities.get(i) == 8) {
                            possibilities.remove(i);
                        }
                    }
                } else if(total < 4) {
                    for(int i = 0; i < possibilities.size(); i++) {
                        if(possibilities.get(i) == 4) {
                            possibilities.remove(i);
                        }
                    }
                } else if (total < 2) {
                    for(int i = 0; i < possibilities.size(); i++) {
                        if(possibilities.get(i) == 2) {
                            possibilities.remove(i);
                        }
                    }
                }
                Thread.sleep(60000*curr*4/(BPM*16));
            } catch (InterruptedException e) {
                System.out.println(noteNum);
                e.printStackTrace();
            }
        }

    }

    public void playSong() throws Exception{
        InputStream is = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Floris\\Documents\\Hackathon_2018\\Midi files/file.mid")));
        sequencer.setSequence(is);
        sequencer.start();
    }

    public void playKey(String key) throws Exception {
        if(key.equals("a")) {
            midiChannels[0].noteOn(57, 100);
        } else if(key.equals("b")){
            midiChannels[0].noteOn(59 ,100);
        } else if(key.equals("c")) {
            midiChannels[0].noteOn(48,100);
        } else if(key.equals("d")) {
            midiChannels[0].noteOn(50,100);
        } else if(key.equals("e")) {
            midiChannels[0].noteOn(52,100);
        } else if(key.equals("f")) {
            midiChannels[0].noteOn(53,100);
        } else if(key.equals("g")) {
            midiChannels[0].noteOn(55,100);
        } else if(key.equals("cs")) {
            midiChannels[0].noteOn(49,100);
        } else if(key.equals("ds")) {
            midiChannels[0].noteOn(51,100);
        } else if(key.equals("fs")) {
            midiChannels[0].noteOn(54,100);
        } else if(key.equals("gs")) {
            midiChannels[0].noteOn(56,100);
        } else if(key.equals("as")) {
            midiChannels[0].noteOn(58,100);
        }
//        sequencer.getSequence().createTrack();
    }



    //number from 1 to 26 for playing note durration (weighted)
    //Plox use a random number generater
    //THIS IS SHITTY CODE
    public int getNoteDur(int num){
        if(num>0 && num<=3){
            return 1;
        }
        else if(num>3 && num<=6){
            return 2;
        }
        else if(num>6 && num<=9){
            return 4;
        }
        else if(num>9 && num<=12){
            return 8;
        }
        else if(num>12 && num<=15){
            return 16;
        }
        else if(num==16){
            return 3;
        }
        else if(num==17){
            return 5;
        }
        else if(num==18){
            return 6;
        }
        else if(num==19){
            return 7;
        }
        else{
            return 9 + num - 20;
        }
    }

}
