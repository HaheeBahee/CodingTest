// 알파벳 배열 spell, 외계어 배열 dic 
// spell의 모든 알파벳을 한 번씩만 사용한 단어 있으면 1, 없으면 2

// => dic과 Spell을 정렬해서 비교하자

import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        // spell 정렬
        char[] spellChars = String.join("", spell).toCharArray();
        Arrays.sort(spellChars);
        String spellSorted = new String(spellChars);  // "dxz"

        // dic 각 단어 정렬해서 비교
        for (String word : dic) {
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String wordSorted = new String(wordChars);  // "dxz"

            if (spellSorted.equals(wordSorted)) {
                return 1;
            }
        }

        return 2;

    }
}