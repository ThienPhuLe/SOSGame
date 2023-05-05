import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class radioPerfromedClass implements ActionListener {
    private MyFrame myFrame;
    private aiModeClass myAi;

    boolean check = true;
    public radioPerfromedClass(MyFrame myFrame, aiModeClass myAi){
        this.myFrame = myFrame;
        this.myAi = myAi;
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

            if (myFrame.player1Computer.isSelected())
            {
                myFrame.player1Ai = true;
                check = true;
                if (myFrame.turnTextField.getText().equals("Player 1 Turn"))
                {
                    for (int i = 0; i < (int) myFrame.getGameBoardSize().getSelectedItem(); i++) {
                        for (int j = 0; j < (int) myFrame.getGameBoardSize().getSelectedItem(); j++) {
                            if (myFrame.sosButtons[i][j].getText() != "")
                            {
                                check = false;
                            }

                            if (check == false)
                            {
                                break;
                            }
                        }
                        if (check == false)
                        {
                            break;
                        }
                    }

                    if (check == true)
                    {
                        myFrame.sosButtons[0][0].doClick();

                    }
                }
            }

            else {
                myFrame.player1Ai = false;
            }


            if (myFrame.player2Computer.isSelected())
            {
                myFrame.player2Ai = true;
                check = true;
                if (myFrame.turnTextField.getText().equals("Player 2 Turn"))
                {
                    for (int i = 0; i < (int) myFrame.getGameBoardSize().getSelectedItem(); i++) {
                        for (int j = 0; j < (int) myFrame.getGameBoardSize().getSelectedItem(); j++) {
                            if (myFrame.sosButtons[i][j].getText() != "")
                            {
                                check = false;
                            }

                            if (check == false)
                            {
                                break;
                            }
                        }
                        if (check == false)
                        {
                            break;
                        }
                    }

                    if (check == true)
                    {
                        myFrame.sosButtons[0][0].doClick();

                    }

                }
            }

            else {
                myFrame.player2Ai = false;
            }
    }
}




