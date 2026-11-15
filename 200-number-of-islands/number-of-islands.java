class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        int r=grid.length;
        int c= grid[0].length;
        int row[]={0,0,1,-1};
        int col[]={1,-1,0,0};
        Queue<pair>q= new LinkedList<>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='1')
                {
                    q.add(new pair(i,j));
                    count++;
                    while(!q.isEmpty())
                    {
                        pair p= q.peek();
                        int f=p.first;
                        int s=p.second;
                        q.remove();
                        for(int k=0;k<4;k++)
                        {
                            if(isCheck(f+row[k],s+col[k],r,c) && grid[f+row[k]][s+col[k]] == '1')
                            {
                                grid[f+row[k]][s+col[k]]='0';
                                q.add(new pair(f+row[k],s+col[k]));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public boolean isCheck(int i,int j,int r, int c)
    {
        return i>=0 && i<r && j>=0 && j<c;
    }
}
class pair{
    public int first,second;
    public pair(int f,int s)
    {
        this.first=f;
        this.second=s;
    }
}