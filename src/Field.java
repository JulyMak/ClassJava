public class Field {
    private char[][] matrix;

    public Field(int size) {
        matrix = new char[size][size];
    }

    public void addZero(int x, int y) {
        matrix[x][y] = '0';
    }

    public void addCross(int x, int y) {
        matrix[x][y] = 'X';
    }

    public void clean(int x, int y) {
        matrix[x][y] = 0;
    }

    public int longestCrosses() {
        int count = 0;
        int maxVert = 0;
        int maxHor = 0;
        int maxDiag1 = 0;
        int maxDiag2 = 0;
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 'X') {
                    count++;
                }
                if (matrix[i][j] == '0' || i == matrix.length - 1) {
                    maxVert = Math.max(maxVert, count);
                    count = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'X') {
                    count++;
                }
                if (matrix[i][j] == '0' || j == matrix.length - 1) {
                    maxHor = Math.max(maxHor, count);
                    count = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == 'X') {
                count++;
            }
            if (matrix[i][i] == '0' || i == matrix.length - 1) {
                maxDiag1 = Math.max(maxDiag1, count);
                count = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix.length - i - 1] == 'X') {
                count++;
            }
            if (matrix[i][matrix.length - i - 1] == '0' || i == matrix.length - 1) {
                maxDiag2 = Math.max(maxDiag2, count);
                count = 0;
            }
        }
        maxDiag1 = Math.max(maxDiag1, maxDiag2);
        return Math.max(maxDiag1, Math.max(maxHor, maxVert));
    }
    public int longestZeroes() {
        int count = 0;
        int maxVert = 0;
        int maxHor = 0;
        int maxDiag1 = 0;
        int maxDiag2 = 0;
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == '0') {
                    count++;
                }
                if (matrix[i][j] == 'X' || i == matrix.length - 1) {
                    maxVert = Math.max(maxVert, count);
                    count = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == '0') {
                    count++;
                }
                if (matrix[i][j] == 'X' || j == matrix.length - 1) {
                    maxHor = Math.max(maxHor, count);
                    count = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == '0') {
                count++;
            }
            if (matrix[i][i] == 'X' || i == matrix.length - 1) {
                maxDiag1 = Math.max(maxDiag1, count);
                count = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix.length - i - 1] == '0') {
                count++;
            }
            if (matrix[i][matrix.length - i - 1] == 'X' || i == matrix.length - 1) {
                maxDiag2 = Math.max(maxDiag2, count);
                count = 0;
            }
        }
        maxDiag1 = Math.max(maxDiag1, maxDiag2);
        return Math.max(maxDiag1, Math.max(maxHor, maxVert));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}

