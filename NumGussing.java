package numguess;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;

public class NumGussing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField T1;
	private JTextField best;
	private JTextField guess;
private	JLabel L1,L2,L3,L4,L5,lblpic,remainingGuessesLabel;
	private int maxGuesses=10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	new NumGussing();
			}
	int rand=(int) (Math.random()*100);
	int count=0;
	/**
	 * Create the frame.
	 */
	public NumGussing() {
		

		
		    setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 744, 448);
			
			contentPane = new JPanel();
			contentPane.setBackground(new Color(192, 192, 192));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			remainingGuessesLabel = new JLabel("Remaining Guesses: " + maxGuesses);
	        remainingGuessesLabel.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 16));
	        remainingGuessesLabel.setBounds(297, 85, 188, 22);
	        contentPane.add(remainingGuessesLabel); 
			
			 L1 = new JLabel("Guess My Number Game !!!");
			 L1.setForeground(new Color(64, 0, 128));
			L1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			L1.setBounds(37, 29, 426, 46);
			contentPane.add(L1);
			
			 L2 = new JLabel("BestScore");
			 
			L2.setFont(new Font("Tahoma", Font.BOLD, 12));
			L2.setBounds(536, 29, 76, 22);
			contentPane.add(L2);
			
			 L3 = new JLabel("Guess");
			L3.setFont(new Font("Tahoma", Font.BOLD, 12));
			L3.setBounds(644, 26, 45, 28);
			contentPane.add(L3);
			
			 L4 = new JLabel("Enter the Number between 1-100");
			 L4.setForeground(new Color(128, 0, 0));
			L4.setFont(new Font("Tahoma", Font.BOLD, 16));
			L4.setBounds(364, 132, 286, 35);
			contentPane.add(L4);
			
			T1 = new JTextField();
			T1.setBounds(456, 177, 96, 35);
			contentPane.add(T1);
			T1.setColumns(10);
			
			 L5 = new JLabel("");
			L5.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 17));
			L5.setBounds(344, 250, 376, 29);
			contentPane.add(L5);
			
			JButton b1 = new JButton(" Play Again");
			b1.setBackground(new Color(255, 255, 255));
			b1.setFont(new Font("Tahoma", Font.BOLD, 18));
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rand=(int )(Math.random()*100);
					
					T1.setText("");
					guess.setText("");
					L5.setText(" Try and Guess Num");
					guess.setText("");
					count=0;
					T1.setEditable(true);
					T1.requestFocus();
					T1.selectAll();
					
					}
			});
			b1.setBounds(561, 320, 147, 35);
			contentPane.add(b1);
			
			JButton b2 = new JButton("Guess");
			b2.setForeground(new Color(64, 0, 64));
			b2.setBackground(new Color(255, 255, 255));
			b2.setFont(new Font("Tahoma", Font.BOLD, 18));
			b2.addActionListener(new ActionListener() {
				int remainingGuesses = maxGuesses;
				int BestScore=100;
				public void actionPerformed(ActionEvent e) {
					
					if (remainingGuesses > 0) {
					int a=Integer.parseInt(T1.getText());
					count=count+1;
					   remainingGuesses--;
					   remainingGuessesLabel.setText("Remaining Guesses: " + remainingGuesses); 
					   
					if(a>rand) {
						L5.setText(a+" is too high Number...");
						L5.setForeground(Color.RED);
					}
					else if (a < rand) {
							L5.setText(a+" is too samll Number...");
							L5.setForeground(Color.RED);
							}
					else {
						L5.setText(a+" Congratulation!!,You Won!!");
						L5.setForeground(Color.green);
						if(count<BestScore)
						{
							BestScore=count;
							best.setText(BestScore+" ");
						}
						else {
							best.setText(" "+BestScore);
							T1.setEditable(false);
						}
						T1.requestFocus();
						T1.selectAll();
						guess.setText(count+" ");
						
					}
					}
					else {
						L5.setText("Out of guesses. The correct answer is " + rand);
	                    T1.setEditable(false);
					}
				}
				
			});
			b2.setBounds(389, 320, 96, 35);
			contentPane.add(b2);
			
			JButton b3 = new JButton("Quit");
			b3.setBackground(new Color(255, 255, 255));
			b3.setFont(new Font("Tahoma", Font.BOLD, 18));
			b3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					guess.setText(" ");
					L5.setText(rand+" is correct answer");
					
					T1.setText(" ");
					T1.setEditable(false);
				}
			});
			b3.setBounds(489, 376, 85, 35);
			contentPane.add(b3);
			
			best = new JTextField();
			best.setFont(new Font("Tahoma", Font.BOLD, 14));
			best.setBounds(524, 73, 76, 32);
			contentPane.add(best);
			best.setColumns(10);
			
			guess = new JTextField();
			guess.setFont(new Font("Tahoma", Font.BOLD, 14));
			guess.setBounds(632, 74, 76, 29);
			contentPane.add(guess);
			guess.setColumns(10);
			
			lblpic = new JLabel("");
			Image img=new ImageIcon(this.getClass().getResource("/NumGuess.png")).getImage();
			lblpic.setIcon(new ImageIcon(img));
			lblpic.setBounds(1, 105, 297, 296);
			contentPane.add(lblpic);
	}
}
