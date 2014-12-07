package project;

import javax.swing.tree.TreeNode;

public class PuzzleSolving {
	public TreeNode boardsTree;
	public Boolean searching;
	public int lastPos;

public class Board{
	private static final int Blank_pos = 0;
	private Object tilesList;
	private boolean solved;

	public Board(int i, Object tilesList2) {
		// TODO Auto-generated constructor stub
	}


	void Puzzle(Board b) {
	 boardsTree = (TreeNode) new Board(lastPos, b);
	 lastPos = b.Blank_pos;
	}

	public String solver(Board b, String route, int level, double fitVal){
		//System.out.println("route in the level " + level +": " +route + " Fitness: ");                          
		//System.out.print(b.f1.getFitnessVal()); 
		//If the depth of the Tree is level 15 or Board is solved return route(moves e.g. WNS)
	if(level == 15||b.solved){
		//if(route != ""){
		//if(route.length()>1){
		// return route.substring(0, route.length()-1);
		//}else{
	return route;
		//}
	}else{
		//Create a temporary store for the last position 
		//Create four auxilliary puzzle boards has child puzzles
		//Perform the different moves on the blank space on each board in different directions      
		//(N=0,S=1,E=2,W=3)
	lastPos = b.Blank_pos;
	Board auxN = new Board(4,b.tilesList);
	Board auxS = new Board(4,b.tilesList);
	Board auxE = new Board(4,b.tilesList);
	Board auxW = new Board(4,b.tilesList);
	//Builds the tree

		//MOVES TO NORTH
		//b.isValidMove(North=0,South=1,East=2,West=3)
	if( b.isValidMove(0)){ 
		 //If the lastPosition (blankPosition in the parent board) is not the position of the  
		 //cell in the north MoveBlank to North
	 if(lastPos != (lastPos - 4)){
		 auxN.MoveBlank(0);
		 ((SearchNode) boardsTree).addSon(0,auxN);
		 if(fitVal >  ((SearchNode) ((SearchNode) ((SearchNode) boardsTree).getSon(0)).getState()).getFitnessVal()){
		 auxN.print();
		 searching = false;
		 return route + "N"; 
	    }
	   }
	  }

	//MOVES TO SOUTH
	//b.isValidMove(North=0,South=1,East=2,West=3)
	if( b.isValidMove(1) ){ 
	 //If the lastPosition (blankPosition in the parent board) is not the position of the  
	 //cell in the north MoveBlank to North
	if(lastPos != (lastPos + 4)){
	 auxS.MoveBlank(1);
	 ((SearchNode) boardsTree).addSon(1,auxS);
	 if(fitVal >  ((SearchNode) ((SearchNode) ((SearchNode) boardsTree).getSon(1)).getState()).getFitnessVal()){
	  auxS.print();
	  searching = false;
	  return route + "S"; 
	   }
	  }
	 }

	 //MOVES TO EAST
	 if( b.isValidMove(2) ){
	    if(lastPos != (lastPos + 1)){
	       auxE.MoveBlank(2);
	       ((SearchNode) boardsTree).addSon(2,auxE);
	       if(fitVal >  ((SearchNode) ((SearchNode) ((SearchNode) boardsTree).getSon(2)).getState()).getFitnessVal()){
	       auxE.print();
	       searching = false;
	       return route + "E";
	     }
	    }
	   }

	//MOVES TO WEST
	if( b.isValidMove(3) ){ 
		if(lastPos != (lastPos -1)){
			auxW.MoveBlank(3);
			((SearchNode) boardsTree).addSon(3,auxW);
			if(fitVal >  ((SearchNode) ((SearchNode) ((SearchNode) boardsTree).getSon(1)).getState()).getFitnessVal()){
			auxW.print();
			searching = false;
			return route + "W"; 
	  }
	 }
	}

	//EVALUATE NEW STATES

	if(searching && b.isValidMove(0)){
	  System.out.println("Actual: " +auxN.Blank_pos+ " Previo: "+lastPos );
	  if(lastPos != auxN.Blank_pos){
	     lastPos = auxN.Blank_pos;
	     route = solver(auxN,route + "N", level+1, fitVal); //NORTH
	     }else{
		     //If  a solution is not generated enter a recursion to find further solutions at a    
		     //further depth of the tree
	     solver(auxN,route, level+1, fitVal); //NORTH
	          }
	 }
	 if(searching  && b.isValidMove(1)){
	  //System.out.println("Actual: " +auxS.Blank_pos+ " Previo: "+lastPos );
	  if(lastPos != auxS.Blank_pos){
	    lastPos = auxS.Blank_pos;
	    route =solver(auxS,route + "S", level+1, fitVal); //NORTH
	  }else{
	    solver(auxS,route, level+1, fitVal); //NORTH
	      }
	 }
	 if(searching  && b.isValidMove(2)){
		 //System.out.println("Actual: " +auxE.Blank_pos+ " Previo: "+lastPos );
	   if(lastPos != auxE.Blank_pos){
	   lastPos = auxE.Blank_pos;
	   route = solver(auxE,route + "E", level+1, fitVal); //NORTH
	   }else{
	   solver(auxE,route, level+1, fitVal); //NORTH
	        }
	   }
	   if(searching  && b.isValidMove(3)){
	    //System.out.println("Actual: " +auxW.Blank_pos+ " Previo: "+lastPos );
	     if(lastPos != auxW.Blank_pos){
	     lastPos = auxW.Blank_pos;
	     route =solver(auxW,route + "W", level+1, fitVal); //NORTH
	     }else{
	     solver(auxW,route, level+1, fitVal); //NORTH
	           }
	      }
	     }
	     return route;

	     }

	private void print() {
		// TODO Auto-generated method stub
		
	}

	private void MoveBlank(int i) {
		// TODO Auto-generated method stub
		
	}

	private boolean isValidMove(int i) {
		// TODO Auto-generated method stub
		return false;
		}
	}
}




