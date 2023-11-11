public class CountingSort {    

    // Attribute untuk menyimpan data
    private int[] data;

    // konstruktor
    public CountingSort(int[] data){
        this.data = data;
    }

    // getter
    public int[] getData() {
        return this.data;
    }

    // setter
    public void setData(int[] data) {
        this.data = data;
    }
    
    // method untuk mencetak
    public void printArray(){

        // cetak satu persatu
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        
        
        System.out.println();

    }

    // method untuk mengurutkan
    public void sort(){

        // cari nilai max dan min dari data
        int max = data[0];
        int min = data[0];
        for (int i = 1; i < data.length; i++){
            if (data[i] > max){
                max= data[i];
            } 

            if (data[i] < min) {
                min = data[i];
            }
        }

        // Array penampung sementara
        int[] count = new int[max - min +1];

        // hitung frekuensi setiap elemen data
        for (int i = 0; i < data.length; i++){
            count[data[i] - min]++;
        }

        // hitung jumlah elemen yang kurang dari atau sama dengan setiap elemen data
        for (int i = 1; i < count.length; i++){
            count[i] += count [i -1];
        }

        // buat aray baru
        int[] sorted = new int[data.length];

        // salin elemen data ke array baru sesuai posisi yang dietentukan array sementara
        for (int i = data.length - 1; i >= 0; i--){
            sorted[count[data[i] - min] - 1] = data[i];
            count[data[i] - min]--;
        }

        // saling kembali ke array asli
        for (int i = 0; i < data.length; i++){
            data[i] = sorted[i];
        }
    }

    // terakhir buat main method
    public static void main(String[] args){
        // tentukan nilai data
        int[] data = { 25, 12, 34, 61, 74, 30 };

        // Buat objek 
        CountingSort cs = new CountingSort(data); 

        // Mencetak data sebelum diurutkan
        System.out.println("Data sebelum diurutkan:");
        cs.printArray();

        // Mengurutkan data dengan metode sort
        cs.sort();

        // Mencetak data setelah diurutkan
        System.out.println("Data setelah diurutkan:");
        cs.printArray();

    }

}
