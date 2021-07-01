package com.example.model;

public class Summoner {
	private String puuid;
	private String id;
	private String posicion;
	private String nombre;
	private String elo;
	private int total;
	private int ganadas;
	private int perdidas;
	private double winrate;
	
	public Summoner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Summoner(String puuid, String id, String posicion, String nombre, String elo, int total, int ganadas,
			int perdidas, double winrate) {
		super();
		this.puuid = puuid;
		this.id = id;
		this.posicion = posicion;
		this.nombre = nombre;
		this.elo = elo;
		this.total = total;
		this.ganadas = ganadas;
		this.perdidas = perdidas;
		this.winrate = winrate;
	}

	public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getElo() {
		return elo;
	}

	public void setElo(String elo) {
		this.elo = elo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGanadas() {
		return ganadas;
	}

	public void setGanadas(int ganadas) {
		this.ganadas = ganadas;
	}

	public int getPerdidas() {
		return perdidas;
	}

	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}

	public double getWinrate() {
		return winrate;
	}

	public void setWinrate(double winrate) {
		this.winrate = winrate;
	}

		
}
