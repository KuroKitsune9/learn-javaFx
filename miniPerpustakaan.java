import java.util.ArrayList;

public class miniPerpustakaan {
    public static void main(String[] args) {
        Perpustakaan perpus = new Perpustakaan("Gramedia");

        perpus.jalankanSimulasi();

        perpus.tampilkanKoleksiBuku();
        perpus.tampilkanLogPeminjaman();
    }
}

class Buku {
    String isbn, judul, pengarang;
    Boolean statusDipinjam;

    public Buku(String isbn, String judul, String pengarang) {
        this.isbn = isbn;
        this.judul = judul;
        this.pengarang = pengarang;
        this.statusDipinjam = false;
    }
}

class Anggota {
    String idAnggota, nama;

    public Anggota(String idAnggota, String nama) {
        this.idAnggota = idAnggota;
        this.nama = nama;
    }
}

class Perpustakaan {
    String nama;
    ArrayList<Buku> koleksiBuku;
    ArrayList<String> daftarPeminjam;

    public Perpustakaan(String nama) {
        this.nama = nama;
        this.koleksiBuku = new ArrayList<>();
        this.daftarPeminjam = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        koleksiBuku.add(buku);
    }

    public Buku cariBuku(String isbn) {
        for (Buku buku : koleksiBuku) {
            if (buku.isbn.equals(isbn)) {
                return buku;
            }
        }
        return null;
    }

    public void pinjamBuku(String isbn, String idAnggota) {
        Buku buku = cariBuku(isbn);

        if (buku == null) {
            System.out.println("Buku tidak ditemukan");
        } else if (buku.statusDipinjam) {
            System.out.println("Buku" + buku.judul + " sedang dipinjam");
        } else {
            buku.statusDipinjam = true;
            daftarPeminjam.add("Anggota " + idAnggota + " meminjam buku " + buku.judul);
            System.out.println("Buku " + buku.judul + " berhasil dipinjam oleh anggota " + idAnggota);
        }
    }

    public void tampilkanKoleksiBuku() {
        System.out.println("\nkoleksi Buku di " + nama + ":");
        for (Buku b : koleksiBuku) {
            String status = b.statusDipinjam ? "Dipinjam" : "Tersedia";
            System.out.println(
                    "ISBN: " + b.isbn + ", Judul: " + b.judul + ", Pengarang: " + b.pengarang + ", Status: " + status);
        }
    }

    public void tampilkanLogPeminjaman() {
        System.out.println("\n Log peminjaman di " + nama + ":");
        if (daftarPeminjam.isEmpty()) {
            System.out.println("Belum ada peminjaman");
        } else {
            for (String log : daftarPeminjam) {
                System.out.println("- " + log);
            }
        }
    }

    // melakukan testing
    public void jalankanSimulasi() {
        tambahBuku(new Buku("001", "Strings Attached", "Firnita"));
        tambahBuku(new Buku("002", "Sesuk", "Tere Liye"));
        tambahBuku(new Buku("003", "Strings Attached", "Firnita"));

        Anggota a1 = new Anggota("A001", "Rafi");
        Anggota a2 = new Anggota("A002", "Amara");

        System.out.println("\n prosess peminjaman buku:");
        pinjamBuku("001", a1.idAnggota); // berhasil
        pinjamBuku("002", a2.idAnggota); // berhasil
        pinjamBuku("004", a2.idAnggota); // buku tidak ditemuukan
        pinjamBuku("003", a2.idAnggota); // berhasil
    }
}