public class Person implements Comparable<Person>
{
    private Date born;
    private Date died;
    private Name name;

    Person(final Date born, final Name name)
    {
        if(born == null){
            throw new IllegalPersonException("invalid date of birth");
        }
        if(name == null){
            throw new IllegalPersonException("invalid name");
        }

        this.born = born;
        this.name = name;
    }

    boolean isAlive(){
        return(died == null);
    }

    Date getDateOfBirth()
    {
        return born;
    }

    Date getDateOfDeath()
    {
        return died;
    }

    void die(final Date dateOfDeath)
    {
        died = dateOfDeath;
    }

    Name getName()
    {
        return name;
    }


    @Override
    public int compareTo(final Person o)
    {
        return born.compareTo(o.born);
    }

    @Override
    public String toString()
    {
        if(isAlive())
        {
            return name.getPrettyName() + " was born " + born.getYyyyMmDd() + " and is still alive";
        }
        return name.getPrettyName() + " was born " + born.getYyyyMmDd() + " and died " + died.getYyyyMmDd();
    }
}
