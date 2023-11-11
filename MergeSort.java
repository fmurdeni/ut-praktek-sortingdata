public class MergeSort {

    // Mengurutkan
    public static void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];

        // Memisahkan array menjadi dua bagian
        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, array.length - middle);

        // Memanggil sort rekursif untuk kedua bagian
        sort(left);
        sort(right);

        // Menggabungkan dua bagian yang sudah diurutkan
        merge(array, left, right);
    }

    // Menggabungkan
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        // Menggabungkan dua bagian menjadi satu array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Menyalin sisa elemen dari bagian kiri (jika ada)
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Menyalin sisa elemen dari bagian kanan (jika ada)
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

     // Mencetak data
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // nilai data yang akan diurutkan
        int[] data = { 15, 22, 34, 63, 11, 30 }; 

        System.out.println("Data sebelum diurutkan:");
        printArray(data);

        sort(data);

        System.out.println("\nData setelah diurutkan:");
        printArray(data);
    }

    
}
