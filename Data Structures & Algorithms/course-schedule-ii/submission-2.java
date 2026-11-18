class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] inwardDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            adj.get(preq[1]).add(preq[0]);
            inwardDegree[preq[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(inwardDegree[i] == 0) q.offer(i);
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int course = q.poll(); 
            res[index++] = course;
            for(int course2 : adj.get(course)){
                inwardDegree[course2]--;
                if(inwardDegree[course2]== 0)q.offer(course2);
            }
        }
        if(index != numCourses) return new int[]{};
        return res;
        
    }
}
