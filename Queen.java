/**
   Rumesh Chathuska
   Project 3
   CSC -103
 * This class Represents a queen on a chessboard.
 */
public class Queen
{
   private int row; //number of raw
   private int column; //number of column  

                      
   /**
   * Constructs a new Queen object with the specified row and column coordinates.
   *
   * @param row the row coordinate of the queen
   * @param column the column coordinate of the queen
   */      
   public Queen(int x, int y)
   {
       row = x;
       column =y;
   }
   /**
   * Returns the row coordinate of the queen.
   *
   * @return the row coordinate of the queen
   */   
   public int getRow() {
     return row;
   }
  /**
   * Returns the column coordinate of the queen.
   *
   * @return the column coordinate of the queen
   */

   public int getColumn() {
      return column;
   }
   /**
   * Sets the row coordinate of the queen.
   *
   * @param row the new row coordinate of the queen
   */
   public void setRow(int x) {
       row = x;
   }
   /**
   * Sets the column coordinate of the queen.
   *
   * @param column the new column coordinate of the queen
   */
   public void setColumn(int y) {
       column = y;
   }

   
   /**
   * Checks whether this queen is in conflict with another queen.
   *
   * @param queen the other queen to check for conflicts with
   * @return true if there is a conflict, false otherwise
   */
   public boolean isConflict(Queen queen) {
    // Assuming Queen object has 'row' property
    
      // Check for row conflict
      if (row == queen.row) {
        return true;
      }
      //check for column conflict
      if(column == queen.column){
         return true;
      }
      //check for the daignol conflict
       if (Math.abs(row - queen.row) == Math.abs(column - queen.column)) {
        return true;
    }
     return false;
   }
   
  /**
   * Returns a string representation of this queen.
   *
   * @return a string representation of this queen in the format "Solutions (row, column)"
   */
   
   public String toString(){
      return ("Solutions (" + getRow() + ", " + getColumn() + ")");   
  }
   
}