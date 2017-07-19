import java.util.List;
import java.util.ArrayList;

public class Board {
	private int[][] board;
	private int rows, cols;
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.board = new int[rows][cols];
	}
	
	public boolean IsShapeFilled(Shape shape) {
		List<Square> emptySquares =  getEmptySquaresOrdered();
		
		for(int i=0; i<emptySquares.size(); i++) {
			if(shape instanceof IShape) {
				IShape ishape = (IShape)shape;
				//fill an I Shape
				if (IsIShapeFit(emptySquares.get(i), ishape)) {
					fillIShape(emptySquares.get(i), ishape);
					return true;
				}
			}
			else {
				//fill an L Shape
				//To be completed....
			}
		}
		return false;
	}

	public List<Square> getEmptySquaresOrdered() {
		List<Square> squareList = new ArrayList();
		
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++) {
				if(board[i][j] == 0) {
					Square s = new Square(i,j);
					squareList.add(s);
				}
			}
		
		return squareList;
	}
	
	public boolean IsIShapeFit(Square base, IShape ishape) {
		if (base.getRow() + ishape.getHeight() > rows) return false;
		if (base.getCol() + ishape.getWidth() > cols) return false;
		
		for (int i=0; i<ishape.getHeight(); i++)
			for(int j=0; j<ishape.getWidth(); j++)
				if(board[base.getRow()+i][base.getCol()+j] != 0 ) return false;
		
		return true;
	}
	
	public void fillIShape(Square base, IShape ishape) {
		for (int i=0; i<ishape.getHeight(); i++)
			for(int j=0; j<ishape.getWidth(); j++) 
				fillSquare(base.getRow()+i, base.getCol()+j);
	}
	
	public void fillSquare(int row, int col) {
		board[row][col] = 1;
	}
	
	public void printoutBoard() {
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++)
				System.out.print(board[rows-1-i][j]+" ");
			System.out.println();
		}
	}
	
	public int[][] getBoard() {
		return board;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
}
