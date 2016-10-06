public class Prueba{
	
	public static void main(String[] args) {
		int numpros;// numero de procesos
		Planificador pl =new Planificador();
		ColaMemoria cm = new ColaMemoria();
		Prozess p =new Prozess();
		p.CapturaDatos(2);
	
	   //numpros =Teclado.LeeEntero("Ingresa el numero de procesos : ");
		//pl.Llenar(numpros);
		//pl.arranca();
		cm.Insertar(p);
      cm.Listar();
	
      
     
	}
}