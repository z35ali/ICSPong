package pong;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;



public class Game {
  
  private int playerScore = 0;
  private int AIScore =0;
  private static final int  MAXX = 600;
  private static final int MAXY = 400;
  private Ball theBall;
  private Paddle AI;
  private Paddle human;
  int count; //To make sure the ball does not change direction to often
  
  /** Create a new Game object with a ball and two paddles
    */
  public Game () {
    this.theBall = new Ball(MAXX/2 - 12,MAXY/2 - 12 ,15);
    this.AI = new Paddle (0, 100, 100, 20);
    this.human = new Paddle (MAXX - 25, 100, 100, 20);
  }
  
  /** Tells the human panel to move up or down by a specific amount
    * @param yChange - the amount of pixels the paddle has to move
    */
  public void change(int yChange){
    this.human.change(yChange);
  }
  
  /** Creates a paint screen
    * @param g - gets the graphics class from the superclass
    */
  public void paint(Graphics g){
    //Tells the paint method in panel to draw a ball and two paddles
    this.theBall.paint(g);
    this.human.paint(g);
    this.AI.paint(g);
    
    //Makes it so that if a player scores 10 it says THE END
    if (this.AIScore >= 10 || this.playerScore >= 10) {
      g.setColor(Color.black);
      g.drawRect(0, 0, 600, 400);
      g.fillRect(0, 0, 600, 400);
      Font a = new Font ("Arial", Font.PLAIN, 60);
      g.setColor(Color.white);
      g.setFont(a);
      g.drawString("THE END", MAXX /2 - 120, MAXY / 2);
    }
  }
  /** Resets the ball to the center of the screen
    */
  public void resetBall() {
    
    if ((theBall.getX() + theBall.getSize()) > MAXX || theBall.getX() + theBall.getSize() < 0){
      //updates the score
      score();
      this.theBall = new Ball(MAXX/2 - 12,MAXY/2 - 12 ,15);
    }
  }
  
  /** Updates the AI paddle and the ball
    */
  public void update(){
    AI.update(MAXY, 2,theBall);
    theBall.update(3); 
  }
  
  /** Checks if the ball has hit a paddle
    */
  public void detectCollision(){
    
    //Only 1 direction change per hit per paddle
    if (count == 0) {
      
      if (AI.getX() + AI.getWidth() >= theBall.getX() && theBall.getY() <= AI.getY() + AI.getHeight()&& theBall.getY() >= AI.getY()) {
        theBall.changeDirection();
        count++;
      } else if (human.getX() <= theBall.getX() + theBall.getSize()&& theBall.getY() <= (human.getY() + human.getHeight()) && theBall.getY() >= human.getY()) {
        theBall.changeDirection();
        count++;
      }
    } else if (theBall.getX() > AI.getX() + AI.getWidth() && theBall.getX() + theBall.getSize() < human.getX() ) {
      count = 0;
    }
  }
  
  /** Gets the AI's score
    * @return the AI's score
    */
  public int getAIScore() {
    return this.AIScore;
  }
  
  /** Gets the player's score
    * @return the player's score
    */
  public int getHumanScore() {
    return this.playerScore;
  }
  
  /** Updates the score and checks if either the AI or the player wins
    */
  public void score(){
    if (this.theBall.getX() + this.theBall.getSize() < 0) {
      this.playerScore ++;
    } else if (this.theBall.getX() + this.theBall.getSize() > this.MAXX){
      this.AIScore ++;
    }
    
  }

  
}


