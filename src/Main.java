import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    static JFrame frame;
    static JTextField textField; // Screen
    static JButton[] numberButtons = new JButton[10];
    static JButton[] functionButtons = new JButton[22];
    static JButton addBtn, subBtn, mulBtn, divBtn, eqBtn, decBtn, clrBtn, delBtn, piBtn, powBtn, sqrtBtn, ansBtn, logBtn, sinBtn, cosBtn, tanBtn, sinhBtn, coshBtn, tanhBtn, sinI_Btn, cosI_Btn, tanI_Btn;
    static JPanel panel;
    static double num1 = 0, num2 = 0, result = 0, preAns = 0;
    static char operator;

    public static void main(String[] args) {
        // Create frame
        frame = new JFrame("Calculator");
        frame.setSize(600, 630);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 200));
        frame.setLayout(null);

        ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\Desktop\\Java Bootcamp\\Calculator\\exit.png");
        JLabel label = new JLabel(icon);
        label.setBounds(550, 0, icon.getIconWidth(), icon.getIconHeight());

        Font myfont = new Font("my font", Font.BOLD, 30);
        textField = new JTextField();
        textField.setBounds(15, 47, 570, 70);
        textField.setFont(myfont);
        textField.setEditable(false);
        textField.setBackground(new Color(0, 0, 0));
        textField.setForeground(new Color(255, 255, 255));
        textField.setBorder(BorderFactory.createEmptyBorder());

        addBtn = createButton("+", myfont, true);
        subBtn = createButton("-", myfont, true);
        mulBtn = createButton("*", myfont, true);
        divBtn = createButton("/", myfont, true);
        eqBtn = createButton("=", myfont, true);
        decBtn = createButton(".", myfont, false);
        clrBtn = createButton("AC", myfont, false);
        delBtn = createButton("Delete", myfont, false);
        piBtn = createButton("Pi", myfont, false);
        powBtn = createButton("^", myfont, false);
        sqrtBtn = createButton("√", myfont, false);
        logBtn = createButton("Log", myfont, false);
        sinBtn = createButton("Sin", myfont, false);
        sinI_Btn = createButton("ASin", myfont, false);
        sinhBtn = createButton("Sinh", myfont, false);
        cosBtn = createButton("Cos", myfont, false);
        cosI_Btn = createButton("ACos", myfont, false);
        coshBtn = createButton("Cosh", myfont, false);
        tanhBtn = createButton("Tanh", myfont, false);
        tanI_Btn = createButton("ATan", myfont, false);
        tanBtn = createButton("Tan", myfont, false);
        ansBtn = createButton("Ans", myfont, false);

        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = eqBtn;
        functionButtons[6] = delBtn;
        functionButtons[7] = clrBtn;
        functionButtons[8] = logBtn;
        functionButtons[9] = powBtn;
        functionButtons[10] = piBtn;
        functionButtons[11] = sqrtBtn;
        functionButtons[12] = sinBtn;
        functionButtons[13] = sinI_Btn;
        functionButtons[14] = sinhBtn;
        functionButtons[15] = cosBtn;
        functionButtons[16] = cosI_Btn;
        functionButtons[17] = coshBtn;
        functionButtons[18] = tanhBtn;
        functionButtons[19] = tanI_Btn;
        functionButtons[20] = tanBtn;
        functionButtons[21] = ansBtn;

        delBtn.setBounds(358, 127, 112, 72);
        clrBtn.setBounds(472, 127, 112, 72);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i), myfont, false);
        }

        panel = new JPanel();
        panel.setBounds(15, 200, 570, 420);
        panel.setLayout(new GridLayout(6, 5, 2, 2));
        panel.setBackground(new Color(0, 0, 0));
        panel.setVisible(true);

        panel.add(tanI_Btn);
        panel.add(cosI_Btn);
        panel.add(coshBtn);
        panel.add(tanhBtn);
        panel.add(sinhBtn);
        panel.add(sinBtn);
        panel.add(cosBtn);
        panel.add(tanBtn);
        panel.add(sinI_Btn);
        panel.add(powBtn);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(divBtn);
        panel.add(piBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulBtn);
        panel.add(sqrtBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(subBtn);
        panel.add(logBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(ansBtn);
        panel.add(addBtn);
        panel.add(eqBtn);

        frame.add(clrBtn);
        frame.add(delBtn);
        frame.add(panel);
        frame.add(label);
        frame.add(textField);
        frame.setVisible(true);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + numberButtons[finalI].getText());
                }
            });
        }

        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (text.isEmpty()) return;
                String[] parts = text.split("[" + operator + "]");
                String currentNumber = parts.length == 1 ? parts[0] : parts[parts.length - 1];
                if (!currentNumber.contains(".")) {
                    textField.setText(text + ".");
                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText(textField.getText() + " + ");
            }
        });

        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText(textField.getText() + " - ");
            }
        });

        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText(textField.getText() + " * ");
            }
        });

        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText(textField.getText() + " / ");
            }
        });

        powBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    num1 = Double.parseDouble(text);
                    operator = '^'; // Set operator to '^' for power
                    textField.setText(text + " ^ ");
                }
            }
        });

        piBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    num1 = Math.PI;
                    textField.setText(Math.PI + "");
                } else {
                    textField.setText(textField.getText() + "" + Math.PI);
                }
            }
        });

        sinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("sin ");
                } else {
                    textField.setText(textField.getText() + "sin ");
                }
            }
        });

        cosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("cos ");
                } else {
                    textField.setText(textField.getText() + "cos ");
                }
            }
        });

        tanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("tan ");
                } else {
                    textField.setText(textField.getText() + "tan ");
                }
            }
        });

        sinhBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("sinh ");
                } else {
                    textField.setText(textField.getText() + "sinh ");
                }
            }
        });

        coshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("cosh ");
                } else {
                    textField.setText(textField.getText() + "cosh ");
                }
            }
        });

        tanhBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("tanh ");
                } else {
                    textField.setText(textField.getText() + "tanh ");
                }
            }
        });

        sinI_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("asin ");
                } else {
                    textField.setText(textField.getText() + "asin ");
                }
            }
        });

        cosI_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("acos ");
                } else {
                    textField.setText(textField.getText() + "acos ");
                }
            }
        });

        tanI_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("atan ");
                } else {
                    textField.setText(textField.getText() + "atan ");
                }
            }
        });

        sqrtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("√ ");
                } else {
                    textField.setText(textField.getText() + "√ ");
                }
            }
        });

        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("log ");
                } else {
                    textField.setText(textField.getText() + "log ");
                }
            }
        });

        eqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = textField.getText();
                    if (text.contains("asin ")) {
                        text = calculateTrig("asin ");
                    } else if (text.contains("acos ")) {
                        text = calculateTrig("acos ");
                    } else if (text.contains("atan ")) {
                        text = calculateTrig("atan ");
                    } else if (text.contains("sinh ")) {
                        text = calculateTrig("sinh ");
                    } else if (text.contains("cosh ")) {
                        text = calculateTrig("cosh ");
                    } else if (text.contains("tanh ")) {
                        text = calculateTrig("tanh ");
                    } else if (text.contains("sin ")) {
                        text = calculateTrig("sin ");
                    } else if (text.contains("cos ")) {
                        text = calculateTrig("cos ");
                    } else if (text.contains("tan ")) {
                        text = calculateTrig("tan ");
                    } else if (text.contains("√ ")) {
                        text = calculateTrig("√ ");
                    } else if (text.contains("log ")) {
                        text = calculateTrig("log ");
                    }
                    if (text.equals("")) {

                    } else {
                        String[] parts = text.split(" ");
                        if (parts.length == 3) {
                            num1 = Double.parseDouble(parts[0]);
                            num2 = Double.parseDouble(parts[2]);
                            switch (operator) {
                                case '+':
                                    result = num1 + num2;
                                    break;
                                case '-':
                                    result = num1 - num2;
                                    break;
                                case '*':
                                    result = num1 * num2;
                                    break;
                                case '/':
                                    if (num2 != 0) {
                                        result = num1 / num2;
                                    } else {
                                        textField.setText("Error");
                                        return;
                                    }
                                    break;
                                case '^': // Handle power operation
                                    result = Math.pow(num1, num2);
                                    break;
                                default:
                                    textField.setText("Error");
                                    return;
                            }
                            textField.setText(String.valueOf(result));
                            preAns = result;
                        } else {
                            textField.setText("Error");
                        }
                    }
                } catch (NumberFormatException ex) {
                    textField.setText("");
                }
            }
        });

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0); // Exit the application
            }
        });

        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isEmpty() == false) {
                    String txt = textField.getText();//123
                    textField.setText("");
                    textField.setText(txt.substring(0, txt.length() - 1));//12
                }
            }
        });

        ansBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().isEmpty()) {
                    textField.setText(preAns + "");
                }else{
                    textField.setText(textField.getText()+preAns);
                }
            }
        });
    }

    private static String calculateTrig(String trigFunction) {
        String text = textField.getText();
        if (text.contains(trigFunction)) {
            int startIndex = text.indexOf(trigFunction);
            String prevText = text.substring(0, startIndex).trim();
            int endIndex = startIndex + trigFunction.length();
            if (endIndex < text.length()) {
                String valueStr = text.substring(endIndex).trim();
                if (!valueStr.isEmpty()) {
                    try {
                        double value = Double.parseDouble(valueStr);
                        double trigResult = 0;
                        switch (trigFunction) {
                            case "sin ":
                                trigResult = Math.sin(value);
                                break;
                            case "cos ":
                                trigResult = Math.cos(value);
                                break;
                            case "tan ":
                                trigResult = Math.tan(value);
                                break;
                            case "tanh ":
                                trigResult = Math.tanh(value);
                                break;
                            case "cosh ":
                                trigResult = Math.cosh(value);
                                break;
                            case "sinh ":
                                trigResult = Math.sinh(value);
                                break;
                            case "asin ":
                                trigResult = Math.asin(value);
                                break;
                            case "acos ":
                                trigResult = Math.acos(value);
                                break;
                            case "atan ":
                                trigResult = Math.atan(value);
                                break;
                            case "√ ":
                                trigResult = Math.sqrt(value);
                                break;
                            case "log ":
                                trigResult = Math.log10(value);
                                break;
                            default:
                                textField.setText("Error");
                                return "";
                        }
                        String resultText = String.valueOf(trigResult);
                        preAns = trigResult;
                        if (!prevText.isEmpty()) {
                            return prevText + " " + resultText;
                        } else {
                            textField.setText(resultText);
                            return "";
                        }
                    } catch (NumberFormatException ex) {
                        textField.setText("Error");
                    }
                }
            }
        }
        return text;
    }

    private static JButton createButton(String text, Font font, boolean isFunctional) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setFocusable(false);
        button.setOpaque(true); // Ensure button background is painted
        button.setBorder(BorderFactory.createEmptyBorder());

        if (isFunctional) {
            button.setBackground(new Color(0, 127, 255)); // Blue background for functional buttons
            button.setForeground(new Color(80, 184, 231)); // Optional: Set text color to white for contrast
        } else {
            button.setBackground(new Color(55, 58, 64)); // Gray background for number and other buttons
            button.setForeground(new Color(80, 184, 231)); // Optional: Set text color for number buttons
        }

        return button;
    }
}
