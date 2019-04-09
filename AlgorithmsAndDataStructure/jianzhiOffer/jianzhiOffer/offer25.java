package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
	���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 */
public class offer25 {
	ArrayList<ArrayList<Integer> > Print(TreeNode root) {
		ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
		if(root == null)return allList;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> list = new ArrayList<>();
			while(size > 0) {
				TreeNode node = q.remove();
				list.add(node.val);
				if(node.left != null)q.add(node.left);
				if(node.right != null)q.add(node.right);
				size --;
			}
			allList.add(list);
		}
		return allList;
    }
}