package sample;

import javax.sound.midi.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Sound {

    private Sequencer sequencer;
    private Synthesizer synth;
    private MidiChannel[] midiChannels;
    private Sequence currentSequence;

    public Sound() throws Exception{

        this.sequencer = MidiSystem.getSequencer();
        this.synth = MidiSystem.getSynthesizer();

        synth.open();

        Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
        midiChannels = synth.getChannels();

        synth.loadInstrument(inst[0]);

        sequencer.open();

        //playSong();

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

    public void playChord(String chord) throws Exception {
        int baseNote = -1;
        switch (""+chord.charAt(0)) {
            case "c":
                baseNote = 48;
                break;
            case "d":
                baseNote = 50;
                break;
            case "e":
                baseNote = 52;
                break;
            case "f":
                baseNote = 53;
                break;
            case "g":
                baseNote = 55;
                break;
            case "a":
                baseNote = 57;
                break;
            case "b":
                baseNote = 59;
                break;
        }
        if(baseNote != -1){
            midiChannels[0].noteOn(baseNote, 100);
            if(chord.length() ==2){
                midiChannels[0].noteOn(baseNote+3, 100);
            }
            else{
                midiChannels[0].noteOn(baseNote+4, 100);
            }
            midiChannels[0].noteOn(baseNote+7, 100);
        }

//        sequencer.getSequence().createTrack();
    }

}
