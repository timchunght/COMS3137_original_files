/*
 Program To find a breadth-first path in a maze with obstacles
 Uses a queue to expand each cell 1 unit distance
 each cell has 4 neighbors: North, East, South, West.
 Input is 8x8 ascii matrix file, with 0 for empty cell, 1 for obstacle,
 S for Start, G for Goal, and spaces between entries.
 Example Maze File:

0 0 0 0 0 0 0 0  
0 1 1 0 0 0 0 0  
0 1 1 0 1 G 0 0  
0 0 0 0 1 1 1 0  
0 0 0 0 0 1 0 0  
0 S 0 0 0 0 0 0  
0 0 0 0 0 1 0 0 
0 0 0 0 0 0 0 0  

program has 1 argument: Maze File Name

    java maze_file_name
*/

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.*;

public class MazeShell implements ActionListener{

// Fields
  private JFrame frame;
  private DrawingCanvas canvas;
  private JTextArea messageArea;
  private Color color;
  private final int CELL_SIZE=50;
  private String filename;
  private BufferedReader diskInput;
  private boolean pathfound=false;
  final int WIDTH=8;
  final int HEIGHT=WIDTH;

  public MazeShell(String file){
    filename=file;
    frame = new JFrame("Maze");
    frame.setSize(500, 500);

    //The graphics area
    canvas = new DrawingCanvas();
    frame.getContentPane().add(canvas, BorderLayout.CENTER);

    //The message area, mainly for debugging.
    messageArea = new JTextArea(1, 80);     //one line text area for messages.
    frame.getContentPane().add(messageArea, BorderLayout.SOUTH);

    JPanel buttonPanel = new JPanel(new java.awt.GridLayout(2,0));
    frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

    addButton(buttonPanel, "Draw Initial Grid").setForeground(Color.black);
    addButton(buttonPanel, "Calculate Distances").setForeground(Color.black);
    addButton(buttonPanel, "Show Path").setForeground(Color.black);
    addButton(buttonPanel, "Quit").setForeground(Color.black);

    frame.setVisible(true);
  }

  /** Helper method for adding buttons */
  private JButton addButton(JPanel panel, String name){
    JButton button = new JButton(name);
    button.addActionListener(this);
    panel.add(button);
    return button;
  }

  /** Respond to button presses */

  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    if (cmd.equals("Draw Initial Grid") ){
       initialize();
       return;
    }  else 
    if (cmd.equals("Calculate Distances") ){
       pathfound = calcDistances();
       return;
    }  else 
    if(cmd.equals("Show Path")) {
        if (pathfound) outputPath();
           else messageArea.insert("no Path found!",0);
        return;
    } else
    if (cmd.equals("Quit") ){
       frame.dispose();
       return;
    } else
	throw new RuntimeException("No such button: "+cmd);
  }
 
    public void initialize(){

       canvas.clear();
       drawGrid();

//some sample draw commands...

       drawText("UL",0,0,Color.black); //upper left is 0,0
       drawText("UR",WIDTH-1,0,Color.black); //upper right is 0,WIDTH-1
       drawText("LL",0,HEIGHT-1,Color.black);//lower left is HEIGHT-1,0)
       drawText("LR",HEIGHT-1,HEIGHT-1,Color.black);//lower right is HEIGHT-1,HEIGHT-1
       drawText("cell(5,2)",5,2,Color.black);//lower right is HEIGHT-1,HEIGHT-1

       fillRectangle(4,0,CELL_SIZE,CELL_SIZE,Color.red);
       fillRectangle(3,6,CELL_SIZE,CELL_SIZE,Color.blue);

       // read in maze file, display "S" for start, "G" for GOAL
       // and fill rectangles for obstacles
       // commands above show how to write text and colored rectangles

       //now read from the diskInput...
       try{
          diskInput = new BufferedReader(new InputStreamReader(
	          new FileInputStream(
	          new File(filename))));

          messageArea.insert("Maze File Name: "+ filename,0);
       }
       catch (IOException e){
            System.out.println("io exception!");
       }



       canvas.display();
    }

    public void drawText(String s,int i, int j,Color color) {
       Color col=color;
       canvas.setForeground(col);
       canvas.drawString(s,(i)*CELL_SIZE+10,(j+1)*CELL_SIZE-10,false);
    }

    public void fillRectangle(int i,int j,int height,int width,Color color){

       Color col=color;
       canvas.setForeground(col);
       canvas.fillRect(i*CELL_SIZE,j*CELL_SIZE,height,width,false);
    }


    public void drawGrid(){

      int k=0;
      int m=0;
      color=Color.black;
      canvas.setForeground(color);
    //draw horizontal grid lines
      for(int i=0;i<9;i++) {
        canvas.drawLine(0,i*CELL_SIZE,WIDTH*CELL_SIZE,i*CELL_SIZE,false);
    }
    //draw vertical grid lines
      for(int i=0;i<9;i++) {
        canvas.drawLine(i*CELL_SIZE,0,i*CELL_SIZE,HEIGHT*CELL_SIZE,false);
    }
  }


    public boolean calcDistances() {
       // returns true and displays distances from start to goal if a path exists
       // returns false if no path exists between start and goal

       return false;
    }
  
    public void outputPath(){ //finds the path between goal and start

	//find and display the path between start and goal if it exists

    } 
    

public static void main(String[] args){

    //  args[0] is maze file name from command line
    MazeShell P=new MazeShell(args[0]);


}

}
























