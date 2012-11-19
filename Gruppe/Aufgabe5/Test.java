import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;

class OString implements Shorter<OString> {
  final String s;

  public OString(String s) {
    this.s = s;
  }

  public String toString() { return s; }
  public boolean shorter(OString e) {
    return this.toString().length() < e.toString().length();
  }
}

public class Test {
  public static void main(String[] args) {
    MyList<String> l = new MyList<String>();
    ListIterator<String> iter = l.iterator();
    iter.add("Hello");
    iter.add("world");
    iter.add("!");

    System.out.println("===== debug");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    iter = l.iterator();
    System.out.println("advanced to: " + iter.next());
    System.out.println("advanced to: " + iter.next());
    iter.set("badum");

    l.add(3, "how are you?");

    System.out.println("===== debug");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    l.remove(3);

    System.out.println("===== debug");
    for(int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    System.out.println(l.contains("Hello"));
    System.out.println(l.contains(new String("Hello")));

    System.out.println("===== Set Test");
    Set<String> s = new Set<String>();

    s.insert("Hello");
    s.insert("world");
    s.insert("!");
    Iterator<String> siter = s.iterator();

    for(int i=0; i<3 ; i++){
      System.out.println(siter.next());
    }

    System.out.println("===== OrderedSet Test");

    ArrayList<OString> t = new ArrayList<OString>();
    t.add(new OString("hello"));
    t.add(new OString("world"));
    t.add(new OString("how are you?"));
    t.add(new OString("abc"));
    t.add(new OString("def"));
    t.add(new OString("abc"));
    t.add(new OString("123456"));
    t.add(new OString("1234"));
    t.add(new OString("12345"));

    OrderedSet<OString> oset = new OrderedSet<OString>();

    for(OString str : t) {
      // System.out.println("Inserting '" + str + "'");
      oset.insert(str);
      // System.out.println(oset);
    }
    
    System.out.println(oset);


    System.out.println("===== OrderedMap Test");

  }
}