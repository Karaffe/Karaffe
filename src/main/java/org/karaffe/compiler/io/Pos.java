package org.karaffe.compiler.io;

public class Pos {

    private final int line;
    private final int column;

    public Pos(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.line;
        hash = 17 * hash + this.column;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Pos other = (Pos) obj;
        if ( this.line != other.line ) {
            return false;
        }
        if ( this.column != other.column ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pos{" + "line=" + line + ", column=" + column + '}';
    }

}
