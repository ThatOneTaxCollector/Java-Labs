import java.util.ArrayList;

public class Aeiou {
    private Object og; // The og field stores an object
    private ArrayList<Nonsense> krz; // The krz field stores an ArrayList of Nonsense objects

    /**
     * Constructor
     * This constructor takes parameters with the same name as the fields and initializes the fields using 'this'.
     * @param og The og field stores an object
     * @param krz The krz field stores an ArrayList of Nonsense objects
     */
    public Aeiou(Object og, ArrayList<Nonsense> krz) {
        this.og = og;
        this.krz = krz;
    }

    /**
     * Get the value of the og field
     * @return The value of the og field
     */
    public Object getOg() {
        return og;
    }

    /**
     * Get the value of the krz field
     * @return The value of the krz field
     */
    public ArrayList<Nonsense> getKrz() {
        return krz;
    }

    /**
     * Set the value of the krz field
     * @param krz The new value for the krz field
     */
    public void setKrz(ArrayList<Nonsense> krz) {
        this.krz = krz;
    }

    /**
     * Set the value of the og field
     * @param og The new value for the og field
     */
    public void setOg(Object og) {
        this.og = og;
    }

    /**
     * Add a Nonsense object to the krz field
     * @param nonSense The Nonsense object to add
     */
    public void addKrz(Nonsense nonSense) {
        this.krz.add(nonSense);
    }
}