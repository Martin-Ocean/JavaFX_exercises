package Exercise_19_1;

public class GenericStack<E> {
  private Object[] list;

  public GenericStack(int l) {
    list = new Object[l];
  }

  public int getSize() {
    return list.length;
  }

  public E peek() {
    int index = -1;
    for (int i = 0; i < list.length; i++) {
      if (list[i] == null) {
        index = i;
        break;
      }
    }
    if (index != -1) {
      return (E) list[index];
    }
    return (E) list[list.length-1];
  }

  public void push(E o) {
    int index = -1;
    for (int i = 0; i < list.length; i++) {
      if (list[i] == null) {
        index = i;
        break;
      }
    }

    if (index == -1) {
      Object[] temp = new Object[list.length*2];
      for (int i = 0; i < list.length; i++) {
        temp[i] = list[i];
      }

      list = new Object[temp.length];

      for (int i = 0; i < temp.length; i++) {
        list[i] = temp[i];
      }
    } else {
      list[index] = o;
    }

  }

  public E pop() {
    int index = -1;
    for (int i = 0; i < list.length; i++) {
      if (list[i] == null) {
        index = i;
        break;
      }
    }
    if (index != -1) {
      E o = (E) list[index];
      list[index] = null;
    }
    E o = (E)list[list.length-1];
    list[list.length-1] = null;
    return o;
  }

  public boolean isEmpty() {
    int index = -1;
    for (int i = 0; i < list.length; i++) {
      if (list[i] == null) {
        index = i;
        break;
      }
    }
    if (index == 0) {
      return true;
    }
    return false;
  }
  
  @Override
  public String toString() {
	return "stack: " + list.toString();
  }
}
