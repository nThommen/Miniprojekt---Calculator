import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JPanel {

    private Controller controller;
    public Insets INSETS = new Insets(5, 5, 5, 5);
    JTextField calcField = new JTextField();
    JButton[] buttons;
    private String[] buttonLabels = {
            "ce", "c", "erase", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", "="
    };

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        buttons = new JButton[buttonLabels.length];
        setLayout(new GridBagLayout());

        add(calcField, new GridBagConstraints(0, 0, 4, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, INSETS, 0, 0));

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller != null) {
                        controller.handleButtonEvent(e);
                    }

                }

            });
            if (i <= 3) {
                add(buttons[i], new GridBagConstraints(i, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH, INSETS, 0, 0));
            } else if (i <= 7) {
                add(buttons[i], new GridBagConstraints(i - 4, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH, INSETS, 0, 0));

            } else if (i <= 11) {
                add(buttons[i], new GridBagConstraints(i - 8, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH, INSETS, 0, 0));

            } else if (i <= 15){
                add(buttons[i], new GridBagConstraints(i - 12, 4, 1, 1, 1, 1, GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH, INSETS, 0, 0));

            } else {
                add(buttons[i], new GridBagConstraints(2*i - 32, 5, 2, 1, 1, 1, GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH, INSETS, 0, 0));
            }
        }

    }

}