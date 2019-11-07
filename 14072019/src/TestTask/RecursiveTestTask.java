package TestTask;

public class RecursiveTestTask {
    int height;
    int width;
    int[][] matrix;
    int count = 100;
    int verticalPosition = 0;
    int horizontalPosition = 0;

    public void fillHorizontalToRight() {
        if (matrix[verticalPosition][horizontalPosition] != 0)
            return;
        for (int i = horizontalPosition; i < width; i++) {
            if (matrix[verticalPosition][i] != 0) {
                horizontalPosition = i - 1;
                verticalPosition++;
                fillVerticalToDown();
                return;
            }
            matrix[verticalPosition][i] = count++;
        }
        horizontalPosition = width - 1;
        verticalPosition++;
        fillVerticalToDown();
    }

    public void fillVerticalToDown() {
        if (matrix[verticalPosition][horizontalPosition] != 0)
            return;
        for (int i = verticalPosition; i < height; i++) {
            if (matrix[i][horizontalPosition] != 0) {
                verticalPosition = i - 1;
                horizontalPosition--;
                fillHorizontalToLeft();
                return;
            }
            matrix[i][horizontalPosition] = count++;
        }
        verticalPosition = height - 1;
        horizontalPosition--;
        fillHorizontalToLeft();
    }

    public void fillHorizontalToLeft() {
        if (matrix[verticalPosition][horizontalPosition] != 0)
            return;
        for (int i = horizontalPosition; i >= 0; i--) {
            if (matrix[verticalPosition][i] != 0) {
                horizontalPosition = i + 1;
                verticalPosition--;
                fillVerticalToUp();
                return;
            }
            matrix[verticalPosition][i] = count++;
        }
        horizontalPosition = 0;
        verticalPosition--;
        fillVerticalToUp();
    }

    public void fillVerticalToUp() {
        if (matrix[verticalPosition][horizontalPosition] != 0)
            return;
        for (int i = verticalPosition; i >= 0; i--) {
            if (matrix[i][horizontalPosition] != 0) {
                verticalPosition = i + 1;
                horizontalPosition++;
                fillHorizontalToRight();
                return;
            }
            matrix[i][horizontalPosition] = count++;
        }
        verticalPosition = height;
        horizontalPosition++;
        fillHorizontalToLeft();
    }

    public RecursiveTestTask(int height, int width) {
        this.height = height;
        this.width = width;
        matrix = new int[height][width];
    }

    public static void main(String[] args) {
        RecursiveTestTask recursiveTestTask = new RecursiveTestTask(10, 3);
        recursiveTestTask.fillHorizontalToRight();
        recursiveTestTask.showMatrix();
    }

    public void showMatrix() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void showWidthAndHeight() {
        System.out.println(verticalPosition + " " + horizontalPosition);
    }


}
