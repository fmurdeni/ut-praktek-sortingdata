public class CountingSort {

    public static void sort(int[] array) {
        
        // cari nilai max dan min dari array
        int max = array[0];
        int min = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
     
        
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }

        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[array.length];

        // Menghitung frekuensi kemunculan setiap elemen
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        // Menghitung prefix sum
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Membangun array output
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Menyalin array output ke array asli
        System.arraycopy(output, 0, array, 0, array.length);
    }

    private static void printArray(int[] data) {
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // nilai data
        int[] data = { 25, 12, 34, 61, 74, 30 }; 

        System.out.println("Data sebelum diurutkan:");
        printArray(data);

        sort(data);

        System.out.println("\nData setelah diurutkan:");
        printArray(data);
    }

    
}
