package Practice.com1217;

class DArray {
    int[] arr = new int[0];

    void add(int num) {
        int[] copyArr = new int[arr.length+1];
        for(int i = 0; i<arr.length; i++){
            copyArr[i] = arr[i];
        }
        copyArr[copyArr.length-1] = num;
        arr = copyArr;
    }

    void Remove(int num) {
        boolean notRemove = true;
        int[] afterArr = new int[arr.length-1];
        for(int i = 0; i<afterArr.length; i++) {
            if(arr[i] == num) {
                afterArr[i] = arr[i+1];
                notRemove = false;
                continue;
            }
            if(notRemove){
                afterArr[i] = arr[i];
            }else {
                afterArr[i] = arr[i+1];
            }

        }
        arr = afterArr;
    }

    int[] getArr() {
        return this.arr;
    }
}

public class Ref {
    public static void main(String[] args) {
        DArray list = new DArray();
        list.add(1110);
        list.add(1111);
        list.add(1112);
        list.add(1113);
        list.add(1114);
        int[] temp = list.getArr();

        for(int i = 0; i<temp.length; i++){
            System.out.print(temp[i] + " ");
        }

        System.out.println();
        list.Remove(1112);
        list.Remove(1111);
        list.Remove(1110);
        list.Remove(1113);

        temp = list.getArr();

        for(int i = 0; i<temp.length; i++){
            System.out.print(temp[i] + " ");
        }

    }
}
