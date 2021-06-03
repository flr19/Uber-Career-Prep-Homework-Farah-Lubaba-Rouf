public class PhoneBookTree implements PhoneBook {
    private Node root;
    @Override
    public int size() {
        return 0;
    }

    @Override
    public void insert(String name,long phoneNumber) {
        root=insertRoot(name,phoneNumber,root);
    }
    private Node insertRoot(String name, long phoneNumber,Node root) {
        if(root==null) {
            Node newnode= new Node(name,phoneNumber);
            return newnode;
        }
        if(phoneNumber<root.phoneNumber) {
            root.left=insertRoot(name,phoneNumber,root.left);
        }
        else if(phoneNumber>=root.phoneNumber) {
            root.right=insertRoot(name,phoneNumber,root.right);
        }
        return root;
    }

    @Override
    public long find(String name) {
        if (root==null || root.name==name)
            return root.phoneNumber;

        // Key is greater than root's key
        if (root.name < name)
            return search(root.right, key);
        

        // Key is smaller than root's key
        return search(root.left, key);
        return 0;
    }
    public static class Node {
        public String name;
        public long phoneNumber;
        public Node left;
        public Node right;

        public Node(String myName,long myNumber) {
            name=myName;
            phoneNumber=myNumber;
            left=null;
            right=null;
        }
    }
}
