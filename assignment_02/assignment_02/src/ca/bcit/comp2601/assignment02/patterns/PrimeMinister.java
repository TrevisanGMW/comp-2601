package ca.bcit.comp2601.assignment02.patterns;

/**
 * PrimeMinister singleton class (Only one is allowed to be created)
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class PrimeMinister{
    private static PrimeMinister pm;
    private final String name;

    static{
        pm = null;
    }

    /**
     * Private Constructor (To create singleton)
     * @param name name of the prime minister
     */
    private PrimeMinister(final String name){
        if (name == null){
            throw new IllegalArgumentException("Invalid name. Cannot be null or blank.");
        }
        this.name = name;
    }

    /**
     * Instance getter (Only one PM allowed)
     * @param name name of the prime minister, so it's created in case it's the first time
     * @return
     */
    public static PrimeMinister getInstance(final String name){
        if(pm == null){
            pm = new PrimeMinister(name);
        }
        return pm;
    }

    /**
     * Name Getter
     * @return PM Name
     */
    public String getName() {
        return name;
    }

    /**
     * toString override
     * @return a formatted version of the prime minister's name and its hashCode
     */
    @Override
    public String toString() {
        return "PrimeMinister \"" + name + "\"" +
                " (hashCode: " + this.hashCode() + ")";
    }
}
