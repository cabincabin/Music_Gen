package sample;
import javax.sound.midi.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class PlayChord implements Runnable {

    private Sequencer sequencer;
    private Synthesizer synth;
    private MidiChannel[] midiChannels;
    private Sequence currentSequence;
    NextNoteObj Next;
    Sound soundMesure1;
    Sound soundMesure2;
    Sound soundMesure3;
    int noteDepth;

    public static String chord;
    public static int BPM;

    public PlayChord() throws Exception{
        soundMesure1 = new Sound();
        soundMesure2 = new Sound();
        soundMesure3 = new Sound();
        chord = "c";
        BPM = 88;
        this.sequencer = MidiSystem.getSequencer();
        this.synth = MidiSystem.getSynthesizer();

        synth.open();

        Instrument[] inst = synth.getDefaultSoundbank().getInstruments();
        midiChannels = synth.getChannels();

        synth.loadInstrument(inst[40]);

        //midiChannels[0].programChange(inst[40].getPatch().getProgram());

        sequencer.open();
        Next = new NextNoteObj();
    }

    @Override
    public void run(){

        try {
            //System.out.println("here");
            noteDepth = (int) Math.random()*4;
            soundMesure1.noteNum = playChord(chord, 100);
            soundMesure1.noteType = chord.length()-1;
            soundMesure1.BPM = BPM;
            soundMesure2.noteNum = playChord(chord, 100)+12;
            soundMesure2.noteType = chord.length()-1;
            soundMesure2.BPM = BPM;
            /*soundMesure3.noteNum = playChord(chord, 100)+34;
            soundMesure3.noteType = chord.length()-1;
            soundMesure3.BPM = BPM;*/
            try {
                new Thread(soundMesure1).start();
                new Thread(soundMesure2).start();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            Thread.sleep(60000/(BPM));
            playChord(chord, 75);
            Thread.sleep(60000/(BPM));
            playChord(chord, 90);
            Thread.sleep(60000/(BPM));
            playChord(chord, 75);
            Thread.sleep(60000/(BPM));
            chord = Next.getNextChord(chord);
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSong() throws Exception{
        InputStream is = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Floris\\Documents\\Hackathon_2018\\Midi files/file.mid")));
        sequencer.setSequence(is);
        sequencer.start();
    }

    public int playChord(String chord, int vel) throws Exception {
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
            //System.out.println(baseNote);
            //System.out.println(vel);
            if (noteDepth==0)
                baseNote = baseNote-12;
            midiChannels[0].noteOn(baseNote, vel);
            if(chord.length() ==2){
                Display.getInstance().incrementNoteHeight(baseNote + 3 - 36);
                midiChannels[0].noteOn(baseNote+3, vel);
            }
            else{
                Display.getInstance().incrementNoteHeight(baseNote + 4 - 36);
                midiChannels[0].noteOn(baseNote+4, vel);
            }
            Display.getInstance().incrementNoteHeight(baseNote + 7 - 36);
            midiChannels[0].noteOn(baseNote+7, vel);
        }
        return baseNote;

//        sequencer.getSequence().createTrack();
    }
}