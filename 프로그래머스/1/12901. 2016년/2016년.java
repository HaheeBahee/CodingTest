
class Solution {
    public String solution(int a, int b) {
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int totalDays = 0;
        
        for (int i = 0; i < a - 1; i++) {
            totalDays += days[i];
        }
        
        totalDays += b;
        int dayIndex = (totalDays + 4) % 7; 
        return week[dayIndex];
    
    }
}
