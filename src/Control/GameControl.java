package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import Service.GameService;
import configure.GameConfig;
import dao.DataBase;
import dao.DataDisk;
import dto.GameDto;
import windows.JFrameGame;
import windows.JFrameSavaScore;
import windows.JPanelGame;

public class GameControl {

	private JPanelGame panelgame;

	private GameDto dto;

	private GameService gameService;

	private GameConfig gameConfig;

	private String direction;

	private DataBase dataBase;

	private DataDisk dataDisk;
	
	private JFrameSavaScore frameSaveScore;

	public GameControl() {
		// ��ʼ�������ļ�
		this.gameConfig = new GameConfig();
		// ��ʼ��dto
		this.dto = new GameDto();
		// ��ȡ���ݿ����
		this.dataBase = gameConfig.getDataConfig().getDatabase();
		// ��ȡ�������ݶ���
		this.dataDisk = gameConfig.getDataConfig().getDatadisk();
		// �������ݿ����
		this.dto.setDataBase(dataBase);
		// ���ñ������ݶ���
		this.dto.setDataDisk(dataDisk);
		// ��ʼ����Ϸ�߼���
		this.gameService = new GameService(dto, panelgame);
		// ��ʼ����Ϸ��
		this.panelgame = new JPanelGame(dto, this);
		// ��ʼ������
		new JFrameGame(panelgame);
		// ��Ӽ�����
		this.panelgame.addKeyListener(new ActionListener());
		// ���ô���������
		this.frameSaveScore = new JFrameSavaScore(dataDisk, dto);
	}

	/**
	 * ���ݼ��̰���������Ӧ����
	 *
	 */
	private class ActionListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			Map<Integer, String> keyMap = gameConfig.getKEYCODE_CONFIG();
			Set<Integer> set = keyMap.keySet();
			if (!dto.isStart() || !set.contains(e.getKeyCode())) {
				return;
			}
			if (e.getKeyCode() == 32) {
				try {
					Method method = gameService.getClass().getMethod(keyMap.get(e.getKeyCode()), null);
					method.invoke(gameService, null);
					if (!dto.isPause()) {
						synchronized (gameService) {
							gameService.notify();
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				return;
			}
			direction = keyMap.get(e.getKeyCode());
			autoMove(direction);
		}
	}

	private void autoMove(String dir) {
		new Thread(new Runnable() {
			public void run() {
				synchronized (gameService) {
					Map<Integer, String> keyMap = gameConfig.getKEYCODE_CONFIG();
					dto.setThreadName(Thread.currentThread().getName());
					try {
						Method method = gameService.getClass().getMethod(direction, null);
						System.out.println();
						while (direction.equals(dir)) {
							method.invoke(gameService, null);						
							if (dto.isOver()) {
								System.out.println("Dead");
								afterOver();
								panelgame.repaint();
								break;
							}
							panelgame.repaint();
							if (dto.isPause()) {
								gameService.wait();
							}
							Thread.sleep(dto.getSleepTime());
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}).start();
	}

	/**
	 * ��ʼ����
	 */
	public void start() {
		direction = "KeyRight";
		this.gameService.startGame();
		this.autoMove(direction);
		this.frameSaveScore.setVisible(false);
		this.panelgame.btn_Start.setEnabled(false);
		this.panelgame.btn_Setting.setEnabled(false);
	}
	/**
	 * ��Ϸ������Ĳ���
	 */
	private void afterOver() {
		this.dto.setStart(false);
		this.panelgame.btn_Start.setEnabled(true);
		this.panelgame.btn_Setting.setEnabled(true);
		this.frameSaveScore.setVisible(true);
		this.dto.setOver(false);
	}
}