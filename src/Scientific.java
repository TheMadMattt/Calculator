import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.RoundingMode;
import java.text.*;

/**
 * Created by Mateusz on 17.07.2017.
 */
public class Scientific extends JFrame implements Toolbox {
    public JPanel scientific;
    private JFormattedTextField mainField;
    private JTextField secondField;
    private JButton a3Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a0Button;
    private JButton add;
    private JButton subtract;
    private JButton multiply;
    private JButton divide;
    private JButton equal;
    private JTextField memoryField;
    private JButton CEButton;
    private JButton a4Button;
    private JButton a2Button;
    private JButton a1Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton negation;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton dotButton;
    private JButton percent;
    private JButton squareRoot;
    private JButton divideByOne;
    private JButton square;
    private JButton MClearButton;
    private JButton MReadButton;
    private JButton MSaveButton;
    private JButton MplusButton;
    private JButton MminusButton;
    private JButton sinus;
    private JButton tangens;
    private JButton cosinus;
    private JButton radButton;
    private JButton powXY;
    private JButton logarithm;
    private double numberA = 0;
    private double numberB = 0;
    private double result = 0;
    private double memory = 0;
    private String operation = "0";
    private char pressedKey = 'a';
    private boolean radEnabled = true;

    Scientific(int posX, int posY) {
        super("Naukowy");
        setContentPane(scientific);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Calculator.png")));
        setBounds(posX, posY, 400, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JMenuBar mainMenu = new JMenuBar();
        JMenu calculators = new JMenu("Kalkulatory");
        JMenuItem standard = new JMenuItem("Standardowy");
        mainMenu.add(calculators);
        calculators.add(standard);
        setJMenuBar(mainMenu);
        mainMenu.setVisible(true);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                mainField.requestFocusInWindow();
            }
        });
        mainField.setBorder(null);
        secondField.setBorder(null);
        MClearButton.setEnabled(false);
        MReadButton.setEnabled(false);
        memoryField.setEditable(false);
        radButton.setBorder(null);
        initButtons();

        clearButton.addActionListener((ActionEvent e) -> {
            mainField.setText("0");
            secondField.setText(null);
            result = 0;
            numberA = 0;
            numberB = 0;
            operation = "0";
            pressedKey = 'a';
            mainField.requestFocusInWindow();
        });
        deleteButton.addActionListener((ActionEvent e) -> {
            if (mainField.getText().equals("Error")) {
                mainField.setText("0");
                secondField.setText(null);
                operation = "0";
                pressedKey = 'a';
            }
            if (!mainField.getText().isEmpty()) {
                String buff;
                buff = mainField.getText();
                mainField.setText(buff.substring(0, buff.length() - 1));
            }
            mainField.requestFocusInWindow();
        });
        add.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
            } else {
                if (!mainField.getText().isEmpty()) {
                    numberB = Double.parseDouble(mainField.getText());
                } else {
                    numberB = 0;
                }
            }
            if (pressedKey != '0' && mainField.getText().equals("0")) {
                pressedKey = add.getText().charAt(0);
            }
            if (operation.equals("+")) {
                numberA += numberB;
            }
            if (operation.equals("-")) {
                numberA = numberA - numberB;
            }
            if (operation.equals("*")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = numberA * numberB;
                }
            }
            if (operation.equals("^")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = Math.pow(numberA, numberB);
                }
            }
            if (operation.equals("/")) {
                if (Character.isDigit(pressedKey)) {
                    if (numberB != 0) {
                        numberA = numberA / numberB;
                        result = numberA;
                        mainField.setText("0");
                        secondField.setText(result + " + ");
                    } else {
                        mainField.setText("Error");
                        secondField.setText(secondField.getText() + numberB);
                    }
                } else if (pressedKey == '+' && mainField.getText().equals("0")) {
                    result = numberA;
                    mainField.setText("0");
                    secondField.setText(result + " + ");
                }
            } else {
                result = numberA;
                secondField.setText(result + " + ");
                mainField.setText("0");
            }
            operation = "+";
            mainField.requestFocusInWindow();
        });
        subtract.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
            } else {
                if (!mainField.getText().isEmpty()) {
                    numberB = Double.parseDouble(mainField.getText());
                } else {
                    numberB = 0;
                }
            }
            if (pressedKey != '0' && mainField.getText().equals("0")) {
                pressedKey = subtract.getText().charAt(0);
            }
            if (operation.equals("+")) {
                numberA += numberB;
            }
            if (operation.equals("-")) {
                numberA = numberA - numberB;

            }
            if (operation.equals("*")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = numberA * numberB;
                }
            }
            if (operation.equals("^")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = Math.pow(numberA, numberB);
                }
            }
            if (operation.equals("/")) {
                if (Character.isDigit(pressedKey)) {
                    if (numberB != 0) {
                        numberA = numberA / numberB;
                        result = numberA;
                        mainField.setText("0");
                        secondField.setText(result + " - ");
                    } else {
                        mainField.setText("Error");
                        secondField.setText(secondField.getText() + numberB);
                    }
                } else if (pressedKey == '-' && mainField.getText().equals("0")) {
                    result = numberA;
                    mainField.setText("0");
                    secondField.setText(result + " - ");
                }
            } else {
                result = numberA;
                secondField.setText(result + " - ");
                mainField.setText("0");
            }
            operation = "-";
            mainField.requestFocusInWindow();
        });
        multiply.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
            } else {
                if (!mainField.getText().isEmpty()) {
                    numberB = Double.parseDouble(mainField.getText());
                } else {
                    numberB = 1;
                }
            }
            if (pressedKey != '0' && mainField.getText().equals("0")) {
                pressedKey = '*';
            }
            if (operation.equals("+")) {
                numberA += numberB;
            }
            if (operation.equals("-")) {
                numberA = numberA - numberB;
            }
            if (operation.equals("*")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = numberA * numberB;
                }
            }
            if (operation.equals("^")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = Math.pow(numberA, numberB);
                }
            }
            if (operation.equals("/")) {
                if (Character.isDigit(pressedKey)) {
                    if (numberB != 0) {
                        numberA = numberA / numberB;
                        result = numberA;
                        mainField.setText("0");
                        secondField.setText(result + " x ");
                    } else {
                        mainField.setText("Error");
                        secondField.setText(secondField.getText() + numberB);
                    }
                } else if (pressedKey == '*' && mainField.getText().equals("0")) {
                    result = numberA;
                    mainField.setText("0");
                    secondField.setText(result + " x ");
                }
            } else {
                result = numberA;
                secondField.setText(result + " x ");
                mainField.setText("0");
            }
            operation = "*";
            mainField.requestFocusInWindow();
        });
        divide.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
            } else {
                if (!mainField.getText().isEmpty()) {
                    numberB = Double.parseDouble(mainField.getText());
                } else numberB = 1;
            }
            if (pressedKey != '0' && mainField.getText().equals("0")) {
                pressedKey = divide.getText().charAt(0);
            }
            if (operation.equals("+")) {
                numberA += numberB;
            }
            if (operation.equals("-")) {
                numberA = numberA - numberB;
            }
            if (operation.equals("*")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = numberA * numberB;
                }
            }
            if (operation.equals("^")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = Math.pow(numberA, numberB);
                }
            }
            if (operation.equals("/")) {
                if (Character.isDigit(pressedKey)) {
                    if (numberB != 0) {
                        numberA = numberA / numberB;
                        result = numberA;
                        mainField.setText("0");
                        secondField.setText(result + " / ");
                    } else {
                        mainField.setText("Error");
                        secondField.setText(secondField.getText() + numberB);
                    }
                }
            } else {
                result = numberA;
                secondField.setText(result + " / ");
                mainField.setText("0");
            }
            operation = "/";
            mainField.requestFocusInWindow();
        });
        equal.addActionListener((ActionEvent e) -> {

            switch (operation) {
                case "+":
                    if (!mainField.getText().isEmpty()) {
                        numberB = Double.parseDouble(mainField.getText());
                    } else numberB = 0;
                    result += numberB;
                    secondField.setText(null);
                    mainField.setText(Double.toString(result));
                    operation = "0";
                    break;
                case "-":
                    if (!mainField.getText().isEmpty()) {
                        numberB = Double.parseDouble(mainField.getText());
                    } else numberB = 0;
                    result -= numberB;
                    secondField.setText(null);
                    mainField.setText(Double.toString(result));
                    operation = "0";
                    break;
                case "*":
                    if (pressedKey != '0' && mainField.getText().equals("0")) {
                        secondField.setText(null);
                        mainField.setText("" + result);
                    } else {
                        if (!mainField.getText().isEmpty()) {
                            numberB = Double.parseDouble(mainField.getText());
                        } else numberB = 1;
                        result *= numberB;
                        secondField.setText(null);
                        mainField.setText(Double.toString(result));
                    }
                    operation = "0";
                    break;
                case "/":
                    if (pressedKey != '0' && mainField.getText().equals("0")) {
                        secondField.setText(null);
                        mainField.setText("" + result);
                    } else if (pressedKey == '0' && mainField.getText().equals("0")) {
                        numberB = Double.parseDouble(mainField.getText());
                        mainField.setText("Error");
                        secondField.setText("" + result + "/" + numberB);
                    } else {
                        if (!mainField.getText().isEmpty()) {
                            numberB = Double.parseDouble(mainField.getText());
                        } else numberB = 1;
                        if (numberB == 0) {
                            mainField.setText("Error");
                            secondField.setText("" + result + "/" + numberB);
                        } else {
                            result /= numberB;
                            secondField.setText(null);
                            mainField.setText(Double.toString(result));
                        }
                    }
                    operation = "0";
                    break;
                case "^":
                    if (pressedKey != '0' && mainField.getText().equals("0")) {
                        secondField.setText(null);
                        mainField.setText("" + result);
                    } else {
                        if (!mainField.getText().isEmpty()) {
                            numberB = Double.parseDouble(mainField.getText());
                        } else numberB = 1;
                        result = Math.pow(result, numberB);
                        secondField.setText(null);
                        mainField.setText(Double.toString(result));
                    }
                    operation = "0";
                    break;
            }
            pressedKey = 'a';
            mainField.requestFocusInWindow();
        });
        squareRoot.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
                result = Math.sqrt(numberA);
                secondField.setText(secondField.getText() + "√" + numberA);
            } else {
                numberB = Double.parseDouble(mainField.getText());
                secondField.setText(secondField.getText() + "√" + numberB);
            }
            if (operation.equals("+")) {
                result += Math.sqrt(numberB);
            }
            if (operation.equals("-")) {
                result -= Math.sqrt(numberB);
            }
            if (operation.equals("*")) {
                result *= Math.sqrt(numberB);
            }
            if (operation.equals("/")) {
                result /= Math.sqrt(numberB);
            }
            mainField.setText(Double.toString(result));
            operation = "0";
            mainField.requestFocusInWindow();
        });
        square.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
                result = numberA * numberA;
                secondField.setText(secondField.getText() + numberA + "²");
            } else {
                numberB = Double.parseDouble(mainField.getText());
                secondField.setText(secondField.getText() + numberB + "²");
            }
            if (operation.equals("+")) {
                result += numberB * numberB;
            }
            if (operation.equals("-")) {
                result -= numberB * numberB;
            }
            if (operation.equals("*")) {
                result *= numberB * numberB;
            }
            if (operation.equals("/")) {
                result /= numberB * numberB;
            }
            mainField.setText(Double.toString(result));
            operation = "0";
            mainField.requestFocusInWindow();
        });
        percent.addActionListener((ActionEvent e) -> {
            numberA = Double.parseDouble(mainField.getText());
            if (operation.equals("+")) {
                result += ((result * numberA) / 100);
            }
            if (operation.equals("-")) {
                result -= ((result * numberA) / 100);
            }
            if (operation.equals("*")) {
                result *= ((result * numberA) / 100);
            }
            if (operation.equals("/")) {
                result /= ((result * numberA) / 100);
            }
            if (operation.equals("0")) {
                secondField.setText(null);
                mainField.setText("0");
            } else {
                secondField.setText(secondField.getText() + numberA + "%");
                mainField.setText(Double.toString(result));
                operation = "0";
            }
            mainField.requestFocusInWindow();
        });
        divideByOne.addActionListener((ActionEvent e) -> {
            numberA = Double.parseDouble(mainField.getText());
            secondField.setText("1/" + Double.toString(numberA));
            result = 1 / numberA;
            mainField.setText(Double.toString(result));
            mainField.requestFocusInWindow();
        });
        dotButton.addActionListener((ActionEvent e) -> {
            String buff;
            buff = mainField.getText();
            if (!buff.contains(".")) {
                mainField.setText(mainField.getText() + ".");
            }
            mainField.requestFocusInWindow();
        });
        negation.addActionListener((ActionEvent e) -> {
            if (!mainField.getText().equals("0")) {
                double buffor;
                buffor = result;
                numberA = Double.parseDouble(mainField.getText());
                result = -1 * numberA;
                mainField.setText(Double.toString(result));
                result = buffor;
            }
            mainField.requestFocusInWindow();
        });
        MClearButton.addActionListener((ActionEvent e) -> {
            MClearButton.setEnabled(false);
            MReadButton.setEnabled(false);
            memory = 0;
            memoryField.setText(null);
            mainField.requestFocusInWindow();
        });
        MSaveButton.addActionListener((ActionEvent e) -> {
            MClearButton.setEnabled(true);
            MReadButton.setEnabled(true);
            if (operation.equals("0")) {
                memory = Double.parseDouble(mainField.getText());
            } else {
                memory = result;
            }
            memoryField.setText(Double.toString(memory));
            mainField.requestFocusInWindow();
        });
        MReadButton.addActionListener((ActionEvent e) -> {
            mainField.setText(Double.toString(memory));
            mainField.requestFocusInWindow();
        });
        CEButton.addActionListener((ActionEvent e) -> {
            if (mainField.getText().equals("Error")) {
                mainField.setText("0");
                secondField.setText(null);
                operation = "0";
                pressedKey = 'a';
            }
            mainField.setText("0");
            numberA = 0;
            numberB = 0;
            mainField.requestFocusInWindow();
        });
        MplusButton.addActionListener((ActionEvent e) -> {
            MReadButton.setEnabled(true);
            MClearButton.setEnabled(true);
            memory += Double.parseDouble(mainField.getText());
            memoryField.setText(Double.toString(memory));
            mainField.requestFocusInWindow();
        });
        MminusButton.addActionListener((ActionEvent e) -> {
            MReadButton.setEnabled(true);
            MClearButton.setEnabled(true);
            memory -= Double.parseDouble(mainField.getText());
            memoryField.setText(Double.toString(memory));
            mainField.requestFocusInWindow();
        });
        mainField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                char key = e.getKeyChar();

                if (Character.isDigit(key)) {
                    pressedKey = key;
                } else if (pressedKey != '0' && mainField.getText().equals("0")) {
                    pressedKey = key;
                }

                if (mainField.getText().equals("0") && !Character.isLetter(key) && key != '+' &&
                        key != '-' && key != '/' && key != '*' && key != KeyEvent.VK_ENTER) {
                    mainField.setText("");
                }

                if (key == KeyEvent.VK_BACK_SPACE && mainField.getText().equals("Error")) {
                    mainField.setText("0");
                    secondField.setText(null);
                    operation = "0";
                    numberA = 0;
                    numberB = 0;
                    result = 0;
                    pressedKey = 'a';
                }
                if (key == KeyEvent.VK_DELETE) {
                    mainField.setText("0");
                    secondField.setText(null);
                    operation = "0";
                    numberA = 0;
                    numberB = 0;
                    result = 0;
                    pressedKey = 'a';
                }

                if (key != KeyEvent.VK_ENTER) {
                    switch (key) {
                        case '+':
                            if (operation.equals("0")) {
                                numberA = Double.parseDouble(mainField.getText());
                            } else {
                                if (!mainField.getText().isEmpty()) {
                                    numberB = Double.parseDouble(mainField.getText());
                                } else {
                                    numberB = 0;
                                }
                            }
                            if (operation.equals("+")) {
                                numberA += numberB;
                            }
                            if (operation.equals("-")) {
                                numberA = numberA - numberB;
                            }
                            if (operation.equals("*")) {
                                if (Character.isDigit(pressedKey)) {
                                    numberA = numberA * numberB;
                                }
                            }
                            if (operation.equals("/")) {
                                if (Character.isDigit(pressedKey)) {
                                    if (numberB != 0) {
                                        numberA = numberA / numberB;
                                        result = numberA;
                                        mainField.setText("0");
                                        secondField.setText(result + " / ");
                                    } else {
                                        mainField.setText("Error");
                                        secondField.setText(secondField.getText() + numberB);
                                        break;
                                    }
                                }
                            }
                            result = numberA;
                            secondField.setText(result + " + ");
                            mainField.setText("0");
                            operation = "+";
                            break;
                        case '-':
                            if (operation.equals("0")) {
                                numberA = Double.parseDouble(mainField.getText());
                            } else {
                                if (!mainField.getText().isEmpty()) {
                                    numberB = Double.parseDouble(mainField.getText());
                                } else {
                                    numberB = 0;
                                }
                            }
                            if (operation.equals("+")) {
                                numberA += numberB;
                            }
                            if (operation.equals("-")) {
                                numberA = numberA - numberB;
                            }
                            if (operation.equals("*")) {
                                if (Character.isDigit(pressedKey)) {
                                    numberA = numberA * numberB;
                                }
                            }
                            if (operation.equals("/")) {
                                if (Character.isDigit(pressedKey)) {
                                    if (numberB != 0) {
                                        numberA = numberA / numberB;
                                        result = numberA;
                                        mainField.setText("0");
                                        secondField.setText(result + " / ");
                                    } else {
                                        mainField.setText("Error");
                                        secondField.setText(secondField.getText() + numberB);
                                        break;
                                    }
                                }
                            }
                            result = numberA;
                            secondField.setText(result + " - ");
                            mainField.setText("0");
                            operation = "-";
                            break;
                        case '*':
                            if (operation.equals("0")) {
                                numberA = Double.parseDouble(mainField.getText());
                            } else {
                                if (!mainField.getText().isEmpty()) {
                                    numberB = Double.parseDouble(mainField.getText());
                                } else {
                                    numberB = 1;
                                }
                            }
                            if (operation.equals("+")) {
                                numberA += numberB;
                            }
                            if (operation.equals("-")) {
                                numberA = numberA - numberB;
                            }
                            if (operation.equals("*")) {
                                if (Character.isDigit(pressedKey)) {
                                    numberA = numberA * numberB;
                                }
                            }
                            if (operation.equals("/")) {
                                if (Character.isDigit(pressedKey)) {
                                    if (numberB != 0) {
                                        numberA = numberA / numberB;
                                        result = numberA;
                                        mainField.setText("0");
                                        secondField.setText(result + " / ");
                                    } else {
                                        mainField.setText("Error");
                                        secondField.setText(secondField.getText() + numberB);
                                        break;
                                    }
                                }
                            }
                            result = numberA;
                            secondField.setText(result + " x ");
                            mainField.setText("0");
                            operation = "*";
                            break;
                        case '/':
                            if (operation.equals("0")) {
                                numberA = Double.parseDouble(mainField.getText());
                                mainField.setText("0");
                                result = numberA;
                                secondField.setText("" + result + " / ");
                            } else {
                                if (!mainField.getText().isEmpty()) {
                                    numberB = Double.parseDouble(mainField.getText());
                                } else numberB = 1;
                            }
                            if (operation.equals("+")) {
                                numberA += numberB;
                            }
                            if (operation.equals("-")) {
                                numberA = numberA - numberB;
                            }
                            if (operation.equals("*")) {
                                if (Character.isDigit(pressedKey)) {
                                    numberA = numberA * numberB;
                                }
                            }
                            if (operation.equals("/")) {
                                if (Character.isDigit(pressedKey)) {
                                    if (numberB != 0) {
                                        numberA = numberA / numberB;
                                        result = numberA;
                                        mainField.setText("0");
                                        secondField.setText(result + " / ");
                                    } else {
                                        mainField.setText("Error");
                                        secondField.setText(secondField.getText() + numberB);
                                        break;
                                    }
                                }
                            }
                            result = numberA;
                            mainField.setText("0");
                            secondField.setText("" + result + " / ");
                            operation = "/";
                            break;
                    }
                } else {
                    switch (operation) {
                        case "+":
                            if (!mainField.getText().isEmpty()) {
                                numberB = Double.parseDouble(mainField.getText());
                            } else numberB = 0;
                            result += numberB;
                            secondField.setText(null);
                            mainField.setText(Double.toString(result));
                            operation = "0";
                            break;
                        case "-":
                            if (!mainField.getText().isEmpty()) {
                                numberB = Double.parseDouble(mainField.getText());
                            } else numberB = 0;
                            result -= numberB;
                            secondField.setText(null);
                            mainField.setText(Double.toString(result));
                            operation = "0";
                            break;
                        case "*":
                            if (pressedKey != '0' && mainField.getText().equals("0")) {
                                secondField.setText(null);
                                mainField.setText("" + result);
                            } else {
                                if (!mainField.getText().isEmpty()) {
                                    numberB = Double.parseDouble(mainField.getText());
                                } else numberB = 1;
                                result *= numberB;
                                secondField.setText(null);
                                mainField.setText(Double.toString(result));
                            }
                            operation = "0";
                            break;
                        case "/":
                            if (pressedKey != '0' && mainField.getText().equals("0")) {
                                secondField.setText(null);
                                mainField.setText("" + result);
                            } else if (pressedKey == '0' && mainField.getText().equals("0")) {
                                numberB = Double.parseDouble(mainField.getText());
                                mainField.setText("Error");
                                secondField.setText("" + result + "/" + numberB);
                            } else {
                                if (!mainField.getText().isEmpty()) {
                                    numberB = Double.parseDouble(mainField.getText());
                                } else numberB = 1;
                                if (numberB == 0) {
                                    mainField.setText("Error");
                                    secondField.setText("" + result + "/" + numberB);
                                } else {
                                    result /= numberB;
                                    secondField.setText(null);
                                    mainField.setText(Double.toString(result));
                                }
                            }
                            operation = "0";
                            break;
                        case "^":
                            if (pressedKey != '0' && mainField.getText().equals("0")) {
                                secondField.setText(null);
                                mainField.setText("" + result);
                            } else {
                                if (!mainField.getText().isEmpty()) {
                                    numberB = Double.parseDouble(mainField.getText());
                                } else numberB = 1;
                                result = Math.pow(result, numberB);
                                secondField.setText(null);
                                mainField.setText(Double.toString(result));
                            }
                            operation = "0";
                            break;
                    }
                    pressedKey = 'a';
                }
            }
        });

        mainField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char key = e.getKeyChar();

                if (key == ',') {
                    e.consume();
                    if (!mainField.getText().contains(".")) {
                        mainField.setText(mainField.getText() + ".");
                    }
                } else if (!Character.isDigit(key)) {
                    e.consume();
                }
            }
        });
        mainField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                mainField.requestFocusInWindow();
            }
        });
        standard.addActionListener((ActionEvent e) -> {
            Double pointX = getLocation().getX();
            Double pointY = getLocation().getY();
            int x, y;
            x = pointX.intValue();
            y = pointY.intValue();
            new Calculator(x, y);
            dispose();
        });
        DecimalFormat formatter = new DecimalFormat("#0.000000");
        formatter.setRoundingMode(RoundingMode.UP);
        sinus.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
                if (radEnabled) {
                    result = (int) (Math.round(Math.sin(numberA) * 100000)) / 100000.0;
                } else {
                    result = (int) (Math.round(Math.sin(Math.toRadians(numberA)) * 100000)) / 100000.0;
                }
                secondField.setText(secondField.getText() + "sin(" + numberA + ")");
            } else {
                numberB = Double.parseDouble(mainField.getText());
                secondField.setText(secondField.getText() + "sin(" + numberB + ")");
            }
            if (operation.equals("+")) {
                if (radEnabled) {
                    result += (int) (Math.round(Math.sin(numberB) * 100000)) / 100000.0;
                } else {
                    result += (int) (Math.round(Math.sin(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("-")) {
                if (radEnabled) {
                    result -= (int) (Math.round(Math.sin(numberB) * 100000)) / 100000.0;
                } else {
                    result -= (int) (Math.round(Math.sin(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("*")) {
                if (radEnabled) {
                    result *= (int) (Math.round(Math.sin(numberB) * 100000)) / 100000.0;
                } else {
                    result *= (int) (Math.round(Math.sin(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("/")) {
                if (radEnabled) {
                    result /= (int) (Math.round(Math.sin(numberB) * 100000)) / 100000.0;
                } else {
                    result /= (int) (Math.round(Math.sin(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            mainField.setText(Double.toString(result));
            operation = "0";
            mainField.requestFocusInWindow();
        });
        cosinus.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
                if (radEnabled) {
                    result = (int) (Math.round(Math.cos(numberA) * 100000)) / 100000.0;
                } else {
                    result = (int) (Math.round(Math.cos(Math.toRadians(numberA)) * 100000)) / 100000.0;
                }
                secondField.setText(secondField.getText() + "cos(" + numberA + ")");
            } else {
                numberB = Double.parseDouble(mainField.getText());
                secondField.setText(secondField.getText() + "cos(" + result + ")");
            }
            if (operation.equals("+")) {
                if (radEnabled) {
                    result += (int) (Math.round(Math.cos(numberB) * 100000)) / 100000.0;
                } else {
                    result += (int) (Math.round(Math.cos(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("-")) {
                if (radEnabled) {
                    result -= (int) (Math.round(Math.cos(numberB) * 100000)) / 100000.0;
                } else {
                    result -= (int) (Math.round(Math.cos(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("*")) {
                if (radEnabled) {
                    result *= (int) (Math.round(Math.cos(numberB) * 100000)) / 100000.0;
                } else {
                    result *= (int) (Math.round(Math.cos(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("/")) {
                if (radEnabled) {
                    result /= (int) (Math.round(Math.cos(numberB) * 100000)) / 100000.0;
                } else {
                    result /= (int) (Math.round(Math.cos(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            mainField.setText(Double.toString(result));
            operation = "0";
            mainField.requestFocusInWindow();
        });
        tangens.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
                if (radEnabled) {
                    result = (int) (Math.round(Math.tan(numberA) * 100000)) / 100000.0;
                } else {
                    result = (int) (Math.round(Math.tan(Math.toRadians(numberA)) * 100000)) / 100000.0;
                }
                secondField.setText(secondField.getText() + "tan(" + numberA + ")");
            } else {
                numberB = Double.parseDouble(mainField.getText());
                secondField.setText(secondField.getText() + "tan(" + result + ")");
            }
            if (operation.equals("+")) {
                if (radEnabled) {
                    result += (int) (Math.round(Math.tan(numberB) * 100000)) / 100000.0;
                } else {
                    result += (int) (Math.round(Math.tan(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("-")) {
                if (radEnabled) {
                    result -= (int) (Math.round(Math.tan(numberB) * 100000)) / 100000.0;
                } else {
                    result -= (int) (Math.round(Math.tan(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("*")) {
                if (radEnabled) {
                    result *= (int) (Math.round(Math.tan(numberB) * 100000)) / 100000.0;
                } else {
                    result *= (int) (Math.round(Math.tan(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            if (operation.equals("/")) {
                if (radEnabled) {
                    result /= (int) (Math.round(Math.tan(numberB) * 100000)) / 100000.0;
                } else {
                    result /= (int) (Math.round(Math.tan(Math.toRadians(numberB)) * 100000)) / 100000.0;
                }
            }
            mainField.setText(Double.toString(result));
            operation = "0";
            mainField.requestFocusInWindow();
        });
        radButton.addActionListener((ActionEvent e) -> {
            if (radEnabled) {
                radEnabled = false;
                radButton.setText("DEG");
            } else {
                radEnabled = true;
                radButton.setText("RAD");
            }
        });
        powXY.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
            } else {
                if (!mainField.getText().isEmpty()) {
                    numberB = Double.parseDouble(mainField.getText());
                } else {
                    numberB = 1;
                }
            }
            if (pressedKey != '0' && mainField.getText().equals("0")) {
                pressedKey = '^';
            }
            if (operation.equals("+")) {
                numberA += numberB;
            }
            if (operation.equals("-")) {
                numberA = numberA - numberB;
            }
            if (operation.equals("*")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = numberA * numberB;
                }
            }
            if (operation.equals("^")) {
                if (Character.isDigit(pressedKey)) {
                    numberA = Math.pow(numberA, numberB);
                }
            }
            if (operation.equals("/")) {
                if (Character.isDigit(pressedKey)) {
                    if (numberB != 0) {
                        numberA = numberA / numberB;
                        result = numberA;
                        mainField.setText("0");
                        secondField.setText(result + " ^ ");
                    } else {
                        mainField.setText("Error");
                        secondField.setText(secondField.getText() + numberB);
                    }
                } else if (pressedKey == '*' && mainField.getText().equals("0")) {
                    result = numberA;
                    mainField.setText("0");
                    secondField.setText(result + " ^ ");
                }
            } else {
                result = numberA;
                secondField.setText(result + " ^ ");
                mainField.setText("0");
            }
            operation = "^";
            mainField.requestFocusInWindow();
        });
        logarithm.addActionListener((ActionEvent e) -> {
            if (operation.equals("0")) {
                numberA = Double.parseDouble(mainField.getText());
                result = (int) (Math.round(Math.log10(numberA) * 100000)) / 100000.0;
                secondField.setText(secondField.getText() + "log(" + numberA + ")");
            } else {
                numberB = Double.parseDouble(mainField.getText());
                secondField.setText(secondField.getText() + "log(" + result + ")");
            }
            if (operation.equals("+")) {
                result += (int) (Math.round(Math.log10(numberB) * 100000)) / 100000.0;
            }
            if (operation.equals("-")) {
                result -= (int) (Math.round(Math.log10(numberB) * 100000)) / 100000.0;
            }
            if (operation.equals("*")) {
                result *= (int) (Math.round(Math.log(numberB) * 100000)) / 100000.0;
            }
            if (operation.equals("/")) {
                result /= (int) (Math.round(Math.log(numberB) * 100000)) / 100000.0;
            }
            mainField.setText(Double.toString(result));
            operation = "0";
            mainField.requestFocusInWindow();
        });
    }

    private void initButtons() {
        a1Button.addActionListener((ActionEvent e) -> ButtonCode(a1Button, mainField, pressedKey));
        a2Button.addActionListener((ActionEvent e) -> ButtonCode(a2Button, mainField, pressedKey));
        a3Button.addActionListener((ActionEvent e) -> ButtonCode(a3Button, mainField, pressedKey));
        a4Button.addActionListener((ActionEvent e) -> ButtonCode(a4Button, mainField, pressedKey));
        a5Button.addActionListener((ActionEvent e) -> ButtonCode(a5Button, mainField, pressedKey));
        a6Button.addActionListener((ActionEvent e) -> ButtonCode(a6Button, mainField, pressedKey));
        a7Button.addActionListener((ActionEvent e) -> ButtonCode(a7Button, mainField, pressedKey));
        a8Button.addActionListener((ActionEvent e) -> ButtonCode(a8Button, mainField, pressedKey));
        a9Button.addActionListener((ActionEvent e) -> ButtonCode(a9Button, mainField, pressedKey));
        a0Button.addActionListener((ActionEvent e) -> ButtonCode(a0Button, mainField, pressedKey));
    }
}
