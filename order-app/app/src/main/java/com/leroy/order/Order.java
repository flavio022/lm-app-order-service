package com.leroy.order;

public class Order {

    private String orderNumber;
    private String status;
    private String nomeCliente;
    private String enderecoCliente;
    private String nomePrestador;
    private String nomeEmpresa;

    public Order(
            String orderNumber,
            String status,
            String nomeCliente,
            String enderecoCliente,
            String nomePrestador,
            String nomeEmpresa){

        this.orderNumber = orderNumber;
        this.status = status;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.enderecoCliente = enderecoCliente;
        this.nomePrestador = nomePrestador;
        this.nomeEmpresa = nomeEmpresa;

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getNomePrestador() {
        return nomePrestador;
    }

    public void setNomePrestador(String nomePrestador) {
        this.nomePrestador = nomePrestador;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
}
