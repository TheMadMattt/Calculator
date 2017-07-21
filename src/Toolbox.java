import javax.swing.*;

public interface Toolbox{
    default void ButtonCode(JButton button, JTextField mainField, char pressedKey) {
        if (mainField.getText().isEmpty()) {
            mainField.setText(mainField.getText() + button.getText());
        } else if (mainField.getText().equals("0")) {
            mainField.setText(button.getText());
        } else {
            mainField.setText(mainField.getText() + button.getText());
        }
        pressedKey = button.getText().charAt(0);
        mainField.requestFocusInWindow();
    }
}
