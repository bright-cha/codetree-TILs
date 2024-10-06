import java.io.*;
import java.util.*;

class Node {
    String data;
    Node prev;
    Node next;

    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class Message {
    int num;
    String a;
    String b;
    String c;

    public Message(int num, String a, String b, String c) {
        this.num = num;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_M = 10;
    public static final int MAX_Q = 10000;

    public static int n, m, q;
    public static Node[] nameArr = new Node[MAX_N];
    public static Message[] messageArr = new Message[MAX_Q];
    public static Node[] lineArr = new Node[MAX_M];
    public static HashMap<String, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        makeLine();
        simulation();

        for (int i = 0; i < m; i++) {
            if (lineArr[i] != null) {
                Node n = lineArr[i];
                while (true) {
                    System.out.print(n.data + " ");

                    if (n.next == null) break;
                    n = n.next;
                }
                System.out.println();
                continue;
            }

            System.out.println(-1);
        }
    }

    public static void simulation() {
        for (int i = 0; i < q; i++) {
            Message message = messageArr[i];
            Node nodeA = null;
            Node nodeB = null;
            Node nodeC = null;
            nodeA = map.get(message.a);

            if (message.b != null) {
                nodeB = map.get(message.b);
            }

            if (message.c != null) {
                nodeC = map.get(message.c);
            }

            switch (message.num) {
            case 1:
                changeFirst(nodeA, nodeB);
                pop(nodeA);
                insertPrev(nodeA, nodeB);
                break;
            case 2: 
                popLine(nodeA);
                pop(nodeA);
                break;
            case 3:
                changeFirst(nodeA, nodeC);
                popRangeAndInsertPrev(nodeA, nodeB, nodeC);
                break;
            }
        }
    }

    public static void changeFirst(Node nodeA, Node nodeB) {
        for (int i = 0; i < m; i++) {
            if (lineArr[i] == nodeB) {
                lineArr[i] = nodeA;
            }
        }
    }

    public static void popLine(Node n) {
        for (int i = 0; i < m; i++) {
            if (lineArr[i] == n) {
                if (n.next != null) {
                    lineArr[i] = n.next;
                    return;
                }

                lineArr[i] = null;
                return;
            }
        }
    }

    public static void makeLine() {
        for (int i = 0; i < n; i++) {
            if (i % m == 0) {
                lineArr[i / m] = nameArr[i];
                continue;
            }

            // 2회차부터 Node 연결
            Node s = lineArr[i / m];
            Node e = nameArr[i];

            insertNext(s, e);
        }
    }

    public static void popRangeAndInsertPrev(Node s, Node e, Node v) {
        connect(s.prev, e.next);

        s.prev = e.next = null;
        
        connect(v.prev, s);
        connect(e, v);
    }

    public static void insertPrev(Node singleton, Node u) {
        singleton.next = u;
        singleton.prev = u.prev;
        u.prev = singleton;

        if (singleton.prev != null) {
            u.prev.next = singleton;
        }
    }

    public static void insertNext(Node u, Node singleton) {
        singleton.prev = u;
        singleton.next = u.next;
        u.next = singleton;

        if (singleton.next != null) {
            singleton.next.prev = singleton;
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

    public static void pop(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.prev = node.next = null;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            Node node = new Node(name);

            nameArr[i] = node;
            map.put(name, node);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            
            int num = Integer.parseInt(st.nextToken());

            String name1 = st.nextToken();
            String name2 = null;
            String name3 = null;

            switch (num) {
            case 1:
                name2 = st.nextToken();
                break;
            case 3:
                name2 = st.nextToken();
                name3 = st.nextToken();
                break;
            }

            messageArr[i] = new Message(num, name1, name2, name3);
        }
    }
}