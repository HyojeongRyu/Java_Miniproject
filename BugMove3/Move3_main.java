package BugMove3;

import java.util.ArrayList;
import java.util.Random;

public class Move3_main {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int t=0;
        Random rd = new Random();

        int map[][] = new int[n + 2][m + 2];
        int m_row = map.length;

        for (int i = 0; i < m_row; i++) { //making obstacles
            int m_col = map[i].length;
            for (int j = 0; j < m_col; j++) {
                if (i == 0 || j == 0 || i == m_row - 1 || j == m_col - 1) {
                    map[i][j] = -1;
                }
            }
        }

        int x = n / 2;
        int y = m / 2;
        int dir_x[] = {0, 1, -1};
        int dir_y[] = {0, 1, -1};

        while (true) {
            int check = 0;
            int pre_x = x;    //If the bug bump, it goes back to the prev place
            int pre_y = y;
            map[x][y]++;    //After passing, the place++

            int rx = rd.nextInt(3);
            int ry = rd.nextInt(3);
            int next_x = dir_x[rx];
            int next_y = dir_y[ry];
            x += next_x;
            y += next_y;

            if (map[x][y] == -1) {
                x = pre_x;
                y = pre_y;
                continue;
            }

            for (int i = 0; i < m_row; i++) { //making obstacles
                int m_col = map[i].length;
                for (int j = 0; j < m_col; j++) {
                    if (map[i][j] == 0) check++;
                }
            }
            t++;
            System.out.println("Left places are: " + check);
            if(check==0) break;
        }
        System.out.println("You've tried "+t+"times!");
    }
}
