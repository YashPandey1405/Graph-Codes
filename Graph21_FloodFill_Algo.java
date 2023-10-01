public class Graph21_FloodFill_Algo {
    public static void FloodFill_Util(int Image[][], int sr, int sc, int Color, boolean Visited[][], int OrigColor) {
        int m = Image.length, n = Image[0].length;
        if (sr < 0 || sc < 0 || sr >= m || sc >= n) {
            return;
        }
        if (Visited[sr][sc] || Image[sr][sc] != OrigColor) {
            return;
        }
        Visited[sr][sc] = true;
        Image[sr][sc] = Color;

        // Left Side Visit.....
        FloodFill_Util(Image, sr, sc - 1, Color, Visited, OrigColor);

        // Right Side Visit.....
        FloodFill_Util(Image, sr, sc + 1, Color, Visited, OrigColor);

        // Up Side Visit.....
        FloodFill_Util(Image, sr - 1, sc, Color, Visited, OrigColor);

        // Down Side Visit.....
        FloodFill_Util(Image, sr + 1, sc, Color, Visited, OrigColor);

    }

    public static void FloodFill(int Image[][], int sr, int sc, int Color) {
        boolean Visited[][] = new boolean[Image.length][Image[0].length];
        FloodFill_Util(Image, sr, sc, Color, Visited, Image[sr][sc]);
    }

    public static void main(String args[]) {
        int Image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        FloodFill(Image, 1, 1, 2);
        for (int i = 0; i < Image.length; i++) {
            for (int j = 0; j < Image[0].length; j++) {
                System.out.print(Image[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
