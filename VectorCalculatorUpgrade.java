/*
@author Liyana Yeahia
@since 2026-05-12
*/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class VectorCalculatorUpgrade {
    public static void main(String[] args) {
        
        //Scanner for all methods to use
        Scanner userInput = new Scanner(System.in);

        //ArrayLists store user input data everytime loop runs
        ArrayList<Double> vectorsXcomponent = new ArrayList<Double>();
        ArrayList<Double> vectorsYcomponent = new ArrayList<Double>();

        double finalXResult = 0;
        double finalYResult = 0;

        do {
            double vmagfunc = vectorMagnitude(userInput);
            double vangfunc = degreesToRadians(vectorAngle(userInput));
            int vquadfunc = vectorQuadrant(userInput);

            double xResult = vectorXValue(vangfunc, vmagfunc, vquadfunc);
            double yResult = vectorYValue(vangfunc, vmagfunc, vquadfunc);

            System.out.println("Entered Vector: " + vectorCartesianCoords(xResult, yResult));

            //calculating final vector
            finalXResult += xResult;
            finalYResult += yResult;

            System.out.println("Final Vector: " + vectorCartesianCoords(finalXResult, finalYResult));
        
            //adding data to arraylists
            vectorsXcomponent.add(xResult);
            vectorsYcomponent.add(yResult);
        }
        while (continueProgram(userInput));

        //prints out stored data from arraylists
        System.out.println("History of vectors: ");
        for(int i = 0; i < vectorsXcomponent.size(); i++) {
            System.out.println(vectorsXcomponent.get(i) + "i + " + vectorsYcomponent.get(i) + "j");
        }

    }

    static double vectorMagnitude(Scanner userInput) {
        System.out.println("What is the magnitude of your vector? ");
        double magnitude = userInput.nextDouble();
        return magnitude;
    }

    static double vectorAngle(Scanner userInput) {
        System.out.println("What is the angle of your vector relative to the x-axis? ");
        double angle = userInput.nextDouble();
        return angle;
    }

    static int vectorQuadrant(Scanner userInput) {
        System.out.println("What quadrant is your vector in? ");
        int quadrant = userInput.nextInt();
        return quadrant;
    }

    //method converts degrees to radians for math function
    static double degreesToRadians(double degree) {
        double radian;
        radian = Math.toRadians(degree);
        return radian;
    }

    //method finds x-component of vector
    static double vectorXValue(double radian, double magnitude, int quadrant) {
        double xVector;
        xVector = magnitude*Math.cos(radian);

        switch (quadrant) {
            case 1:
                break;
            case 2:
                xVector *= -1;
                break;
            case 3:
                xVector *= -1;
                break;
            case 4:
                break;
        }
        return xVector;
    }

    //method finds y-component of vector
    static double vectorYValue(double radian, double magnitude, int quadrant) {
        double yVector;
        yVector = magnitude*Math.sin(radian);

        switch (quadrant) {
            case 1:
                break;
            case 2: 
                break;
            case 3:
                yVector *= -1;
                break;
            case 4:
                yVector *= -1;
                break;
        }
        return yVector;
    }

    //method prints out vector in rectangular form
    static String vectorCartesianCoords(double xVector, double yVector) {
        return(xVector + "i + " + yVector + "j");
    }

    //method asks if user wants to add another vector
    static boolean continueProgram(Scanner userInput) {
        boolean another;

        userInput.nextLine(); //since .nextLine reads all lines, this one cleans it up

        System.out.println("Would you like to add another vector? Type Y or N: ");
        String answer = userInput.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            another = true;
        }
        else {
            another = false;
            System.out.println("Thank you for using the Vector Calculator!");
        }
        return another;
    }

}