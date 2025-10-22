package com.prog3.demo.model;

import java.util.List;


public class Ruta {
    private List<Lugar> lugares;
    private double distanciaTotalKm;
    private double tiempoTotalMin;
    private double costoTotal;

    public Ruta() {}

    // Constructor necesario para Dijkstra u otros algoritmos
    public Ruta(List<Lugar> lugares, double distanciaTotalKm, int tiempoTotalMin, int costoTotal) {
        this.lugares = lugares;
        this.distanciaTotalKm = distanciaTotalKm;
        this.tiempoTotalMin = tiempoTotalMin;
        this.costoTotal = costoTotal;
    }

    // getters y setters
    public List<Lugar> getLugares() { return lugares; }
    public void setLugares(List<Lugar> lugares) { this.lugares = lugares; }

    public double getDistanciaTotalKm() { return distanciaTotalKm; }
    public void setDistanciaTotalKm(double distanciaTotalKm) { this.distanciaTotalKm = distanciaTotalKm; }

    public double getTiempoTotalMin() { return tiempoTotalMin; }
    public void setTiempoTotalMin(double tiempoTotalMin) { this.tiempoTotalMin = tiempoTotalMin; }

    public double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(double costoTotal) { this.costoTotal = costoTotal; }
}