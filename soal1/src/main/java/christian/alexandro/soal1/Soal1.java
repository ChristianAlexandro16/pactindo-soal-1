package christian.alexandro.soal1;

import christian.alexandro.soal1.entity.MahasiswaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Soal1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Jumlah mahasiswa: ");
        int jumlah = scan.nextInt();

        List<MahasiswaEntity> dataSiswa = new ArrayList<>();
        for (int i = 1; i <= jumlah; i++) {
            MahasiswaEntity siswa = new MahasiswaEntity();
            System.out.println("Data mahasiswa ke " + i + ": ");
            System.out.print("Masukkan NIM: ");
            siswa.setNim(scan.next());
            System.out.print("Masukkan Nama: ");
            siswa.setNama(scan.next());
            System.out.print("Masukkan Nilai Kehadiran: ");
            siswa.setKehadiran(scan.nextInt());
            System.out.print("Masukkan Nilai Midtest: ");
            siswa.setMidtest(scan.nextInt());
            System.out.print("Masukkan Nilai UAS: ");
            siswa.setUas(scan.nextInt());

            siswa = cekNilai(siswa);

            dataSiswa.add(siswa);
        }

        showResult(dataSiswa);
    }

    public static MahasiswaEntity cekNilai (MahasiswaEntity siswa){
        double cekNilai = (siswa.getKehadiran()*0.2) + (siswa.getMidtest()*0.4) + (siswa.getUas()*0.4);
        siswa.setNilaiAkhir(cekNilai);
        if (cekNilai >= 85) {
            siswa.setGrade('A');
            siswa.setStatus(true);
        }
        else if (cekNilai >= 76) {
            siswa.setGrade('B');
            siswa.setStatus(true);
        }
        else if (cekNilai >= 61) {
            siswa.setGrade('C');
            siswa.setStatus(true);
        }
        else if (cekNilai >= 46) {
            siswa.setGrade('D');
            siswa.setStatus(false);
        }
        else {
            siswa.setGrade('E');
            siswa.setStatus(false);
        }

        return siswa;
    }

    public static void showResult (List<MahasiswaEntity> dataSiswa) {
        System.out.println("No. NIM        Nama   Nilai Akhir  Grade");
        System.out.println("===================================================================");
        int jumlah = 0;
        int lulus = 0;
        int tidakLulus = 0;

        for (int i = 0; i < dataSiswa.size(); i++) {
            System.out.print(i+1 + ".  ");
            System.out.print(dataSiswa.get(i).getNim() + "   ");
            System.out.print(dataSiswa.get(i).getNama() + "    ");
            System.out.print(dataSiswa.get(i).getNilaiAkhir() + "    ");
            System.out.println(dataSiswa.get(i).getGrade());

            jumlah++;

            if (dataSiswa.get(i).isStatus()) {
                lulus++;
            } else {
                tidakLulus++;
            }
        }
        System.out.println("===================================================================");
        System.out.println("Jumlah Mahasiswa: " + jumlah);
        System.out.println("Jumlah Mahasiswa yg Lulus: " + lulus);
        System.out.println("Jumlah Mahasiswa: yg Tidak Lulus: " + tidakLulus);
    }
}
