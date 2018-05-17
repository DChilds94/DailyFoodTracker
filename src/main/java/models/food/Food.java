package models.food;


public abstract class Food {

    private int id;
    private String name;
    private int kcal;

    public Food() {
    }

    public Food(String name, int kcal) {
        this.name = name;
        this.kcal = kcal;
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

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }
}
