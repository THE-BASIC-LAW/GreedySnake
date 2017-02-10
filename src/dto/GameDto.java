package dto;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import dao.DataBase;
import dao.DataDisk;

public class GameDto {

	private int score;

	private int level;

	private List<Point> snake;

	private Point next;

	private boolean isStart;

	private int sleepTime;

	private int startLevel;
	
	private DataBase dataBase;
	
	private DataDisk dataDisk;
	
	private boolean isPause;
	
	private String threadName;
	
	private boolean isOver;

	public GameDto() {
		
	}

	public void init() {
		this.score = 0;
		this.level = 0;
		this.snake = initSnake();
		this.next = Next(snake);
		this.isStart = true;
		this.startLevel = 0;
		this.sleepTime = 100;
		this.isPause = false;
	}

	/**
	 * 初始化贪吃蛇数组
	 */
	public ArrayList<Point> initSnake() {
		ArrayList<Point> list = new ArrayList<Point>();
		for (int i = 4; i >= 0; i--) {
			list.add(new Point(i, 15));
		}
		return list;
	}

	public Point Next(List<Point> list) {
		int x = (int) (Math.random() * 16);
		int y = (int) (Math.random() * 16);
		for (int i = 0; i < list.size(); i++) {
			if (x == list.get(i).getX() && y == list.get(i).getY()) {
				x = (int) (Math.random() * 16);
				y = (int) (Math.random() * 16);
				i = -1;
			}
		}
		return new Point(x, y);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public ArrayList<Point> getSnake() {
		return (ArrayList<Point>) snake;
	}

	public void setSnake(List<Point> snake) {
		this.snake = snake;
	}

	public Point getNext() {
		return next;
	}

	public void setNext(Point next) {
		this.next = next;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public int getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	public int getStartLevel() {
		return startLevel;
	}

	public void setStartLevel(int startLevel) {
		this.startLevel = startLevel;
	}

	public DataBase getDataBase() {
		return dataBase;
	}

	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}

	public DataDisk getDataDisk() {
		return dataDisk;
	}

	public void setDataDisk(DataDisk dataDisk) {
		this.dataDisk = dataDisk;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public boolean isOver() {
		return isOver;
	}

	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}

}
