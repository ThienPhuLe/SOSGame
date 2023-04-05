import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class boardSizePerfromed implements ActionListener {
    private MyFrame myFrame;

    public boardSizePerfromed(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public void firstTurn(){
        if (myFrame.random.nextInt(2) == 0 )
        {
            myFrame.player1_turn = true;
            myFrame.turnTextField.setText("Player 1 Turn");
        }

        else{
            myFrame.player1_turn = false;
            myFrame.turnTextField.setText("Player 2 Turn");
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myFrame.getGameBoardSize())
        {
            firstTurn();
            myFrame.buttonPanel.removeAll();
            myFrame.revalidate();
            myFrame.repaint();
            myFrame.totalBoard = (int) myFrame.getGameBoardSize().getSelectedItem() * (int) myFrame.getGameBoardSize().getSelectedItem();
            myFrame.sosButtons = new JButton[myFrame.totalBoard];
            myFrame.buttonPanel.setBorder(myFrame.buttonPanel.getBorder());
            myFrame.buttonPanel.setLayout(new GridLayout((int) myFrame.getGameBoardSize().getSelectedItem(),(int) myFrame.getGameBoardSize().getSelectedItem()));
            myFrame.buttonPanel.setBackground(Color.LIGHT_GRAY);

            if ((int) myFrame.getGameBoardSize().getSelectedItem() == 3 || (int) myFrame.getGameBoardSize().getSelectedItem() == 4 ||  (int) myFrame.getGameBoardSize().getSelectedItem() == 5 || (int) myFrame.getGameBoardSize().getSelectedItem() == 6
                    || (int) myFrame.getGameBoardSize().getSelectedItem() == 7)
            {
                myFrame.size = 150/(int) myFrame.getGameBoardSize().getSelectedItem();
            }

            else {
                myFrame.size = 12;
            }

            for (int i = 0; i < myFrame.totalBoard; i++){
                myFrame.sosButtons[i] = new JButton();
                myFrame.buttonPanel.add( myFrame.sosButtons[i]);
                myFrame.sosButtons[i].setFont(new Font("MV Boli", Font.BOLD,myFrame.size));
                myFrame.sosButtons[i].setFocusable(false);
                myFrame.sosButtons[i].addActionListener(this);
            }
        }



        for (int i = 0; i < myFrame.totalBoard; i++ )
        {
            if (e.getSource() ==  myFrame.sosButtons[i]){
                if(myFrame.player1_turn) {
                    if( myFrame.sosButtons[i].getText() == ""){

                        myFrame.getGameBoardSize().setEnabled(false);
                        myFrame.simpleRadio.setEnabled(false);
                        myFrame.generalRadio.setEnabled(false);
                        myFrame.sosButtons[i].setForeground(new Color(255,0,0));
                        myFrame.sosButtons[i].setText(myFrame.getPlayer1Text());
                        myFrame.player1_turn = false;
                        myFrame.turnTextField.setText("Player 2 Turn");
                    }
                }
                else{
                    if( myFrame.sosButtons[i].getText() == ""){
                        myFrame.getGameBoardSize().setEnabled(false);
                        myFrame.simpleRadio.setEnabled(false);
                        myFrame.generalRadio.setEnabled(false);
                        myFrame.sosButtons[i].setForeground(new Color(0,0,225));
                        myFrame.sosButtons[i].setText(myFrame.getPlayer2Text());
                        myFrame.player1_turn = true;
                        myFrame.turnTextField.setText("Player 1 Turn");
                    }
                }
            }

        }
    }
}
