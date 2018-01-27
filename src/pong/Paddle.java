/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

    private int x;
    private int y;
    private int direction;
    private int height;
    private int width;
    private static final int UP = 1;
    private static final int DOWN = 0;
    private static final int  MAXX = 600;
    private static final int MAXY = 400;
    private static final int BORDERERROR = 25;

    public Paddle(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
       
    }

    public void change(int yChange){
        System.out.println(this.y);
        if ((this.y + height + yChange + BORDERERROR - 2) <= MAXY && (this.y + yChange + 5) > 0){
            this.y += yChange;
    }
    }


    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getWidth(){
        return this.width;
    }
     public int getHeight(){
        return this.height;
    }

    public void update(int yMax, int change, Ball aBall){
        if (y + this.height + change + BORDERERROR  >= yMax){
            this.direction = Paddle.UP;
        } else if (y <= 0){
            this.direction = Paddle.DOWN;
        }

        if (aBall.getY() >= this.y + this.height ){
            this.direction = Paddle.DOWN;
        } else if (aBall.getY() <= this.y){
            this.direction = Paddle.UP;
        }

        if(this.direction == Paddle.DOWN){
           this.y += change;
       } else {
           this.y -= change;
        }
    }
 
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

}