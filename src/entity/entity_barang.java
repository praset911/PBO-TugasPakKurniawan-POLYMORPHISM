package entity;
public class entity_barang {
    private int kodeBarang;
    private String nama;

    public entity_barang(int kodeBarang, String nama) {
        this.kodeBarang = kodeBarang;
        this.nama = nama;
    }

    public int getKodeBarang(){
        return kodeBarang;
    }

    public void setNama(String nama){
        this.nama=nama;
    }
    public void cetak(){
        System.out.println();
        System.out.println("kode barang     : "+this.kodeBarang);
        System.out.println("nama barang     : "+this.nama);
    }
}



