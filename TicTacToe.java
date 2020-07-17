import java.util.Scanner;
import java.lang.*;

public class TicTacToe{
	static char[][] array = new char[3][3];
	static char count = 'a';

 	public static void resetArray(){
		for(int i=0; i<=2; i++){
			for(int j=0;j<=2;j++){
			array[i][j] = count;
			count++;
			}
		}
	}

	public static void setXArray(int first, int second){
		for(int i=0; i<=2; i++){
			for(int j=0; j<=2; j++){
			if(i == first && j == second){
					array[i][j] = 'X';
					showArray();
				}
			}
		}
	}

	public static void setOArray(int first, int second){
                for(int i=0; i<=2; i++){
                        for(int j=0; j<=2; j++){
                        if(i == first && j == second){
                                        array[i][j] = 'O';
                                        showArray();
                                }
                        }
                }
        }


	public static void showArray(){
		System.out.println("   "+array[0][0]+"   "+array[0][1]+"   "+array[0][2]);
		System.out.println("   "+array[1][0]+"   "+array[1][1]+"   "+array[1][2]);
		System.out.println("   "+array[2][0]+"   "+array[2][1]+"   "+array[2][2]);
	}

	public static int[] getIndexOfArray(char pos){
		int[] getIndex = new int[2];
		for(int i=0;i<=2;i++){
                        for(int j=0;j<=2;j++){
                        if(array[i][j] == pos){
					getIndex[0] = i;
					getIndex[1] = j;
					break;
				}
                        }
                }
		return getIndex;
	}

	public static void checkToContinue(){
		int over = 0;
		for(int i=0; i<=2; i++){
			for(int j=0; j<=2; j++){
				if(array[i][j] == 'X' || array[i][j] == 'O'){
					over = 0;
				}
				else{
					over = 1;
					break;
				}
			}
		}
		if(over == 0){
			System.out.println("Oops no more positions to mark! Please try again.");
			System.out.println("To play another game, press Y. To exit, press N");
			Scanner sc = new Scanner(System.in);
			char input = sc.next().charAt(0);
			if(input == 'N'){
				System.exit(0);
			}
			resetArray();
			showArray();
		}
	}

	public static void main(String []s){
		int[] getIndex = new int[2];
		System.out.println("Enter Player 1's name:");
		Scanner name1 = new Scanner(System.in);
		String player1 = name1.nextLine();
		System.out.println("Enter Player 2's name:");
                Scanner name2 = new Scanner(System.in);
                String player2 = name2.nextLine();
		resetArray();
		showArray();
		while(true){
			System.out.println(player1+", Enter the position you want to mark ---->");
			Scanner sc1 = new Scanner(System.in);
			char pos1 = sc1.next().charAt(0);
			getIndex = getIndexOfArray(pos1);
			setXArray(getIndex[0],getIndex[1]);

			if((array[0][0] == array[0][1] && array[0][1] == array[0][2]) || 
			(array[1][0] == array[1][1] && array[1][1] == array[1][2]) ||
			(array[2][0] == array[2][1] && array[2][1] == array[2][2]) ||
			(array[0][0] == array[1][0] && array[1][0] == array[2][0]) ||
			(array[0][1] == array[1][1] && array[1][1] == array[2][1]) ||
			(array[0][2] == array[1][2] && array[1][2] == array[2][2]) ||
			(array[0][0] == array[1][1] && array[1][1] == array[2][2]) ||
			(array[0][2] == array[1][1] && array[1][1] == array[2][0])){
				System.out.println("Congratulations X, you have won!");
				System.exit(0);
			}
			checkToContinue();

			System.out.println(player2+", Enter the position you want to mark ---->");
                        Scanner sc2 = new Scanner(System.in);
                        char pos2 = sc2.next().charAt(0);
                        getIndex = getIndexOfArray(pos2);
                        setOArray(getIndex[0],getIndex[1]);

			if((array[0][0] == array[0][1] && array[0][1] == array[0][2]) ||
                        (array[1][0] == array[1][1] && array[1][1] == array[1][2]) ||
                        (array[2][0] == array[2][1] && array[2][1] == array[2][2]) ||
                        (array[0][0] == array[1][0] && array[1][0] == array[2][0]) ||
                        (array[0][1] == array[1][1] && array[1][1] == array[2][1]) ||
                        (array[0][2] == array[1][2] && array[1][2] == array[2][2]) ||
                        (array[0][0] == array[1][1] && array[1][1] == array[2][2]) ||
                        (array[0][2] == array[1][1] && array[1][1] == array[2][0])){
                                System.out.println("Congratulations O, you have won!");
                                System.exit(0);
                        }
			checkToContinue();
		}
	}
}

