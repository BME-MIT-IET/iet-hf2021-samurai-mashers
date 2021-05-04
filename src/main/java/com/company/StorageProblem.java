package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StorageProblem {
    public ArrayList<Package> packages;
    public Storage storage;

    public void GetInputFromConsole(){
        Scanner input = new Scanner(System.in);
        int length;
        int width;
        int colcount;
        int packagecount;
        packages = new ArrayList<Package>();
        length = input.nextInt();
        width = input.nextInt();
        storage = new Storage(length, width);
        colcount = input.nextInt();
        packagecount = input.nextInt();
        int colx;
        int coly;
        for(int i = 0; i < colcount; i++){
            coly = input.nextInt();
            colx = input.nextInt();
            storage.columns.add(new Column(colx, coly));
        }
        int pacx;
        int pacy;
        for(int i = 0; i < packagecount; i++){
            pacy = input.nextInt();
            pacx = input.nextInt();
            packages.add(new Package(pacx, pacy, i+1));
        }
        input.close();
    }

    public void GetInputFromIntArrayList(ArrayList<Integer> input){
        Iterator<Integer> iter = input.iterator();
        int length;
        int width;
        int colcount;
        int packagecount;
        packages = new ArrayList<Package>();
        length = iter.next();
        width = iter.next();
        storage = new Storage(length, width);
        colcount = iter.next();
        packagecount = iter.next();
        int colx;
        int coly;
        for(int i = 0; i < colcount; i++){
            coly = iter.next();
            colx = iter.next();
            storage.columns.add(new Column(colx, coly));
        }
        int pacx;
        int pacy;
        for(int i = 0; i < packagecount; i++){
            pacy = iter.next();
            pacx = iter.next();
            packages.add(new Package(pacx, pacy, i+1));
        }
    }

    public void Solve (){
        storage.Algorythm(packages);
    }

    public void PrintStorage(){
        for (int i = 0; i < storage.y; i++){
            for (int j = 0; j < storage.x; j++){
                if(j != storage.x-1)
                    System.out.print(storage.reserved[j][i] + "\t");
                else if(j == storage.x-1)
                    System.out.println(storage.reserved[j][i]);
            }
        }
    }
}
