import java.util.List;

public class DataController {

    List<Integer> data;

    public DataController(List<Integer> data) {
        this.data = data;
    }

    public int getData(int index) {
        return this.data.get(index);
    }

    public void setData(int data) {
        this.data.add(data);
    }
}
