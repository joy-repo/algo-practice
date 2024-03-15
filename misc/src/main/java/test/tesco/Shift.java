package test.tesco;

import java.util.Objects;



/// 0 1 2 3 4 5 6 7 8 9 10
///   t     t     t
///      t          t t


class Shift implements Comparable<Shift> {

  public int start;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Shift shift = (Shift) o;
    return start == shift.start && end == shift.end;
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }

  public int end;

  public Shift(int start, int end){
    this.start=start;
    this.end=end;
    if(end<start)
      this.end=end+24;
  }

  @Override
  public int compareTo(Shift o) {
    return this.start-o.start;
  }
  @Override
  public String toString() {
    return "Shift{" +
        "start=" + start +
        ", end=" + end +
        '}';
  }
}