import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private MainPanel mainPanel;

    public View() {
        super("Tervise statistika");
        setLayout(new BorderLayout());  // See on Frame layout

        mainPanel = new MainPanel(); // Kogu visuaal on siin

        add(mainPanel, BorderLayout.NORTH);  // mainPanel pannakse Frame-le
    }

    public void registerButtonOpen(ActionListener al) {
        mainPanel.getBtnOpen().addActionListener(al);
    }
    public void registerButtonShow(ActionListener al) {
        mainPanel.getBtnShow().addActionListener(al);
    }

    public JButton getBtnOpen() {
        return mainPanel.getBtnOpen();
    }

    public JButton getBtnShow() {
        return mainPanel.getBtnShow();
    }

    public JComboBox<String> getCmbYears() {
        return mainPanel.getCmbYears();
    }

    public JLabel getLblFilename() {
        return mainPanel.getLblFilename();
    }

    public JTextArea getTxtArea() {
        return mainPanel.getTxtArea();
    }
}
