class pair{
    int first;
    int second;
    pair(int f,int s)
    {
        this.first=f;
        this.second=s;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(times.length <k)
        {
            return -1;
        }
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int distance[]= new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=0;i<times.length;i++)
        {
            int u=times[i][0]-1;
            int v=times[i][1]-1;
            int wt=times[i][2];
            adj.get(u).add(new pair(v,wt));
        }
        distance[k-1]=0;
        PriorityQueue<pair>pq= new PriorityQueue<>((a,b)->Integer.compare(a.second,b.second));
        pq.add(new pair(k-1,distance[k-1]));
        while(!pq.isEmpty())
        {
            pair p = pq.peek();
            int node=p.first;
            int dt=p.second;
            pq.remove();
            if(distance[node] < dt)
            {
                continue;
            }
            for(pair t : adj.get(node))
            {
                int vertex=t.first;
                int vertexWt=t.second;
                if(distance[vertex] > distance[node]+vertexWt)
                {
                    distance[vertex]=distance[node]+vertexWt;
                    pq.add(new pair(vertex,distance[vertex]));
                }
            }
        }
        Arrays.sort(distance);
        return distance[distance.length-1] == Integer.MAX_VALUE ? -1 : distance[distance.length-1];
    }
}