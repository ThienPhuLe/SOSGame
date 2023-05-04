import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class aiModeClass {
    private MyFrame myFrame;
    private checkMovePerfromed myMove;
    boolean check = false;
    int sizeO = 0;
    int sizeS = 0;
    int aiRowO, aiRowS;
    int aiColO, aiColS;
    Random rand = new Random();
    List<Pair> emptyMove = new ArrayList<Pair>();

    public aiModeClass(MyFrame myFrame, checkMovePerfromed myMove) {
        this.myFrame = myFrame;
        this.myMove = myMove;
    }

    public Pair randomPair (List<Pair> emptyMove)
    {
        int randPair = rand.nextInt(emptyMove.size() - 1);
        return emptyMove.get(randPair);
    }


    public void aiMove(int row, int col, String player) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (myFrame.sosButtons[i][j].getText() == "") {
                    emptyMove.add(new Pair(i,j));
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
                Pair nextMovePair = randomPair(emptyMove);
                if (myFrame.player2Text.equals("S")) {
                    myFrame.player2ButtonO.doClick();
                    myFrame.sosButtons[nextMovePair.getR()][nextMovePair.getC()].doClick();
                    check = true;
                } else if (myFrame.player2Text.equals("O")) {
                    myFrame.player2ButtonS.doClick();
                    myFrame.sosButtons[nextMovePair.getR()][nextMovePair.getC()].doClick();
                    check = true;
                }
            }
        }
        else if (player == "Player 1 Turn") {
            if (sizeO > sizeS) {
                myFrame.player1ButtonO.doClick();
                myFrame.sosButtons[aiRowO][aiColO].doClick();
                sizeO = 0;
                sizeS = 0;
            } else if (sizeO < sizeS) {
                myFrame.player1ButtonS.doClick();
                myFrame.sosButtons[aiRowS][aiColS].doClick();
                sizeO = 0;
                sizeS = 0;
            } else if (sizeO == sizeS && sizeO > 0) {
                myFrame.player1ButtonS.doClick();
                myFrame.sosButtons[aiRowS][aiColS].doClick();
                sizeO = 0;
                sizeS = 0;
            } else if (sizeO == sizeS && sizeO == 0 && sizeS == 0) {
                Pair nextMovePair = randomPair(emptyMove);
                if (myFrame.player1Text.equals("S")) {
                    myFrame.player1ButtonO.doClick();
                    myFrame.sosButtons[nextMovePair.getR()][nextMovePair.getC()].doClick();
                    check = true;
                } else if (myFrame.player1Text.equals("O")) {
                    myFrame.player1ButtonS.doClick();
                    myFrame.sosButtons[nextMovePair.getR()][nextMovePair.getC()].doClick();
                    check = true;
                }
            }


        }
    }
}