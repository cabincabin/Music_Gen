package sample;

public class Display {

    private int[] noteHeight;

    private static volatile Display instance;
    private static Object mutex = new Object();

    private Display() {
        noteHeight = new int[86 + 4 - 36];
        for(int i = 0; i < 86 + 4 - 36; i++) {
            noteHeight[i] = 1   ;
        }
    }

    public static Display getInstance() {
        Display result = instance;

        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new Display();

            }
        }

        return result;
    }

    public int[] getNoteHeight() {
        return noteHeight;
    }

    public void setNoteHeight(int[] noteHeight) {
        this.noteHeight = noteHeight;
    }

    public void setSpecificNoteHeight(int value, int n) {
        this.noteHeight[n] = value;
    }

    public int getSpecficNoteHeight(int n) {
        return noteHeight[n];
    }

    public void incrementNoteHeight(int n) {
        //System.out.println("This is the noteheight: " + n);
        noteHeight[n] = noteHeight[n] + 50;
    }

    public void decrementAllNoteHeight() {
        for(int i = 0 ; i < noteHeight.length; i++) {
            if(noteHeight[i] > 1)
                noteHeight[i] = noteHeight[i] - 1;
        }
    }
}
