int[] array1 = new int[] {1, 2}
int[] array2 = new int[] {1, 2}
set.add(array1), ---> return true
set.add{array2} --> return true

List<Integer> list1 = new ArrayList<>(); {1, 2}
List<Integer> list2 = new ArrayList<>(); {1, 2}
set.add(list1); --> return true
set.add(list2); --> return false

because lisy 改写了 hashset 的 equals 原本返回的是reference 所以第一个全对，第二个是T,false

if hashmap is n size, give n/0.75 size array for hashmap

