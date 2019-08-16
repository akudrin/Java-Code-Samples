//import The Apache Commons Math library

public class DataScience5 {
    public static void main(String[] args) {

        int sizeA = 3;
        RealVector vectorA = new ArrayRealVector(size);

        double[] dataA = {1.0, 2.2, 4.5};
        RealVector vectorB = new ArrayRealVector(data);

        int sizeB = 3;
        double defaultValueA = 1.0;
        RealVector vectorC = new ArrayRealVector(size, defaultValueA);

        int rowDimensionA = 10;
        int colDimensionA = 20;
        RealMatrix matrix = new Array2DRowRealMatrix(rowDimensionA, colDimensionA);

        double[][] dataB = {{1.0, 2.2, 3.3}, {2.2, 6.2, 6.3}, {3.3, 6.3, 5.1}};
        RealMatrix matrixA = new Array2DRowRealMatrix(data);

        int rowDimensionB = 10;
        int colDimensionB = 20;
        double defaultValueB = 1.0;
        RealMatrix matrixB = new Array2DRowRealMatrix(rowDimensionB, colDimensionB);
        matrix.scalarAdd(defaultValueB);

        /* deep copy contents of matrix */
        RealMatrix anotherMatrix = matrix.copy();
    }
}
