class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr=new int[26];
        int count=0;

        for(char c:sentence.toCharArray()){
            int index=c-'a';
            if(arr[index]==0){
                arr[index]++;
                count++;
            }
        }
        if(count==26)return true;
        return false;
    }
}