import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char[][] microchip = new char[height][width];
        for (int y = 0; y < height; y++) {
            microchip[y] = in.nextLine().toCharArray();
        }

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(microchip[y][x] == '0') {
                    Node currentNode = new Node(x, y);                    
                    Node rightNode = getFirstNodeOnTheRight(microchip, currentNode);
                    Node bottomNode = getFirstNodeBelow(microchip, currentNode);

                    System.out.println(currentNode + " " + rightNode + " " + bottomNode);
                }
            }
        }
    }

    private static Node getFirstNodeOnTheRight(char[][] microchip, Node currentNode) {
        int i = currentNode.x + 1;
        
        while(i < microchip[currentNode.y].length && microchip[currentNode.y][i] != '0') {
            i++;
        }

        if(i == microchip[currentNode.y].length) {
            return new Node(-1, -1);
        }
        return new Node(i, currentNode.y);
    }

    private static Node getFirstNodeBelow(char[][] microchip, Node currentNode) {
        int i = currentNode.y + 1;
        
        while(i < microchip.length && microchip[i][currentNode.x] != '0') {
            i++;
        }

        if(i == microchip.length) {
            return new Node(-1, -1);
        }
        return new Node(currentNode.x, i);
    }
}