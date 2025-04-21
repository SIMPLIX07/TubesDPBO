package com.mycompany.tubesfreelance;

import java.util.Scanner;

public class Pembayaran {
    private Client client;
    private Freelance freelancer;
    private double jumlahBayar;
    private boolean statusSelesai;

    public Pembayaran(Client client, Freelance freelancer, double jumlahBayar) {
        this.client = client;
        this.freelancer = freelancer;
        this.jumlahBayar = jumlahBayar;
        this.statusSelesai = false;
    }

    public void prosesPembayaran(Scanner scanner) {
        System.out.println(" ");
        System.out.println("! Konfirmasi Pembayaran !");
        System.out.println("Client: " + client.getUsername());
        System.out.println("Freelancer: " + freelancer.getUsername());
        System.out.println("Jumlah Bayar: Rp " + jumlahBayar);
        System.out.println("Apakah proyek ini sudah selesai? (yes/no): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("yes")) {
            statusSelesai = true;
            System.out.println("Proyek telah selesai.");
            System.out.println(" ");
            System.out.println("Memproses pembayaran...");

            if (potongSaldoClient(jumlahBayar)) {
                tambahSaldoFreelancer(jumlahBayar);
                System.out.println("Pembayaran berhasil diproses!");
                System.out.println("Saldo client telah dipotong.");
                System.out.println("Saldo freelancer telah ditambahkan.");
            } else {
                System.out.println("Gagal memproses pembayaran. Saldo client tidak mencukupi.");
            }
        } else {
            System.out.println("Proyek belum selesai. Pembayaran ditunda.");
        }
    }

    private boolean potongSaldoClient(double jumlah) {
        double saldoClient = 100000;
        if (saldoClient >= jumlahBayar) {
            saldoClient -= jumlahBayar;
            System.out.println("Saldo client sekarang: Rp " + saldoClient);
            return true;
        } else {
            return false;
        }
    }

    private void tambahSaldoFreelancer(double jumlah) {
        double saldoFreelancer = 0;
        saldoFreelancer += jumlah;
        System.out.println("Saldo freelancer sekarang: Rp " + saldoFreelancer);
    }

    public boolean isStatusSelesai() {
        return statusSelesai;
    }
}