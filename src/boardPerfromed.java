import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class boardPerfromed implements ActionListener {
    private MyFrame myFrame;

    int countPlayer1 = 0;
    int countPlayer2 = 0;

    int count = 0;

    private checkMovePerfromed myMove;

    public boardPerfromed(MyFrame myFrame, checkMovePerfromed myMove) {
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

            count = 0;

            for (int i = 0; i < (int) myFrame.getGameBoardSize().getSelectedItem(); i++){
                for (int j = 0; j < (int) myFrame.getGameBoardSize().getSelectedItem(); j++) {
                        myFrame.sosButtons[i][j] = new JButton();
                        myFrame.buttonPanel.add(myFrame.sosButtons[i][j]);

                        myFrame.sosButtons[i][j].setFont(new Font("MV Boli", Font.BOLD, myFrame.size));
                        int finalI = i;
                        int finalJ = j;
                        myFrame.sosButtons[i][j].addActionListener(
                                new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        onSOSButtonPressed(finalI, finalJ);
                                    }
                                }
                        );
                    }

                }
            }
        }


    public void onSOSButtonPressed(int i, int j) {
        if (myFrame.player1_turn) {
            if (myFrame.sosButtons[i][j].getText() == "") {
                myFrame.getGameBoardSize().setEnabled(false);
                myFrame.simpleRadio.setEnabled(false);
                myFrame.generalRadio.setEnabled(false);
                myFrame.sosButtons[i][j].setForeground(new Color(255, 0, 0));
                myFrame.sosButtons[i][j].setText(myFrame.getPlayer1Text());
                myFrame.sosButtons[i][j].getText();
                if (!myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).isEmpty()) {
                    if (myFrame.simpleRadio.isSelected()) {
                        changeColor(i, j);
                        myFrame.turnTextField.setText("Player 1 Win");
                        newGame();
                    } else if (myFrame.generalRadio.isSelected()) {
                        changeColor(i, j);
                        countPlayer1++;
                    }
                }
                count++;
                boardFillCheck();
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
                if (!myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).isEmpty()) {
                    if (myFrame.simpleRadio.isSelected()) {
                        changeColor(i, j);
                        myFrame.turnTextField.setText("Player 2 Win");
                        newGame();
                    } else if (myFrame.generalRadio.isSelected()) {
                        changeColor(i, j);
                        countPlayer2++;
                    }
                }

                    count++;
                    boardFillCheck();
                    myFrame.player1_turn = true;
                    myFrame.turnTextField.setText("Player 1 Turn");
            }
        }
    }

    public void boardFillCheck() {
        if (count  == (int) myFrame.getGameBoardSize().getSelectedItem() * (int) myFrame.getGameBoardSize().getSelectedItem()) {

            if (myFrame.simpleRadio.isSelected()) {
                myFrame.turnTextField.setText("Draw");
                newGame();
            }

            else if (myFrame.generalRadio.isSelected()) {
                if (countPlayer1 > countPlayer2) {
                    myFrame.turnTextField.setText("Player 1 Win");
                    newGame();
                } else if (countPlayer1 < countPlayer2) {
                    myFrame.turnTextField.setText("Player 2 Win");
                    newGame();
                } else if (countPlayer1 == countPlayer2){
                    myFrame.turnTextField.setText("Draw");
                    newGame();
                }
            }
        }
    }

    public void changeColor (int i, int j){
        int R1 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(0).r;
        int R2 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(1).r;
        int C1 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(0).c;
        int C2 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(1).c;
        int R3 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(2).r;
        int C3 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(2).c;

        if (myFrame.turnTextField.getText().equals( "Player 1 Turn")) {
            myFrame.sosButtons[R1][C1].setBackground(Color.PINK);
            myFrame.sosButtons[R2][C2].setBackground(Color.PINK);
            myFrame.sosButtons[R3][C3].setBackground(Color.PINK);
        }

        else if (myFrame.turnTextField.getText().equals("Player 2 Turn")) {
            myFrame.sosButtons[R1][C1].setBackground(Color.cyan);
            myFrame.sosButtons[R2][C2].setBackground(Color.cyan);
            myFrame.sosButtons[R3][C3].setBackground(Color.cyan);
        }

        myFrame.sosButtons[R1][C1].setEnabled(false);
        myFrame.sosButtons[R2][C2].setEnabled(false);
        myFrame.sosButtons[R3][C3].setEnabled(false);


    }

    public void newGame(){
        int reply = JOptionPane.showConfirmDialog(null, myFrame.turnTextField.getText(), "Winner", JOptionPane.PLAIN_MESSAGE);
        if (reply == JOptionPane.OK_OPTION){
            myFrame.getGameBoardSize().setSelectedIndex(1);
            myFrame.getGameBoardSize().setEnabled(true);
            myFrame.simpleRadio.setEnabled(true);
            myFrame.generalRadio.setEnabled(true);
            myFrame.turnTextField.setText("Current Turn");
        }
    }


//    public void drawline (int i, int j) {
//        Graphics2D g2D = (Graphics2D) myFrame.layeredPane.getGraphics();
//
//        g2D.setColor(Color.red);
//        g2D.setStroke(new BasicStroke(2));
//        int R1 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(0).r;
//        int R2 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(1).r;
//        int C1 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(0).c;
//        int C2 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(1).c;
//        int R3 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(2).r;
//        int C3 = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(0).get(2).c;
//
//
//        int x1 = myFrame.sosButtons[R1][C1].getX() +
//                myFrame.sosButtons[R1][C1].getWidth() / 2;
//
//        int y1 = myFrame.sosButtons[R1][C1].getY() +
//                myFrame.sosButtons[R1][C1].getHeight() / 2;
//
//        int x2 = myFrame.sosButtons[R2][C2].getX() +
//                myFrame.sosButtons[R2][C2].getWidth() / 2;
//
//        int y2 = myFrame.sosButtons[R2][C2].getY() +
//                myFrame.sosButtons[R2][C2].getHeight() / 2;
//
//        int x3 = myFrame.sosButtons[R3][C3].getX() +
//                myFrame.sosButtons[R3][C3].getWidth() / 2;
//
//        int y3 = myFrame.sosButtons[R3][C3].getY() +
//                myFrame.sosButtons[R3][C3].getHeight() / 2;
//
//
//
//        g2D.drawLine(x1, y1, x2, y2);
//        g2D.drawLine(x2, y2, x3, y3);
//    }
}
