import java.util.ArrayList;
import java.util.List;

public class Datas {
    private List<Integer> dataList;

    public Datas() {
        dataList = new ArrayList<>();
        for(int i = 0; i<10; i++) {
            dataList.add(i);
        }
    }

    public List<Integer> getData() {
        return dataList;
    }
}
