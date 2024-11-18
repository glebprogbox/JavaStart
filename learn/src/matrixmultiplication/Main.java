package matrixmultiplication;

public class Main {
    public static void main(String[] args) {
        String filePathM1 = "learn/src/matrixmultiplication/m1.txt";
        String filePathM2 = "learn/src/matrixmultiplication/m2.txt";
        validateFile(filePathM1);
        validateFile(filePathM2);

        Matrix mat = new Matrix(3, 4);
        mat.setValue(0,1,1);
        System.out.println(mat.getMatrix());

    }


    private static void validateFile(String filePath) {
        if (!filePath.endsWith(".txt")) {
            System.out.println("Error. File is not a .txt file!");
            System.exit(1);
        }
    }
}
