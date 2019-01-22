import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Screen {
	JFrame frame=null;
	String secret=null;
	MyDrawPanel slika;
	public void go(String word, String secret, int status, String message, boolean visibility) {
		
		//prozor
		frame = new JFrame("Gallows pole!");
		JPanel letterPanel = new JPanel();
		JPanel wordPanel = new JPanel();
		this.secret=secret;
		
		//gumbi
		JButton ButtonA = new JButton("A");
		JButton ButtonB = new JButton("B");
		JButton ButtonC = new JButton("C");
		JButton ButtonD = new JButton("D");
		JButton ButtonE = new JButton("E");
		JButton ButtonF = new JButton("F");
		JButton ButtonG = new JButton("G");
		JButton ButtonH = new JButton("H");
		JButton ButtonI = new JButton("I");
		JButton ButtonJ = new JButton("J");
		JButton ButtonK = new JButton("K");
		JButton ButtonL = new JButton("L");
		JButton ButtonM = new JButton("M");
		JButton ButtonN = new JButton("N");
		JButton ButtonO = new JButton("O");
		JButton ButtonP = new JButton("P");
		JButton ButtonQ = new JButton("Q");
		JButton ButtonR = new JButton("R");
		JButton ButtonS = new JButton("S");
		JButton ButtonT = new JButton("T");
		JButton ButtonU = new JButton("U");
		JButton ButtonV = new JButton("V");
		JButton ButtonW = new JButton("W");
		JButton ButtonX = new JButton("X");
		JButton ButtonY = new JButton("Y");
		JButton ButtonZ = new JButton("Z");
		JButton Restart = new JButton("New game!");
		if(visibility) {
		Restart.setVisible(true);
		} else Restart.setVisible(false);
		
		JLabel guessSpace = new JLabel(secret);
		JLabel poruka = new JLabel(message);
		guessSpace.setFont((new Font("Serif", Font.CENTER_BASELINE, 29)));
		poruka.setFont((new Font("Serif", Font.CENTER_BASELINE, 18)));
		Restart.setFont((new Font("Serif", Font.CENTER_BASELINE, 29)));
		Restart.setSize(new Dimension(100, 100));
	
		slika = new MyDrawPanel();
		slika.setStatus(status);
		
		//dodaj gumbe
		letterPanel.setLayout(new GridLayout(2,2));
		letterPanel.add(ButtonA);
		letterPanel.add(ButtonB);
		letterPanel.add(ButtonC);
		letterPanel.add(ButtonD);
		letterPanel.add(ButtonE);
		letterPanel.add(ButtonF);
		letterPanel.add(ButtonG);
		letterPanel.add(ButtonH);
		letterPanel.add(ButtonI);
		letterPanel.add(ButtonJ);
		letterPanel.add(ButtonK);
		letterPanel.add(ButtonL);
		letterPanel.add(ButtonM);
		letterPanel.add(ButtonN);
		letterPanel.add(ButtonO);
		letterPanel.add(ButtonP);
		letterPanel.add(ButtonQ);
		letterPanel.add(ButtonR);
		letterPanel.add(ButtonS);
		letterPanel.add(ButtonT);
		letterPanel.add(ButtonU);
		letterPanel.add(ButtonV);
		letterPanel.add(ButtonW);
		letterPanel.add(ButtonX);
		letterPanel.add(ButtonY);
		letterPanel.add(ButtonZ);
		
		//dodaj ActionListener
		ButtonA.addActionListener(new LetterListener(ButtonA, status, word));
		ButtonB.addActionListener(new LetterListener(ButtonB, status, word));
		ButtonC.addActionListener(new LetterListener(ButtonC, status, word));
		ButtonD.addActionListener(new LetterListener(ButtonD, status, word));
		ButtonE.addActionListener(new LetterListener(ButtonE, status, word));
		ButtonF.addActionListener(new LetterListener(ButtonF, status, word));
		ButtonG.addActionListener(new LetterListener(ButtonG, status, word));
		ButtonH.addActionListener(new LetterListener(ButtonH, status, word));
		ButtonI.addActionListener(new LetterListener(ButtonI, status, word));
		ButtonJ.addActionListener(new LetterListener(ButtonJ, status, word));
		ButtonK.addActionListener(new LetterListener(ButtonK, status, word));
		ButtonL.addActionListener(new LetterListener(ButtonL, status, word));
		ButtonM.addActionListener(new LetterListener(ButtonM, status, word));
		ButtonN.addActionListener(new LetterListener(ButtonN, status, word));
		ButtonO.addActionListener(new LetterListener(ButtonO, status, word));
		ButtonP.addActionListener(new LetterListener(ButtonP, status, word));
		ButtonQ.addActionListener(new LetterListener(ButtonQ, status, word));
		ButtonR.addActionListener(new LetterListener(ButtonR, status, word));
		ButtonS.addActionListener(new LetterListener(ButtonS, status, word));
		ButtonT.addActionListener(new LetterListener(ButtonT, status, word));
		ButtonU.addActionListener(new LetterListener(ButtonU, status, word));
		ButtonV.addActionListener(new LetterListener(ButtonV, status, word));
		ButtonW.addActionListener(new LetterListener(ButtonW, status, word));
		ButtonX.addActionListener(new LetterListener(ButtonX, status, word));
		ButtonY.addActionListener(new LetterListener(ButtonY, status, word));
		ButtonZ.addActionListener(new LetterListener(ButtonZ, status, word));
		Restart.addActionListener(new RestartListener());

		frame.add(slika);
		wordPanel.add(guessSpace);
		wordPanel.add(poruka);
		wordPanel.add(Restart);
		wordPanel.setLayout(new GridLayout(3,1));
				
		frame.getContentPane().add(BorderLayout.SOUTH, letterPanel);
		frame.getContentPane().add(BorderLayout.EAST, wordPanel);
		frame.setVisible(true);
		frame.setSize(900,700);
		frame.setBackground(Color.white);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class LetterListener implements ActionListener {
		JButton Slovo;
		int status;
		String word;
		Screen s1 = new Screen();
		LetterListener(JButton slovo, int status, String word) {
			this.Slovo = slovo;
			this.status=status;
			this.word=word;
			
		}
		public void actionPerformed(ActionEvent event) {
			if(status<11) {
			if(Word.checkLetter(Slovo.getText())==true) {
				secret=Word.addLetter(Slovo.getText());
				frame.dispose();
				if (secret.contains("_")) {
				s1.go(word, secret, status, "There is letter "  + Slovo.getText() + " in the wanted expression",false);
				} else {
					s1.go(word, secret, status, "The letter "  + Slovo.getText() + " is in the wanted expression. The word has been found!",true);
				}
			}else{		
				frame.dispose();
				s1.go(word, secret, status+1, "The letter "  + Slovo.getText() + " is not in the wanted expression.",false);	
			}
		} else  {
			frame.dispose();
			Word.restartPosition();
			s1.go(word, secret, status, "The game is over! You lost. The wanted expression is "+ Word.getWord()+"!",true);
		}
		}
	}
	
	public class RestartListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Start s1= new Start();
			try {
				frame.dispose();
				Word.restartPosition();
				s1.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	class MyDrawPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private String filepath;
		public void setStatus(int status) {
			filepath="./gallows/"+status+".jpg";
		}
		public void paintComponent(Graphics g) {
			Image image = new ImageIcon(filepath).getImage();
			g.drawImage(image, 0,0,342, 306, this);
		}
		}
}
