package pong;

import java.awt.Color;
import java.awt.Graphics;



public class Ball {

    private int random;
    private int x;
    private int y;
    private int direction;
    private int vDirection;
    private int size;
    private static final int MAXX = 600;
    private static final int MAXY = 400;
    private static final int RIGHT = 1;
    private static final int LEFT = 0;
    private static final int UP = 1;
    private static final int DOWN = 0;
    private static final int BORDERERROR = 25;


   public Ball(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
        random = (int)(Math.random() * 2 + 1);
        if (random == 1) {
         this.direction = Ball.RIGHT;
            } else {
            this.direction = Ball.LEFT;
            }
        random = (int)(Math.random() * 2 + 1);
        if (random == 1) {
            this.vDirection = Ball.UP;
        }  else {
            this.vDirection = Ball.DOWN;
         }
    }

    public void change(int xChange, int yChange){
        this.x += xChange;
        this.y += yChange;
    }

    public void update(int change){

        if(this.direction == Ball.LEFT){
            this.x -= change;
        } else {
            this.x += change;
        }
        if (this.y <= 0) {
            vDirection = Ball.DOWN;
        } else if (this.y + this.size + BORDERERROR >= MAXY) {
            System.out.println(this.y);
            vDirection = Ball.UP;
        }
        if(this.vDirection == Ball.UP){
            this.y -= change;
        } else {
            this.y += change;
        }


    }

    public int getX(){
        return this.x;
    }

    public int getSize(){
        return this.size;
    }

    public void changeDirection(){
         if (this.direction == 1){
        this.direction = Ball.LEFT;
     } else {
         this.direction = Ball.RIGHT;
     }
    }

    public int getY(){
        return this.y;
    }


    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(this.x, this.y, this.size, this.size);
    }

}


