package Sword_1;

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
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Stage3 extends JFrame {

	// 공통
	private Image screenImage;
	private Graphics screenGraphic;

	private Image background = new ImageIcon(Main.class.getClassLoader().getResource("images/background_bora.png"))
			.getImage();

	private JLabel menuBar = new JLabel(
			new ImageIcon(Main.class.getClassLoader().getResource("buttons/menubar_1.png")));

	private ImageIcon exitButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/cross_1.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/cross.png"));
	private ImageIcon moneyButton_Basic = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/moneyButton.png"));
	private ImageIcon moneyButton_hover = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/moneyButton_hover.png"));
	private ImageIcon swordButton_Basic = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/swordButton.png"));
	private ImageIcon swordButton_hover = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/swordButton_hover.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage); // 상단 우측 X 버튼
	private JButton moneyButton = new JButton(moneyButton_Basic); // 돈과 칼 선택지 중 돈
	private JButton swordButton = new JButton(swordButton_Basic); // 돈과 칼 선택지 중 칼

	private int mouseX, mouseY, x = 100, y = 300;

	// sword
	private ImageIcon endingButtonImage = new ImageIcon(Main.class.getClassLoader().getResource("buttons/exit.png"));
	private ImageIcon undoButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/undobuttonbasic.png"));
	private ImageIcon undoButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/undobuttonentered.png"));
	private ImageIcon fightButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/fightbuttonbasic.png"));
	private ImageIcon fightButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/fightbuttonentered.png"));
	private ImageIcon runButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/runbuttonbasic.png"));
	private ImageIcon runButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/runbuttonentered.png"));
	private ImageIcon attackButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/attackbuttonbasic.png"));
	private ImageIcon attackButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/attackbuttonentered.png"));
	private ImageIcon healButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/healbuttonbasic.png"));
	private ImageIcon healButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/healbuttonentered.png"));
	private ImageIcon turnButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/turnbuttonbasic.png"));
	private ImageIcon turnButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/turnbuttonentered.png"));
	private ImageIcon nextButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/nextbuttonbasic.png"));
	private ImageIcon nextButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/nextbuttonentered.png"));
	private ImageIcon talkButtonBasicImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/talkbuttonbasic.png"));
	private ImageIcon talkButtonEnteredImage = new ImageIcon(
			Main.class.getClassLoader().getResource("buttons/talkbuttonentered.png"));

	private ImageIcon hbb_basic = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_기본.gif"));
	private ImageIcon hbb_turn = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_방향전환.gif"));
	private ImageIcon hbb_attackReady = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_공격준비.gif"));
	private ImageIcon hbb_attackAction = new ImageIcon(
			Main.class.getClassLoader().getResource("images/호빵이_공격 loop.gif"));
	private ImageIcon hbb_heal = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_치료.gif"));
	private ImageIcon hbb_die = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_죽음.gif"));
	private ImageIcon hbb_hurt = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_아픔.gif"));
	private ImageIcon hbb_happy = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_메롱.gif"));
	private ImageIcon hbb_dirty = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_꼬질꼬질.gif"));
	private ImageIcon hbb_turndirty = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_방향전환꼬질.gif"));
	private ImageIcon hbb_angry = new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_화남.gif"));
	private ImageIcon guard_basic = new ImageIcon(Main.class.getClassLoader().getResource("images/겨엉비.png"));
	private ImageIcon guard_attackAction = new ImageIcon(
			Main.class.getClassLoader().getResource("images/겨엉비_공격 loop.gif"));
	private ImageIcon guard_hurt = new ImageIcon(Main.class.getClassLoader().getResource("images/겨엉비_아픔.png"));
	private ImageIcon lucky_basic = new ImageIcon(Main.class.getClassLoader().getResource("images/럭키.png"));
	private ImageIcon boss_basic = new ImageIcon(Main.class.getClassLoader().getResource("images/보오스.png"));
	private ImageIcon boss_attackAction = new ImageIcon(
			Main.class.getClassLoader().getResource("images/보오스_공격 loop.gif"));
	private ImageIcon boss_hurt = new ImageIcon(Main.class.getClassLoader().getResource("images/보오스_아픔.png"));
	private ImageIcon boss_die = new ImageIcon(Main.class.getClassLoader().getResource("images/보오스_죽음.gif"));
	private ImageIcon boss_heal = new ImageIcon(Main.class.getClassLoader().getResource("images/보오스_치료.gif"));

	private JLabel gameOver = new JLabel(
			new ImageIcon(Main.class.getClassLoader().getResource("buttons/gameover.png"))); // 게임오버글씨
	private JLabel win = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("buttons/win.png"))); // 승리글씨
	private JLabel talk = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("buttons/talk1.png"))); // 럭키와의
																													// 대화
	private JLabel hobbang = new JLabel(hbb_basic); // 호빵이
	private JLabel guard = new JLabel(guard_basic); // 겨엉비
	private JLabel lucky = new JLabel(lucky_basic); // 럭키
	private JLabel boss = new JLabel(boss_basic); // 겨엉비

	private ImageIcon HPbar_die = new ImageIcon(Main.class.getClassLoader().getResource("buttons/HPbar_die.png"));
	private JLabel HP = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("buttons/HP.png"))); // 호빵이 HP
	private JLabel HPbar = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("buttons/HPbar.png")));
	private JLabel HP_O = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("buttons/HP.png"))); // 상대 HP
	private JLabel HPbar_O = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("buttons/HPbar.png")));
	private int hp, hp_o;

	private JButton endingButton = new JButton(endingButtonImage); // 하단 우측 나가기 버튼
	private JButton undoButton = new JButton(undoButtonBasicImage); // 하단 우측 되돌리기 버튼
	private JButton nextButton = new JButton(nextButtonBasicImage); // 하단 우측 NEXT 버튼
	private JButton fightButton = new JButton(fightButtonBasicImage); // guardEvent 선택지 중 Fight!
	private JButton runButton = new JButton(runButtonBasicImage); // guardEvent 선택지 중 Run away!
	private JButton attackButton = new JButton(attackButtonBasicImage); // battleEvent 선택지 중 Attack
	private JButton healButton = new JButton(healButtonBasicImage); // battleEvent 선택지 중 Heal
	private JButton turnButton = new JButton(turnButtonBasicImage); // 상대 공격 차례
	private JButton talkButton = new JButton(talkButtonBasicImage); // 럭키와의 대화

	private boolean move = false, guardEvent = false, luckyEvent = false;
	private int talknum = 1, hptmp;

	private Random random = new Random();

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
				swordEvent();
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
				// moneyEvent
			}
		});
		add(moneyButton);

	}

	public void swordEvent() { // nextButton
		background = new ImageIcon(Main.class.getClassLoader().getResource("images/background_bora.png")).getImage();
		moneyButton.setVisible(false);
		swordButton.setVisible(false);
		move = true;
		guardEvent = true;

		Container c = getContentPane();
		c.setLayout(null);
		hobbang.setBounds(x, y, 128, 128);
		c.add(hobbang);
		c.addKeyListener(new MyKeyListener());
		c.setFocusable(true);
		c.requestFocus();

		guard.setBounds(640, 300, 128, 128);
		add(guard);
		guardEvent = true;

		nextButton.setVisible(false);
		nextButton.setBounds(1010, 530, 180, 100);
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
				if (guardEvent) {
					HP.setVisible(false);
					HPbar.setVisible(false);
					HP_O.setVisible(false);
					HPbar_O.setVisible(false);
					win.setVisible(false);
					guard.setVisible(false);
					nextButton.setVisible(false);
					guardEvent = false;

					background = new ImageIcon(Main.class.getClassLoader().getResource("images/background_bora.png"))
							.getImage();
					hobbang.setIcon(hbb_dirty);
					x = 100;
					y = 300;
					hobbang.setBounds(x, y, 128, 128);
					lucky.setBounds(640, 290, 128, 128);
					add(lucky);
					move = true;
					luckyEvent = true;
				} else if (luckyEvent) {
					lucky.setVisible(false);
					talk.setVisible(false);
					talkButton.setVisible(false);
					nextButton.setVisible(false);
					luckyEvent = false;

					bossEvent();
				} else {
					win.setVisible(false);
					boss.setVisible(false);
					nextButton.setVisible(false);

					endingEvent();
				}
			}
		});
		add(nextButton);
	}

	public void guardEvent() { // undoButton, fightButton, runButton
		move = false;
		hobbang.setIcon(hbb_basic);
		hobbang.setBounds(512, 300, 128, 128);
		guard.setIcon(guard_basic);
		guard.setBounds(640, 300, 128, 128);
		gameOver.setVisible(false);
		gameOver.setBounds(405, 150, 470, 100);
		add(gameOver);
		fightButton.setVisible(true);
		runButton.setVisible(true);

		undoButton.setVisible(false);
		undoButton.setBounds(1180, 630, 60, 60);
		undoButton.setBorderPainted(false);
		undoButton.setContentAreaFilled(false);
		undoButton.setFocusPainted(false);
		undoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				undoButton.setIcon(undoButtonEnteredImage);
				undoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				undoButton.setIcon(undoButtonBasicImage);
				undoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				if (guardEvent) {
					HP.setVisible(false);
					HPbar.setVisible(false);
					HP_O.setVisible(false);
					HPbar_O.setVisible(false);
					guardEvent();
				} else {
					undoButton.setVisible(false);
					gameOver.setVisible(false);
					bossEvent();
				}
			}
		});
		add(undoButton);

		fightButton.setBounds(411, 470, 458, 88);
		fightButton.setBorderPainted(false);
		fightButton.setContentAreaFilled(false);
		fightButton.setFocusPainted(false);
		fightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				fightButton.setIcon(fightButtonEnteredImage);
				fightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				fightButton.setIcon(fightButtonBasicImage);
				fightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				fightButton.setVisible(false);
				runButton.setVisible(false);
				battleMode(guard);
			}
		});
		add(fightButton);

		runButton.setBounds(411, 570, 458, 88);
		runButton.setBorderPainted(false);
		runButton.setContentAreaFilled(false);
		runButton.setFocusPainted(false);
		runButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				runButton.setIcon(runButtonEnteredImage);
				runButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				runButton.setIcon(runButtonBasicImage);
				runButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				fightButton.setVisible(false);
				runButton.setVisible(false);
				undoButton.setVisible(true);
				gameOver.setVisible(true);
				hobbang.setIcon(hbb_hurt);
				guard.setIcon(guard_attackAction);
				guard.setBounds(512, 300, 256, 128);
			}
		});
		add(runButton);

	}

	public void battleMode(JLabel opponent) {
		hobbang.setIcon(hbb_attackReady);
		hobbang.setBounds(490, 300, 256, 128);
		if (guardEvent) {
			hp = 106;
			hp_o = 106;
			guard.setIcon(guard_basic);
			guard.setBounds(662, 300, 128, 128);
			battleEvent(guard);
		} else {
			hp = 106;
			hp_o = 106;
			boss.setIcon(boss_basic);
			boss.setBounds(662, 300, 128, 128);
			battleEvent(boss);
		}

		hp = 106;
		hp_o = 106;

		HPbar.setVisible(true);
		HPbar.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/HPbar.png")));
		HPbar.setBounds(hobbang.getLocation().x + 6, hobbang.getLocation().y - 25, 116, 23);
		add(HPbar);
		HP.setVisible(true);
		HP.setBounds(hobbang.getLocation().x + 16, hobbang.getLocation().y - 25, hp, 23);
		add(HP);
		HPbar_O.setVisible(true);
		HPbar_O.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/HPbar.png")));
		HPbar_O.setBounds(opponent.getLocation().x + 6, opponent.getLocation().y - 25, 116, 23);
		add(HPbar_O);
		HP_O.setVisible(true);
		HP_O.setBounds(opponent.getLocation().x + 16, opponent.getLocation().y - 25, hp_o, 23);
		add(HP_O);

	}

	public void battleEvent(JLabel opponent) { // attackButton, healButton, turnButton
		attackButton.setVisible(true);
		attackButton.setBounds(411, 470, 458, 88);
		attackButton.setBorderPainted(false);
		attackButton.setContentAreaFilled(false);
		attackButton.setFocusPainted(false);
		attackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				attackButton.setIcon(attackButtonEnteredImage);
				attackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				attackButton.setIcon(attackButtonBasicImage);
				attackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				attackButton.setVisible(false);
				healButton.setVisible(false);
				turnButton.setVisible(true);
				hobbang.setIcon(hbb_attackAction);
				hobbang.setBounds(490, 300, 256, 128);
				hptmp = hp;
				if (guardEvent) {
					guard.setIcon(guard_hurt);
					guard.setBounds(662, 300, 128, 128);
					hp_o -= (random.nextInt(5) + 1) * 10;
					HP_O.setBounds(guard.getLocation().x + 16, guard.getLocation().y - 25, hp_o, 23);
					if (hp_o <= 0) {
						win.setBounds(405, 150, 470, 100);
						add(win);
						HP_O.setVisible(false);
						HPbar_O.setIcon(HPbar_die);
						attackButton.setVisible(false);
						healButton.setVisible(false);
						turnButton.setVisible(false);
						hobbang.setIcon(hbb_happy);
						hobbang.setBounds(490, 300, 128, 128);
						nextButton.setVisible(true);
					}
				} else {
					boss.setIcon(boss_hurt);
					boss.setBounds(662, 300, 128, 128);
					hp_o -= (random.nextInt(3) + 1) * 10;
					HP_O.setBounds(boss.getLocation().x + 16, boss.getLocation().y - 25, hp_o, 23);
					if (hp_o <= 0) {
						win.setVisible(true);
						HP.setVisible(false);
						HPbar.setVisible(false);
						HP_O.setVisible(false);
						HPbar_O.setVisible(false);
						attackButton.setVisible(false);
						healButton.setVisible(false);
						turnButton.setVisible(false);
						hobbang.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("images/호빵이_공격.gif")));
						hobbang.setBounds(490, 300, 256, 128);
						boss.setIcon(boss_die);
						boss.setBounds(662, 268, 128, 160);
						nextButton.setVisible(true);
					}
				}

			}
		});
		add(attackButton);

		healButton.setVisible(true);
		healButton.setBounds(411, 570, 458, 88);
		healButton.setBorderPainted(false);
		healButton.setContentAreaFilled(false);
		healButton.setFocusPainted(false);
		healButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				healButton.setIcon(healButtonEnteredImage);
				healButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				healButton.setIcon(healButtonBasicImage);
				healButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				hobbang.setIcon(hbb_heal);
				hobbang.setBounds(490, 300, 128, 128);
				hp += (random.nextInt(4) + 1) * 10;
				if (hp > 106) {
					hp = 106;
				}
				hptmp = hp;
				HP.setBounds(hobbang.getLocation().x + 16, hobbang.getLocation().y - 25, hp, 23);
				attackButton.setVisible(false);
				healButton.setVisible(false);
				turnButton.setVisible(true);
				if (guardEvent) {
					guard.setIcon(guard_basic);
					guard.setBounds(662, 300, 128, 128);
				} else {
					boss.setIcon(boss_basic);
					boss.setBounds(662, 300, 128, 128);
				}
			}
		});
		add(healButton);

		turnButton.setVisible(false);
		turnButton.setBounds(opponent.getLocation().x, opponent.getLocation().y + 130, 128, 32);
		turnButton.setBorderPainted(false);
		turnButton.setContentAreaFilled(false);
		turnButton.setFocusPainted(false);
		turnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				turnButton.setIcon(turnButtonEnteredImage);
				turnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				turnButton.setIcon(turnButtonBasicImage);
				turnButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonMusic = new Music("mouse.mp3", false);
				buttonMusic.start();
				turnButton.setVisible(false);
				attackButton.setVisible(true);
				healButton.setVisible(true);
				if (guardEvent) {
					guard.setVisible(true);
					hobbang.setIcon(hbb_hurt);
					hobbang.setBounds(490, 300, 128, 128);
					guard.setIcon(guard_attackAction);
					guard.setBounds(534, 300, 256, 128);
					hp -= (random.nextInt(3) + 1) * 10;
					HP.setBounds(hobbang.getLocation().x + 16, hobbang.getLocation().y - 25, hp, 23);
					if (hp <= 0) {
						HPbar.setIcon(HPbar_die);
						attackButton.setVisible(false);
						healButton.setVisible(false);
						turnButton.setVisible(false);
						hobbang.setIcon(hbb_die);
						undoButton.setVisible(true);
						gameOver.setVisible(true);
					}
				} else {
					int n = random.nextInt(2);
					switch (n) {
					case 0:
						hobbang.setIcon(hbb_attackReady);
						hobbang.setBounds(490, 300, 256, 128);
						boss.setIcon(boss_heal);
						boss.setBounds(662, 300, 128, 128);
						hp_o += (random.nextInt(4) + 1) * 10;
						if (hp_o > 106) {
							hp_o = 106;
						}
						HP_O.setBounds(boss.getLocation().x + 16, boss.getLocation().y - 25, hp_o, 23);
						hp = hptmp;
						HP.setBounds(hobbang.getLocation().x + 16, hobbang.getLocation().y - 25, hp, 23);
						break;
					case 1:
						hobbang.setIcon(hbb_hurt);
						hobbang.setBounds(490, 300, 128, 128);
						boss.setIcon(boss_attackAction);
						boss.setBounds(534, 300, 256, 128);
						hp -= (random.nextInt(5) + 1) * 10;
						HP.setBounds(hobbang.getLocation().x + 16, hobbang.getLocation().y - 25, hp, 23);
						if (hp <= 0) {
							HP.setVisible(false);
							HPbar.setVisible(false);
							HP_O.setVisible(false);
							HPbar_O.setVisible(false);
							attackButton.setVisible(false);
							healButton.setVisible(false);
							turnButton.setVisible(false);
							hobbang.setIcon(hbb_die);
							undoButton.setVisible(true);
							gameOver.setVisible(true);
						}
						break;

					}

				}

			}
		});
		add(turnButton);

	}

	public void luckyEvent() { // talkButton
		move = false;
		hobbang.setBounds(512, 300, 128, 128);

		talkButton.setBounds(720 + 132, 120 + 182, 33, 22);
		talkButton.setBorderPainted(false);
		talkButton.setContentAreaFilled(false);
		talkButton.setFocusPainted(false);
		talkButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				talkButton.setIcon(talkButtonEnteredImage);
				talkButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				talkButton.setIcon(talkButtonBasicImage);
				talkButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonMusic = new Music("mouse.mp3", false);
				ButtonMusic.start();
				if (luckyEvent) {
					talknum += 1;
					switch (talknum) {
					case 2:
						talk.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/talk2.png")));
						break;
					case 3:
						talk.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/talk3.png")));
						hobbang.setIcon(hbb_heal);
						break;
					case 4:
						talk.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/talk4.png")));
						hobbang.setIcon(hbb_basic);
						break;
					case 5:
						talk.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/talk5.png")));
						talkButton.setVisible(false);
						nextButton.setVisible(true);
					}
				} else {
					talknum += 1;
					switch (talknum) {
					case 7:
						talk.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/talk7.png")));
						break;
					case 8:
						talk.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/talk8.png")));
						break;
					case 9:
						talk.setVisible(false);
						talkButton.setVisible(false);
						battleMode(boss);
					}

				}

			}
		});
		add(talkButton);

		talk.setBounds(720, 120, 256, 256); // lucky.setBounds(640, 300, 128, 128)
		add(talk);

	}

	public void bossEvent() {
		background = new ImageIcon(Main.class.getClassLoader().getResource("images/background_bora.png")).getImage();
		hobbang.setIcon(hbb_angry);
		x = 100;
		y = 300;
		hobbang.setBounds(x, y, 128, 128);
		boss.setIcon(boss_basic);
		boss.setBounds(1052, 300, 128, 128);
		add(boss);
		talk.setIcon(new ImageIcon(Main.class.getClassLoader().getResource("buttons/talk6.gif")));
		talk.setBounds(140, 100, 1000, 200);
		talk.setVisible(true);
		talkButton.setBounds(1120, 220, 33, 22);
		talkButton.setVisible(true);
		talknum = 6;
	}

	public void endingEvent() {
		background = new ImageIcon(Main.class.getClassLoader().getResource("images/happyending.jpg")).getImage();
		hobbang.setIcon(hbb_basic);
		x = 300;
		y = 300;
		hobbang.setBounds(x, y, 128, 128);
		move = true;
	}

	class MyKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if (move) {
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
					if (luckyEvent) {
						hobbang.setIcon(hbb_turndirty);
					} else {
						hobbang.setIcon(hbb_turn);
					}
					if (x - 10 < 0)
						x = 0;
					else
						x -= 10;
					hobbang.setLocation(x, y);
					break;
				case KeyEvent.VK_RIGHT:
					if (luckyEvent) {
						hobbang.setIcon(hbb_dirty);
					} else {
						hobbang.setIcon(hbb_basic);
					}
					if (x + 10 > c.getWidth() - 30)
						x = c.getWidth() - 30;
					else
						x += 10;
					hobbang.setLocation(x, y);
					break;
				}

				if (guardEvent) {
					if (((x - 704) * (x - 704) + (y - 364) * (y - 364)) <= 203 * 203) {
						guardEvent();
					}
				}
				if (luckyEvent) {
					if (((x - 704) * (x - 704) + (y - 364) * (y - 364)) <= 203 * 203) {
						luckyEvent();
					}
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

}
