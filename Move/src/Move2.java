

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Move2 extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image background = new ImageIcon(Main.class.getClassLoader().getResource("images/earth.jpg")).getImage();
	private JLabel hobbang = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_기본.gif")));
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("images/menubar_1.png")));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/cross.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/cross_1.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/leftbuttonentered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/leftbuttonbasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/rightbuttonentered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/rightbuttonbasic.png"));
	private ImageIcon upButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/upbuttonentered.png"));
	private ImageIcon upButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/upbuttonbasic.png"));
	private ImageIcon downButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/downbuttonentered.png"));
	private ImageIcon downButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("images/downbuttonbasic.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton upButton = new JButton(upButtonBasicImage);
	private JButton downButton = new JButton(downButtonBasicImage);
	
	private int mouseX, mouseY;
	private int x = 300, y = 300;

	public Move2() {
		setUndecorated(true); // 기본 메뉴바 보이지 않음
		setTitle("Let's move!"); // 프로그램 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임 창 크기
		setResizable(false); // 창 크기 임의적 변경 불가
		setLocationRelativeTo(null); // 창이 화면 정중앙에 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램 종료
		setVisible(true); // 창 정상적으로 출력
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		Container c = getContentPane();
		c.setLayout(null);

		hobbang.setBounds(x, y, 128, 128);
		c.add(hobbang);

		c.addKeyListener(new MyKeyListener());
		c.setFocusable(true);
		c.requestFocus();

		exitButton.setBounds(1250, 5, 20, 20);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Music ButtonMusic = new Music("mouse.mp3", false);
				ButtonMusic.start();
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonMusic = new Music("mouse.mp3", false);
				ButtonMusic.start();
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
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

	class MyKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			Container c = (Container) e.getSource();

			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (y - 10 < 0)
					y = 0;
				else
					y -= 10;
				hobbang.setLocation(x, y);
				break;
			case KeyEvent.VK_DOWN:
				if (y + 10 > c.getHeight() - 20)
					y = c.getHeight() - 20;
				else
					y += 10;
				hobbang.setLocation(x, y);
				break;
			case KeyEvent.VK_LEFT:
				if (x - 10 < 0)
					x = 0;
				else
					x -= 10;
				hobbang.setLocation(x, y);
				break;
			case KeyEvent.VK_RIGHT:
				if (x + 10 > c.getWidth() - 30)
					x = c.getWidth() - 30;
				else
					x += 10;
				hobbang.setLocation(x, y);
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// Ű�� ���� ����
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// ���� Ű�� ���� ����. UnicodeŰ�� �Էµ� ��쿡��
		}
	}
}
