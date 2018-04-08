package com.draw.canvas;

public class Line implements Shape  {

    @Override
    public void drawShape(String[] inputArr, Canvas canvas) {
        {
            int x1 = Integer.valueOf(inputArr[1]);
            int y1 = Integer.valueOf(inputArr[2]);
            int x2 = Integer.valueOf(inputArr[3]);
            int y2 = Integer.valueOf(inputArr[4]);

            if(x1 > canvas.getWidth() || x2 > canvas.getWidth() || y1 > canvas.getHeight() || y2 > canvas.getHeight()){
                System.out.println(" Coordinates of line are going out of canvas");
                return;
            }else{
                StringBuilder sb = null;
                for(int j =y1-1;j<=y2-1;j++){
                    sb = canvas.getMiddleLine(j);
                    for(int i = x1; i<=x2;i++){
                        sb.replace(i,i,"x");
                        sb.deleteCharAt(i+1);
                    }
                    canvas.setMiddleLine(j,sb);
                }
                System.out.println(canvas);
            }
        }
    }
}
