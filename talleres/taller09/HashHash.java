public class HashHash {

    private int[] array = new int[10];

    public static void main(String[] args) {
        HashHash h = new HashHash();
        h.add("Hola", 10);
        h.add("Iola", 9);
        h.add("Jola", 8);
        h.add("Kola", 7);
        System.out.println(h.get("Iola"));
    }

    public int hasher(String str) {
        return ((int) str.charAt(0)) % 10;
    }

    public void add(String str, int num) {
        int pos = hasher(str);
        array[pos] = num;
    }

    public int get(String str) {
        int algo = hasher(str);
        return array[algo];
    }
}
