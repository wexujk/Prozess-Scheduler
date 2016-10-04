class Ordenamientos 
{
      private static void IntercambiaDatos(Nodo i, Nodo j){
  	    Prozess aux=i.GetInfo();
  	    i.SetInfo(j.GetInfo());
  	    j.SetInfo(aux);
      }
      
      public static void Sortieren(Nodo H){
    	 Nodo i, j;
    	  for(i=H;i.GetSig()!=null;i=i.GetSig()){
    		  for(j=i.GetSig();j!=null;j=j.GetSig()){
    			  if(i.GetInfo().GetPrioridad()<j.GetInfo().GetPrioridad())
    				  IntercambiaDatos(i,j);
    		  }
    	  }
      }
}
      
      