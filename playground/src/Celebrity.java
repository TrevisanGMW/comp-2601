class Celebrity    {
    String firstName;
    String lastName;
    String famousFor;
    int    yearBorn;

    Celebrity(final String firstName, final String lastName, final String famousFor, final int yearBorn)        {
        this.firstName = firstName;
        this.lastName = lastName;
        this.famousFor = famousFor;
        this.yearBorn = yearBorn;
    }

    @Override
    public String toString()        {
        return "Celebrity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", famousFor='" + famousFor + '\'' +
                ", yearBorn=" + yearBorn +
                '}';
    }
}

