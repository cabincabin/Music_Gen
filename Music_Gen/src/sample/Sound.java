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
        }
//        sequencer.getSequence().createTrack();
    }

}
