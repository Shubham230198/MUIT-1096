 /********************************************************************4-Feb, 2021*********************************************/
class Doubts {
    public static int getHeight(Node root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


    public static int getDiameter(Node root) {

        //base
        if(root == null) {                    //invalid diameter
            return Integer.MIN_VALUE;
        }
        else if(root.left == null && root.right == null) {        //leaf node
            return 1;
        }

        //left ka diameter mangalo
        int leftDia = getDiameter(root.left);

        //right ka diameter magalo
        int rightDia = getDiameter(root.right);


        //case-1
        int leftHeight = Integer.MIN_VALUE;
        if(root.left != null)
            leftHeight = getHeight(root.left);

        int rightHeight = Integer.MIN_VALUE;
        if(root.right != null)
            rightHeight = getHeight(root.right);

        int case1 = leftHeight + rightHeight + 1;

        //case2
        int case2 = leftDia;

        //case3
        int case3 = rightDia;

        //return max of case1, case2, case3
        return Math.max(case1, Math.max(case2, case3));

    }



    public static ArrayList<Integer> nodeToRootPath(Node root, int data) {

        if(root == null) {
            return new ArrayList<>();
        }


        if(root.val == data) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.val);

            return ans;
        }


        ArrayList<Integer> left = nodeToRootPath(root.left, data);
        if(left.size() > 0) {
            left.add(root.val);

            return left;
        }

        ArrayList<Integer> right = nodeToRootPath(root.right, data);
        if(right.size() > 0) {
            right.add(root.val);

            return right;
        }

        return new ArrayList<>();
    }


    public static int getLCA(Node root, int data1, int data2) {

        ArrayList<Integer> data1Path = nodeToRootPath(root, data1);
        ArrayList<Integer> data2Path = nodeToRootPath(root, data2);

        int i = data1Path.size() - 1;
        int j = data2Path.size() - 1;
        int lca = -1;

        while(i >= 0 && j >= 0) {
            if(data1Path.get(i) == data2Path.get(j)) {
                lca = data1Path.get(i);
                i--;
                j--;
            }
            else {
                break;
            }
        }

        return lca;
    }


    public static void main(String[] args) throws InterruptedException {

        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(16);


        root.right.left = new Node(27);
        root.right.right = new Node(42);
        root.right.right.right = new Node(14);
        root.right.left.left = new Node(13);
        root.right.left.left.left = new Node(18);



//
//        int diameter = getDiameter(root);
//        System.out.println(diameter);


        int data1 = 27;
        int data2 = 1;
        int lca = getLCA(root, data1, data2);
        System.out.println(lca);



    }



}

