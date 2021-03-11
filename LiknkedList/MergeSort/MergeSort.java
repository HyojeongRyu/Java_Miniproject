package LiknkedList.MergeSort;

class Node {
    int data;
    Node next;

    Node() {
        data = 0;
        next = null;
    }
}

class List {
    Node first;

    public List() { first = new Node(); }
    public List(int d) {
        first = new Node();
        first.data = d;
    }

    void addList(List l) {
        if ( first.next == null) first.next = l.first;
        else {
            Node temp = first;
            while(temp.next != null) temp = temp.next;
            temp.next = l.first;
        }
    }

    void addNode(int d) {
        Node nextNode = new Node();
        nextNode.data = d;

        if (first.next == null) first.next = nextNode;
        else {
            Node temp = first;
            while (temp.next != null) temp = temp.next;
            temp.next = nextNode;
        }
    }

    void showList() {
        Node temp = this.first;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}

class ListIter {
    List list;
    Node node;
    int data;

    ListIter(List l) {
        list = l;
        node = l.first;
        data = l.first.data;
    }

    Node next() {   //the temp node goes to next node
        node = node.next;
        return node;
    }

    boolean NotNull() { //if the node is null, return false
        if (node != null) return true;
        else return false;
    }

    boolean NotNextNull() { //if the next node is null, return false
        if (node.next != null) return true;
        else return false;
    }
}

class Sort {
    List list;
    Node node;

    Sort(List l) {
        this.list = l;
        this.node = l.first;
    }

    int count() {   //count the number of nodes
        ListIter iter = new ListIter(list);
        int c = 0;
        while (iter.NotNextNull() == true) {
            iter.next();
            c++;
        }
        return c;
    }

    void SimpleSplit(List s, List e) {
        int count=0;
        Node temp = s.first;
        while(temp!=null){
            temp = temp.next;
            count++;
        }

        int i = 0;
        Node temp2 = s.first;
        while (i != count/ 2 - 1) {
            temp2 = temp.next;
            i++;
        }
        e.first = temp2.next;
        temp2.next = null;
    }

    List[] Split() {
        int c = this.count();
        List[] arr = new List[c];
        arr[0] = list;

        int start = 0;
        int end = 1;

        while (start != end) {
            while (arr[0].first.next != null) {
                SimpleSplit(arr[start], arr[end]);
                end++;
            }
            start++;
        }
        return arr;
    }

    void SimpleMerge(List p, List q) {
        Node a, b, rs, head;
        a = p.first;
        b = q.first;
        head = null;
        rs = null;

        while (a != null || b != null) {
            if (head == null) {
                if (a.data <= b.data) {
                    head = a;
                    rs = head;
                    a = a.next;
                } else {
                    head = b;
                    rs = head;
                    b = b.next;
                }
            } else {
                if (a.data <= b.data) {
                    rs.next = a;
                    rs = a;
                    a = a.next;
                } else {
                    rs.next = b;
                    rs = b;
                    b = b.next;
                }
            }
            rs.next = null;
        }
        if (a != null) rs.next = a;
        if (b != null) rs.next = b;
    }

    void Merge(List[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            Merge(arr, start, mid);
            Merge(arr, mid + 1, end);

            int p = start;
            int q = mid + 1;
            SimpleMerge(arr[p], arr[q]);
        }
    }
}

public class MergeSort {
    public static void main(String[] args) {

        List l1 = new List(2);
        l1.addNode(1);
        l1.addNode(3);

        List l2 = new List(4);
        l2.addNode(6);
        l2.addNode(5);
        l2.addNode(8);
        l2.addNode(7);

        l1.addList(l2);

        Sort sort_l1 = new Sort(l1);
        int count = sort_l1.count();

        List[] arr= sort_l1.Split();
        sort_l1.Merge(arr,0, count);
        l1.showList();
    }
}