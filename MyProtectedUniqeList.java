import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyProtectedUniqeList<t> implements Iterable {
    private final String password;
    List<t> words=new ArrayList<>();
    private int count=0;
    private int count2=0;
    public MyProtectedUniqeList(String psw){
        password=psw;
    }

    public void add(String pass,String word) {
        if(word==null||word=="")
            throw new RuntimeException("word was not inserted");
        if (pass != password) {
            return;
        }

        for (var k : words){
            if (k == word)
                return;
    }
        words.add((t) word);
    }

    public void remove(String pass,String word){
       if(word==null||word=="")
         throw new RuntimeException("word was not inserted");
       if(pass!=password)
         return;
        words.remove(word);
    }

    public void removeAt(String pass, int i){
        if(i<0||i>words.stream().count())
            throw new RuntimeException("index is out of bounds");
        if(pass!=password)
            return;
        words.remove(i);
    }

    public void clear(String pass){
        if(pass!=password)
            throw new RuntimeException("incorrect password");
        words.clear();
    }

    public void sort(String pass){
        if(pass!=password)
            throw new RuntimeException("incorrect password");
        words.sort(new Comparator<t>() {
            @Override
            public int compare(t o1, t o2) {
                return o1.hashCode()-o2.hashCode();
            }
        });
    }

    public String toString(){
        String s="";
        for(var t:words){
           s+=t+" ";
        }
        return s;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {

            @Override
            public boolean hasNext() {
        if(words.stream().count()>count)
            return false;
        else{
            count++;
            return true;
        }
    }
    @Override
    public t next() {
        return words.get(count2++);
    }
        };
    }
}
