package com.company;

public class Column {
    public int x;
    public int y;
    
    public Column(int _x, int _y){
        x = _x;
        y = _y;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if (!(o instanceof Column))
            return false;
        Column c = (Column) o;
        
        return x == c.x && y == c.y;
    }
}
