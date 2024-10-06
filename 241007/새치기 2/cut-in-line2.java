import java.io.*;
import java.util.*;

class Node {
    String name;
    Node prev;
    Node next;

    public Node(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}

public class Main {
    // 해쉬맵으로 Node 추적
    // 1. insertPrev
    // 2. pop
    // 3. popRangeAndInsertPrev
    // 4. headChange

    public static final int MAX_N = 100000;
    public static final int MAX_M = 10;
    public static final int MAX_Q = 10000;
    public static int n, m, q, x;
    public static Node[] heads = new Node[MAX_M];
    public static HashMap<String, Node> hm = new HashMap<>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

    public static void main(String[] args) throws IOException {
        init();
        inputMessage();
        printLine();
    }

    public static void inputMessage() throws IOException {

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String a = null;
            String b = null;
            String c = null;
            Node nodeA = null;
            Node nodeB = null;
            Node nodeC = null;

            switch (num) {
                case 1: 
                    a = st.nextToken();
                    b = st.nextToken();
                    nodeA = hm.get(a);
                    nodeB = hm.get(b);

                    headChange(nodeA, nodeA.next);
                    pop(nodeA);

                    insertPrev(nodeA, nodeB);
                    headChange(nodeB, nodeA);
                    break;
                case 2: 
                    a = st.nextToken();
                    nodeA = hm.get(a);

                    headChange(nodeA, nodeA.next);
                    pop(nodeA);
                    break;
                case 3: 
                    a = st.nextToken();
                    b = st.nextToken();
                    c = st.nextToken();
                    nodeA = hm.get(a);
                    nodeB = hm.get(b);
                    nodeC = hm.get(c);

                    headChange(nodeA, nodeB.next);
                    popRangeAndInsertPrev(nodeA, nodeB, nodeC);
                    headChange(nodeC, nodeA);
                    break;
            }
        }
    }

    // 1. insertPrev
    public static void insertPrev(Node front, Node back) {
        front.prev = back.prev;
        front.next = back;
        back.prev = front;

        if (front.prev != null) {
            front.prev.next = front;
        }
    }

    // 2. pop
    public static void pop(Node n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        }

        if (n.next != null) {
            n.next.prev = n.prev;
        }

        n.prev = null;
        n.next = null;
    }

    // 3. popRangeAndInsertPrev
    public static void popRangeAndInsertPrev(Node s, Node e, Node c) {
        connect(s.prev, e.next);

        s.prev = e.next = null;

        connect(c.prev, s);
        connect(e, c);
    }

    // 4. headChange
    public static void headChange(Node origin, Node new_) {
        for (int i = 0; i < m; i++) {
            if (heads[i] == origin) {
                heads[i] = new_;
                return;
            }
        }
    }

    public static void connect(Node s, Node e) {
        if (s != null) {
            s.next = e;
        }

        if (e != null) {
            e.prev = s;
        }
    }

    public static void printLine() {
        for (int i = 0; i < m; i++) {
            Node head = heads[i];

            while (true) {
                if (head == null) break;
                System.out.print(head.name + " ");
                head = head.next;
            }
            
            System.out.println();
        }
    }

    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        x = n / m;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            Node n = new Node(name);
            hm.put(name, n);

            // 줄 수
            int line = i / x;

            // head
            if (i % x == 0) {
                heads[line] = n;
            } else {
                // head가 아닌 경우
                Node head = heads[line];
                while (true) {
                    if (head.next == null) {
                        connect(head, n);
                        break;
                    }

                    head = head.next;
                }
            }
        }
    }
}