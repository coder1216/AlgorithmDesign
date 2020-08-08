package OODesign.PolyDomi;
import java.util.*;

public class Unit {
    int factor;
    int exp;

    public Unit() {

    }

    public int cal(int x) {
        return (int) (factor * Math.pow(x, exp));
    }

    public int eval(List<Unit> units, int x) {
        int res = 0;

        for (Unit unit : units) {
            res += unit.cal(x);
        }
        return res;
    }
}
