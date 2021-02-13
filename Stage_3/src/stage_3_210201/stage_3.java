package stage_3_210201;

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

public class stage_3 extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image background = new ImageIcon(Main.class.getClassLoader().getResource("images/background.jpg")).getImage();	// �̹����� ��� ��ü
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("buttons/menuBar.png")));
	private JLabel boss = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("images/boss.gif")));
	private JLabel hbb_merong = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("images/hbb_merong.gif")));
	private JLabel hbb_sad = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("images/hbb_sad.gif")));
	private JLabel ssung = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("images/ssung.png")));
	
	private ImageIcon exitButton_Basic = new ImageIcon(Main.class.getClassLoader().getResource("buttons/exitButton.png"));	
	private ImageIcon exitButton_hover = new ImageIcon(Main.class.getClassLoader().getResource("buttons/exitButton_hover.png"));
	private ImageIcon moneyButton_Basic = new ImageIcon(Main.class.getClassLoader().getResource("buttons/moneyButton.png"));
	private ImageIcon moneyButton_hover = new ImageIcon(Main.class.getClassLoader().getResource("buttons/moneyButton_hover.png"));
	private ImageIcon swordButton_Basic = new ImageIcon(Main.class.getClassLoader().getResource("buttons/swordButton.png"));
	private ImageIcon swordButton_hover = new ImageIcon(Main.class.getClassLoader().getResource("buttons/swordButton_hover.png"));	
	private ImageIcon rightButton_Basic = new ImageIcon(Main.class.getClassLoader().getResource("buttons/right.png"));
	private ImageIcon leftButton_Basic = new ImageIcon(Main.class.getClassLoader().getResource("buttons/left.png"));
	private ImageIcon endingButton_Basic = new ImageIcon(Main.class.getClassLoader().getResource("buttons/exit.png"));
	
	private JButton exitButton = new JButton(exitButton_Basic);
	private JButton moneyButton = new JButton(moneyButton_Basic);
	private JButton swordButton = new JButton(swordButton_Basic);
	private JButton rightButton = new JButton(rightButton_Basic);
	private JButton leftButton = new JButton(leftButton_Basic);
	private JButton endingButton = new JButton(endingButton_Basic);
	
	private int mouseX, mouseY;
	
	Music introMusic = new Music("bensound-epic.mp3", true);
	Music endingMusichappy = new Music("bensound-littleidea.mp3", true);
	Music endingMusicgameover = new Music("bensound-sadday.mp3", true);

	public stage_3() {		
		setTitle("Title"); 		//Ÿ��Ʋ
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); 	//â ũ�� ����
		setResizable(false); 		//â ũ�� ���Ƿ� ���� �Ұ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//���α׷� ����� ����Ʈ������
		setLocationRelativeTo(null);	//�ʱ� â ���� �� ����� ����
		setUndecorated(true);			//�⺻ �޴��� ��� ����
		setVisible(true); 				//â ���������� ���
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		introMusic.start();
		
		exitButton.setBounds(1250, 5, 20, 20);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButton_hover);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButton_Basic);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);		//exitButton Ŭ�������� ���α׷� ����
			}
		});
		add(exitButton);		//�޴��� ������ ��ġ�� ���� ��ư. hover �ÿ� �Ķ������� �ٲ�
		
		endingButton.setBounds(1200, 650, 60, 60);
		endingButton.setBorderPainted(false);
		endingButton.setContentAreaFilled(false);
		endingButton.setFocusPainted(false);
		endingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				endingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);		//Ŭ�������� ���α׷� ����
			}
		});

		
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
				//Į ��ư �̺�Ʈ ó��
				introMusic.stop();
				endingMusichappy.start();
				hbb_merong.setBounds(300, 300, 128, 128);
				add(hbb_merong);		//Į ��ư Ŭ��������, ȣ���� ����
				ssung.setBounds(840, 378, 128, 128);
				add(ssung);
				add(endingButton);	//���� ��ư ����
				background = new ImageIcon(Main.class.getClassLoader().getResource("images/happyending.jpg")).getImage(); //Į ��ư �����ϸ� ���ǿ���
				rightButton.setVisible(false);
				leftButton.setVisible(false);
				swordButton.setVisible(false);
				moneyButton.setVisible(false);	//��ư ����
			}
		});
		add(swordButton);		//Į ���� ��ư. hover�� ���µ� ���� �Ϸ�
		
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
				//�Ӵ� ���� ��ư �̺�Ʈ ó��
				introMusic.stop();
				endingMusicgameover.start();
				boss.setBounds(320, 185, 128, 128);
				add(boss);		//�Ӵ� ��ư ����������, ������ ����
				hbb_sad.setBounds(840, 378, 128, 128);
				add(hbb_sad);
				add(endingButton);	//���� ��ư ����
				background = new ImageIcon(Main.class.getClassLoader().getResource("images/gameover.png")).getImage(); //�Ӵ� ��ư �����ϸ� ���ӿ���
				rightButton.setVisible(false);
				leftButton.setVisible(false);				
				swordButton.setVisible(false);
				moneyButton.setVisible(false);	//��ư ����	
			}
		});
		add(moneyButton);		//�Ӵ� ���� ��ư. hover�� ���µ� ���� �Ϸ�
		
		rightButton.setBounds(1150, 300, 100, 100);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//right ��ư �̺�Ʈ ó��
				background = new ImageIcon(Main.class.getClassLoader().getResource("images/BG 1.jpg")).getImage();		//��� ��ü
				swordButton.setVisible(false);
				moneyButton.setVisible(false);
				hbb_merong.setVisible(false);
				boss.setVisible(false);		//������ ��ư�� ĳ���͵� ����
				add(endingButton);	//���� ��ư ����
			}
		});
		add(rightButton);
		
		leftButton.setBounds(30, 300, 100, 100);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//left ��ư �̺�Ʈ ó��
				background = new ImageIcon(Main.class.getClassLoader().getResource("images/BG 2.jpg")).getImage();		//��� ��ü
				swordButton.setVisible(false);
				moneyButton.setVisible(false);
				hbb_merong.setVisible(false);
				boss.setVisible(false);		//������ ��ư�� ĳ���͵� ����
				add(endingButton);	//���� ��ư ����
			}
		});
		add(leftButton);	
		

		menuBar.setBounds(0, 0, 1280, 30);		//�޴� �� ��ġ ����
		
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { 	//���콺�� Ŭ���������� ��ġ �� �ҷ��ͼ� ������ �־���
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);	//���콺�� �巡�׵Ǹ� �ǽð����� ���� ��ġ������ ����
			}
		});		
		add(menuBar);		//�޴��ٸ� �巡�� �������� ��ü â�� �̵��ǵ��� ����	

	}	

	   public void paint(Graphics g) {       //ȭ���� �׷��ִ� �Լ�. ������ ������ Ư�� ���ǿ��� �ٲ��� ����
		      screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);    //ȭ�� ũ�⸸ŭ �̹��� ����
		      screenGraphic = screenImage.getGraphics();
		      screenDraw(screenGraphic);          //�̹����� ���ϴ� ���� �׷���
		      g.drawImage(screenImage, 0, 0, null);    //screenImage�� (0,0) ��ġ�� �׷���
		   }

		   public void screenDraw(Graphics g) {
		      g.drawImage(background, 0, 0, null);
		      paintComponents(g);
		      this.repaint();
		   }         //��� �̹��� ����

		}