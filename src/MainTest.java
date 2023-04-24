import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    MyFrame myFrame = new MyFrame();
    checkMovePerfromed myMove = new checkMovePerfromed(myFrame);
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


    @Test
    void generalGameMoveTest() throws InterruptedException {
        Thread.sleep(1000);
        myFrame.getGameBoardSize().setSelectedIndex(2);
        myFrame.generalRadio.doClick();
        myFrame.player2ButtonS.doClick();
        myFrame.player1ButtonO.doClick();
        for (int i = 0; i < (int) myFrame.getGameBoardSize().getSelectedItem(); i++) {
            for (int j = 0; j < (int) myFrame.getGameBoardSize().getSelectedItem(); j++) {
                if (myFrame.player1_turn) {
                    if (myFrame.sosButtons[i][j].getText() == "") {
                        Thread.sleep(1000);
                        myFrame.sosButtons[i][j].doClick();

                    }
                } else {
                    if (myFrame.sosButtons[i][j].getText() == "") {
                        Thread.sleep(1000);
                        myFrame.sosButtons[i][j].doClick();
                    }
                }
            }


        }

    }

}