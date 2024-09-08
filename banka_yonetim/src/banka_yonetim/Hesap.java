package banka_yonetim;

public class Hesap {

	private String hesapNo;
	private double bakiye;

	//birden fazla hesap için arraylist kullan
	
	
	
	// constructor
	public Hesap(String hesapNo, double bakiye) {

		this.hesapNo = hesapNo;
		if(bakiye > 0 ) {
			this.bakiye = bakiye;
			System.out.println("hesabınız oluşturuldu, hesap no:"+this.getHesapNo()+" bakiye:"+this.getBakiye());
			
		}else {
			System.out.println("sıfırdan büyük değer giriniz");
		}
	}

	// getter setter
	public String getHesapNo() {
		return hesapNo;
	}

	public void setHesapNo(String hesapNo) {
		this.hesapNo = hesapNo;
	}

	public double getBakiye() {
		return bakiye;
	}

	public void setBakiye(double bakiye) {
		this.bakiye = bakiye;
	}

	// metotlar
	public void paraCek(double bakiye) {
		if( this.bakiye > bakiye) {
			this.bakiye -= bakiye ;
			
		}
		else {
			System.out.println("uygun bakiye giriniz");
		}
	}

	public void paraYatir(double bakiye) {
		if (bakiye > 0) {
			this.bakiye += bakiye;
		}else {
			System.out.println("uygun bakiye giriniz");
		}
	}

}
