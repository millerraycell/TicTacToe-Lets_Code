package com.company;

import Table.Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Table table = new Table();
        int turn = 1;

        while (table.win() == 'a'){
            if(turn == 1){
                System.out.println("Jogador: X");
            }
            else{
                System.out.println("Jogador: O");
            }
            System.out.println("Insira as coordenadas que deseja jogar:");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String  lines = br.readLine();
            String[] strs = lines.trim().split("\\s+");
            int[] coordinates = new int[2];

            for (int i = 0; i < strs.length; i++) {
                coordinates[i] = Integer.parseInt(strs[i]);
            }


            if( table.play(coordinates[0], coordinates[1], turn==1 ? 'X' : 'O') == 1 ){
                if(turn == 1){
                    turn = 2;
                }
                else{
                    turn = 1;
                }
            }
            else {
                System.out.println("Jogada inválida");
            }

            table.showTable();
        }

        System.out.printf("Ganhou jogador: %c\n", table.win());
    }
}
