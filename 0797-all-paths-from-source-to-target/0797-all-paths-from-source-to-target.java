class Solution {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> existingList = new ArrayList<>();
    int target;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        target = graph.length - 1;
        dfs(0,graph);
        return result;
    }

    public void dfs(int node,int[][] graph){
        existingList.add(node);
        
            if(node == target){
                result.add(new ArrayList<>(existingList));
                
                return;
            }
            else{
                for(int children : graph[node]){

                    dfs(children,graph);
                    existingList.remove(existingList.size() - 1);
                }
            }
        }
        
    
}