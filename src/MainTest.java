import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Random;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    MyFrame myFrame = new MyFrame();
    checkMovePerfromed myMove = new checkMovePerfromed(myFrame);
    boardPerfromed myPerformed = new boardPerfromed(myFrame,myMove);

    @Test
    void simpleGameMoveTest() throws InterruptedException {
        Thread.sleep(1000);
        myFrame.getGameBoardSize().setSelectedIndex(2);
        myFrame.player2ButtonS.doClick();
        myFrame.player1ButtonO.doClick();
        for (int i = 0; i < (int) myFrame.getGameBoardSize().getSelectedItem(); i++) {
            for (int j = 0; j < (int) myFrame.getGameBoardSize().getSelectedItem(); j++) {
                if (myFrame.player1_turn) {
                    if (myFrame.sosButtons[i][j].getText() == "") {
                        Thread.sleep(1000);
                        myFrame.sosButtons[i][j].doClick();
                        if (!myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).isEmpty()) {
                            assertEquals("Player 1 Win", myFrame.turnTextField.getText());
                        }

                    }
                } else {
                    if (myFrame.sosButtons[i][j].getText() == "") {
                        Thread.sleep(1000);
                        myFrame.sosButtons[i][j].doClick();
                        if (!myMove.winCondition(i, j, myFrame.sosButtons[i][j].getText()).isEmpty()) {
                            assertEquals("Player 2 Win", myFrame.turnTextField.getText());
                        }
                    }
                }
            }


        }

    }
}