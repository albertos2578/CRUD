/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejerciciocrud;

import controler.PedidosDAOMYSQL;
import controler.ProductosDAOMYSQL;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import models.Productos;
import models.Pedidos;

/**
 *
 * @author AlbertoMoralesGalvez
 */


public class Principal {
     static ProductosDAOMYSQL dao = new ProductosDAOMYSQL();
    static PedidosDAOMYSQL dau = new PedidosDAOMYSQL();
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Timestamp fechita = new Timestamp(System.currentTimeMillis());
        ArrayList<Timestamp> tiemposDePedidos = new ArrayList<Timestamp>();
   
        for (var aae : dau.getAllPEDIDOS()){tiemposDePedidos.add(aae.getFecha());}
 
        limpiaPantalla();
		
		int opcion =1;
		while (opcion!=9) {
	imprimirMenu();
	
	opcion=leerEntrada();
    switch (opcion){
    case 0 : opcion= 0;
    		TodosLosPedidos();
    		  break;
    
    case 1:  opcion = 1;
     
    			Meter(tiemposDePedidos);
             break;
    case 2:  opcion = 2;
    			Borrar(tiemposDePedidos);
             break;
    case 3:  opcion = 3;
    			actualizar(tiemposDePedidos);
             break;
    case 4:  opcion = 4;
			PedidosHoy(tiemposDePedidos);
             break;
    case 5:  opcion = 5;
    		PedidosPorCliente();
             break;
    case 6:  opcion = 6;//ejercicio opcional
    		clientes();
             break;
    case 7:  opcion = 7;//ejercicio opcional
	ProductoRepetido();
     break;
    case 8:  opcion = 8; //ejercicio opcional
   	IngresosMes();
        break;

	case 9:
	
		System.out.println("Has salido del programa");
		break;
		default:{System.out.println("ese número no existe en el menu");}
			
	} 
		
	if (opcion!=9) 
	System.out.println();
	System.out.println("Pulse enter para continuar");
	esperaPulsacion();
		}
	}
	
				public static void esperaPulsacion() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
				
	}

				public static int leerEntrada() {
	Scanner sc = new Scanner(System.in);
			int numero = sc.nextInt();
			return numero;
	}
				private static void limpiaPantalla() {

					
					for (int i=0;i<200;i++) {
						System.out.println();
					}
				}
					
				
				public static void imprimirMenu() {
					System.out.println("************************************");
					System.out.println("************ Menu Principal ********");
					System.out.println("************ Menu de Programas ********");
					 System.out.println("0 Ver todos los pedidos");
					 System.out.println("1 Anadir pedido");
     			      System.out.println("2 Borrar pedido");
     			      System.out.println("3 Marcar como recogido un producto");
     			      System.out.println("4 Pedidos de hoy");
     			      System.out.println("5 Pedidos por cliente");
     			      System.out.println("6 Numero de clientes");
     			     System.out.println("7 Plato mas consumido");
     			    System.out.println("8 Ingresos del ultimo mes");
					System.out.println("9 Salir ");
					System.out.println("************************************");
					System.out.println("Introduzca una opción:");
				}
      Scanner sc = new Scanner(System.in);
 
      

    private static void Meter(ArrayList<Timestamp>tiemposDePedidos){
    	 for (var aa : dao.getAllProductos()){  System.out.println(aa); };
    	   Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
    	    Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre del cliente ");
            String nombre = sc.nextLine();
        Pedidos p = new Pedidos();
   
        p.setCliente(nombre);
        System.out.println("Introduce el numero del producto que desea" );
        int aer=0;
          for (var aa : dao.getAllProductos()){  System.out.println(aer+++"  "+aa.getNombre()); };
        
        int producto = sc.nextInt();
        switch (producto){
        case 0:  producto = 0;
        	
        			p.setProducto("paella");
                 break;
        case 1:  producto = 1;

		p.setProducto("flan");
     break;
        }
        
        p.setFecha(fechaActual);
        p.setEstado("En preparacion");
        dau.add(p);
        tiemposDePedidos.add(fechaActual);
    
    }
    private static void Borrar( ArrayList<Timestamp>tiemposDePedidos){
    	 int aer =0;
    
    	  for (var aa : dau.getAllPEDIDOS()){  System.out.println(aer+++"  "+aa); };

          Scanner sc = new Scanner(System.in);
          System.out.println("Introduce el numero del pedido que se desea eliminar ");
          int numeroPedido = sc.nextInt();
       
          Timestamp fecha = new Timestamp(System.currentTimeMillis());
         
        fecha=  tiemposDePedidos.get(numeroPedido);
      
        dau.delete(fecha);
        System.out.println("Pedido borrado");
        tiemposDePedidos.remove(numeroPedido);
    
    	 
 }
    
    private static void actualizar( ArrayList<Timestamp>tiemposDePedidos){
   	 int aer =0;
   	  for (var aa : dau.getAllPEDIDOS()){  System.out.println(aer+++"  "+aa); };
   	 
         Scanner scj = new Scanner(System.in);
         System.out.println("¿Que numero de pedido se ha recogido? ");
         int numerito = scj.nextInt();
       
        Timestamp fecha=  tiemposDePedidos.get(numerito);
    
       dau.update(fecha);
       
       
     
   	 
}
    private static void PedidosHoy( ArrayList<Timestamp>tiemposDePedidos){
      	 int aer =0;
      	  System.out.println("Pedidos de hoy: ");
      	  for (var aa : dau.GETALGUNOS()){  System.out.println(aer+++"  "+aa); };

    
   
}
    
    private static void PedidosPorCliente(){
 	
 	    Scanner sc = new Scanner(System.in);
         System.out.println("Introduce el nombre del cliente ");
         String nombre = sc.nextLine();
     Pedidos p = new Pedidos();
     int aer=0;
     p.setCliente(nombre);
     for (var aa : dau.GetAllPedidosByCliente(nombre)){  System.out.println(aer+++"  "+aa); };
  
     }
    
    

    private static void  ProductoRepetido(){
         
       Pedidos p = new Pedidos();
       System.out.println(dau.ProductoRepetido());
     
      
    
      }
    
    private static void  TodosLosPedidos(){
        
        Pedidos p = new Pedidos();
        int aer=0;
     
        for (var aa : dau.getAllPEDIDOS()){  System.out.println(aer+++"  "+aa); };
      
       
     
       }
private static void  IngresosMes(){
        
        Pedidos p = new Pedidos();
       System.out.println(dau.TotalDeIngresosDelMes() +"euros ganaron en el ultimo mes");
     
       }

private static void clientes() {
	  int aer = 1;
	    System.out.println("Numero de clientes: "+dau.NumeroClientes());
	    for (var aa : dau.NombreClientes()){  System.out.println(aer+++"  "+aa.getCliente()); };
}
}