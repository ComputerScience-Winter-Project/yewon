package Stage3_1;

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

public class Stage3 extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image background = new ImageIcon(Main.class.getClassLoader().getResource("images/background_bora.png"))
			.getImage();

	private ImageIcon hbb_basic = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_기본.gif"));
	private ImageIcon hbb_swordReady = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_공격준비.gif"));
	private ImageIcon hbb_swordAction = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_공격 loop.gif"));
	private ImageIcon hbb_bribe =  new ImageIcon(Main.class.getClassLoader().getResource("images/돈거래 loop.gif"));
	private ImageIcon hbb_die =  new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_죽음.gif"));
	private ImageIcon hbb_hurt =  new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_아픔.gif"));
	private ImageIcon guard_basic =  new ImageIcon(Main.class.getClassLoader().getResource("images/겨엉비.png"));
	private ImageIcon guard_sword =  new ImageIcon(Main.class.getClassLoader().getResource("images/겨엉비_공격 loop.gif"));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/cross.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/cross_1.png"));
	private ImageIcon moneyButton_Basic = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/moneyButton.png"));
	private ImageIcon moneyButton_hover = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/moneyButton_hover.png"));
	private ImageIcon swordButton_Basic = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/swordButton.png"));
	private ImageIcon swordButton_hover = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/swordButton_hover.png"));
	private ImageIcon nextButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/nextbuttonbasic.png"));
	private ImageIcon nextButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/nextbuttonentered.png"));
	private ImageIcon swordFightBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/swordfightbasic.png"));
	private ImageIcon swordFightEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/swordfightentered.png"));
	private ImageIcon swordRunBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/swordrunbasic.png"));
	private ImageIcon swordRunEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/swordrunentered.png"));
	private ImageIcon endingButtonImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/exit.png"));

	private JLabel menuBar = new JLabel(
			new ImageIcon(Main.class.getClassLoader().getResource("buttons/menubar_1.png")));
	private JLabel gameOver = new JLabel(
			new ImageIcon(Main.class.getClassLoader().getResource("buttons/gameover.png")));
	private JLabel hobbang = new JLabel(hbb_basic);
	private JLabel hobbangFix = new JLabel(hbb_basic);
	private JLabel ssung = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("images/슝슝이.png")));
	private JLabel guard = new JLabel(guard_basic);

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton moneyButton = new JButton(moneyButton_Basic);
	private JButton swordButton = new JButton(swordButton_Basic);
	private JButton nextButton = new JButton(nextButtonBasicImage);
	private JButton swordFightButton = new JButton(swordFightBasicImage);
	private JButton swordRunButton = new JButton(swordRunBasicImage);
	private JButton endingButton = new JButton(endingButtonImage);

	private boolean guardEvent = false;

	private int mouseX, mouseY, x = 100, y = 300, hbb_x, hbb_y;
	private int choice = 0; // sword is 1, money is 2

	public Stage3() {
		setUndecorated(true); // 기본 메뉴바 보이지 않음
		setTitle("Stage3"); // 프로그램 이름
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
			public void mousePressed(MouseEvent e) {
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
		
		endingButton.setVisible(false);
		endingButton.setBounds(1200, 650, 60, 60);
		endingButton.setBorderPainted(false);
		endingButton.setContentAreaFilled(false);
		endingButton.setFocusPainted(false);
		endingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				endingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);	
			}
		});
		add(endingButton);

		swordButton.setBounds(100, 500, 500, 100);
		swordButton.setBorderPainted(false);
		swordButton.setContentAreaFilled(false);
		swordButton.setFocusPainted(false);
		swordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				swordButton.setIcon(swordButton_hover);
				swordButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				swordButton.setIcon(swordButton_Basic);
				swordButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				start();
				choice = 1;
				guardEvent = true;
			}
		});
		add(swordButton);

		moneyButton.setBounds(700, 500, 500, 100);
		moneyButton.setBorderPainted(false);
		moneyButton.setContentAreaFilled(false);
		moneyButton.setFocusPainted(false);
		moneyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				moneyButton.setIcon(moneyButton_hover);
				moneyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				moneyButton.setIcon(moneyButton_Basic);
				moneyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				start();
				choice = 2;
				guardEvent = true;
			}
		});
		add(moneyButton);
		
		nextButton.setVisible(false);
		nextButton.setBounds(1030, 550, 160, 80);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nextButton.setIcon(nextButtonEnteredImage);
				nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nextButton.setIcon(nextButtonBasicImage);
				nextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonMusic = new Music("mouse.mp3", false);
				ButtonMusic.start();
				guardEvent = false;
				bossEvent(choice);
			}
		});
		add(nextButton);
		
		swordFightButton.setBounds(470, 500, 340, 70);
		swordFightButton.setBorderPainted(false);
		swordFightButton.setContentAreaFilled(false);
		swordFightButton.setFocusPainted(false);
		swordFightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				swordFightButton.setIcon(swordFightEnteredImage);
				swordFightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				swordFightButton.setIcon(swordFightBasicImage);
				swordFightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonMusic = new Music("mouse.mp3", false);
				ButtonMusic.start();
				swordFightButton.setVisible(false);
				swordRunButton.setVisible(false);
				hobbangFix.setIcon(hbb_swordAction);
				hobbangFix.setBounds(490, 300, 256, 128);
				guard.setIcon(guard_sword);
				guard.setBounds(534, 300, 256, 128);
				nextButton.setVisible(true);
			}
		});
		
		swordRunButton.setBounds(470, 580, 340, 70);
		swordRunButton.setBorderPainted(false);
		swordRunButton.setContentAreaFilled(false);
		swordRunButton.setFocusPainted(false);
		swordRunButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				swordRunButton.setIcon(swordRunEnteredImage);
				swordRunButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				swordRunButton.setIcon(swordRunBasicImage);
				swordRunButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonMusic = new Music("mouse.mp3", false);
				ButtonMusic.start();
				swordFightButton.setVisible(false);
				swordRunButton.setVisible(false);
				guard.setIcon(guard_sword);
				guard.setBounds(512, 300, 256, 128);
				hobbangFix.setIcon(hbb_hurt);
				endingButton.setVisible(true);
				gameOver.setBounds(405, 150, 470, 100);
				add(gameOver);
			}
		});

		hobbang.setBounds(512, 300, 128, 128);
		ssung.setBounds(640, 300, 128, 128);
		guard.setBounds(640, 300, 128, 128);

		add(hobbang);
		add(ssung);

	}
	
	public void bossEvent(int choice) {
		background = new ImageIcon(Main.class.getClassLoader().getResource("images/background_bora.png")).getImage();
		hobbangFix.setVisible(false);
		guard.setVisible(false);
		nextButton.setVisible(false);
		x = 100; y = 300;
		hobbang.setBounds(x, y, 128, 128);
		hobbang.setVisible(true);
	}

	public void guardEvent(int choice) {
		if (choice == 1) {
			hobbang.setVisible(false);
			add(hobbangFix);
			hobbangFix.setBounds(512, 300, 128, 128);
			add(swordFightButton);
			add(swordRunButton);
		} 
		else if (choice == 2) {
			hobbang.setVisible(false);
			guard.setVisible(false);
			hobbangFix.setIcon(hbb_bribe);
			add(hobbangFix);
			hobbangFix.setBounds(512, 300, 256, 128);
			nextButton.setVisible(true);
		}
	}

	public void start() {
		Container c = getContentPane();
		c.setLayout(null);
		hobbang.setBounds(x, y, 128, 128);
		c.add(hobbang);
		c.addKeyListener(new MyKeyListener());
		c.setFocusable(true);
		c.requestFocus();
		
		background = new ImageIcon(Main.class.getClassLoader().getResource("images/background_bora.png")).getImage();
		moneyButton.setVisible(false);
		swordButton.setVisible(false);
		ssung.setVisible(false);
		add(guard);
	}

	public void paint(Graphics g) { // 화면을 그려주는 함수, 약속된 것으로 바뀌지 않음
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 화면 크기만큼 이미지 생성
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic); // 이미지에 원하는 내용을 그려줌
		g.drawImage(screenImage, 0, 0, null); // screenImage를 (0,0) 위치에 그려줌
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g); // add된 것 그려줌
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

			hbb_x = hobbang.getLocation().x;
			hbb_y = hobbang.getLocation().y;
			if (guardEvent) {
				if (500 < hbb_x && hbb_x < 908 && 160 < hbb_y && hbb_y < 568) {
					guardEvent(choice);
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

	}

}
