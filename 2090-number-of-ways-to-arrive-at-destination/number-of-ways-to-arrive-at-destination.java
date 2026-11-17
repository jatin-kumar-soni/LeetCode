class pair{
    int first;
    long second;
    pair(int f,long s)
    {
        this.first= f;
        this.second=s;

    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
            ArrayList<ArrayList<pair>>adj= new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<roads.length;i++)
            {
                int u=roads[i][0];
                int v=roads[i][1];
                int wt=roads[i][2];
                adj.get(u).add(new pair(v,wt));
                adj.get(v).add(new pair(u,wt));
            }
            long distance[]=new long[n];
            Arrays.fill(distance,Long.MAX_VALUE);
            PriorityQueue<pair>pq= new PriorityQueue<>((a,b)->Long.compare(a.second,b.second));
            int ways[]=new int[n];
            Arrays.fill(ways,0);
            ways[0]=1;
            distance[0]=0;
            pq.add(new pair(0,0));
            while(!pq.isEmpty())
            {
                pair p= pq.peek();
                int node=p.first;
                long dt=p.second;
                pq.remove();
                if(dt > distance[node])
                {
                    continue;
                }
                for(pair q : adj.get(node))
                {
                    int vertex=q.first;
                    long vertexWt=q.second;
                    long newDistance= distance[node]+vertexWt;
                    if(newDistance  < distance[vertex])
                    {
                        distance[vertex]=newDistance;
                        ways[vertex]=ways[node];
                        pq.add(new pair(vertex,newDistance));

                    }
                    else if(newDistance == distance[vertex])
                    {
                        ways[vertex]=(int) ((ways[vertex]+ (long) ways[node]) %1000000007);
                    }
                }
            }
          return ways[n-1];
    }
}