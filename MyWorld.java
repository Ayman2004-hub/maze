import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int score = 0;
    private int elapsedTime = 0;
    private boolean gameOver = false;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
public MyWorld() {    
        super(800, 800, 1);
        this.score = 0;
        prepare();
    }
    
public void act() {
    if (!gameOver) {
        showText("Score = " + score, 50, 25);
        showText("Time: " + (elapsedTime / 60), 750, 25); // Display elapsed time in seconds
        elapsedTime++;

        if (elapsedTime >= 60 * 60) { // 60 seconds * 60 = 3600 (1 hour)
            gameOver = true;
            showText("Game Over", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        } else {
            if (score >= 3) {
                addObject(new Home(), 575, 25);
            }
        }
    }
}
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    private void prepare()
    { 
        int y = 25;
        int x = 25;        
        int[][] maze = 
            {
                {1, 1, 1, 1, 0, 2, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
                {Greenfoot.getRandomNumber(2)+2, 0, 0, 1, 0, 1, 1, 1, 1, Greenfoot.getRandomNumber(2)+2, 0, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                {Greenfoot.getRandomNumber(2)+2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, },
                {1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 1, 2, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 0, Greenfoot.getRandomNumber(2)+2, 0, 1, 1 , 1 ,1 ,1 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, Greenfoot.getRandomNumber(2)+2},
                {Greenfoot.getRandomNumber(2)+2, 1, 0, 1, 0, 1, 1, 0, 0, 1, Greenfoot.getRandomNumber(2)+2, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1 ,1 ,1 ,1},
                {0, 0, 0, Greenfoot.getRandomNumber(2)+2, 0, Greenfoot.getRandomNumber(2)+2, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 ,0},
                {0, 0, 0, Greenfoot.getRandomNumber(2)+2, 0, Greenfoot.getRandomNumber(2)+2, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1,1 ,1 , 1, 1},
            };
        for(int i=0; i<maze.length; i++) {
            x = 25;
            for(int j=0; j<maze[i].length; j++) {  
                if(maze[i][j] == 1){
                    addObject(new Wall(),x,y);
                }
                else if(maze[i][j] == 2){
                    addObject(new Food(),x,y);
                }  
                else if(maze[i][j] == 3){
                    addObject(new Enemy(),x,y);
                }  
                x = x+50;
            }
            y= y+50;
        }

        addObject(new Person(),25,575);

    }
  
}
