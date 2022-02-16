// Public Class
public class DrawTree {

    // Runs depth first search on an adjacency matrix
    public static void explore (int [][] G, int v, String [] s, String root, String [] names, boolean tell) {
        // v has been visited
        G[v][v] = 1;

        int c = -1;
        while (c < s.length && s[++c] != null) continue;

        // return string s gets a new element
        s[c] = root + "+-" + names[v];
        root = root + (tell ? "| " : "  ");

        c = 0;
        int t = 0;
        for (int i = 0; i < G[v].length; i++)
            t += (v != i) ? G[v][i] : 0;

        // explore children
        for (int i = 0; i < G[v].length; i++)
            if (G[v][i] == 1 && G[i][i] == 0)
                explore(G, i, s, root, names, ++c < t && t > 1);
    }

    // Constructs an adjacency matrix and sends it to be searched.
    public static String [] draw (int [] parents, String [] names) {
        // make graph, an adjacency matrix
        int [][] graph = new int[parents.length][parents.length];

        int root = 0;

        // construct graph / tree, locate root node
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] != -1)
                graph[parents[i]][i] = 1;
            else
                root = i;
        }
        String [] s = new String[parents.length];

        // run depth-first search, filling s
        explore(graph, root, s, "", names, false);

        // return s
        return s;
    }

    // Prints out an adjacency matrix
    public static void print_graph (int [][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++)
                System.out.print(graph[i][j] + " ");
            System.out.println();
        }
    }

    // Main function
    public static void main (String [] args) {
        int [] tree = {-1, 0, 1, 1, 2, 2, 3, 3, 0, 8, 8, 9, 9, 10, 10};
        String [] names = {"A", "B", "C", "D", "E", "F", "G", "H","I", "J", "K", "L", "M", "N", "O"};
        String [] output = draw(tree, names);
        for (int i = 0; i < output.length; i++)
            System.out.println(output[i]);
    }
}
