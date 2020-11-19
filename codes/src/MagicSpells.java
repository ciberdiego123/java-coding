import java.util.*;

public class MagicSpells {

    static Map<Character, SortedSet<Integer>> createIndexDictionary(String base){
        Map<Character, SortedSet<Integer>> d = new HashMap<>();
        for (int i = 0; i < base.length(); i++) {
            if(!d.containsKey(base.charAt(i))){
                SortedSet<Integer> indexes = new TreeSet<>();
                indexes.add(i);
                d.put(base.charAt(i), indexes);
            }else{
                d.get(base.charAt(i)).add(i);
            }
        }
        return d;
    }

    static String longestSpell(Map<Character, SortedSet<Integer>> d, String word){
        StringBuilder spell = new StringBuilder();
        int k = -1;
        for (int i = 0; i < word.length(); i++) {
            if(d.containsKey(word.charAt(i))){
                SortedSet<Integer> indexes = d.get(word.charAt(i))
                        .tailSet(k+1);
                if(indexes.isEmpty())
                    break;
                int mini = indexes.first();
                if(mini > k){
                    k=mini;
                    spell.append(word.charAt(i));
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return spell.length() > 0 ? spell.toString() : "IMPOSSIBLE";
    }

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        var d = createIndexDictionary(s);
        for (int i = 0; i < n; i++) {
            String l = in.next();
            System.out.println(longestSpell(d, l));
        }
    }

}
