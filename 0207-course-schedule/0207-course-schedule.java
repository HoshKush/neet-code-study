class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] courses = new Node[numCourses];
        for(int i = 0; i < numCourses; i++) {
            courses[i] = new Node();
        }
        for(int[] p : prerequisites) {
            int n = p[0];
            int m = p[1];
            if(n >= numCourses || m >= numCourses) return false;
            courses[n].pre.push(courses[m]);
        }

        for(Node n : courses) {
            if(!dfs(n)) return false;
        }

        return true;
    }

    private boolean dfs(Node n) {
        if(n.isChecking) return false;
        if(n.isChecked()) return true;
        n.isChecking = true;
        while(!n.pre.isEmpty()) {
            if(!dfs(n.pre.pop())) return false;
        }
        n.isChecking = false;
        return true;
    }
}

class Node {
  LinkedList<Node> pre;
  boolean isChecking;
  Node() {
    this.pre = new LinkedList<>();
    isChecking = false;
  }

  boolean isChecked() {
    return pre.isEmpty();
  }
}