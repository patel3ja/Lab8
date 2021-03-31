import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton, playAgainButton;
  JLabel prompt, tellUser, lastGuess;
  Random r = new Random();
  int randomNum = r.nextInt(100) + 1;
  
  GuessingGame() {
    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);
    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");
    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");
    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);
    prompt = new JLabel("Enter your guess: ");
    tellUser = new JLabel("");
    lastGuess = new JLabel("");

    frame.add(prompt);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(tellUser);
    frame.add(lastGuess);
    frame.add(playAgainButton);
    frame.setVisible(true);
  }     
    public void actionPerformed(ActionEvent ae) {
      if (userGuess.getText() == "") {
        tellUser.setText("asdf");
        return;
      }
      if(ae.getActionCommand().equals("Guess")) {
        int guess = Integer.parseInt(userGuess.getText());
        if(guess < randomNum) {
          tellUser.setText("Too Low!");
          lastGuess.setText("Last guess was: " + guess);
        }else if (guess > randomNum) {
          tellUser.setText("Too high!");
          lastGuess.setText("Last guess was: " + guess);
        }else {
          tellUser.setText("You Got It!");
          lastGuess.setText("Last guess was: " + guess);
        }
        }else if (ae.getActionCommand().equals("Play Again")) {
          int randomNum = r.nextInt(100) + 1;
          tellUser.setText("");
          lastGuess.setText("");
        }else {
          tellUser.setText("You pressed Enter. Please press the Guess Button");
        }
      }
}