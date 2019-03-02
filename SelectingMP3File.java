import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.*;
import sun.audio.*;

public class SelectingMp3File implements ActionListener{
	
	JButton play = new JButton("Play");
	JButton pause = new JButton("Pause");
	
	public void Gui(){
		JFrame Frame = new JFrame("MP3 Player");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setLayout(new GridLayout(10,10,20,20));
		Frame.add(play);
		Frame.add(pause);
		Frame.pack();
		Frame.setVisible(true);
		
		play.addActionListener(this);
		pause.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args){
		new SelectingMp3File().Gui();
		MP3("Play My Music");
	}
	
		public static void MP3(String path){
		InputStream mp3player;
		try{
			mp3player = new FileInputStream(new File(path));
			AudioStream soundtrack = new AudioStream(mp3player);
			AudioPlayer.player.start(soundtrack);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		
		
	}
}
