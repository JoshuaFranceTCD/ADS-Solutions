/* Kahns Algorithm Solution 2: build adjacency list using a -> b, meaning a can be done after b. Inward edges = 0,no courses require this to be completed, so it can be done last. Build topological order in reverse */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int [numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();

        // courses that arent prerequisites for any other courses will be done last
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }


        int index = numCourses - 1;
        int[] output = new int[numCourses];
        while (!q.isEmpty()) {
            int node = q.poll();
            output[index--] = node;
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        if (index != -1) {
            return new int[0];
        }
        return output;



        
    }
}
