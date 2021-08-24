import java.util.*;

class Matrix {
    List<List<Integer>> values;
    int min, max;
    int posX=0, posY = 0;
    boolean pointX = false;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> sp = new HashSet<>();

        for (List<Integer> value : values) {
            max = Collections.max(value);
            posX = values.indexOf(max);
            min = findMinValByCol(values);
            if (max == min){
                sp.add(new MatrixCoordinate(posX+1, posY+1));
                pointX = true;
            }
            if (pointX){ break; }
        }
        return sp;
    }

    private int findMinValByCol(List<List<Integer>> values) {
        int currentValue;
        for (int i = 0; i < values.size(); i++) {
            currentValue = values.get(0).get(i);

            for (int j = 0; j < values.get(i).size(); j++) {
                if(values.get(j).get(i) < currentValue){
                    currentValue = values.get(j).get(i);
                    if (currentValue == max){
                        posX = j;
                        return currentValue;
                    }
                }
            }
        }
        return 0;
    }
}
