import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class CowView extends JFrame {
    private JTextField idField;
    private JTextField breedField;
    private JTextField ageYearsField;
    private JTextField ageMonthsField;
    private JButton submitButton;
    private JButton addCowButton;
    private JButton showIdsButton;
    private JLabel resultLabel;
    private JLabel milkLabel;
    private JLabel totalMilkLabel;
    private JTextArea idListArea;

    public CowView() {
        setTitle("Cow Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter Cow ID (8 digits, no leading zero):"));
        idField = new JTextField(15);
        add(idField);

        add(new JLabel("Breed (White, Brown, Pink):"));
        breedField = new JTextField(15);
        add(breedField);

        add(new JLabel("Age in Years:"));
        ageYearsField = new JTextField(5);
        add(ageYearsField);

        add(new JLabel("Age in Months:"));
        ageMonthsField = new JTextField(5);
        add(ageMonthsField);

        submitButton = new JButton("Submit");
        add(submitButton);

        addCowButton = new JButton("Add Cow");
        add(addCowButton);

        showIdsButton = new JButton("Show All Cow IDs");
        add(showIdsButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        milkLabel = new JLabel("");
        add(milkLabel);

        totalMilkLabel = new JLabel("");
        add(totalMilkLabel);

        idListArea = new JTextArea(10, 30);
        idListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(idListArea);
        add(scrollPane);
    }

    public String getIdInput() {
        return idField.getText();
    }

    public String getBreedInput() {
        return breedField.getText();
    }

    public int getAgeYearsInput() {
        try {
            return Integer.parseInt(ageYearsField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int getAgeMonthsInput() {
        try {
            return Integer.parseInt(ageMonthsField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setResultMessage(String message) {
        resultLabel.setText(message);
    }

    public void setMilkMessage(String message) {
        milkLabel.setText(message);
    }

    public void setTotalMilkMessage(String message) {
        totalMilkLabel.setText(message);
    }

    public void setIdList(String ids) {
        idListArea.setText(ids);
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void addAddCowListener(ActionListener listener) {
        addCowButton.addActionListener(listener);
    }

    public void addShowIdsListener(ActionListener listener) {
        showIdsButton.addActionListener(listener);
    }
}
