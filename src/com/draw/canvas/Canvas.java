package com.draw.canvas;

import java.util.ArrayList;
import java.util.List;

public class Canvas {

    private int height;

    private int width;

    private StringBuilder topLine;

    private StringBuilder bottomLine;

    private List<StringBuilder> midLines;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public StringBuilder getTopLine() {
        return topLine;
    }

    public void setTopLine(StringBuilder topLine) {
        this.topLine = topLine;
    }

    public StringBuilder getBottomLine() {
        return bottomLine;
    }

    public void setBottomLine(StringBuilder bottomLine) {
        this.bottomLine = bottomLine;
    }

    public List<StringBuilder> getMidLines() {
        return midLines;
    }

    public void setMidLines(List<StringBuilder> midLines) {
        this.midLines = midLines;
    }

    public StringBuilder getMiddleLine(int i){
        return midLines.get(i);
    }

    public void setMiddleLine(int i, StringBuilder line) {
        this.midLines.set(i,line);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.topLine);
        for(int i=0;i< this.midLines.size();i++){
            sb.append("\n");
            sb.append(this.midLines.get(i));
        }
        sb.append("\n");
        sb.append(this.bottomLine);
        return sb.toString();
    }

    public Canvas getCanvas(String[] inputArr){
        StringBuilder sb = new StringBuilder();
        this.width = Integer.valueOf(inputArr[1]);
        this.height = Integer.valueOf(inputArr[2]);

        for(int i =0;i<this.width ;i++){
            sb.append("-");
        }
        this.topLine = sb;
        this.bottomLine = sb;
        List<StringBuilder> lines = new ArrayList<>();
        sb = new StringBuilder();

        for(int j =0;j<this.height;j++){
            sb.append("|");
            for(int k =0;k<this.width-2 ;k++){
                sb.append(" ");
            }
            sb.append("|");
            lines.add(sb);
            sb = new StringBuilder();
        }

        this.midLines = lines;

        System.out.println(this);
        return this;
    }
}
