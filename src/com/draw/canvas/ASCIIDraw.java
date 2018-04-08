package com.draw.canvas;

import java.util.Scanner;

import static java.lang.System.exit;

public class ASCIIDraw {

    private Canvas canvas = null;

    public static void main(String args[]){
        ASCIIDraw draw = new ASCIIDraw();
        String[] inputArr = null;
        String command = null;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            command = scanner.nextLine();
            if(!command.contains("enter command:")){
                System.out.println("Command is not prefixed by 'enter command:'. Please enter correctly.");

            }else{
                inputArr= command.substring(command.indexOf(":") +1).trim().split(" ");
                draw.executeCommand(inputArr);
            }
        }
    }

    public void executeCommand(String[] inputArr){
        Shape shape = null;

        switch (inputArr[0]){
            case "C" :
                if(inputArr.length !=3){
                    System.out.println("Invalid no. of inputs");
                }else{
                    this.canvas = new Canvas().getCanvas(inputArr);
                }
                break;

            case "L" :
                if(areValidInputsForShape(inputArr, 5)){
                    shape = new Line();
                    shape.drawShape(inputArr, this.canvas);
                }
                break;
            case "R" :
                if(areValidInputsForShape(inputArr, 5)){
                        shape = new Rectangle();
                        shape.drawShape(inputArr, this.canvas);
                    }
                break;
            case "B" :
                if(areValidInputsForShape(inputArr, 4)){
                    shape = new Bucket();
                    shape.drawShape(inputArr, this.canvas);
                }
                break;

            case "Q" :
                exit(0);

            default:
                System.out.println("Invalid command");;

        }
    }

    public boolean areValidInputsForShape(String[] inputArr, int noOfInputs){
        if(inputArr.length !=noOfInputs){
            System.out.println("Invalid no. of inputs");
            return false;
        }else if(canvas == null){
            System.out.println("Please draw canvas first!!");
            return false;
        }
        return true;
    }
}
