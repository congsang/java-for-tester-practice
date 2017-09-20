package chap09_arraysiteration.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MultiDimensionalArraysTest {

    @Test
    public void createAMultiDimensionalArray() {
        int[][] multi = new int[4][4];

        print2DIntArray(multi);

        Assert.assertEquals(4, multi[0].length);

        Assert.assertEquals(0, multi[0][1]);

        Arrays.fill(multi[0], 0);
        Arrays.fill(multi[1], 1);
        Arrays.fill(multi[2], 2);
        Arrays.fill(multi[3], 3);

        print2DIntArray(multi);
    }

    public void print2DIntArray(int[][] multi) {
        for (int[] outer : multi) {
            if (outer == null) {
                System.out.print("null");
            } else {
                for (int inner : outer) {
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void createAndDefineAMultiArray() {
        int[][] multi = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        Assert.assertEquals(1, multi[0][0]);
        Assert.assertEquals(7, multi[1][2]);
        Assert.assertEquals(12, multi[2][3]);
        Assert.assertEquals(14, multi[3][1]);

        print2DIntArray(multi);
    }

    @Test
    public void createA3DArrayArray() {
        int[][][] multi3d = new int[3][4][5];

        Assert.assertEquals(3, multi3d.length);
        Assert.assertEquals(4, multi3d[0].length);
        Assert.assertEquals(4, multi3d[1].length);
        Assert.assertEquals(4, multi3d[2].length);
        Assert.assertEquals(5, multi3d[0][1].length);
        Assert.assertEquals(5, multi3d[0][2].length);
        Assert.assertEquals(5, multi3d[1][3].length);
        Assert.assertEquals(0, multi3d[0][0][0]);
    }

    @Test
    public void ragged2DArray() {
        int[][] ragged2d = {{1, 2, 3, 4},
                {5, 6},
                {7, 8, 9}
        };

        Assert.assertEquals(4, ragged2d[0].length);
        Assert.assertEquals(2, ragged2d[1].length);
        Assert.assertEquals(3, ragged2d[2].length);

        Assert.assertEquals(4, ragged2d[0][3]);
        Assert.assertEquals(6, ragged2d[1][1]);
        Assert.assertEquals(7, ragged2d[2][0]);

        print2DIntArray(ragged2d);
    }

    @Test
    public void createRagged2dArray() {
        int[][] ragged2d = new int[10][];

        ragged2d[0] = new int[10];
        ragged2d[1] = new int[3];

        print2DIntArray(ragged2d);
    }

    @Test
    public void createRagged3dArray() {
        int[][][] ragged3d = new int[10][][];
    }
}
