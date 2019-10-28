inicio(){
nota primera = DO;



mientras(n<10){
  	reproduce(DO);
	si(n==2){
		silencio(1); //detiene por un segundo
	          volumen(1); //coloca el volumen en 1
		imprimir(n);
	}
	
  n++;

}
reproduce(RE);
silencio(2);
continuar();
reproduce(DO);


}
