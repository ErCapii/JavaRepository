package CuentaAtras;

public class CuentaAtras2 implements Runnable{
	private Integer valorInicial;
	private String nombre;
	private static Integer milis = 300;
	private Integer valorActual;
	
	public CuentaAtras2(Integer valorInicial, String nombre) {
		this.valorInicial = valorInicial;
		this.nombre = nombre;
	}
	
	public Integer getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(Integer valorInicial) {
		this.valorInicial = valorInicial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		for (valorActual = getValorInicial(); valorActual>=0; valorActual--) {
			System.out.println(this);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				System.out.println("Ha ocurrido un  fallo");
			}
		}
	}
	

	@Override
	public String toString() {
		return "CuentaAtras [valorInicial=" + valorInicial + ", nombre=" + nombre + ", valorActual=" + valorActual
				+ "]";
	}

	public static void main(String[] args) {
	
		CuentaAtras2 c1 = new CuentaAtras2(10, "C-1");
		CuentaAtras2 c2 = new CuentaAtras2(5, "C-2");
		
		new Thread(c1).start();
		new Thread(c2).start();
		
		
	}
	
}