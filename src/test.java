import java.util.*;

public class test {


//    public static int editDistance(String A, String B) {
//
//        //base case
//        if(A.length() == 0 && B.length() == 0) {
//            return 0;
//        }
//        else if(A.length() == 0) {
//            return B.length();
//        }
//        else if(B.length() == 0) {
//            return A.length();
//        }
//
//        char last_of_A = A.charAt(A.length() - 1);
//        char last_of_B = B.charAt(B.length() - 1);
//
//        if(last_of_B == last_of_A) {
//            //just make the next call
//            String rem_ques_of_A = A.substring(0,A.length() - 1);
//            String rem_ques_of_B = B.substring(0, B.length() - 1);
//
//            int rem_operations = editDistance(rem_ques_of_A, rem_ques_of_B);
//
//            return rem_operations;
//        }
//        else {
//            String rem_ques_of_A = A.substring(0,A.length() - 1);
//            String rem_ques_of_B = B.substring(0, B.length() - 1);
//
//            //add
//            int rem_operations_on_add = editDistance(rem_ques_of_A, B);
//
//            //delete
//            int rem_operations_on_delete = editDistance(A, rem_ques_of_B);
//
//            //update
//            int rem_operations_on_update = editDistance(rem_ques_of_A, rem_ques_of_B);
//
//
//            return (Math.min(rem_operations_on_add, Math.min(rem_operations_on_delete, rem_operations_on_update)) + 1);
//        }
//    }
//
//
//    public static int editDistanceTB(String A, String B) {
//        int[][] dp = new int[A.length() + 1][B.length() + 1];
//
//        for(int i = 0; i < dp.length; i++) {
//            for(int j = 0; j < dp[0].length; j++) {
//                //first part
//                if(i == 0 && j == 0) {
//                    dp[i][j] = 0;
//                }
//                else if(j == 0) {    //second part
//                    dp[i][j] = i;
//                }
//                else if(i == 0) {    //third part
//                    dp[i][j] = j;
//                }
//                else {                //fourth part
//
//                    char rowCharacter = A.charAt(i - 1);
//                    char colCharacter = B.charAt(j - 1);
//
//                    if(rowCharacter == colCharacter) {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                    else {
//
//                        int add_operations = dp[i - 1][j];
//                        int upadate_operations = dp[i - 1][j - 1];
//                        int delete_operations = dp[i][j - 1];
//
//                        int min_operations = Math.min(add_operations, Math.min(upadate_operations, delete_operations));
//
//                        dp[i][j] = min_operations + 1;
//                    }
//                }
//            }
//        }
//
//        return dp[dp.length - 1][dp[0].length - 1];
//
//    }





    public static class Node {
        int val;
        Node left;
        Node right;

        Node (int val) {
            this.val = val;
        }
    }

    public static int getSize(Node root) {
        //base case
        if(root == null) {
            return 0;
        }

        //left se size mangao
        int leftSize = getSize(root.left);

        //right se size mangao
        int rightSize = getSize(root.right);

        return leftSize + rightSize + 1;
    }


    public static boolean checkForDivide(Node root, int totalSize) {
        //base case
        if(root == null) {
            return false;
        }

        int nowNodeSize = getSize(root);

        if(nowNodeSize * 2 == totalSize) {
            return true;
        }

        boolean isLeftPossible = checkForDivide(root.left, totalSize);
        if(isLeftPossible == true) {
            return true;
        }

        boolean isRightPossible = checkForDivide(root.right, totalSize);
        if(isRightPossible == true) {
            return true;
        }

        return false;

    }


    public static boolean printAncestors(Node root, int key) {
        //base case
        if(root == null) {
            return false;
        }

        //if i am key
        if(root.val == key) {
            return true;
        }

        boolean ifLeftPresent = printAncestors(root.left, key);
        if(ifLeftPresent == true) {
            System.out.println(root.val);
            return true;
        }

        boolean ifRightPresent = printAncestors(root.right, key);
        if(ifRightPresent == true) {
            System.out.println(root.val);
            return true;
        }

        return false;
    }


    static int ceil = Integer.MAX_VALUE;
    public static void findCeil(Node root, int key) {
        //base case
        if(root == null) {
            return;
        }

        //if node.val >= key, then this could be a answer
        if(root.val >= key) {
            if(root.val < ceil) {
                ceil = root.val;
            }
        }

        findCeil(root.left, key);
        findCeil(root.right, key);


    }


    /********************************************************************4-Feb, 2021*********************************************/

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
//        int size = getSize(root);
////        System.out.println(size);
//
//        boolean isDividingPossible = checkForDivide(root, size);
//        System.out.println(isDividingPossible);

//
//        int key = 13;
//        printAncestors(root, key);

//        int key = 14;
//        findCeil(root, key);
//        System.out.println(ceil);


//
//        int diameter = getDiameter(root);
//        System.out.println(diameter);


        int data1 = 27;
        int data2 = 1;
        int lca = getLCA(root, data1, data2);
        System.out.println(lca);



    }



}





















