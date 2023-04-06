import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkMovePerfromed {
    private MyFrame myFrame;

    public checkMovePerfromed(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public boolean winCondition (int col, int row, String getText){
        boolean winCheck = false;

        if (getText == "O")
        {
            if (col == 0 || col == (int) myFrame.getGameBoardSize().getSelectedItem() -1)
            {
                winCheck = false;
            }

            else{
                if (col-1 >= 0)
                {
                    if (myFrame.sosButtons[row][col-1].getText() == "S")
                    {
                        if (col + 1 <= (int) myFrame.getGameBoardSize().getSelectedItem() -1)
                        {
                            if (myFrame.sosButtons[row][col+1].getText() == "S")
                            {
                                winCheck = true;
                            }
                        }
                    }
                }

                else if (row -1 >=0 || row +1 <= (int) myFrame.getGameBoardSize().getSelectedItem() -1) {
                    if (myFrame.sosButtons[row-1][col].getText() == "S") {
                            if (myFrame.sosButtons[row+1][col].getText() == "S") {
                                winCheck = true;}

                    }
                }

                else if (row-1 >=0 && col-1 >= 0 ||
                        row+1 <=(int) myFrame.getGameBoardSize().getSelectedItem() -1 && col+1 <=(int) myFrame.getGameBoardSize().getSelectedItem())
                {
                    if (myFrame.sosButtons[row-1][col-1].getText() == "S"){
                        if (myFrame.sosButtons[row+1][col+1].getText() == "S"){
                            winCheck = true;
                        }
                    }
                }

                else if (row+1 <= (int) myFrame.getGameBoardSize().getSelectedItem() -1 && col+1 <=(int) myFrame.getGameBoardSize().getSelectedItem())
                {
                    if (myFrame.sosButtons[row-1][col+1].getText() == "S")
                    {
                        if (myFrame.sosButtons[row+1][col-1].getText() == "S")
                        {
                            winCheck = true;
                        }
                    }
                }

            }
        }
        else if (getText == "S") {
            if (col-2 >=0 && col+2 <= (int) myFrame.getGameBoardSize().getSelectedItem()-1)
            {
                if (myFrame.sosButtons[row][col-1].getText() == "O" || myFrame.sosButtons[row][col+1].getText() == "O")
                {
                    if (myFrame.sosButtons[row][col-2].getText() == "S" || myFrame.sosButtons[row][col+2].getText() == "S")
                    {
                        winCheck = true;
                    }
                }

            }


        }

        return winCheck;
    }


}
