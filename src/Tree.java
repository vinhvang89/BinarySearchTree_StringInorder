public class Tree {
    Node root;
    private int size ;
    public Tree(){

    }
    public Tree(String[] arrays){
        for (int i = 0 ; i < arrays.length;i++){
            insert(arrays[i]);
        }
    }
    private class Node{
        Node left;
        Node right;
        String data;
        public Node(String data){
            this.data = data;
        }
    }
    public boolean insert(String data){
        if( root == null)
            root = new Node(data);
        else {
            Node parent = null;
            Node current = root;
            while (current != null) {
                if (data.compareTo(current.data) > 0) {
                    parent = current;
                    current = current.right;
                } else if (data.compareTo(current.data) < 0) {
                    parent = current;
                    current = current.left;
                } else
                    return false;
            }
            if( data.compareTo(parent.data) > 0)
                parent.right = new Node(data);
            if ( data.compareTo(parent.data) < 0)
                parent.left = new Node(data);
        }
        size++;
        return true;
    }
    private void inorder(Node root){
        if ( root == null)
            return;
        inorder(root.left);
        System.out.print(root.data +" , ");
        inorder(root.right);
    }
    public void getSize(){
        System.out.println("This size of Tree is :" +size);
    }
    public void inorder(){
        inorder(root);
    }

}
