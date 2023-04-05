import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class radioPerfromedClass implements ActionListener {
    private MyFrame myFrame;

    public radioPerfromedClass(MyFrame myFrame){
        this.myFrame = myFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton player1ButtonS = (JRadioButton)e.getSource();
        JRadioButton player1ButtonO = (JRadioButton)e.getSource();
        if (player1ButtonS.isSelected())
        {
            myFrame.setPlayer1Text("S");
        } else if (player1ButtonO.isSelected()) {
            myFrame.setPlayer1Text("O");
        }

    }
}




