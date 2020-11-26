package catLady;

public class Cat {
    private String name;
    private String breeds;
    private double size;

    public Cat(String[] s) {
        this.name = s[1];
        this.breeds = s[0];
        this.size = Double.parseDouble(s[2]);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breeds, this.name, this.size);
    }

}
