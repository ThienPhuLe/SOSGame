import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class boardPerfromed implements ActionListener {
    private MyFrame myFrame;
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // This code will be executed every 5 seconds
            System.out.println("1 seconds have passed");
        }
    });
    int countPlayer1 = 0;
    int countPlayer2 = 0;
    int Rn;
    int Cn;
    boolean gameContinue = true;
    int count = 0;
    private checkMovePerfromed myMove;
    private aiModeClass myAi;

    public boardPerfromed(MyFrame myFrame, checkMovePerfromed myMove, aiModeClass myAi) {
        this.myFrame = myFrame;
        this.myMove = myMove;
        this.myAi = myAi;

    }

    public void firstTurn() {
        if (myFrame.random.nextInt(2) == 0) {
            myFrame.player1_turn = true;
            myFrame.turnTextField.setText("Player 1 Turn");
        } else {
            myFrame.player1_turn = false;
            myFrame.turnTextField.setText("Player 2 Turn");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myFrame.getGameBoardSize()) {
            firstTurn();
            myFrame.buttonPanel.removeAll();
            myFrame.revalidate();
            myFrame.repaint();
            myFrame.totalBoard = (int) myFrame.getGameBoardSize().getSelectedItem() * (int) myFrame.getGameBoardSize().getSelectedItem();
            myFrame.sosButtons = new JButton[(int) myFrame.getGameBoardSize().getSelectedItem()][(int) myFrame.getGameBoardSize().getSelectedItem()];
            myFrame.buttonPanel.setBorder(myFrame.buttonPanel.getBorder());
            myFrame.buttonPanel.setLayout(new GridLayout((int) myFrame.getGameBoardSize().getSelectedItem(), (int) myFrame.getGameBoardSize().getSelectedItem()));
            myFrame.buttonPanel.setBackground(Color.LIGHT_GRAY);

            if ((int) myFrame.getGameBoardSize().getSelectedItem() == 3 || (int) myFrame.getGameBoardSize().getSelectedItem() == 4 || (int) myFrame.getGameBoardSize().getSelectedItem() == 5 || (int) myFrame.getGameBoardSize().getSelectedItem() == 6
                    || (int) myFrame.getGameBoardSize().getSelectedItem() == 7) {
                myFrame.size = 150 / (int) myFrame.getGameBoardSize().getSelectedItem();
            } else {
                myFrame.size = 12;
            }

            count = 0;

            for (int i = 0; i < (int) myFrame.getGameBoardSize().getSelectedItem(); i++) {
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
            }
                count++;
                if (myFrame.simpleRadio.isSelected()) {
                    simpleGameWin(i, j);
                } else if (myFrame.generalRadio.isSelected()) {
                    generalGame(i, j);
                }

                myFrame.player1_turn = false;
                myFrame.turnTextField.setText("Player 2 Turn");
                if (myFrame.player2Ai == true)
                {
                    timer.start();
                    timer.stop();
                    myAi.aiMove((int) myFrame.getGameBoardSize().getSelectedItem(),(int) myFrame.getGameBoardSize().getSelectedItem(),"Player 2 Turn");
                }

        } else {
            if (myFrame.sosButtons[i][j].getText() == "") {
                myFrame.getGameBoardSize().setEnabled(false);
                myFrame.simpleRadio.setEnabled(false);
                myFrame.generalRadio.setEnabled(false);
                myFrame.sosButtons[i][j].setForeground(new Color(0, 0, 225));
                myFrame.sosButtons[i][j].setText(myFrame.getPlayer2Text());
            }
            count++;
            if (myFrame.simpleRadio.isSelected()) {
                simpleGameWin(i, j);

            } else if (myFrame.generalRadio.isSelected()) {
                generalGame(i, j);
            }
            myFrame.player1_turn = true;
            myFrame.turnTextField.setText("Player 1 Turn");
            if (myFrame.player1Ai == true)
            {
                timer.start();
                timer.stop();
                myAi.aiMove((int) myFrame.getGameBoardSize().getSelectedItem(),(int) myFrame.getGameBoardSize().getSelectedItem(),"Player 1 Turn");
            }
        }
    }

    public void simpleGameWin(int i, int j) {
        if (!myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).isEmpty()) {
            if (myFrame.turnTextField.getText().equals("Player 1 Turn")) {
                changeColor(i, j);
                myFrame.turnTextField.setText("Player 1 Win");
                gameContinue = false;
                newGame();
            } else if (myFrame.turnTextField.getText().equals("Player 2 Turn")) {
                changeColor(i, j);
                myFrame.turnTextField.setText("Player 2 Win");
                gameContinue = false;
                newGame();
            }
        }

        if (count == (int) myFrame.getGameBoardSize().getSelectedItem() * (int) myFrame.getGameBoardSize().getSelectedItem()) {
            myFrame.turnTextField.setText("Draw");
            newGame();
        }
    }

    public void generalGame(int i, int j) {
        if (!myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).isEmpty()) {
            if (myFrame.turnTextField.getText().equals("Player 1 Turn")) {
                changeColor(i, j);

            } else if (myFrame.turnTextField.getText().equals("Player 2 Turn")) {
                changeColor(i, j);
            }
        }

        if (count == (int) myFrame.getGameBoardSize().getSelectedItem() * (int) myFrame.getGameBoardSize().getSelectedItem()) {
            if (countPlayer1 > countPlayer2) {
                myFrame.turnTextField.setText("Player 1 Win");
                newGame();
            } else if (countPlayer1 < countPlayer2) {
                myFrame.turnTextField.setText("Player 2 Win");
                newGame();
            } else if (countPlayer1 == countPlayer2) {
                myFrame.turnTextField.setText("Draw");
                newGame();
            }
        }
    }


    public void changeColor(int i, int j) {
        for (int x = 0; x < myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).size(); x++) {
            for (int y = 0; y < myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(x).size(); y++) {
                Rn = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(x).get(y).r;
                Cn = myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).get(x).get(y).c;
                if (myFrame.turnTextField.getText().equals("Player 1 Turn")) {
                    myFrame.sosButtons[Rn][Cn].setBackground(Color.PINK);
                    myFrame.sosButtons[Rn][Cn].setEnabled(false);
                    countPlayer1++;
                } else if (myFrame.turnTextField.getText().equals("Player 2 Turn")) {
                    myFrame.sosButtons[Rn][Cn].setBackground(Color.cyan);
                    myFrame.sosButtons[Rn][Cn].setEnabled(false);
                    countPlayer2++;
                }
            }
        }

    }

    public void newGame() {

        int reply = myFrame.optionAnser.showConfirmDialog(null, myFrame.turnTextField.getText(), "Winner", JOptionPane.PLAIN_MESSAGE);
        if (reply == myFrame.optionAnser.OK_OPTION) {
            myFrame.getGameBoardSize().setSelectedIndex(1);
            myFrame.getGameBoardSize().setEnabled(true);
            myFrame.simpleRadio.setEnabled(true);
            myFrame.generalRadio.setEnabled(true);
            myFrame.turnTextField.setText("Current Turn");
        }
    }

}
