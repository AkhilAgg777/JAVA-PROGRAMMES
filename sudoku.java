package july6;

import java.util.Scanner;

public class sudoku {

	private static void sudoku1(int arr[][],int cellno,int row[],int col[],int sb[][] ) {
		if(cellno>arr.length*arr.length) {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr.length;j++)
					System.out.print(arr[i][j]+" ");
				System.out.println();
			}
			return;
		}
		int r=(cellno-1)/arr.length;
		int c=(cellno-1)%arr.length;
		if(arr[r][c]==0) {
		for(int i=1;i<=9;i++) {
			if(isNumberAvailable(arr,row,col,sb,i,r,c)) {
				reserveANumber(arr, row, col, sb,i, r, c);
				sudoku1(arr,cellno+1,row,col,sb);
				releaseTheNumber(arr, row, col, sb,i, r, c);
}
	}
		}else {
		sudoku1(arr,cellno+1,row,col,sb);
	}
	}
		
	
	
	private static boolean isNumberAvailable(int arr[][],int row[],int col[],int sb[][],int num,int r,int c) {
		int mask=1<<num;
		if((row[r] & mask)!=0)
			return false;
		else if((col[c] & mask)!=0)
			return false;
		else if((sb[r/3][c/3] & mask)!=0)
return false;
else
	return true;
			
	}
	
	private static void reserveANumber(int arr[][],int row[],int col[],int sb[][],int num,int r,int c) {
		int mask=1<<num;
		arr[r][c]=num;
		row[r]=row[r]|mask;
		col[c]=col[c]|mask;
		sb[r/3][c/3]=sb[r/3][c/3]|mask;
	}
	
	private static void releaseTheNumber(int arr[][],int row[],int col[],int sb[][],int num,int r,int c) {
	int mask=~(1<<num);
	arr[r][c]=0;
	row[r]=row[r]&mask;
	col[c]=col[c]&mask;
	sb[r/3][c/3]=sb[r/3][c/3]&mask;
	
	}
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
//int arr[][]=new int[9][9];


int arr[][]= {{3,0,6,5,0,8,4,0,0},
		{5, 2 ,0 ,0, 0 ,0, 0 ,0 ,0},
		{0, 8, 7, 0 ,0, 0 ,0, 3 ,1},
		{0, 0 ,3, 0 ,1 ,0, 0 ,8, 0},
		{9, 0 ,0, 8, 6, 3, 0 ,0, 5},
		{0 ,5 ,0, 0, 9, 0, 6 ,0, 0},
		{1 ,3 ,0 ,0 ,0, 0, 2 ,5, 0},
		{0, 0, 0 ,0, 0, 0 ,0 ,7, 4},
		{0, 0, 5, 2, 0, 6 ,3 ,0 ,0}};
int row[]=new int[9];
int col[]=new int[9];
int sb[][]=new int[3][3];
//for(int i=0;i<arr.length;i++) {
//	for(int j=0;j<arr.length;j++) 
//		arr[i][j]=sc.nextInt();
//}

for(int i=0;i<arr.length;i++) {
	for(int j=0;j<arr.length;j++) {
	row[i]|=(1<<arr[i][j]);
	col[j]|=(1<<arr[i][j]);
	sb[i/3][j/3]|=(1<<arr[i][j]);
	
		
	}
}
sudoku1(arr,1, row, col, sb);
//for(int i=0;i<arr.length;i++) {
//	for(int j=0;j<arr.length;j++)
//		System.out.print(arr[i][j]+" ");
//	System.out.println();
//}


	}

}
