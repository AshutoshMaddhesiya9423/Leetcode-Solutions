class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        int n = numCourses;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:prerequisites){
            int a1=edge[0];
            int b1= edge[1];
            adj.get(a1).add(b1);
        }
         int []indegree= new int [n];
        for(int u=0;u<n;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
          Queue<Integer> q = new LinkedList<>();
         for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
         while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.offer(neighbor);
            }
        }
        if(result.size()==n){
            return true;
        }
        return false;
    }
}