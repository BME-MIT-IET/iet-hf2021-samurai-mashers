package com.company;

public class Package {
    public int x;
    public int y;
    public int id;

    public Package(int _length, int _width, int _id){
        y = _length;
        x = _width;
        id = _id;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if (!(o instanceof Package))
            return false;
        Package p = (Package) o;
        
        return x == p.x && y == p.y && id == p.id;
    }
}
