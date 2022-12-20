package Practice.com1219;

class Node {
    int data;
    int length;
    Node next = null;

    public Node(int data) {
        this.data = data;
        this.length++;
    }

    // 노드에 데이터 넣기
    public void add(int data) {
        boolean isNext = true;
        Node willAddNode = new Node(data);
        Node currentNode = this;

        while(isNext) {
            if(currentNode.next == null) {
                currentNode.next = willAddNode;
                isNext = false;
            }else {
                currentNode = currentNode.next;
            }
        }

        this.length++;
    }

    // 끝 부분 삭제
    public void removeEnd() {
        boolean isNext = true;
        Node currentNode = this;
        Node nextNode = this.next;
        while(isNext) {
            if(nextNode.next == null) {
                currentNode.next = null;
                isNext = false;
            }else {
                currentNode = currentNode.next;
                nextNode = currentNode.next;
            }
        }
        this.length--;
    }

    public void removeIdx(int idx) {
        Node currentNode = this;
        Node nextNode = this.next;
        for(int i = 0; i<this.length; i++){
            if(idx == 0) {
                currentNode.data = nextNode.data;
                currentNode.next = nextNode.next;
                break;
            }else if(i+1 == idx) {
                currentNode.next = nextNode.next;
                break;
            }
            currentNode = nextNode;
            nextNode = currentNode.next;
        }
        this.length--;
    }

    // 리스트의 데이터를 삭제
    public void removeItm(int data) {
        Node currentNode = this;
        Node nextNode = this.next;
        while(true) {
            if(nextNode.data == data) {
                currentNode.next = nextNode.next;
                break;
            }else if(currentNode.data == data) {
                currentNode.data = nextNode.data;
                currentNode.next = nextNode.next;
                break;
            }
            currentNode = nextNode;
            nextNode = currentNode.next;
        }
        this.length--;
    }

    // 리스트에 저장된 데이터 순서대로 출력
    public void loop() {
        boolean isNext = true;
        Node currentNode = this;
        while(isNext){
            if(currentNode.next == null) {
                System.out.println(currentNode.data + "->" + null);
                isNext = false;
            }else{
                System.out.println(currentNode.data + "->" + currentNode.next);
                currentNode = currentNode.next;
            }
        }
    }

    public int size() {
        return this.length;
    }
}

class Stu {
    private int age;

    public Stu(int age) {
        this.age = age;
    }

    public void Show() {
        System.out.println("저는 " + age + "살입니다!");
    }
}

public class Link {
    public static void main(String[] args){

        Node linkedList = new Node(5);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.loop();
        System.out.println(linkedList.size());
        System.out.println("----------------------------------");
        linkedList.removeItm(2);
        linkedList.removeItm(4);
        linkedList.loop();
        System.out.println(linkedList.size());
    }
}
