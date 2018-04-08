package com.draw.canvas;

public class Rectangle implements Shape {
    @Override
    public void drawShape(String[] inputArr, Canvas canvas) {
        {
            int x1 = Integer.valueOf(inputArr[1]);
            int y1 = Integer.valueOf(inputArr[2]);
            int x2 = Integer.valueOf(inputArr[3]);
            int y2 = Integer.valueOf(inputArr[4]);

            if(x1 > canvas.getWidth() || x2 > canvas.getWidth() || y1 > canvas.getHeight() || y2 > canvas.getHeight()){
                System.out.println(" Coordinates of rectangle are going out of canvas");
                return;
            }else{
                StringBuilder sb = null;
                for(int j =y1-1;j<=y2-1;j++){
                    sb = canvas.getMiddleLine(j);
                    int count = -1;
                    for(int i = x1; i<=x2;i++){
                        if(j == y1-1 || j == y2-1 ) {
                            sb.replace(i, i, "x");
                            sb.deleteCharAt(i + 1);
                        }else{
                            sb.replace(i, i, "x");
                            sb.deleteCharAt(i + 1);
                            i = ++count + x2-1;
                        }
                    }
                    canvas.setMiddleLine(j,sb);
                }
                System.out.println(canvas);
            }
        }
    }
}
