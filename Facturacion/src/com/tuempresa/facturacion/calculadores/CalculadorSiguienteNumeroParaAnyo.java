package com.tuempresa.facturacion.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;

public class CalculadorSiguienteNumeroParaAnyo
   implements ICalculator{
 @Getter @Setter
	int Anyo;
	@Override
	public Object calculate() throws Exception {
		Query query= XPersistence.getManager()
				.createQuery("select max(f.numero) from Factura f where f.anyo = :anyo");
		query.setParameter("Anyo", Anyo);
		Integer ultimonumero=(Integer) query.getSingleResult();
		return ultimonumero==null ?1: ultimonumero+1;
	}
	
	
	
	
	 
}
