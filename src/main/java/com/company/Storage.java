package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Storage {

    public int y;
    public int x;
    public ArrayList<Column> columns;
    public int[][] reserved;

    public Storage(int _length, int _width) {
        y = _length;
        x = _width;
        columns = new ArrayList<Column>();
        reserved = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                reserved[i][j] = 0;
            }
        }
    }

    public boolean fit(Package p, int startx, int starty) {
        if (p.x + startx > x || p.y + starty > y)
            return false;
        for (int i = startx; i < p.x + startx; i++) {
            for (int j = starty; j < p.y + starty; j++) {
                if (reserved[i][j] != 0)
                    return false;
            }
        }
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).x > startx && columns.get(i).x < startx + p.x && columns.get(i).y > starty&& columns.get(i).y < starty + p.y)
                return false;
        }
        return true;
    }

    public int RowCount(Package p, int posx, int posy) {
        int count = 0;
        for (int i = posx; i < p.x + posx; i++) {
            for (int j = posy; j < p.y + posy; j++) {
                reserved[i][j] = 1;
            }
        }
        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (reserved[i][j] != 0) {
                    count++;
                    break;
                }
            }
        }
        for (int i = posx; i < p.x + posx; i++) {
            for (int j = posy; j < p.y + posy; j++) {
                reserved[i][j] = 0;
            }
        }
        return count;
    }

    public void Algorythm(ArrayList<Package> packages) {
        int tempx;
        int tempy;
        int minrow;
        int posx;
        int posy;
        Collections.sort(packages, new SizeSorter());
        for (int i = 0; i < packages.size(); i++) {
            ArrayList<ArrayList<Integer>> newrows = new ArrayList<ArrayList<Integer>>();

            IterateOverStorage(newrows, packages, i, 0);

            // Change the x and the y coordinate
            tempx = packages.get(i).x;
            tempy = packages.get(i).y;
            packages.get(i).x = tempy;
            packages.get(i).y = tempx;

            IterateOverStorage(newrows, packages, i, 1);

            ArrayList<Integer> counts = new ArrayList<>();
            ArrayList<Integer> sorted = new ArrayList<>();

            for (int iter = 0; iter < newrows.size(); iter++) {
                counts.add(newrows.get(iter).get(0));
                sorted.add(newrows.get(iter).get(0));
            }

            Collections.sort(sorted);
            minrow = sorted.get(0);
            minrow = counts.indexOf(minrow);
            posx = newrows.get(minrow).get(1);
            posy = newrows.get(minrow).get(2);

            if (newrows.get(minrow).get(3) == 0) {
                packages.get(i).x = tempx;
                packages.get(i).y = tempy;
            }
            else {
                packages.get(i).x = tempy;
                packages.get(i).y = tempx;
            }
            for (int e = posx; e < packages.get(i).x + posx; e++) {
                for (int f = posy; f < packages.get(i).y + posy; f++) {
                    reserved[e][f] = packages.get(i).id;
                }
            }
        }
    }

    private void IterateOverStorage(ArrayList<ArrayList<Integer>> newrows, ArrayList<Package> packages, int index,
            int rotated) {
        // Iterate over the columns
        for (int z = 0; z < x; z++) {
            // Iterate over the rows
            for (int j = 0; j < y; j++) {
                // If the package fit put it in
                if (fit(packages.get(index), z, j) == true) {
                    ArrayList<Integer> cords = new ArrayList<>();
                    cords.add(RowCount(packages.get(index), z, j));
                    cords.add(z);
                    cords.add(j);
                    cords.add(rotated);
                    newrows.add(cords);
                }
            }
        }
    }
}
