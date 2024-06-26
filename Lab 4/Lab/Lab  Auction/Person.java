/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling and braden gerlach.
 * @version 2024.05.31
 */
public class Person
{
    // The name of this person.
    private final String name;

    /**
     * Create a new person with the given name.
     * @param name The person's name.
     */
    public Person(String name)
    {
        this.name = name;
    }

    /**
     * @return The person's name.
     */
    public String getName()
    {
        return name;
    }
}
