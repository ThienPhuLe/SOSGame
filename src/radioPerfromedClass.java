import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class radioPerfromedClass implements ActionListener {
    private MyFrame myFrame;
    public radioPerfromedClass(MyFrame myFrame){
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (myFrame.player1ButtonS.isSelected()){

                myFrame.player1Text = "S";
            }
            else
            {
                myFrame.player1Text = "O";
            }

            if (myFrame.player2ButtonS.isSelected()){

                myFrame.player2Text = "S";
            }
            else
            {
                myFrame.player2Text = "O";
            }
    }
}




