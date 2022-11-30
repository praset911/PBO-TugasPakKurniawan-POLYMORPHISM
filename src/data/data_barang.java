package data;
import entity.entity_barang2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class data_barang {
    Scanner input = new Scanner(System.in);
    private ArrayList <entity_barang2> data_barang;
    public static int i;

    public data_barang()
    {
        this.data_barang = new ArrayList<>();
    }

    public void create(int kode, String nama, int harga, int stok)
    {
        i++;
        this.data_barang.add(new entity_barang2(kode,nama,harga,stok));
    }

    public void updateNameByKodeBarang(int kodeBarang, String Nama)
    {
        int index = this.search(kodeBarang);
        if (index == -1)
        {
            System.out.println("\ndata tidak ditemukan");
        }
        else
        {
            this.data_barang.get(index).setNama(Nama);
            System.out.println("\ndata dengan kode barang "+kodeBarang+" berhasil diupdate");
        }
    }

    public void deleteByKodeBarang(int kodeBarang)
    {
        int index = this.search(kodeBarang);
        if (index == -1)
        {
            System.out.println("\ndata tidak ditemukan");
        }
        else
        {
            this.data_barang.remove(index);
            System.out.println("\ndata dengan KodeBarang "+kodeBarang +" berhasil dihapus");
        }
    }

    private int search(int kodeBarang)
    {
        for (int i=0;i<this.data_barang.size();i++)
        {
            if (kodeBarang == this.data_barang.get(i).getKodeBarang())
            {
                return i;
            }
        }
        return -1;
    }
    public void view()
    {
        if(data_barang.isEmpty()){
            System.out.println("\nBARANG KOSONG");
            System.out.println();
        }
        else {
            for (int i = 0; i < this.data_barang.size(); i++) {
                this.data_barang.get(i).cetak();
            }
        }
    }

    public void view(int index)
    {
         this.data_barang.get(index).cetak();
    }

    public void tambahBarang(){
        System.out.print("\nMASUKKAN KODE BARANG : ");
        int kode = input.nextInt();
        input.nextLine();
        System.out.print("MASUKKAN NAMA BARANG : ");
        String nama = input.nextLine();
        System.out.print("MASUKKAN HARGA       : ");
        int harga = input.nextInt();
        input.nextLine();
        System.out.print("MASUKKAN STOK        : ");
        int stok = input.nextInt();
        input.nextLine();

        create(kode, nama, harga, stok);

    }

    public void lihatBarangByIndex(){
        if(data_barang.isEmpty()){
            System.out.println("\nBARANG KOSONG");
            System.out.println();
        }
        else {
            System.out.println("\nTOTAL INDEX          : " +i);
            System.out.print("VIEW BARANG INDEX KE : ");
            int index = input.nextInt();
            input.nextLine();
            view(index-1);
        }
    }

    public void update(){
        if(data_barang.isEmpty()){
            System.out.println("\nBARANG KOSONG");
            System.out.println();
        }
        else {
            System.out.print("\nMASUKKAN KODE BARANG : ");
            int kodeBarang = input.nextInt();
            input.nextLine();
            System.out.print("MASUKKAN NEW NAME    : ");
            String newName = input.nextLine();
            updateNameByKodeBarang(kodeBarang, newName);
        }
    }

    public void delete(){
        i--;
        if(data_barang.isEmpty()){
            System.out.println("\nBARANG KOSONG");
            System.out.println();
        }
        else {
            System.out.print("MASUKKAN KODE BARANG : ");
            int kodeBarang = input.nextInt();
            input.nextLine();
            deleteByKodeBarang(kodeBarang);
        }
    }

    public void exit(){
        System.out.println("\nEXIT....");
    }

    public void warning(){
        System.out.println("\nKODE INPUT SALAH");
    }
    public void menu(){
        int Scan;
        do {
            System.out.println("""
                    
                    1.CreateBarang
                    2.ViewBarangIndexTertentu
                    3.ViewAllBarang
                    4.UpdateNamaBarang
                    5.DeleteNamaBarang
                    0.exit""");
            System.out.print("INPUT : ");
            Scan = input.nextInt();

            switch (Scan) {
                case 1 -> tambahBarang();
                case 2 -> lihatBarangByIndex();
                case 3 -> view();
                case 4 -> update();
                case 5 -> delete();
                case 0 -> exit();
                default -> warning();
            }
        }while(Scan != 0);
    }
}
