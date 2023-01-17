package com.pyraminx;

import java.util.Arrays;

public class Pyramid {

    int[][] triangles;
    int size;

    //Store pyramid in 3d array (0-2 x, 0-2 y, 0-3 z) (x and y represent each square on a face, z represents which face), then use matrix stuff to do rotations
    //Each rotation is stored as multiple swaps of two elements in the matrix ---- I think this is the one.
    //or some group theory nonsense to do it??

    public Pyramid(int dimension){
        size = dimension;
        triangles = new int[4][numberOfTriangles(dimension)];
        setColours();
    }

    private int numberOfTriangles(int number){
        int total = 0;
        for(int i = 1; i < number + 1; i++){
            total += (2 * i - 1);
        }
        return total;
    }

    private void setColours(){
        for (int i = 0; i < 4; i++) {
            Arrays.fill(triangles[i], i);
        }
    }

    private void rotate(){
        //only need dictionary of largest possible moves, smaller moves are a subset
        //dictionary of relative indexes from each point?
    }








    public void printAsString(){
        //These NEED to be centered around top point
        int face0Index = 0;
        int face1Index = triangles[0].length - 1;
        int face2Index = triangles[0].length - 1;
        int face3Index = triangles[0].length - 1;
        for(int column = 0; column < size; column++) {
            for(int i = 0; i < column; i++){
                System.out.print("  ");
            }
            for(int i = 0; i < (size - column) * 2 - 1; i++) {
                System.out.print(triangles[1][face1Index] + " ");
                face1Index -= 1;
            }
            System.out.print("/ ");
            for(int i = 0; i < (column + 1) * 2 - 1; i++) {
                System.out.print(triangles[0][face0Index] + " ");
                face0Index += 1;
            }
            System.out.print("\\ ");
            for(int i = 0; i < (size - column) * 2 - 1; i++) {
                System.out.print(triangles[2][face2Index] + " ");
                face2Index -= 1;
            }
            System.out.println();
        }
        for(int i = 0; i < 2 * size + 2; i++){
            System.out.print(" ");
        }
        for(int i = 0; i < (size * 2) - 1; i++){
            System.out.print("- ");
        }
        System.out.println();
        for(int column = 0; column < size; column++) {
            for(int i = 0; i < ((column + size) * 2) + 2; i++){
                System.out.print(" ");
            }
            for(int i = 0; i < (size - column) * 2 - 1; i++) {
                System.out.print(triangles[3][face3Index] + " ");
                face3Index -= 1;
            }
            System.out.println();
        }
    }
}