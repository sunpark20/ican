/**
 * Created by soy on 2016-09-14.
 */
public class e67_wall {
    private int rightW;
    private int topW;
    private int leftW;
    private int bottomW;

    public e67_wall(int startNum) {
        this.rightW = startNum;
        this.topW = startNum;
        this.leftW = startNum;
        this.bottomW = startNum;
    }
    void expand(){
        rightW+=1;
        topW-=1;
        leftW-=1;
        bottomW+=1;
    }

    public int getRightW() {
        return rightW;
    }

    public int getTopW() {
        return topW;
    }

    public int getLeftW() {
        return leftW;
    }

    public int getBottomW() {
        return bottomW;
    }
}
