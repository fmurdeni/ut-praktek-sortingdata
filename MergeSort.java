public class MergeSort {

    // attribute untuk menyimpan data
    private int[] data;

    // konstruktor
    public MergeSort(int[] data){
        this.data = data;
    }

    // getter
    public int[] getData() {
        return data;
    }

    // setter untuk data
    public void setData(int[] data) {
        this.data = data;
    }

    // Method mencetak data
    public void printArray(){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // fungsi untuk membagi data menjadi 2 bagian
    private static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            // Mencari indeks tengah
            int mid = (left + right) / 2;

            // Mengurutkan bagian kiri
            mergeSort(data, left, mid);

            // Mengurutkan bagian kanan
            mergeSort(data, mid + 1, right);

            // Menggabungkan dua bagian yang sudah diurutkan
            merge(data, left, mid, right);
        }
    }

    // Fungsi untuk menggabungkan dua bagian yang diurutkan
    private static void merge(int[] data, int left, int mid, int right) {
        // Membuat array sementara untuk menyimpan data
        int[] temp = new int[right - left + 1];

        // Menentukan indeks awal dari dua bagian
        int i = left;
        int j = mid + 1;
        int k = 0;

        // Membandingkan dan memilih elemen terkecil dari dua bagian
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                temp[k] = data[i];
                i++;
            } else {
                temp[k] = data[j];
                j++;
            }
            k++;
        }

        // Menyalin sisa elemen dari bagian kiri (jika ada)
        while (i <= mid) {
            temp[k] = data[i];
            i++;
            k++;
        }

        // Menyalin sisa elemen dari bagian kanan (jika ada)
        while (j <= right) {
            temp[k] = data[j];
            j++;
            k++;
        }

        // Menyalin kembali elemen dari array sementara ke array asli
        for (i = left; i <= right; i++) {
            data[i] = temp[i - left];
        }
    }

    // buat fungsi method untuk memanggil fungsi mergeSort
    public void sort() {
        mergeSort(data, 0, data.length - 1);
    }

    public static void main(String[] args){
        // berikan nilai sesuai soal
        int[] data = {5,2,4,6,1,3};

        // buat objek dari kelas MergeSort 
        MergeSort ms =  new MergeSort(data);

        // cetak data awal
        System.out.println("Data awal:");  
        ms.printArray();
        
        // panggil method sort()
        ms.sort();

        // data setelah di sort
        System.out.println("MergeSort:");
        ms.printArray();
    }
    
}
