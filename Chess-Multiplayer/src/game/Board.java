package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import game.Figure.COLOR;

public class Board {

	public static Figure field[][] = new Figure[8][8];
	public static boolean moves[][] = new boolean[8][8];
	public static final int FIELDSIZE = 64;
	
	//init a new chess-board
	public void init(){
		//BLACK
		field[0][0] = new Turm(0,0,COLOR.BLACK);
		field[1][0] = new Pferd(1,0,COLOR.BLACK);
		field[2][0] = new Laeufer(2,0,COLOR.BLACK);
		field[3][0] = new Dame(3,0,COLOR.BLACK);
		field[4][0] = new Koenig(4,0,COLOR.BLACK);
		field[5][0] = new Laeufer(5,0,COLOR.BLACK);
		field[6][0] = new Pferd(6,0,COLOR.BLACK);
		field[7][0] = new Turm(7,0,COLOR.BLACK);
		
		for(int i = 0; i <= 7; i++){
			field[i][1] = new Bauer(i,1,COLOR.BLACK);
		}
		
		//WHITE
		field[0][7] = new Turm(0,7,COLOR.WHITE);
		field[1][7] = new Pferd(1,7,COLOR.WHITE);
		field[2][7] = new Laeufer(2,7,COLOR.WHITE);
		field[3][7] = new Dame(3,7,COLOR.WHITE);
		field[4][7] = new Koenig(4,7,COLOR.WHITE);
		field[5][7] = new Laeufer(5,7,COLOR.WHITE);
		field[6][7] = new Pferd(6,7,COLOR.WHITE);
		field[7][7] = new Turm(7,7,COLOR.WHITE);
		
		for(int i = 0; i <= 7; i++){
			field[i][6] = new Bauer(i,6,COLOR.WHITE);
		}
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		//render chess-fields
		for(int i = 0; i <= 7; i++){
			for(int j = 0; j <= 7; j++){
				
				if((i*7 + j)% 2 == 0){ 
					g.setColor(Color.gray);
				}else{
					g.setColor(Color.orange);
				}
				g.fillRect(Game.SCREEN_WIDTH/2 - 4*FIELDSIZE + j*FIELDSIZE, Game.SCREEN_HEIGHT/2 - 4*FIELDSIZE + i*FIELDSIZE, FIELDSIZE, FIELDSIZE);
				
				if(field[j][i] != null) field[j][i].render(g);
				//render possible moves
				//render figures
			}
		}
	}
	
	public static boolean isOnBoard(int x,int y){
		return x >= 0 && x <= 7 && y >= 0 && y <= 7;
	}
}
