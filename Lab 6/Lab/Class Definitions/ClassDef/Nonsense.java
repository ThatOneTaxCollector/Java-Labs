/**
 * Class: Nonsense
 * This class represents a Nonsense object with three fields: krz, og, and zi4928.
 */
public class Nonsense {
    private Object krz; // The krz field stores an object
    private byte og; // The og field stores a byte value
    private char zi4928; // The zi4928 field stores a char value

    /**
     * Constructor
     * This constructor takes parameters with the same name as the fields and initializes the fields using 'this'.
     * @param krz The krz field stores an object
     * @param og The og field stores a byte value
     * @param zi4928 The zi4928 field stores a char value
     */
    public Nonsense(Object krz, byte og, char zi4928) {
        this.krz = krz;
        this.og = og;
        this.zi4928 = zi4928;
    }

    /**
     * Get the value of the krz field
     * @return The value of the krz field
     */
    public Object getKrz() {
        return krz;
    }

    /**
     * Get the value of the og field
     * @return The value of the og field
     */
    public byte getOg() {
        return og;
    }

    /**
     * Get the value of the zi4928 field
     * @return The value of the zi4928 field
     */
    public char getZi4928() {
        return zi4928;
    }

    /**
     * Set the value of the krz field
     * @param krz The new value for the krz field
     */
    public void setKrz(Object krz) {
        this.krz = krz;
    }

    /**
     * Set the value of the og field
     * @param og The new value for the og field
     */
    public void setOg(byte og) {
        this.og = og;
    }

    /**
     * Set the value of the zi4928 field
     * @param zi4928 The new value for the zi4928 field
     */
    public void setZi4928(char zi4928) {
        this.zi4928 = zi4928;
    }
}