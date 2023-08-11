package com.pdfgenerate.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FarmsData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String farms;

	private int Zinc;

	private int Magnesium;

	private int Calcium;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFarms() {
		return farms;
	}

	public void setFarms(String farms) {
		this.farms = farms;
	}

	public int getZinc() {
		return Zinc;
	}

	public void setZinc(int zinc) {
		Zinc = zinc;
	}

	public int getMagnesium() {
		return Magnesium;
	}

	public void setMagnesium(int magnesium) {
		Magnesium = magnesium;
	}

	public int getCalcium() {
		return Calcium;
	}

	public void setCalcium(int calcium) {
		Calcium = calcium;
	}

	public FarmsData(Long id, String farms, int zinc, int magnesium, int calcium) {
		super();
		this.id = id;
		this.farms = farms;
		Zinc = zinc;
		Magnesium = magnesium;
		Calcium = calcium;
	}

	public FarmsData() {
		super();
	}

	@Override
	public String toString() {
		return "FarmsData [id=" + id + ", farms=" + farms + ", Zinc=" + Zinc + ", Magnesium=" + Magnesium + ", Calcium="
				+ Calcium + "]";
	}

}
