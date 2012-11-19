import java.util.ListIterator;
import java.lang.ClassCastException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Wrapper<T extends Shorter<T>, U> implements Shorter<T> {
  private final T elem;
  private MyList<U> list;

  public Wrapper (T e){
    this.elem = e;
    list = new MyList<U>();
  }

  public T getElem() { return this.elem; }

  public boolean shorter(T o){
    return elem.shorter(o);
  }

  public void add(U listelem){
    list.add(listelem);
  }
  public ListIterator<U> iterator(){
      return this.list.iterator();
    }

  public boolean equals(Wrapper<T,U> that) {
    if(this.elem != that.getElem())
      return false;
    return true;
    }
}

public class OrderedMap<T extends Shorter<T>, U> extends OrderedSet<T> {
  protected MyList<Wrapper<T, U>> wrap_list;

  public OrderedMap (){
    super();
  }

  class MyIterator implements Iterator<T> {
      Iterator<T> iter;
      Wrapper<T,U> cur;

      MyIterator(Iterator<T> i) {
          this.iter = i;
      }

      public boolean hasNext() {
          return iter.hasNext();
      }

      public T next() {
        Wrapper<T, U> tmp = new Wrapper<T, U>(iter.next());
        for(Wrapper<T, U> w : wrap_list) {
          if(w.equals(tmp)) {
            cur = w;
            break;
          }
        }
        
        return cur.getElem();
      }

      public void remove() {
          iter.remove();
      }

      public ListIterator<U> iterator(){
        return cur.iterator();
      }
    }

  @Override
  public void insert(T e){
    if(list.contains(e)) return;

    super.insert(e);

    Wrapper<T,U> wrap = new Wrapper<T,U>(e);
    wrap_list.add(wrap);
  }

  public MyIterator iterator(){
    return new MyIterator(this.list.iterator());

  }
}