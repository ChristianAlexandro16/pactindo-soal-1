package christian.alexandro.soal1.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MahasiswaEntity {
    private String nim;

    private String nama;

    private int kehadiran;

    private int midtest;

    private int uas;

    private double nilaiAkhir;

    private char grade;

    private boolean status;


}
