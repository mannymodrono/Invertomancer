import java.util.HashMap;
import java.util.Scanner;

public class invert {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int worlds = s.nextInt();

        for (int i = 0; i < worlds; i++) {
            int rows = s.nextInt();
            int columns = s.nextInt();
            int climbingHeight = s.nextInt();
            s.nextLine();

            /*
            2
            5 8 2
            ........
            ...#.#..
            .#.#.###
            .#.#.### 
            ########
            */

            int invertoColumn = 0;
            int invertoRow = -1;

            HashMap<Integer, HashMap<Integer, Boolean>> world = new HashMap<>();

            for (int j = 0; j < rows; j++) {

                HashMap<Integer, Boolean> row = new HashMap<>();
                String rowString = s.nextLine();
                
                char[] rowChars = rowString.toCharArray();

                for (int k = 0; k < columns; k++) {
                    String blockType = String.valueOf(rowChars[k]);

                    boolean blockTypeBool = false;

                    if (blockType.equals("#"))
                        blockTypeBool = true;

                    row.put(k, blockTypeBool);
                }
                
                world.put(j, row);
            }

            //Spawning position
            for (int j = rows - 1; j >= 0; j--) {
                HashMap<Integer, Boolean> row = world.get(j);
                if (row.get(0) == false) {
                    invertoRow = j;
                    break;
                }
            }

            System.out.printf("Inverto row: %d, Inverto column: %d", invertoRow, invertoColumn);
            
            

            /*
            World
            Map<int, 
            
            Column
            Map<int, boolean>
            >
            */
        }
    }
}