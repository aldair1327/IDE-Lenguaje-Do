inicio(){
nota primera = DO;
nota segunda = RE;
nota tercera = MI;
entero i = 0;
entero n; 
n = i;
n++;

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
