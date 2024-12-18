package CuentaAtras;

public class CuentaAtrasSynchronized implements Runnable{
	private Integer valorInicial;
	private String nombre;
	private static Integer milis = 1;
	private Integer valorActual;
	private Integer ejecucionesInstancias = 0;
	private static Integer ejecuciones = 0;
	
	public CuentaAtrasSynchronized(Integer valorInicial, String nombre) {
		this.valorInicial = valorInicial;
		this.nombre = nombre;
	}
	
	public  Integer getEjecucionesInstancias() {
		return ejecucionesInstancias;
	}

	public static Integer getEjecuciones() {
		return ejecuciones;
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
	
	private synchronized void incrementarEjecuciones() {
		ejecuciones++;
		ejecucionesInstancias++;
	}
	
	@Override
	public void run() {
		for (valorActual = getValorInicial(); valorActual>=0; valorActual--) {
			System.out.println(this);
			incrementarEjecuciones();
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
		Integer NVeces = 100000;
		CuentaAtrasSynchronized c1=new CuentaAtrasSynchronized(10, "C-1");
		for (int i = 0; i < NVeces; i++) {
			new Thread(c1).start();;
		}
		
		try {
			Thread.sleep(milis*NVeces/10);
		}catch (Exception e) {
			
		}
		System.out.println(CuentaAtrasSynchronized.getEjecuciones());
		System.out.println(c1.getEjecucionesInstancias());
		
		
	}
	
}