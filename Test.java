给定一个 没有重复 数字的序列，返回其所有可能的全排列。
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        back(nums,0,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    private void back(int[] nums,int len,List<Integer> row,boolean[] isVisited){
        if(len==nums.length){
            res.add(new ArrayList(row));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                row.add(nums[i]);
                back(nums,len+1,row,isVisited);
                isVisited[i]=false;
                row.remove(row.size()-1);
            }
        }
    }
}

public class Main{
    private static int grad(int a,int b){
        while(b!=0){
            int c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            boolean flag=false;
            String str=sc.next();
            int n=0;
            if(str.charAt(0)=='<'){
                n=Integer.parseInt(str.substring(5));
            }else{
                n=Integer.parseInt(str);
            }
            int res=sc.nextInt();
            for(int i=0;i<n-1;i++){
                int b=sc.nextInt();
                if(b<=res){
                    res+=b;
                }else{
                    res+=grad(res,b);
                }
            }
            String t=sc.next();
            int c=0;
            for(int i=0;i<t.length();i++){
                char ch=t.charAt(i);
                if(ch=='<'){
                    flag=true;
                    break;
                }else{
                    c=c*10+(ch-'0');
                }
            }
            if(c<=res){
                res+=c;
            }else{
                res+=grad(res,c);
            }
            System.out.println(res);
            if(flag) break;
        }
    }
}



