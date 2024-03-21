//Rumesh Chathuska
//Project 3
//CSC 103

//This program is a Java implementation of the N Queens problem, . 
//The problem is to find all possible configurations of placing N chess queens on 
//an N x N chessboard such that no two queens attack each other. The program uses a 
//backtracking algorithm using LinkedStack and stack to explore all possible positions on the board and finds 
//solutions by placing queens one at a time and checking for conflicts. The program 
//then displays all solutions found up to a specified limit, which is entered by the user.

import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QueenStimulation{
   public static void main(String[] args) {
      Stack<Queen> position  = new Stack<>( ); 
      LinkedStack<Queen> finalQueens = new LinkedStack<>( ); 
      Scanner scan = new Scanner(System.in);
      
      int entry = 0;
      System.out.println("N Queens Solover");
      System.out.println();
      while (true) {
         System.out.println("Please enter the number of solutions you want to find (integer only):");
         if (scan.hasNextInt()) {
            entry = scan.nextInt();
            break; // Exit the loop if input is valid
         } else {
            System.out.println("Invalid input. Please enter an integer.");
            scan.next(); // Consume the invalid input
         }
      }
      System.out.println("Here are the solutions");
      System.out.println();
      boolean flag = true;
      int k = 2;
      int solutions = 0;
      while(finalQueens.size() <= entry && flag == true && k <=entry){
         for(int i= 1; i<= entry; i++ ){            
            for(int n= 1; n<=entry; n++ ){
                                               
               if(n > entry || i> entry){
                  break;               
               } 
               Queen add1 = new Queen(i,n);
               //Checking for the conflicts between the qenn
               if(!finalQueens.isEmpty()&& finalQueens.size() <=entry ){
                  int conflicts = 0;
                  //iterate through already added queens                
                  for(int j = 0; j< finalQueens.size(); j++){ 
                     Queen linkedQueen = finalQueens.itemAt(j);
                     if(add1.isConflict(linkedQueen)){
                        conflicts++;
                        
                     }                    
                  }
                  if(conflicts == 0){//add queen to LinkedList
                     Queen currentPush= position.push(add1);//Skiping the rest of the columns if the queen added
                     finalQueens.push(add1);
                     if(finalQueens.size()!=entry ){
                        i = currentPush.getRow()+1;
                        n = 0;
                     }
                     if(finalQueens.size()==entry){// Recod the solutions and print them
                        solutions++;
                        for(int l = finalQueens.size()-1; l >= 0; l--){  // print solutions                   
                           Queen printQueen = finalQueens.itemAt(l);
                           System.out.print(printQueen.toString());                         
                         
                        }
                        System.out.println();
                     }
                     
                     
                  }
                   //checking the same raw if not remove previous queen and move back to prevous row
                  if(conflicts >=1 && n==entry ){
                                         
                     Queen current = position.pop();
                     finalQueens.pop();
                     i = current.getRow();
                     n = current.getColumn();
                     if(n == entry && i != 1){
                        Queen current1 = position.pop();
                        finalQueens.pop();
                        i = current1.getRow();
                        n = current1.getColumn();
                     }
                     
                  }
                  //if no queens in the board move 1 unill n column
                  if(finalQueens.isEmpty()){//increament the fist queen each iteration until if is replaceable
                     if(k >entry){ //if the surpass the n column brake it
                        break;
                     }else{
                        i = 1;
                        n = k;
                        add1.setRow(i);
                        add1.setColumn(k);
                        k++;
                        
                     }
                     
                  }
               } 
               //if the board is empty add the first queen 
               if(finalQueens.isEmpty()){
                  position.push(add1);
                  finalQueens.push(add1);
                  Queen currentPush= position.push(add1);
                  if(i!=entry || n!=entry){
                     i = currentPush.getRow()+1;
                     n = 0;
                  }
                    
               }
              
                            
               
            }
               
         }
      }
      
      System.out.println("we have "+ solutions + " solutions");
      
     
                    
   }
      
     
}

  
