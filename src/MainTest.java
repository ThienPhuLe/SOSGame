import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Random;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    MyFrame myFrame = new MyFrame();
    String selected;
    int totalBoard;
    Random rand = new Random();

    @Test
    void comboboxTesting() throws InterruptedException {

        Thread.sleep(1000);
        myFrame.gameBoardSize.setSelectedIndex(1);
        assertEquals(3, myFrame.gameBoardSize.getSelectedItem());

        Thread.sleep(1000);
        myFrame.gameBoardSize.setSelectedIndex(2);
        assertEquals(4, myFrame.gameBoardSize.getSelectedItem());


        Thread.sleep(1000);
        myFrame.gameBoardSize.setSelectedIndex(3);
        assertEquals(5, myFrame.gameBoardSize.getSelectedItem());


        Thread.sleep(1000);
        myFrame.gameBoardSize.setSelectedIndex(4);
        assertEquals(6, myFrame.gameBoardSize.getSelectedItem());


        Thread.sleep(1000);
        myFrame.gameBoardSize.setSelectedIndex(5);
        assertEquals(7, myFrame.gameBoardSize.getSelectedItem());

        Thread.sleep(1000);
        myFrame.gameBoardSize.setSelectedIndex(6);
        assertEquals(8, myFrame.gameBoardSize.getSelectedItem());

        Thread.sleep(1000);
        myFrame.gameBoardSize.setSelectedIndex(7);
        assertEquals(9, myFrame.gameBoardSize.getSelectedItem());
    }

    @Test
    void gameModeTest() throws InterruptedException {
        Thread.sleep(1000);
        myFrame.generalRadio.doClick();
        assertTrue(myFrame.generalRadio.isSelected());

        radioPlayerButtonTest();

        Thread.sleep(1000);
        myFrame.simpleRadio.doClick();
        assertFalse(myFrame.generalRadio.isSelected());

        radioPlayerButtonTest();
    }

    @Test
    void simpleGameMoveTest() throws InterruptedException {
        myFrame.gameBoardSize.setSelectedIndex(2);
        totalBoard = (int) myFrame.gameBoardSize.getSelectedItem() * (int) myFrame.gameBoardSize.getSelectedItem();
        myFrame.player1ButtonS.doClick();
        selected = myFrame.player1ButtonS.getText();

        for (int i = 0; i < totalBoard; i++) {
            int randomValue = rand.nextInt(totalBoard);
            if (myFrame.player1_turn == true) {
                Thread.sleep(1000);
                assertEquals("Player 1 Turn", myFrame.turnTextField.getText());


                if (myFrame.player1ButtonS.isSelected())
                {
                    myFrame.player1ButtonO.doClick();
                    selected = myFrame.player1ButtonO.getText();

                } else {
                    myFrame.player1ButtonS.doClick();
                    selected = myFrame.player1ButtonS.getText();
                }

                myFrame.sosButtons[randomValue].doClick();
                while (myFrame.sosButtons[randomValue].isSelected())
                {
                    randomValue = rand.nextInt(totalBoard);
                    myFrame.sosButtons[randomValue].doClick();
                }


            }

            else
            {
                Thread.sleep(1000);
                assertEquals("Player 2 Turn", myFrame.turnTextField.getText());

                if (myFrame.player2ButtonS.isSelected())
                {
                    myFrame.player2ButtonO.doClick();
                    selected = myFrame.player2ButtonO.getText();

                } else {
                    myFrame.player2ButtonS.doClick();
                    selected = myFrame.player2ButtonS.getText();
                }

                myFrame.sosButtons[randomValue].doClick();
                while (myFrame.sosButtons[randomValue].isSelected())
                {
                    randomValue = rand.nextInt(totalBoard);
                    myFrame.sosButtons[randomValue].doClick();
                }

            }

            if (i == 5) {
                break;
            }
        }
    }

    @Test
    void generalGameMoveTest() throws InterruptedException {
        myFrame.generalRadio.doClick();
        myFrame.gameBoardSize.setSelectedIndex(2);
        totalBoard = (int) myFrame.gameBoardSize.getSelectedItem() * (int) myFrame.gameBoardSize.getSelectedItem();
        myFrame.player1ButtonS.doClick();
        selected = myFrame.player1ButtonS.getText();

        for (int i = 0; i < totalBoard; i++) {
            int randomValue = rand.nextInt(totalBoard);
            if (myFrame.player1_turn == true) {
                Thread.sleep(1000);
                assertEquals("Player 1 Turn", myFrame.turnTextField.getText());


                if (myFrame.player1ButtonS.isSelected())
                {
                    myFrame.player1ButtonO.doClick();
                    selected = myFrame.player1ButtonO.getText();

                } else {
                    myFrame.player1ButtonS.doClick();
                    selected = myFrame.player1ButtonS.getText();
                }

                myFrame.sosButtons[randomValue].doClick();
                while (myFrame.sosButtons[randomValue].isSelected())
                {
                    randomValue = rand.nextInt(totalBoard);
                    myFrame.sosButtons[randomValue].doClick();
                }


            }

            else
            {
                Thread.sleep(1000);
                assertEquals("Player 2 Turn", myFrame.turnTextField.getText());

                if (myFrame.player2ButtonS.isSelected())
                {
                    myFrame.player2ButtonO.doClick();
                    selected = myFrame.player2ButtonO.getText();

                } else {
                    myFrame.player2ButtonS.doClick();
                    selected = myFrame.player2ButtonS.getText();
                }

                myFrame.sosButtons[randomValue].doClick();
                while (myFrame.sosButtons[randomValue].isSelected())
                {
                    randomValue = rand.nextInt(totalBoard);
                    myFrame.sosButtons[randomValue].doClick();
                }

            }

            if (i == 5) {
                break;
            }
        }
    }

    void radioPlayerButtonTest() throws InterruptedException {
        Thread.sleep(1000);
        myFrame.player1ButtonO.doClick();
        assertTrue(myFrame.player1ButtonO.isSelected());

        Thread.sleep(1000);
        myFrame.player1ButtonS.doClick();
        assertFalse(myFrame.player1ButtonO.isSelected());

        Thread.sleep(1000);
        myFrame.player2ButtonO.doClick();
        assertTrue(myFrame.player2ButtonO.isSelected());

        Thread.sleep(1000);
        myFrame.player2ButtonS.doClick();
        assertFalse(myFrame.player2ButtonO.isSelected());
    }
}