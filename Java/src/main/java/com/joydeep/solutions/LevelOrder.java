package com.joydeep.solutions;

import com.joydeep.utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        if (level > result.size() - 1) {
            result.add(new ArrayList<>());
        }

        result.get(level).add((Integer) root.val);
        levelOrder(root.left, level + 1, result);
        levelOrder(root.right, level + 1, result);

    }

}

