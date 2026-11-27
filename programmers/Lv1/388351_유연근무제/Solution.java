class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int workers = schedules.length;
        
        for(int i = 0; i< workers; ++i){    //사람 수만큼 계산
              boolean event = true;
            for(int j = 0; j<7; ++j){       //7일동안 계산
              
                int day = (startday + j) % 7;
                if(day == 6 || day == 0)        //토욜이나 일욜이면 계산안하고 다음 시행
                    continue;
                int hopeTime = schedules[i];
                int arrive = timelogs[i][j];
                
                if(!safe(hopeTime,arrive)){
                    event = false;
                    break;
                }
                
            }
            if(event){
                answer++;
            }
        }
        return answer;
    }
    
    static boolean safe(int hopeTime, int arrive) {
    int limit = hopeTime + 10;
    if (limit % 100 >= 60)
        limit += 40;
    return arrive <= limit;
}
}