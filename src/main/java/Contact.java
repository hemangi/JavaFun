import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Contact {
    class TrieNode {
        public TrieNode(char ch)  {
            value = ch;
            children = new HashMap<>();
            bIsEnd = false;
        }
        public HashMap<Character,TrieNode> getChildren() {   return children;  }
        public char getValue()                           {   return value;     }
        public void setIsEnd(boolean val)                {   bIsEnd = val;     }
        public boolean isEnd()                           {   return bIsEnd;    }

        private char value;
        private HashMap<Character,TrieNode> children;
        private boolean bIsEnd;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> contactToAdd = new ArrayList<>();
        List<String> contactToFind = new ArrayList<>();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) {
                contactToAdd.add(contact);
            } else if(op.contains("find")) {
                contactToFind.add(contact);
            }
        }
        contactToFind.stream().forEach(x -> {
            Predicate <String> predicate = element -> element.contains(x);
            long count = contactToAdd.parallelStream().filter(predicate).count();
            System.out.println(count);

        });
    }
}
