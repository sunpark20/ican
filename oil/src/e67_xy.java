/**
 * Created by soy on 2016-09-14.
 */
public class e67_xy {
    private int x,y;

    public e67_xy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void r(){
        y+=1;
    }
    public void u(){
        x-=1;
    }
    public void l(){
        y-=1;
    }
    public void d(){
        x+=1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
