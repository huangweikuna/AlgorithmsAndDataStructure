package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
	��ʵ�������������ֱ��������л��ͷ����л�������
 */
public class offer27 {
	String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if(root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}
	int index = -1;
	TreeNode Deserialize(String str) {
		index ++;
		String strs[] = str.split(",");
		TreeNode root = null;
		if(!strs[index].equals("#")) {
			root = new TreeNode(Integer.parseInt(strs[index]));
			root.left = Deserialize(str);
			root.right = Deserialize(str);
			return root;
		}
		return root;
	}
}