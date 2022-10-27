/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author AlbertoMoralesGálvez
 */

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
/**
 *
 * @author AlbertoMoralesGálvez
 */

public class Pedidos implements Serializable {
    
     @Override
	public String toString() {
		return "Pedidos [fecha=" + fecha + ", cliente=" + cliente + ", estado=" + estado + ", producto=" + producto
				+ "]";
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	private Timestamp fecha;
     private String cliente;
     private String estado;
     private String  producto;
     
     
            
}