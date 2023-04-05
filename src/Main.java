import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        boardSizePerfromed boardSize = new boardSizePerfromed(myFrame);
        myFrame.getGameBoardSize().addActionListener(boardSize);


    }
}