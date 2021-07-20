package com.app.entity;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="CORONA_VACCINE")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class CoronaVaccine implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regNo;
	@Column(length = 20)
	@NonNull
	private String name;
	@Column(length = 20)
	@NonNull
	private String company;
	@NonNull
	@Column(length = 20)
	private String country;
	@NonNull
	private Double price;
	@NonNull
	private Integer requiredDoseCount;
	
	
	
}
