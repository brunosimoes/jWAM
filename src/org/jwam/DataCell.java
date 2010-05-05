package org.jwam;

/**
 * Representação de uma célula de memória.
 *
 * @author Bruno Simões
 * @author Pedro Guerreiro
 * @version 1.00
 */

public class DataCell extends Symbol {

	/** Conte�do da vari�vel no caso de REF... */
	private int value;

	/** Conte�do da vari�vel no caso de CON, FUN... */
	private String data;

	/** UNB, REF, CON, LIS, STR... */
	private int tag;

	/** Label associado a esta c�lula. */
	private String label = " ";

	/**
	 * Constroi uma c�lula apartir de um TAG e uma refer�ncia.
	 * @param tag TAG.
	 * @param value refer�ncia.
	 */

	public DataCell(int tag, int value){
		this.set(tag, value);
	}

	/**
	 * Cria uma c�lula contendo uma refer�ncia.
	 * @param value � suposto ser um endere�o.
	 */

	public DataCell(int value){
		this.set(REF, value);
	}

	/**
	 * Cria uma c�lula com determinado TAG, eg. CON, FUN, dados: e.g halt e REF.
	 * @param tag TAG.
	 * @param value informa��o em String.
	 * @param addr refer�ncia.
	 */

	public DataCell(int tag, String value, int addr){
		this.tag = tag;
		this.data = value;
		this.value = addr;
	}

	/**
	 * Define um novo TAG e REF.
	 * @param tag novo TAG.
	 * @param value nova REF.
	 */

	public void set(int tag, int value){
		this.tag = tag;
		this.value = value;
	}

	/**
	 * Associa um label a esta c�lula.
	 * @param l label a associar.
	 */

	public void setLabel(String l){
		label = l;
	}

	/**
	 * Obtem o label associado � c�lula.
	 * @return Devolve o label associado � c�lula.
	 */

	public String label(){
		return label;
	}

	/**
	 * Compara dois labels.
	 * @param label label a comparar com o desta c�lula.
	 * @return Devolve true se forem iguais.
	 */

	public boolean compareToLabel(String label){
		return this.label.equals(label);
	}

	/**
	 * Obtem uma refer�ncia se for esse o conte�do desta c�lula, else -1.
	 * @return Devolve a referencia se for esse o conte�do desta c�lula, else -1.
	 */

	public int getValue(){
		return (tag == REF || tag == CON) ? value : -1;
	}

	/**
	 * Define dados nesta c�lula.
	 * @param data dados a inserir na c�lula.
	 */

	public void setStringValue(String data){
		this.data = data;
	}

	/**
	 * Obtem a constante ou o functor se existirem.
	 * @return Devolve a constante ou o functor se existirem nesta c�lula.
	 */

	public String getStringValue(){
		return (tag == CON || tag == FUN) ? data : "";
	}

	/**
	 * Obtem o TAG desta c�lula.
	 * @return Devolve o TAG desta c�lula.
	 */

	public int getTag(){
		return tag;
	}

	/**
	 * Compara dois TAGS.
	 * @param tag TAG a comparar com o desta c�lula.
	 */

	public boolean equals(int tag){
		return this.tag == tag;
	}

	/**
	 * Copia a informa��o de uma c�lula para esta.
	 * @param dc c�lula a copiar.
	 */

	public void copyFrom(DataCell dc){
		if(dc == null){
			System.out.println("trying to copy a null datacell");
			return;
		}

		this.tag = dc.getTag();

		if(dc.equals(REF))
			this.value = dc.getValue();
		else
			this.data = dc.getStringValue();
	}

	/**
	 * Compara dois functores.
	 * @param f functor a comparar com o desta c�lula.
	 * @return Devolve true se forem iguais.
	 */

	public boolean compareFunctor(String f){
		return (equals(FUN) && data.equals(f));
	}

	/**
	 * Apresenta a celula numa representa��o textual.
	 * @return Devolve uma String que representa a celula.
	 */

	public String toString(){
		if(equals(FUN))
			return "[ FUN | " + data + " ]";

		else if(equals(CON))
			return "[ CON | " + data + " ]";

		else if(equals(STR))
			return "[ STR | " + value + " ]";

		else if(equals(REF))
			return "[ REF | " + value + " ]";

		else if(equals(LIS))
			return "[ LIS | " + value + " ]";

		else
			return "[ _ | " + value + " ]";
	}
}
