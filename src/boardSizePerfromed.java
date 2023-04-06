import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class boardSizePerfromed implements ActionListener {
    private MyFrame myFrame;
    boolean winOrNot;
    private checkMovePerfromed myMove;

    public boardSizePerfromed(MyFrame myFrame, checkMovePerfromed myMove) {
        this.myFrame = myFrame;
        this.myMove = myMove;

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
            myFrame.sosButtons = new JButton[(int) myFrame.getGameBoardSize().getSelectedItem()][(int) myFrame.getGameBoardSize().getSelectedItem()];
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

            for (int i = 0; i < (int) myFrame.getGameBoardSize().getSelectedItem(); i++){
                for (int j = 0; j < (int) myFrame.getGameBoardSize().getSelectedItem(); j++) {
                    myFrame.sosButtons[i][j] =new JButton();
                    myFrame.buttonPanel.add(myFrame.sosButtons[i][j]);
                    myFrame.sosButtons[i][j].setFont(new Font("MV Boli", Font.BOLD, myFrame.size));
                    myFrame.sosButtons[i][j].addActionListener(this);
                }
            }
        }



        for (int i = 0; i < (int) myFrame.getGameBoardSize().getSelectedItem(); i++ ) {
            for (int j = 0; j < (int) myFrame.getGameBoardSize().getSelectedItem(); j++) {
                if (e.getSource() == myFrame.sosButtons[i][j]) {
                    if (myFrame.player1_turn) {
                        if (myFrame.sosButtons[i][j].getText() == "") {
                            myFrame.getGameBoardSize().setEnabled(false);
                            myFrame.simpleRadio.setEnabled(false);
                            myFrame.generalRadio.setEnabled(false);
                            myFrame.sosButtons[i][j].setForeground(new Color(255, 0, 0));
                            myFrame.sosButtons[i][j].setText(myFrame.getPlayer1Text());
                            myFrame.sosButtons[i][j].getText();
                            myFrame.sosButtons[i][j].putClientProperty("Row", i);
                            myFrame.sosButtons[i][j].putClientProperty("Column", j);

                            System.out.println(myFrame.sosButtons[i][j].getClientProperty("Row"));
                            System.out.println(myFrame.sosButtons[i][j].getClientProperty("Column"));
                           winOrNot = myMove.winCondition((int) myFrame.sosButtons[i][j].getClientProperty("Column"),
                                    (int) myFrame.sosButtons[i][j].getClientProperty("Row"),
                                    myFrame.sosButtons[i][j].getText());

                           System.out.println(winOrNot);


                            myFrame.player1_turn = false;
                            myFrame.turnTextField.setText("Player 2 Turn");
                        }
                    } else {
                        if (myFrame.sosButtons[i][j].getText() == "") {
                            myFrame.getGameBoardSize().setEnabled(false);
                            myFrame.simpleRadio.setEnabled(false);
                            myFrame.generalRadio.setEnabled(false);
                            myFrame.sosButtons[i][j].setForeground(new Color(0, 0, 225));
                            myFrame.sosButtons[i][j].setText(myFrame.getPlayer2Text());
                            myFrame.sosButtons[i][j].putClientProperty("Row", i);
                            myFrame.sosButtons[i][j].putClientProperty("Column", j);
                            System.out.println(myFrame.sosButtons[i][j].getClientProperty("Row"));
                            System.out.println(myFrame.sosButtons[i][j].getClientProperty("Column"));
                            winOrNot = myMove.winCondition((int) myFrame.sosButtons[i][j].getClientProperty("Column"),
                                    (int) myFrame.sosButtons[i][j].getClientProperty("Row"),
                                    myFrame.sosButtons[i][j].getText());
                            System.out.println(winOrNot);
                            myFrame.player1_turn = true;
                            myFrame.turnTextField.setText("Player 1 Turn");
                        }
                    }
                }

            }
        }
    }
}
