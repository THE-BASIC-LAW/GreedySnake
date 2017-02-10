package Service;

import java.awt.Point;
import java.util.ArrayList;

import dto.GameDto;
import windows.JPanelGame;

public class GameService {

	/**
	 * 设置dto对象
	 */
	private GameDto dto;

	/**
	 * 构造方法
	 */
	public GameService(GameDto dto, JPanelGame panelgame) {
		this.dto = dto;
	}

	/**
	 * 方向键上对应操作
	 */
	public void KeyUp() {
		this.move(0, -1);
	}

	/**
	 * 方向键下对应操作
	 */
	public void KeyDown() {
		this.move(0, 1);
	}

	/**
	 * 方向键左对应操作
	 */
	public void KeyLeft() {
		this.move(-1, 0);
	}

	/**
	 * 方向键右对应操作
	 */
	public void KeyRight() {
		this.move(1, 0);
	}

	public void Pause() {
		dto.setPause(!dto.isPause());
	}

	public void startGame(){
		this.dto.init();
	}
	
	/**
	 * 移动并判断是否吃入蛇果并进行相应操作
	 */
	private void move(int i, int j) {
		Point p = dto.getNext();
		ArrayList<Point> list = dto.getSnake();
		Point next = new Point((int) list.get(0).getX() + i, (int) list.get(0).getY() + j);
		if (isGameOver(next)) {
			dto.setOver(true);
			return;
		}
		if (next.getX() == p.getX() && next.getY() == p.getY()) {
			list.add(0, new Point((int) next.getX(), (int) next.getY()));
			dto.setNext(dto.Next(list));
			dto.setSnake(list);
			dto.setScore(dto.getScore() + 1);
			if ((dto.getScore() % 10) == 0) {
				dto.setLevel(dto.getLevel() + 1);
			}
			if (dto.getSnake().size() == 251) {
				dto.setOver(true);
			}
			return;
		}
		list.add(0, next);
		list.remove(list.size() - 1);
		this.dto.setSnake(list);
	}

	/**
	 * 判断游戏是否结束
	 */
	private boolean isGameOver(Point p) {
		double x = p.getX();
		double y = p.getY();
		if (x < 0 || x > 15 || y < 0 || y > 15) {
			return true;
		}
		for(int i=1;i<dto.getSnake().size();i++){
			if(x == dto.getSnake().get(i).getX() && y == dto.getSnake().get(i).getY()){
				return true;
			}
		}
		return false;
	}
}
