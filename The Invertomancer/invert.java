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
             * 2 5 8 2 ........ ...#.#.. .#.#.### .#.#.### ########
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

            // Spawning position
            for (int j = rows - 1; j >= 0; j--) {
                HashMap<Integer, Boolean> row = world.get(j);
                if (row.get(0) == false) {
                    invertoRow = j;
                    break;
                }
            }

            printWorld(world, invertoColumn, invertoRow);

            /*
             * .... ..#. .### ####
             */

            // Looping over all columns
            label: for (int j = 0; j < columns - 1; j++) {
                int columnToCheck = invertoColumn + 1;
                int rowToCheck = invertoRow;

                //Gravity
                invertoRow = getLowestAirOfColumn(world, rows, invertoColumn);

                // Advance upwards
                for (int k = 0; k < climbingHeight; k++) {
                    if (world.get(rowToCheck).get(columnToCheck)) {
                        rowToCheck -= 1;
                        continue;
                    } else {
                        // We hit an air block
                        invertoColumn++;
                        invertoRow = rowToCheck;
                        printWorld(world, invertoColumn, invertoRow);
                        continue label;
                        // TODO: Move him up to be on top of grass
                    }
                }
                // TODO: Invert if we never hit an air
            }

            //Gravity
            invertoColumn = getLowestAirOfColumn(world, rows, invertoColumn);

            /*
             * World Map<int,
             * 
             * Column Map<int, boolean> >
             */
        }
    }

    public static void printWorld(HashMap<Integer, HashMap<Integer, Boolean>> world, int x, int y) {
        // Loop through all rows
        for (int i = 0; i < world.size(); i++) {
            // Loop through all columns in a row
            for (int j = 0; j < world.get(i).size(); j++) {
                boolean block = world.get(i).get(j);
                if (block) {
                    System.out.printf("#");
                } else {
                    System.out.printf(".");
                }
            }
            System.out.println();
        }
        System.out.printf("X: %d, Y: %d\n", x, y);

    }

    public static int getLowestAirOfColumn(HashMap<Integer, HashMap<Integer, Boolean>> world, int totalRows,
            int column) {
        // Change size to index
        int currentRow = totalRows - 1;

        // Loop through all rows
        for (; currentRow >= 0; currentRow--) {
            boolean block = world.get(currentRow).get(column);
            if (!block) {
                return currentRow;
            }
        }

        return 0;

    }
}
