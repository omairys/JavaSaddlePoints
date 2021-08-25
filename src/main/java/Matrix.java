import java.util.*;

class Matrix {
    List<List<Integer>> values;
    int min, max;
    int posX=0, posY = 0;
    List<List<Integer>> columns = new ArrayList<List<Integer>>();
    Matrix(List<List<Integer>> values) { this.values = values; }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> sp = new HashSet<>();

        for (List<Integer> value : values) {
            max = Collections.max(value);
            posY = value.indexOf(max);
            findMinValByCol(values);

            for (List<Integer> column : columns) {
                min = Collections.min(column);
                if (column.contains(max) && max == min){
                    posX = column.indexOf(min);
                    sp.add(new MatrixCoordinate(posX+1, posY+1));
                }
            }
        }
        return sp;
    }

    private void findMinValByCol(List<List<Integer>> values) {
        for (int i = 0; i < values.size(); i++) {
            List<Integer> currentColumn = new ArrayList<>();
            for (int j = 0; j < values.get(i).size(); j++) {
                currentColumn.add(values.get(j).get(i));
            }
            columns.add(currentColumn);
        }
    }
}
