

public class Traveller {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "\n Name: " + name + " ID: " + id;
    }

    /**
     * Initiates Traveller object
     *
     * @param id    Traveller ID #
     * @param name  Name of the traveller
     *
     */
    public Traveller(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
