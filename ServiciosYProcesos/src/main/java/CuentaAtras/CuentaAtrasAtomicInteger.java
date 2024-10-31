package CuentaAtras;

import java.util.concurrent.atomic.AtomicInteger;

public class CuentaAtrasAtomicInteger implements Runnable{
	private Integer valorInicial;
	private String nombre;
	private static Integer milis = 1;
	private Integer valorActual;
	private AtomicInteger ejecucionesInstancias = new AtomicInteger(0);
	private static AtomicInteger ejecuciones = new AtomicInteger(0);
	
	public CuentaAtrasAtomicInteger(Integer valorInicial, String nombre) {
		this.valorInicial = valorInicial;
		this.nombre = nombre;
	}
	
	public  AtomicInteger getEjecucionesInstancias() {
		return ejecucionesInstancias;
	}

	public static AtomicInteger getEjecuciones() {
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
	
	@Override
	public void run() {
		for (valorActual = getValorInicial(); valorActual>=0; valorActual--) {
			System.out.println(this);
			ejecucionesInstancias.incrementAndGet();
			ejecuciones.incrementAndGet();
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
		CuentaAtrasAtomicInteger c1=new CuentaAtrasAtomicInteger(10, "C-1");
		for (int i = 0; i < NVeces; i++) {
			new Thread(c1).start();;
		}
		
		try {
			Thread.sleep(milis*NVeces/10);
		}catch (Exception e) {
			
		}
		System.out.println(CuentaAtrasAtomicInteger.getEjecuciones());
		System.out.println(c1.getEjecucionesInstancias());
		
		
	}
	
}
