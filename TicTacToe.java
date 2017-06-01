import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe
{
    JFrame _frame = new JFrame("Tic-Tac-Toe");
    JButton[] _buttons = new JButton[9];
    boolean turn = true;

    public TicTacToe()
    {
        JPanel _ttt = new JPanel();
        JPanel _newPanel = new JPanel();
        JButton _newGameButton = new JButton("New Game");
        boolean turn = true;

        for(int i=0; i<9; i++)
        {
            //make a new button in the array location with text "_"
            _buttons[i] = new JButton("_");
            //Associate a new ButtonListener to the button
            ActionListener buttonListener = new ButtonListener();
            _buttons[i].addActionListener(buttonListener);
            //set the font on the button
            _buttons[i].setFont(new Font("Courier", Font.PLAIN, 48));
            //add this button to the _ttt panel
            _ttt.add(_buttons[i]);
        }
        ActionListener buttonListener = new ButtonListener();
        _newGameButton.addActionListener(buttonListener);
        _newPanel.add(_newGameButton);

        _ttt.setLayout(new GridLayout(3,3));
        _newPanel.setLayout(new FlowLayout());
        //this will place the tic-tac-toe (_ttt) panel at the top of
        //the frame and the _newPanel panel at the bottom
        _frame.add(_ttt, BorderLayout.NORTH);
        _frame.add(_newPanel, BorderLayout.SOUTH);

        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setSize(400, 400);
        _frame.setVisible(true);
    }

    class ButtonListener implements ActionListener
    {
        //every time we click the button, it will perform
        //the following action.
        public void actionPerformed(ActionEvent e)
        {
            JButton source = (JButton) e.getSource();
            String currentText = source.getText();
            if(currentText.equals("New Game"))
            {
                turn = true;
                for(int i=0; i<9; i++)
                {
                    _buttons[i].setText("_");
                }
            }
            if(currentText.equals("_") && !currentText.equals("O") && turn)
            {
                source.setText("X");
                turn = false;
                //System.out.println("x just moved: turn = " + turn);
            }
            else if(currentText.equals("_") && !currentText.equals("X") && !turn)
            {
                source.setText("O");
                turn = true;
                //System.out.println("o just moved: turn = " + turn);
            }
            /*else
            {
                source.setText("_");
            }*/
        }
    }

    public static void main(String[] args)
    {
        new TicTacToe();
    }
}
