import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class BoardGame {
	static List<Shape> shapes = new ArrayList<Shape>();
	static List<Board> boards = new ArrayList<Board>();
	
	public static void main(String[] args) {
		BoardGame game = new BoardGame();
		
		//Read and Parse Input
		game.readAndParseInput();
		
		//Play all board games
        for(int i=0; i<boards.size(); i++) {
        	Board board = boards.get(i);
        	System.out.println("*** Playing board "+i+": "+board.getRows()+"x"+board.getCols());
        	for(int j=0; j<shapes.size(); j++) {
        		Shape shape = shapes.get(j);
        		System.out.println("Filling shape "+j+": "+shape.getHeight()+"x"+shape.getWidth());
        		if (!board.IsShapeFilled(shape)) {
	        		System.out.println("###FAILED: Cannot fill shape " + j);
	        		board.printoutBoard();
	        		break;
        		}
        		board.printoutBoard();
        	}
        	//board.printoutBoard();
        }
	}
	
	public void readAndParseInput() {
		try {
			File file = new File("input.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			//read in shapes
	        String line = reader.readLine();
	        System.out.println(line);
	        String[] shapeStrs = line.split(",");
	        parseAndOrderShapes(shapeStrs);
	        for(int i=0; i<shapes.size(); i++)
	        	System.out.println("Shape "+i+":"+shapes.get(i).getHeight()+"x"+shapes.get(i).getWidth());
	        
	        //read in boards
	        while ((line = reader.readLine()) != null) {
	        	System.out.println(line);
	            String[] b = line.split(",");
	            int rows = Integer.parseInt(b[0].trim());
	            int cols = Integer.parseInt(b[1].trim());
	            boards.add(new Board(rows, cols));
	        }
	        for(int i=0; i<boards.size(); i++)
	        	System.out.println("Board "+i+":"+boards.get(i).getRows()+"x"+boards.get(i).getCols());
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
	}
		
	public void parseAndOrderShapes(String[] shapeStrs) {
		for(int i=0; i<shapeStrs.length; i++) {
			int shapeInt = Integer.parseInt(shapeStrs[i].trim());
			if (shapeInt < 100) {
				//IShape
				int height = shapeInt / 10;
				int width = shapeInt % 10;
				shapes.add(new IShape(height, width));
			}
			else {
				//LShape
				//To be completed....
			}
		}
		
		//Order shapes
		for(int i=0; i<shapes.size()-1; i++)
			for(int j=i+1; j<shapes.size(); j++) {
				Shape shapei = shapes.get(i);
				Shape shapej = shapes.get(j);
				if(shapei.getArea() < shapej.getArea()) {
					//swap shape i & j
					shapes.set(i, shapej);
					shapes.set(j, shapei);
				}
		}
	}
}
	
