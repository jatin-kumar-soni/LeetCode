class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int inDegree[]= new int[numCourses];
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
            inDegree[u]++;
        }
        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i] == 0)
            {
                q.add(i);
            }
        }
        ArrayList<Integer>result= new ArrayList<>();
        while(!q.isEmpty())
        {
            int node= q.peek();
            q.remove();
            result.add(node);
            numCourses--;
            for(int neib:adj.get(node))
            {
                inDegree[neib]--;
                if(inDegree[neib] == 0)
                {
                    inDegree[neib]=(inDegree[neib]+1)%2;
                    q.add(neib);
                }
            }
        }
        int ans[]=new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            ans[i]=result.get(i);
        }
        return numCourses > 0 ?  new int[0] : ans;
    }
}