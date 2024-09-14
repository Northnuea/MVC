import java.util.ArrayList;
import java.util.List;

class CowModel {
    private List<Cow> cows;

    public CowModel() {
        cows = new ArrayList<>();
        generateSampleData();
    }

    public void generateSampleData() {
        cows.add(new Cow("12345678", "White", 5, 3)); 
        cows.add(new Cow("23456789", "Brown", 2, 0)); 
        cows.add(new Cow("34567890", "Pink", 0, 8)); 
        cows.add(new Cow("45678901", "White", 8, 2)); 
        cows.add(new Cow("56789012", "Brown", 7, 0)); 
        cows.add(new Cow("67890123", "Pink", 0, 2));
        cows.add(new Cow("78901234", "White", 6, 9)); 
        cows.add(new Cow("89012345", "Brown", 4, 10)); 
        cows.add(new Cow("90123456", "Pink", 9, 2));
        cows.add(new Cow("15987530", "White", 1, 3)); 
        cows.add(new Cow("25879461", "Brown", 3, 3)); 
        cows.add(new Cow("11111111", "Pink", 4, 9));
        cows.add(new Cow("22222222", "White", 1, 5)); 
        cows.add(new Cow("33333333", "Brown", 9, 9)); 
        cows.add(new Cow("44444444", "Pink", 0, 1));
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    public List<Cow> getAllCows() {
        return cows;
    }

    public double calculateMilkProduction(Cow cow) {
        String breed = cow.getBreed();
        double milk = 0;
        switch (breed) {
            case "White":
                milk = 120 - (cow.getAgeYears() * 12 + cow.getAgeMonths());
                break;
            case "Brown":
                milk = 40 - cow.getAgeYears();
                break;
            case "Pink":
                milk = 30 - cow.getAgeMonths();
                break;
        }
        return Math.max(milk, 0); // Ensure milk is not negative
    }

    public String getMilkType(Cow cow) {
        switch (cow.getBreed()) {
            case "White":
                return "Plain Milk";
            case "Brown":
                return "Chocolate Milk";
            case "Pink":
                return "Strawberry Milk";
            default:
                return "Unknown";
        }
    }
}

