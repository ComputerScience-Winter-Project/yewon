

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {  // 프로그램 내의 또다른 하나의 작은 프로그램

	private Player player;
	private boolean isLoop;  // 곡의 반복 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {  // 생성자
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();  // 곡 실행 프로그램 종료
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
