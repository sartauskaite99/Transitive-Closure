package com.company;
import java.util.Arrays;
import java.util.Scanner;

//Programa randa visas orientuoto/neorientuoto grafo briaunas, kurios patenka i tranzityvuji uzdarini. Jei briauna patenka
//spausdiname 1, nei ne 0

public class Main {
    private static int max =4;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
	    int adj_matrix[][];
	    adj_matrix = new int[max][max];

	    System.out.println("Enter matrix\n");

	    //Jeigu orientuota briauna priklauso grafui, rasyti 1, nei ne - 0
        //Virsune (1,1) visada priklauso grafui
        //Reiksmes vesti su tarpu

	    for(int i=0; i<max; i++){
	        for(int j=0; j<max; j++){
                int correct = scanner.nextInt();
	            if(i==j){
	                //Bet kokiu atveju ar ivestas skaicius buvo teisingas ar ne, rasysime 1, nes si salyga yra butina
	                adj_matrix[i][j] = 1;
                    continue;
                }
	            if(correct == 1|| correct == 0)
	                adj_matrix[i][j]= correct;
	            else{
	                System.out.println("Entered value is incorrect\n");
	                System.exit(0);
                }
            }
        }
        TransitiveClosure(adj_matrix,max);
	    printMatrix(adj_matrix);
    }
    private static void TransitiveClosure(int adj_mat[][], int max){
        for(int k=0; k<max; k++){
            for(int i=0; i<max; i++){
                for(int j=0; j<max; j++){
                    if(adj_mat[i][j] < (adj_mat[i][k] * adj_mat[k][j]))
                        adj_mat[i][j] = (adj_mat[i][k] * adj_mat[k][j]);
                    else
                        adj_mat[i][j] = adj_mat[i][j];
                }
            }
        }
    }
    private static void printMatrix(int adj_mat[][]){
        System.out.println(Arrays.deepToString(adj_mat));
    }
}

