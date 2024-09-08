package banka_yonetim;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Hesap> hesapListesi = new ArrayList<>();

		System.out.println("*****vektörel banka*****");
		Hesap hesap = null;
		int secim = 0;
		while (true) {
			liste();
			secim = scan.nextInt();
			scan.nextLine(); // buffer
			if (secim == 1) {

				String hesapNo;
				double baslangic_bakiye;

				System.out.print("Hesap numarası giriniz:");
				hesapNo = scan.nextLine();

				System.out.print("başlangıç bakiyesi giriniz:");
				baslangic_bakiye = scan.nextDouble();

				hesap = new Hesap(hesapNo, baslangic_bakiye);
				hesapListesi.add(hesap);

				continue;

			} else if (secim == 2) {
				// bakiye görüntüle

				// kullanıcıdan hesap numarası iste

				String hesap_no;
				System.out.print("görüntülemek istediğiniz hesabın numarasını giriniz:");
				hesap_no = scan.nextLine();

				// hesabı bul
				boolean hesapBulundu = false;
				for (int i = 0; i < hesapListesi.size(); i++) {
					if (hesapListesi.get(i).getHesapNo().equals(hesap_no)) {
						System.out.println("Bakiyeniz: " + hesapListesi.get(i).getBakiye());
						hesapBulundu = true;
						break;
					}
				}
				if (!hesapBulundu) {
					System.out.println("Hesap bulunamadı.");
				}

			} else if (secim == 3) {
				// para yatırma
				// kullanıcıdan hesap numarası iste
				String hesap_no;
				System.out.print("para yatırmak istediğiniz hesabın numarasını giriniz:");
				hesap_no = scan.nextLine();

				// hesabı bul
				for (int i = 0; i < hesapListesi.size(); i++) {
					if (hesapListesi.get(i).getHesapNo().equals(hesap_no)) {

						if (nullCheck(hesap)) {
							double miktar;
							System.out.print("yatırmak istediğiniz miktarı giriniz:");
							miktar = scan.nextDouble();
							hesap.paraYatir(miktar);
						}

						else {
							System.out.println("hesap bulunamadı,hesap açınız");
						}

					}
				}
				//// hesabı bul sonu

			} else if (secim == 4) {
				// para çek
				// kullanıcıdan hesap numarası iste

				// hesabı bul
				String hesap_no;
				System.out.print("para yatırmak istediğiniz hesabın numarasını giriniz:");
				hesap_no = scan.nextLine();

				for (int i = 0; i < hesapListesi.size(); i++) {
					if (hesapListesi.get(i).getHesapNo().equals(hesap_no)) {
						if (nullCheck(hesap)) {
							double miktar;
							System.out.print("çekmek istediğiniz miktarı giriniz:");
							miktar = scan.nextDouble();
							hesap.paraCek(miktar);
						}

						else {
							System.out.println("hesap bulunamadı,hesap açınız");
						}

					}
				}
				//hesap bul

			} else if (secim == 5) {

				hesapGoruntule(hesapListesi);
			}

			else if (secim == 6) {
				System.out.println("çıkış yapıldı");
				break;
			} else {
				System.out.println("hata");
			}

		}

	}

	public static void hesapGoruntule(ArrayList<Hesap> array) {
		if (array.size() == 0) {
			System.out.println("hesap bulunamadı");
		} else {

			for (Hesap hesap : array) {
				System.out.println("hesap numarası" + hesap.getHesapNo() + "hesap bakiye:" + hesap.getBakiye());
			}
		}
	}

	public static boolean nullCheck(Hesap hesap) {

		if (hesap != null) {
			return true;
		} else {
			return false;
		}
	}

	public static void liste() {
		System.out.println(
				"ne yapmak istiyorsunuz\n" + "1-hesap açma\n" + "2-bakiye görüntüle\n" + "3-hesaba para yatır\n"
						+ "4-hesaptan para çek\n" + "5-hesapları görüntüle\n" + "6-çıkış\n" + "seçiniz:");
	}
}
