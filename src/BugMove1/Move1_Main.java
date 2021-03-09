package BugMove1;

import java.util.Random;

public class Move1_Main {
    public static void main(String[] args) {
        int n = 4;   //row of map
        int m = 4;    //col of map

        int map[][] = new int[n][m];    //Map bug's gonna sneak around
        Random rd = new Random();


        int x = n / 2;
        int y= m / 2; //center of the map

        int t=0;    //The number of try

        while(true) {
            int check = 0; //The number of places bug has been
            map[y][x]++;    //bug starts at center of the map

            if (x == 0 || y == 0 || x == n - 1 || y == m - 1) { //wall
                if (x == 0) {
                    int wall = rd.nextInt(2);
                    x += wall;
                }
                if (y == 0) {
                    int wall = rd.nextInt(2);
                    y += wall;
                }
                if (x == n - 1) {
                    int wall = rd.nextInt(2) - 1;
                    x += wall;
                }
                if (y == m - 1) {
                    int wall = rd.nextInt(2) - 1;
                    y += wall;
                }
            } else {
                int x_next = rd.nextInt(3) - 1;
                int y_next = rd.nextInt(3) - 1;
                x += x_next;
                y += y_next;
            }

            for (int i = 0; i < map.length; i++) {  //check the number of places the bug has not been
                for (int j = 0; j < map.length; j++) {
                    if (map[i][j] == 0) {
                        check++;
                    }
                }
            }
            System.out.println("Left place: " + check);
            if (check == 0) break;
            t++;
        }
        System.out.println("You've tried " + t + "!");
    }
}