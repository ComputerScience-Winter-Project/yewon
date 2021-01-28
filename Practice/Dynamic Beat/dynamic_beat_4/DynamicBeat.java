package dynamic_beat_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image introBackground = new ImageIcon(
			Main.class.getClassLoader().getResource("images/DB_introbackground.jpg")).getImage();
	// 이미지를 담는 객체
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("images/menubar_1.png")));
	
	private ImageIcon exitButtonEnterdImage = new ImageIcon(Main.class.getClassLoader().getResource("images/cross.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getClassLoader().getResource("images/cross_1.png"));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY;

	public DynamicBeat() {
		setUndecorated(true); // 기본 메뉴바 보이지 않음
		setTitle("Dynamic Beat"); // 프로그램 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 크기 임의적 변경 불가
		setLocationRelativeTo(null); // 창이 화면 정중앙에 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램 종료
		setVisible(true); // 창 정상적으로 출력
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		exitButton.setBounds(1250, 5, 20, 20);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnterdImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 눌렀을 때
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

	}

	public void paint(Graphics g) { // 화면을 그려주는 함수, 약속된 것으로 바뀌지 않음
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 화면 크기만큼 이미지 생성
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic); // 이미지에 원하는 내용을 그려줌
		g.drawImage(screenImage, 0, 0, null); // screenImage를 (0,0) 위치에 그려줌
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}