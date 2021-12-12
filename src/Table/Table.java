package Table;

import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class Table {
    private char[][] table = new char[3][3];

    public Table(){
        for(int i=0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                table[i][j] = 'a';
            }
        }
    }

    public void showTable(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i%2 == 0){
                    if(j%2 == 0){
                        if(table[i/2][j/2] == 'a'){
                            System.out.print(" ");
                        }
                        else {
                            System.out.printf("%c", table[i / 2][j / 2]);
                        }
                    }
                    else{
                        System.out.print(" | ");
                    }
                }
                else{
                    if(j%2 ==0){
                        System.out.print("- ");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public int play(int i, int j, char player){
        if(table[i][j] == 'a'){
            table[i][j] = player;
            return 1;
        }
        else{
            return 0;
        }

    }

    private void emptyStack(@NotNull Stack stack){
        while(!stack.empty()){
            stack.pop();
        }
    }

    private char rowAndColumn(int order){
        char winner = 'a';
        for(int i=0; i < 3; i++){
            if(table[i][0] == 'a'){
                continue;
            }

            Stack<Character> stack = new Stack<Character>();

            stack.push(table[i][0]);

            for(int j=1; j < 3; j++){
                if (order == 0){
                    if(table[i][j] != stack.peek()){
                        emptyStack(stack);
                        break;
                    }
                    else{
                        stack.push(table[i][j]);
                    }
                }
                else {
                    if(table[j][i] != stack.peek()){
                        emptyStack(stack);
                        break;
                    }
                    else{
                        stack.push(table[j][i]);
                    }
                }
            }
            if(!stack.empty()){
                winner = stack.peek();
                break;
            }
        }
        return winner;
    }

    private char mainDiagonal(){
        if(table[0][0] == 'a'){
            return 'a';
        }

        Stack<Character> stack = new Stack<Character>();

        stack.push(table[0][0]);

        for(int i=1; i < 3; i++){
            if(table[i][i] != stack.peek()){
                return 'a';
            }
            else {
                stack.push(table[i][i]);
            }
        }
        return stack.peek();
    }

    private char secondaryDiagonal(){
        if(table[0][0] == 'a'){
            return 'a';
        }

        Stack<Character> stack = new Stack<Character>();

        stack.push(table[0][2]);

        for(int i = 1; i < 3; i++){
            if(table[i][2-i] != stack.peek()){
                return 'a';
            }
            else {
                stack.push(table[i][2-i]);
            }
        }
        return stack.peek();
    }

    public char win() {
        char[] end = {rowAndColumn(0), rowAndColumn(1), mainDiagonal(), secondaryDiagonal()};
        char result = 'a';

        for (int i=0; i < 4; i++){
            if(end[i] != 'a'){
                result = end[i];
            }
        }

        return result;
    }
}
