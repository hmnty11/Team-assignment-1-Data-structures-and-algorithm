// Identitas Kelompok
// Nama Anggota 1: DARREN JEHONATHAN - 2902714100
// Nama Anggota 2: JOSHUA CHRISTIAN SUPIT- 2902706736
// Nama Anggota 3: GABRIEL SIGALINGGING - 2902724442
// Nama Anggota 4: RENATA MUTIARA NIRWANA - 2902733131
// Nama Anggota 5: EVELYN KIMORA TJIU - 2902692466


/**
 * Class Lagu merepresentasikan sebuah lagu dengan judul, artis, dan durasi.
 */
class Lagu {
    private String judul;
    private String artis;
    private double durasi; // dalam menit

    // Constructor
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Getter
    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public double getDurasi() {
        return durasi;
    }

    // Setter
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

    // Menampilkan info lagu
    public void tampilkanInfo() {
        System.out.println("Judul  : " + judul);
        System.out.println("Artis  : " + artis);
        System.out.println("Durasi : " + durasi + " menit");
    }
}

/**
 * Class Playlist mengelola kumpulan lagu menggunakan array.
 */
class Playlist {
    private Lagu[] daftarLagu;
    private int jumlahLagu;
    private final int KAPASITAS = 10; // maksimal 10 lagu

    public Playlist() {
        daftarLagu = new Lagu[KAPASITAS];
        jumlahLagu = 0;
    }

    // Menambahkan lagu ke playlist
    public boolean tambahLagu(Lagu lagu) {
        if (jumlahLagu < KAPASITAS) {
            daftarLagu[jumlahLagu] = lagu;
            jumlahLagu++;
            return true;
        } else {
            System.out.println("Playlist penuh! Tidak dapat menambah lagu.");
            return false;
        }
    }

    // Menampilkan semua lagu di playlist
    public void tampilkanSemua() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong.");
            return;
        }
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println("Lagu ke-" + (i + 1));
            daftarLagu[i].tampilkanInfo();
            System.out.println();
        }
    }

    // Mencari lagu berdasarkan judul (mengembalikan indeks, -1 jika tidak ditemukan)
    public int cariLagu(String judul) {
        for (int i = 0; i < jumlahLagu; i++) {
            if (daftarLagu[i].getJudul().equalsIgnoreCase(judul)) {
                return i;
            }
        }
        return -1;
    }

    // Menghitung rata-rata durasi semua lagu
    public double hitungRataDurasi() {
        if (jumlahLagu == 0) return 0;
        double total = 0;
        for (int i = 0; i < jumlahLagu; i++) {
            total += daftarLagu[i].getDurasi();
        }
        return total / jumlahLagu;
    }

    // Getter jumlah lagu (untuk keperluan lain)
    public int getJumlahLagu() {
        return jumlahLagu;
    }

    // Mendapatkan lagu berdasarkan indeks (untuk member)
    public Lagu getLagu(int indeks) {
        if (indeks >= 0 && indeks < jumlahLagu) {
            return daftarLagu[indeks];
        }
        return null;
    }
}

/**
 * Class User sebagai parent class (abstrak bisa, tapi kita buat konkret dengan method umum)
 */
class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    // Method yang akan di-override oleh child class (polymorphism)
    public void tampilkanAkses() {
        System.out.println("User " + username + " memiliki akses umum.");
    }

    public String getUsername() {
        return username;
    }
}

/**
 * Class Admin sebagai turunan User.
 */
class Admin extends User {
    public Admin(String username) {
        super(username);
    }

    // Override method tampilkanAkses
    @Override
    public void tampilkanAkses() {
        System.out.println("Admin " + username + " memiliki akses untuk menambah lagu.");
    }

    // Method khusus admin: menambah lagu ke playlist
    public void tambahLagu(Playlist playlist, Lagu lagu) {
        boolean berhasil = playlist.tambahLagu(lagu);
        if (berhasil) {
            System.out.println("Lagu \"" + lagu.getJudul() + "\" berhasil ditambahkan oleh admin.");
        }
    }
}

/**
 * Class Member sebagai turunan User.
 */
class Member extends User {
    public Member(String username) {
        super(username);
    }

    // Override method tampilkanAkses
    @Override
    public void tampilkanAkses() {
        System.out.println("Member " + username + " memiliki akses melihat playlist dan mencari lagu.");
    }

    // Method melihat daftar lagu
    public void lihatPlaylist(Playlist playlist) {
        System.out.println("Member " + username + " melihat daftar lagu:");
        playlist.tampilkanSemua();
    }

    // Method mencari lagu berdasarkan judul
    public void cariLagu(Playlist playlist, String judul) {
        int indeks = playlist.cariLagu(judul);
        if (indeks != -1) {
            System.out.println("Lagu ditemukan:");
            playlist.getLagu(indeks).tampilkanInfo();
        } else {
            System.out.println("Lagu dengan judul \"" + judul + "\" tidak ditemukan.");
        }
    }

    // Method menghitung rata-rata durasi
    public void hitungRataDurasi(Playlist playlist) {
        double rata = playlist.hitungRataDurasi();
        System.out.println("Rata-rata durasi lagu dalam playlist: " + rata + " menit");
    }
}

/**
 * Class utama untuk menjalankan program.
 */
public class PlaylistOOP {
    public static void main(String[] args) {
        // Membuat objek playlist
        Playlist playlist = new Playlist();

        // Membuat beberapa objek lagu
        Lagu lagu1 = new Lagu("Monokrom", "Tulus", 3.57);
        Lagu lagu2 = new Lagu("Remaja", "Hivi!", 3.633);
        Lagu lagu3 = new Lagu("Kisah Sebentar", "Fourtwnty", 4.5);

        // Membuat objek admin dan member
        Admin admin = new Admin("Andi");
        Member member = new Member("Budi");

        // Menampilkan akses masing-masing (polymorphism)
        admin.tampilkanAkses();
        member.tampilkanAkses();
        System.out.println();

        // Admin menambahkan lagu ke playlist
        admin.tambahLagu(playlist, lagu1);
        admin.tambahLagu(playlist, lagu2);
        admin.tambahLagu(playlist, lagu3);
        System.out.println();

        // Member melihat playlist
        member.lihatPlaylist(playlist);
        System.out.println();

        // Member mencari lagu
        member.cariLagu(playlist, "Remaja");
        System.out.println();
        member.cariLagu(playlist, "Halo");
        System.out.println();

        // Member menghitung rata-rata durasi
        member.hitungRataDurasi(playlist);
    }
}