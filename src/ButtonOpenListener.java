import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonOpenListener implements ActionListener {
    private Model model;
    private View view;

    public ButtonOpenListener(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // MIlliseid fail veel näeb (*.*) lisaks *.csv
        FileNameExtensionFilter ff = new FileNameExtensionFilter("CSV Files", "csv");
        JFileChooser fc = new JFileChooser(); // Open Dialogi aken
        fc.addChoosableFileFilter(ff); // Filtri lisamine dialoogi aknale
        fc.setFileFilter(ff); // Vaikimisi valik
        // Dialoogi aken näitab jooksva projekti kausta
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        // Näita dialoogi akent ja püüa kinni tulemus
        int result = fc.showOpenDialog(view); // view vs null
        if (result == JFileChooser.APPROVE_OPTION) {
            if(fc.getSelectedFile().toString().toLowerCase().endsWith("csv")) {
                // Seadista mudelis failinimi
                model.setFilename(fc.getSelectedFile().toString());
                File f = new File(model.getFilename());
                view.getLblFilename().setText(f.getName());

                model.readFileContents(); // Läheb ja loeb faili ssiu massiivi (List)

            }
        }

    }
}
