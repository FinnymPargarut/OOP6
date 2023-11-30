package View.MyActionListener;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToMainActionListener implements ActionListener {
    FigureSettings figureSettings;
    ContainerSettings containerSettings;
    ArrayListSettings arrayListSettings;
    MainWindow mw;
    Window ow;

    public BackToMainActionListener(FigureSettings visibleFalse, MainWindow visibleTrue, Window ow) {
        this.figureSettings = visibleFalse;
        this.mw = visibleTrue;
        this.ow = ow;
    }

    public BackToMainActionListener(ContainerSettings visibleFalse, MainWindow visibleTrue) {
        this.containerSettings = visibleFalse;
        this.mw = visibleTrue;
    }

    public BackToMainActionListener(ArrayListSettings arrayListSettings, MainWindow mw) {
        this.arrayListSettings = arrayListSettings;
        this.mw = mw;
    }

    public void actionPerformed(ActionEvent e) {
        if (figureSettings != null) figureSettings.setVisible(false);
        if (containerSettings != null) containerSettings.setVisible(false);
        if (arrayListSettings != null) arrayListSettings.setVisible(false);
        mw.setVisible(true);

//        ow.setVisible(false);
//        ow.setVisible(true);
    }
}
