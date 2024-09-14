public class Cow {
    private String id;
    private String breed;
    private int ageYears;
    private int ageMonths;

    public Cow(String id, String breed, int ageYears, int ageMonths) {
        this.id = id;
        this.breed = breed;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
    }

    public String getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }
}

