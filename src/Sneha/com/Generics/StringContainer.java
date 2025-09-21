package Sneha.com.Generics;

public class StringContainer<T> implements Container<T>{
      
      private T item;
      
      @Override
      public void add(T s) {
            this.item = s;
      }
      
      @Override
      public T get() {
            return this.item;
      }
}
