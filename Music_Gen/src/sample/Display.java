package sample;

public class Display {

    private int[] noteHeight;

    private static volatile Display instance;
    private static Object mutex = new Object();

    private Display() {

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
        noteHeight[n] = noteHeight[n] + 10;
    }

    public void decrementAllNoteHeight() {
        for(int n: noteHeight) {
            n --;
        }
    }
}
