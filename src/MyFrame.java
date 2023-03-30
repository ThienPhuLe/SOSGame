import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener {
    Random random ;
    int size;
    String player1Text = "S";
    String player2Text = "S";
    int totalBoard ;
    ImageIcon image;
    JLabel label;
    JLabel labelBoard;
    JRadioButton generalRadio;
    JRadioButton simpleRadio;
    JRadioButton player1ButtonS;
    JRadioButton player1ButtonO;
    JRadioButton player2ButtonS;
    JRadioButton player2ButtonO;
    JRadioButton player1Human;
    JRadioButton player2Human;
    JRadioButton player1Computer;
    JRadioButton player2Computer;
    ButtonGroup player1Group;
    ButtonGroup player2Group;
    ButtonGroup player1Type;
    ButtonGroup player2Type;
    ButtonGroup gameType;
    JPanel buttonPanel;
    JPanel right_panel;
    JPanel bottom_panel;
    JPanel left_panel;
    JLabel right_panLabel;
    JLabel left_panLabel;
    JCheckBox recordBox;
    JTextField turnTextField;
    JButton replayButton;
    JButton newGmButton;
    JButton[] sosButtons;
    JComboBox gameBoardSize;
    boolean player1_turn;
    MyFrame(){
        // Main/Head Jpanel

        Border border = BorderFactory.createLineBorder(Color.BLACK,3);//Border color
        this.setTitle("S.O.S Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720,720); // Set the x dimension, and y-dimension of this
        this.setResizable(false);
        this.setLayout(null);
        image = new ImageIcon("images.png");
        this.setIconImage(image.getImage());// Change icone of this
        label = new JLabel();// Create a label
        labelBoard  = new JLabel();
        labelBoard.setText("Board Size: ");
        Integer[] boardSizeSelection = {0, 3, 4, 5, 6, 7, 8, 9};
        gameBoardSize = new JComboBox(boardSizeSelection);
        gameBoardSize.addActionListener(this);
        this.add(label);
        label.setIcon(image);
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setBounds(230,0,250,170);
        labelBoard.setBounds(30,50,100,100);
        gameBoardSize.setBounds(110,90,50,20);
        generalRadio = new JRadioButton("General game");
        generalRadio.addActionListener(this);
        simpleRadio = new JRadioButton("Simple game");
        simpleRadio.addActionListener(this);
        simpleRadio.setSelected(true);
        gameType = new ButtonGroup();
        gameType.add(generalRadio);
        gameType.add(simpleRadio);
        generalRadio.setBounds(550,40,150,50);
        simpleRadio.setBounds(550,90,150,50);
        this.add(generalRadio);
        this.add(simpleRadio);
        this.add(labelBoard);
        this.add(gameBoardSize);

        random = new Random();


        //Center JPanel
        buttonPanel = new JPanel();
        this.add(buttonPanel);
        buttonPanel.setBorder(border);
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setBounds(160,170,380,380);


        // Right Jpanel
        right_panel = new JPanel();
        right_panLabel = new JLabel();
        player1ButtonS = new JRadioButton(new AbstractAction("S") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == player1ButtonS)
                {
                    player1Text = "S";
                }
            }
        });

        player1ButtonS.setSelected(true);

        player1ButtonO = new JRadioButton(new AbstractAction("O") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == player1ButtonO)
                {
                    player1Text = "O";
                }
            }
        });



        player1Human = new JRadioButton("Human");
        player1Human.addActionListener(this);
        player1Computer = new JRadioButton("Computer");
        player1Computer.addActionListener(this);
        player1Group = new ButtonGroup();
        player1Type = new ButtonGroup();
        player1Group.add(player1ButtonS);
        player1Group.add(player1ButtonO);
        player1Type.add(player1Human);
        player1Type.add(player1Computer);
        right_panel.setLayout(null);
        right_panLabel.setText("Player 1");
        right_panLabel.setBounds(50,10,50,50);
        right_panel.add(right_panLabel);
        player1ButtonS.setBounds(50,70,50,50);
        player1ButtonO.setBounds(50,100,50,50);
        player1Computer.setBounds(30,170,90,50);
        player1Human.setBounds(30,210,90,50);
        right_panel.add(player1Computer);
        right_panel.add(player1Human);
        right_panel.add(player1ButtonS);
        right_panel.add(player1ButtonO);
        this.add(right_panel);
        right_panel.setBounds(0,170,145,375);

        //Left Jpanel
        left_panel = new JPanel();
        left_panLabel = new JLabel();
        player2ButtonS = new JRadioButton(new AbstractAction("S") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == player2ButtonS)
                {
                    player2Text = "S";
                }

            }
        });

        player2ButtonS.setSelected(true);

        player2ButtonO = new JRadioButton(new AbstractAction("O") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == player2ButtonO)
                {
                    player2Text = "O";
                }
            }
        });

        player2Computer = new JRadioButton("Computer");
        player2Computer.addActionListener(this);
        player2Human = new JRadioButton("Human");
        player2Human.addActionListener(this);
        player2Group = new ButtonGroup();
        player2Type = new ButtonGroup();
        left_panel.setLayout(null);
        player2Type.add(player2Computer);
        player2Type.add(player2Human);
        player2Group.add(player2ButtonS);
        player2Group.add(player2ButtonO);
        left_panLabel.setText("Player 2");
        left_panLabel.setBounds(50,10,50,50);
        player2ButtonS.setBounds(50,70,50,50);
        player2ButtonO.setBounds(50,100,50,50);
        player2Computer.setBounds(30,170,90,50);
        player2Human.setBounds(30,210,90,50);
        left_panel.add(player2Human);
        left_panel.add(player2Computer);
        left_panel.add(player2ButtonS);
        left_panel.add(player2ButtonO);
        left_panel.add(left_panLabel);
        this.add(left_panel);
        left_panel.setBounds(553,170,150,375);

        //Bottom Jpanel
        bottom_panel = new JPanel();
        this.add(bottom_panel);
        bottom_panel.setBounds(0,546,705,130);
        bottom_panel.setLayout(null);
        recordBox = new JCheckBox();
        turnTextField = new JTextField();
        replayButton = new JButton();
        newGmButton = new JButton();
        replayButton.setText("Replay");
        newGmButton.setText("New Game");
        turnTextField.setEditable(false);
        turnTextField.setText("Current Turn");
        turnTextField.setFont(new Font("serif",Font.BOLD,20));
        turnTextField.setHorizontalAlignment(JTextField.CENTER);
        recordBox.setText("Record game");
        turnTextField.setBounds(240,10,200,30);
        recordBox.setBounds(40,20,150,50);
        replayButton.setBounds(550,10,100,30);
        newGmButton.setBounds(550,50,100,30);
        bottom_panel.add(replayButton);
        bottom_panel.add(newGmButton);
        bottom_panel.add(turnTextField);
        bottom_panel.add(recordBox);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameBoardSize)
        {
            firstTurn();
            buttonPanel.removeAll();
            revalidate();
            repaint();
            totalBoard = (int) gameBoardSize.getSelectedItem() * (int) gameBoardSize.getSelectedItem();
            sosButtons = new JButton[totalBoard];
            buttonPanel.setBorder(buttonPanel.getBorder());
            buttonPanel.setLayout(new GridLayout((int) gameBoardSize.getSelectedItem(),(int) gameBoardSize.getSelectedItem()));
            buttonPanel.setBackground(Color.LIGHT_GRAY);

            if ((int) gameBoardSize.getSelectedItem() == 3 || (int) gameBoardSize.getSelectedItem() == 4 ||  (int) gameBoardSize.getSelectedItem() == 5 || (int) gameBoardSize.getSelectedItem() == 6
                    || (int) gameBoardSize.getSelectedItem() == 7)
            {
                size = 150/(int) gameBoardSize.getSelectedItem();
            }

            else {
                size = 12;
            }

            for (int i = 0; i < totalBoard; i++){
                sosButtons[i] = new JButton();
                buttonPanel.add(sosButtons[i]);
                sosButtons[i].setFont(new Font("MV Boli", Font.BOLD,size));
                sosButtons[i].setFocusable(false);
                sosButtons[i].addActionListener(this);
            }
        }



        for (int i = 0; i < totalBoard; i++ )
        {
            if (e.getSource() == sosButtons[i]){
                if(player1_turn) {
                    if(sosButtons[i].getText() == ""){
                        gameBoardSize.setEnabled(false);
                        simpleRadio.setEnabled(false);
                        generalRadio.setEnabled(false);
                        sosButtons[i].setForeground(new Color(255,0,0));
                        sosButtons[i].setText(player1Text);
                        player1_turn = false;
                        turnTextField.setText("Player 2 Turn");
                    }
                }
                else{
                    if(sosButtons[i].getText() == ""){
                        gameBoardSize.setEnabled(false);
                        simpleRadio.setEnabled(false);
                        generalRadio.setEnabled(false);
                        sosButtons[i].setForeground(new Color(0,0,225));
                        sosButtons[i].setText(player2Text);
                        player1_turn = true;
                        turnTextField.setText("Player 1 Turn");
                    }
                }
            }

        }

    }
    public void firstTurn(){
        if (random.nextInt(2) == 0 )
        {
            player1_turn = true;
            turnTextField.setText("Player 1 Turn");
        }

        else{
            player1_turn = false;
            turnTextField.setText("Player 2 Turn");
        }
    }
}
