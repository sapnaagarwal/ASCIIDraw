package com.draw.canvas;

import java.util.*;

public class Bucket implements Shape {
    @Override
    public void drawShape(String[] inputArr, Canvas canvas) {
        {
            int x = Integer.valueOf(inputArr[1]);
            int y = Integer.valueOf(inputArr[2]);
            String val = inputArr[3];
            if(x > canvas.getWidth() || y > canvas.getHeight()){
                System.out.println(" Coordinates of bucket fill are going out of canvas");
                return;
            }else{
                Map<Integer, List<Integer>> values = new LinkedHashMap<>();
                List<Integer> lst = new ArrayList<>();
                StringBuilder  sb = canvas.getMiddleLine(y-1);
                int lineNoToUpdate =y-1;
                if (sb.charAt(x) == 'x') {
                    for (int i = x; i >= 0; i--) {
                        replaceCharX(i, sb, lst,'x',val);
                        //canvas.setMiddleLine(lineNoToUpdate,sb);
                    }
                    for (int i = x + 1; i < sb.length(); i++) {
                        //replaceCharX(i, sb, lst,'x',val);
                        if (sb.charAt(i) == 'x') {
                            lst.add(i);
                            sb.replace(i, i, val);
                            sb.deleteCharAt(i + 1);
                        } else {
                            break;
                        }

                    }
                    canvas.setMiddleLine(lineNoToUpdate,sb);
                    values.put(lineNoToUpdate,lst);
                    for(int i=lineNoToUpdate +1 ;i< canvas.getMidLines().size(); i++ ){
                        values.put(i, null);
                    }
                    for(int i= lineNoToUpdate -1; i>= 0; i--){
                        values.put(i, null);
                    }

                    Iterator iter = values.keySet().iterator();
                    int lineNo = -1;
                    while (iter.hasNext()){

                        lineNo = (Integer) iter.next();
                        List<Integer> iterVal = (List<Integer>) values.get(lineNo);
                        if (lineNo == canvas.getMidLines().size()-1){
                            continue;
                        }else if(lineNo !=0 && lineNo >= y-1 ) {
                            lineNo = lineNo + 1;
                        }else if(lineNo > 1 && lineNo < y-1 ){
                            lineNo = lineNo -1;

                        }else if (lineNo == 0){
                            values.put(lineNo,values.get(1));
                            iterVal = (List<Integer>) values.get(lineNo);
                        }else{
                            values.put(lineNo,values.get(lineNo + 1));
                            iterVal = (List<Integer>) values.get(lineNo);
                        }
                        sb = canvas.getMiddleLine(lineNo);
                        int index = 0;
                        lst = new ArrayList<>();
                        for (int i = 0; i <iterVal.size() ; i++) {
                            index = iterVal.get(i);
                            replaceCharX( index, sb, lst,'x',val);

                        }
                        for (int i = index+1; i < sb.length(); i++) {
                            if (sb.charAt(i) == 'x') {
                                lst.add(i);
                                sb.replace(i, i, val);
                                sb.deleteCharAt(i + 1);
                            } else {
                                break;
                            }
                        }
                        canvas.setMiddleLine(lineNo,sb);
                        values.put(lineNo,lst);

                    }



                } else {
                    //check for space
                    Character charVal = sb.charAt(x);
                    for (int k = 0; k < canvas.getMidLines().size(); k++) {
                        sb = canvas.getMiddleLine(k);
                        for (int i = x; i >= 0; i--) {
                            if (sb.charAt(i) == charVal) {
                                sb.replace(i, i, val);
                                sb.deleteCharAt(i + 1);
                            } else {
                                break;
                            }
                        }
                        for (int i = x + 1; i < sb.length(); i++) {
                            if (sb.charAt(i) == charVal) {
                                sb.replace(i, i, val);
                                sb.deleteCharAt(i + 1);
                            } else {
                                break;
                            }
                        }
                        canvas.setMiddleLine(k,sb);
                    }
                }
                System.out.println(canvas);
            }
        }
    }

    private void replaceCharX(int i, StringBuilder sb,List<Integer> lst, Character charVal, String val ) {
        if (sb.charAt(i) == charVal) {
            lst.add(i);
            sb.replace(i, i, val);
            sb.deleteCharAt(i + 1);
        }
    }
}
