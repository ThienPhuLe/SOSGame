
import java.util.ArrayList;
import java.util.List;


public class checkMovePerfromed {
    private MyFrame myFrame;
    public checkMovePerfromed(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
    public String getLetter(MyFrame myFrame, Pair myPair) {
        if (0 <= myPair.getR() && myPair.getR() < (int) myFrame.getGameBoardSize().getSelectedItem() &&
                0 <= myPair.getC() && myPair.getC() < (int) myFrame.getGameBoardSize().getSelectedItem()) {
            return myFrame.sosButtons[myPair.getR()][myPair.getC()].getText();
        }

        return "";

    }

    public List<List<Pair>> winCondition(int row, int col, String getText) {
        List<List<Pair>> SOSs = new ArrayList<>();
        List<Pair> direction = new ArrayList<>();
        direction.add(new Pair(0, 1));
        direction.add(new Pair(1, 1));
        direction.add(new Pair(1, 0));
        direction.add(new Pair(1, -1));
        Pair coordinate = new Pair(row, col);

        if (getText == "O") {
            for (int i = 0; i < direction.size(); i++) {
                Pair dirPair = direction.get(i);
                Pair S1 = coordinate.add(dirPair);
                Pair S2 = coordinate.sub(dirPair);

                if (getLetter(myFrame, S1) == "S" && getLetter(myFrame, S2) == "S") {
                    List<Pair> SOS = new ArrayList<>();
                    SOS.add(S1);
                    SOS.add(coordinate);
                    SOS.add(S2);
                    SOSs.add(SOS);
                }
            }

        } else if (getText == "S") {
            for (int i = 0; i < direction.size(); i++) {
                Pair dirPair = direction.get(i);

                Pair OF = coordinate.add(dirPair);
                Pair SF = OF.add(dirPair);

                Pair OB = coordinate.sub(dirPair);
                Pair SB = OB.sub(dirPair);

                if (getLetter(myFrame, OF) == "O" && getLetter(myFrame, SF) == "S") {
                    List<Pair> SOS = new ArrayList<>();
                    SOS.add(coordinate);
                    SOS.add(OF);
                    SOS.add(SF);
                    SOSs.add(SOS);
                }

                if (getLetter(myFrame, OB) == "O" && getLetter(myFrame, SB) == "S") {
                    List<Pair> SOS = new ArrayList<>();
                    SOS.add(coordinate);
                    SOS.add(OB);
                    SOS.add(SB);
                    SOSs.add(SOS);
                }

            }
        }

        return SOSs;
    }

}
