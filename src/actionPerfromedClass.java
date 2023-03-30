import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class actionPerfromedClass implements ActionListener {
    MyFrame actionFrame = new MyFrame();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == actionFrame.gameBoardSize)
        {

        }

    }
}
