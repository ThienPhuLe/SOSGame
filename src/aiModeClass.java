import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class aiModeClass {
    private MyFrame myFrame;
    private checkMovePerfromed myMove;
    boolean check = false;
    int sizeO = 0;
    int sizeS = 0;
    int aiRowO, aiRowS;
    int aiColO, aiColS;

    public aiModeClass(MyFrame myFrame, checkMovePerfromed myMove) {
        this.myFrame = myFrame;
        this.myMove = myMove;
    }


    public void aiMove(int row, int col, String player) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (myFrame.sosButtons[i][j].getText() == "") {
                    if (sizeO < myMove.winCondition(i, j, "O").size()) {
                        sizeO = myMove.winCondition(i, j, "O").size();
                        aiRowO = i;
                        aiColO = j;
                    }

                    if (sizeS < myMove.winCondition(i, j, "S").size()) {
                        sizeS = myMove.winCondition(i, j, "S").size();
                        aiRowS = i;
                        aiColS = j;
                    }

                }

            }
        }

        if (player == "Player 2 Turn") {
            if (sizeO > sizeS) {
                myFrame.player2ButtonO.doClick();
                myFrame.sosButtons[aiRowO][aiColO].doClick();
            } else if (sizeO < sizeS) {
                myFrame.player2ButtonS.doClick();
                myFrame.sosButtons[aiRowS][aiColS].doClick();
            } else if (sizeO == sizeS && sizeO > 0) {
                myFrame.player2ButtonS.doClick();
                myFrame.sosButtons[aiRowS][aiColS].doClick();
            } else if (sizeO == sizeS && sizeO == 0 && sizeS == 0) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (myFrame.sosButtons[i][j].getText() == "") {
                            if (myFrame.player2Text.equals("S")) {
                                myFrame.player2ButtonO.doClick();
                                myFrame.sosButtons[i][j].doClick();
                                check = true;
                            } else if (myFrame.player2Text.equals("O")) {
                                myFrame.player2ButtonS.doClick();
                                myFrame.sosButtons[i][j].doClick();
                                check = true;
                            }

                            if (check == true) {
                                break;
                            }

                        }
                    }

                    if (check == true) {
                        break;
                    }
                }
            }
        }

        else if (player == "Player 1 Turn") {
                if (sizeO > sizeS) {
                    myFrame.player1ButtonO.doClick();
                    myFrame.sosButtons[aiRowO][aiColO].doClick();
                    sizeO =0;
                    sizeS =0;
                } else if (sizeO < sizeS) {
                    myFrame.player1ButtonS.doClick();
                    myFrame.sosButtons[aiRowS][aiColS].doClick();
                    sizeO =0;
                    sizeS =0;
                } else if (sizeO == sizeS && sizeO > 0) {
                    myFrame.player1ButtonS.doClick();
                    myFrame.sosButtons[aiRowS][aiColS].doClick();
                    sizeO =0;
                    sizeS =0;
                } else if (sizeO == sizeS && sizeO == 0 && sizeS == 0) {
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            if (myFrame.sosButtons[i][j].getText() == "") {
                                if (myFrame.player1Text.equals("S")) {
                                    myFrame.player1ButtonO.doClick();
                                    myFrame.sosButtons[i][j].doClick();
                                    check = true;
                                } else if (myFrame.player1Text.equals("O")) {
                                    myFrame.player1ButtonS.doClick();
                                    myFrame.sosButtons[i][j].doClick();
                                    check = true;
                                }

                                if (check == true) {
                                    break;
                                }

                            }
                        }

                        if (check == true) {
                            sizeO =0;
                            sizeS =0;
                            break;
                        }
                    }
                }


            }
        }
}

