import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonShowListener implements ActionListener {
    private Model model;
    private View view;

    public ButtonShowListener(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Show Kukimuki");
    }
}
