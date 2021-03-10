package BugMove2;

import java.util.Random;

//There are obstacles and if the bug bump them, bug goes back to the previous place
public class Move2_main {
    public static void main(String[] args) {
        int n = 4;   //row of map
        int m = 4;    //col of map

        int map[][] = new int[n + 2][m + 2];    //Map bug's gonna sneak around

        for (int i = 0; i < n + 2; i++) {   //Make obstacles
            for (int j = 0; j < m + 2; j++) {
                if (i == 0 || j == 0 || i == n + 1 || j == m + 1) {
                    map[i][j] = -1;
                }
            }
        }
        Random rd = new Random();

        int x = n / 2;
        int y = m / 2; //center of the map
        int t = 0;    //The number of try

        while (true) {
            int check = 0; //The number of places bug has been
            int prev_x = x;
            int prev_y = y;
            int x_next = rd.nextInt(3) - 1;
            int y_next = rd.nextInt(3) - 1;

            x += x_next;
            y += y_next;
            if (map[x][y] == -1) {  //bug bump! goes back to the prev
                x = prev_x;
                y = prev_y;
            } else {
                map[x][y]++;   //After passing, the place++
            }
            for (int i = 0; i < map.length; i++) {  //check the number of places the bug has not been
                for (int j = 0; j < map[i].length; j++) {
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