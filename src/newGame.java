import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newGame implements ActionListener{
    private MyFrame myFrame;


    public newGame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myFrame.newGmButton)
        {
            int reply = JOptionPane.showConfirmDialog(null, "Do You want to start a new game ?", "New Game", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                myFrame.getGameBoardSize().setSelectedIndex(1);
                myFrame.getGameBoardSize().setEnabled(true);
                myFrame.simpleRadio.setEnabled(true);
                myFrame.generalRadio.setEnabled(true);
                myFrame.simpleRadio.setSelected(true);
                myFrame.turnTextField.setText("Current Turn");
            }
        }

    }
}
