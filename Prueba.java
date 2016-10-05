public class Prueba{
	
	public static void main(String[] args) {
		int numpros;// numero de procesos
		Planificador pl =new Planificador();

	   numpros =Teclado.LeeEntero("Ingresa el numero de procesos : ");
		pl.Llenar(numpros);
		pl.arranca();
	
      
     
	}
}