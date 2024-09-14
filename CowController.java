import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CowController {
    private CowModel model;
    private CowView view;

    public CowController(CowModel model, CowView view) {
        this.model = model;
        this.view = view;

        this.view.addSubmitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        this.view.addAddCowListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddCow();
            }
        });

        this.view.addShowIdsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllCowIds();
            }
        });
    }

    private void handleSubmit() {
        String id = view.getIdInput().trim();
        
        if (isValidId(id)) {
            Cow cow = findCowById(id);
            if (cow != null) {
                view.setResultMessage("ID is valid!");
                double milkProduction = model.calculateMilkProduction(cow);
                double totalMilk = milkProduction;

                view.setMilkMessage("Milk produced: " + milkProduction + " liters");
                view.setTotalMilkMessage("Total milk of all types: " + totalMilk + " liters");
            } else {
                view.setResultMessage("Invalid ID. Please enter a valid 8-digit ID.");
                view.setMilkMessage("");
                view.setTotalMilkMessage("");
            }
        } else {
            view.setResultMessage("Invalid ID. ID must be 8 digits long and cannot start with 0.");
            view.setMilkMessage("");
            view.setTotalMilkMessage("");
        }
    }

    private void handleAddCow() {
        String id = view.getIdInput().trim();
        String breed = view.getBreedInput().trim();
        int ageYears = view.getAgeYearsInput();
        int ageMonths = view.getAgeMonthsInput();

        if (isValidId(id) && isValidBreed(breed)) {
            Cow newCow = new Cow(id, breed, ageYears, ageMonths);
            model.addCow(newCow);
            view.setResultMessage("New cow added successfully!");
        } else {
            view.setResultMessage("Invalid data. Please check the ID and breed.");
        }
    }

    private boolean isValidId(String id) {
        return id.matches("[1-9]\\d{7}"); // ID must be 8 digits long and cannot start with 0
    }

    private boolean isValidBreed(String breed) {
        return breed.equals("White") || breed.equals("Brown") || breed.equals("Pink");
    }

    private void showAllCowIds() {
        StringBuilder ids = new StringBuilder();
        for (Cow cow : model.getAllCows()) {
            ids.append(cow.getId()).append("\n");
        }
        view.setIdList(ids.toString());
    }

    private Cow findCowById(String id) {
        for (Cow cow : model.getAllCows()) {
            if (cow.getId().equals(id)) {
                return cow;
            }
        }
        return null;
    }

    public void start() {
        view.setVisible(true);
    }
}
