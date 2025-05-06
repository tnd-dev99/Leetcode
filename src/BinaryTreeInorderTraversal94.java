import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    BinaryTreeInorderTraversal94(){

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public void recursion(TreeNode treeNode, List<Integer> list){
        if(treeNode == null) return;
        recursion(treeNode.left, list);
        list.add(treeNode.val);
        recursion(treeNode.right, list);
    }
}
