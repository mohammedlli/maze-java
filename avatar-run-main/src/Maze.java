
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
public class Maze {
    int[][]lab=new int[13][23];
    int row=0;
    int col=0;
    int rownumber=13;
    int colnumber=23;
    int blockwidth=40;
    int blockheight=40;

    boolean check = false;

    public void paint(Graphics grafico){
        int [][]maze=getMaze();

        for(row=0;row<rownumber;row++){
            for(col=0;col<colnumber;col++){
                if(maze[row][col]==1){
                    if(Game.getLevel()==1){grafico.setColor(Color.darkGray);}
                    if(Game.getLevel()==2){grafico.setColor(Color.green);}
                    if(Game.getLevel()>=3){grafico.setColor(Color.blue);}

                    grafico.fillRect(col*40,row*40,blockwidth,blockheight);
                    grafico.setColor(Color.black);
                    grafico.drawRect(col*40,row*40,blockwidth,blockheight);
                }
            }
        }
        grafico.drawString("Start", 5, 62);
        grafico.drawString("End", 850, 462);





     if (check){
         grafico.setColor(Color.green);
     }else{
        grafico.setColor(Color.red);}
        grafico.fillRect(206, 206, 30, 30);
        grafico.drawRect(206, 206, 30, 30);
        grafico.setColor(Color.yellow);
        grafico.drawString("hint", 210, 220 );
    }
    
    public int [][] getMaze(){
        if(Avatar.x == 200 && Avatar.y == 200){
            check = true;        }
        if(Game.getLevel()==1){
            int maze[][]=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            { 1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1},
            { 1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1},
            { 1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
            { 1,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,1,0,1,0,1,1},
            { 1,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,0,1,0,1,1},
            { 1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1},
            { 1,1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,0,1,0,1,1},
            { 1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1},
            { 1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,1},
            { 1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1},
            { 1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
            
            lab=maze;
        }
        
        if(Game.getLevel()==2){
            
            //Level 2
            int maze[][]=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            { 1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
            { 1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1},
            { 1,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
            { 1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1},
            { 1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,1},
            { 1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1},
            { 1,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
            { 1,1,0,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1},
            { 1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,1},
            { 1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1},
            { 1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
            
            lab=maze;
        }
        
        if(Game.getLevel()==3){

            int maze [][]=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            { 1,0,0,0,1,0,0,0,0,0,0,1,1,1,0,0,1,1,3,0,0,1,1},
            { 1,1,1,0,1,0,1,0,1,1,1,0,0,0,1,0,0,0,1,1,0,1,1},
            { 1,1,0,0,0,0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,1},
            { 1,1,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,1,0,1,0,1,1},
            { 1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0,0,1,0,1,1},
            { 1,1,1,0,1,0,1,1,1,1,0,0,0,0,1,0,0,1,0,1,0,1,1},
            { 1,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1},
            { 1,1,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1},
            { 1,1,0,1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1},
            { 1,1,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,0,0,1,0,1,1},
            { 1,1,0,1,0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,1,0,0,1},
            { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
            
            lab=maze;
        }
        
        return lab;
        
    }
}
